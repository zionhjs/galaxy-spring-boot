package com.galaxy.project.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.project.core.Result;
import com.galaxy.project.core.ResultCode;
import com.galaxy.project.utils.*;
import com.galaxy.project.vo.SysMenuVo;
import com.galaxy.project.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @author cjm
 */
//@WebFilter+@ServletComponentScan ，可以解决在过滤器中@Autowired无法自动注入得问题
@WebFilter(urlPatterns = "/*")
public class BasicTokenFilter implements Filter {

    @Resource
    private RedisService redisService;

    @Autowired
    private MatchUrlUtils matchUrlUtils;

    @Autowired
    private MagConfig magConfig;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {

            String url = httpRequest.getServletPath();
            String[] s = url.split("/");

            //false 不拦截,true 拦截
            boolean tag = true;
            //暂时全都没有拦截
            List<String> urlsList = Arrays.asList(magConfig.getNotCheckLoginUrl().split(","));
            for (String u :urlsList) {
                //如果包含的话那就是不拦截
                if (u.replaceAll("/","").equalsIgnoreCase(s[s.length-1])){
                    tag = false;
                    break;
                }
            }

            if (tag){
                Logger.info(this,"拦截器 拦截路径" + url);

                String accessToken = httpRequest.getHeader("accessToken");
                Result result = new Result();
                if (null != accessToken){
                    SysUserVo sysUserVo = (SysUserVo) redisService.get(Constants.REDIS_KEY_LOGIN + accessToken);
                    if (null != sysUserVo){
                        long curTime = System.currentTimeMillis();
                        if (curTime > sysUserVo.getExpireTime()) {
                            Logger.info(this, "accessToken 失效--" + ":curTime is " + curTime + " expireTime is " + sysUserVo.getExpireTime());
                            result = new Result();
                            result.setCode(ResultCode.OUT_TIME_TOKEN);
                            result.setMessage("accessToken 失效");
                            this.setResponseData(httpResponse, JsonBinderUtil.toJson(result));
                        } else {

                            int i = 0;

                            //增加权限校验
                            if (sysUserVo.getSysMenuList().size() > 0 ){
                                for (Object obj :sysUserVo.getSysMenuList()) {
                                    ObjectMapper mapper = new ObjectMapper();
                                    SysMenuVo sysMenuVo = mapper.convertValue(obj, SysMenuVo.class);
                                    if (sysMenuVo.getLinkUrl().contains(s[s.length-1])){
                                        i = ++i;
                                    }
                                }
                                if (0 == i){
                                    result = new Result();
                                    result.setCode(ResultCode.USER_PERMISSION_ERROR);
                                    result.setMessage("暂无权限使用此功能");
                                    this.setResponseData(httpResponse, JsonBinderUtil.toJson(result));
                                }
                            }

                            //校验通过
                            //存入本地线程变量
                            //UserContext.init(sysUserVo);
                        }
                    }else {
                        result = new Result();
                        result.setCode(ResultCode.USER_LOGIN_CHANNEL_ERROR);
                        result.setMessage("用户未登录,请重新登录");
                        this.setResponseData(httpResponse, JsonBinderUtil.toJson(result));
                    }
                }else {
                    result = new Result();
                    result.setCode(ResultCode.NOT_EXIST_TOKEN_EXCEPTION);
                    result.setMessage("accessToken不存在(请重新登录再访问)");
                    this.setResponseData(httpResponse, JsonBinderUtil.toJson(result));
                }
            }
            chain.doFilter(httpRequest, httpResponse);
        } catch (Exception e) {
            Logger.error(this, ":其他异常:", e);
        }
        return;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void setResponseData(HttpServletResponse httpServletResponse, String result) throws IOException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
    }

}
