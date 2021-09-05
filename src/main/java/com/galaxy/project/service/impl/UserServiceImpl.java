package com.galaxy.project.service.impl;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.ResultCode;
import com.galaxy.project.core.ResultGenerator;
import com.galaxy.project.dao.UserMapper;
import com.galaxy.project.model.User;
import com.galaxy.project.service.SysMenuService;
import com.galaxy.project.service.UserService;
import com.galaxy.project.core.AbstractService;
import com.galaxy.project.vo.CaptchaVo;
import com.galaxy.project.vo.LoginVo;
import com.galaxy.project.vo.SysUserVo;
import com.galaxy.project.vo.VerfiyCodeVo;
import com.galaxy.project.utils.*;
import com.wf.captcha.GifCaptcha;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
* Created by CodeGenerator on 2021/04/16.
*/
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private MagConfig magConfig;

    @Override
    public Result list(Long id) {
        User user = userMapper.selectUser(id);

        return ResultGenerator.genSuccessResult(user);
    }

    @Override
    public Result logout(Long userId) {
        SysUserVo sysUserVo = null;
        String token=(String)redisService.get(userId+"USERID");
        try {
            sysUserVo = (SysUserVo)redisService.get(Constants.REDIS_KEY_LOGIN + token);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("redis异常");
        }

        redisService.delete(userId+"USERID");

        if (sysUserVo != null){
            redisService.delete(Constants.REDIS_KEY_LOGIN + token);

            return ResultGenerator.genSuccessResult();
        }

        return ResultGenerator.genFailResult(ResultCode.NOT_LOGIN_EXCEPTION,"用户未登录,请重新登录");
    }

    @Override
    public Result login(LoginVo vo) {

        //声明存储对象
        SysUserVo sysUserVo = new SysUserVo();

        User user = new User();

        //手机号或者邮箱登录
        if (vo.getPhone().contains("@")){
            //邮箱登录
            user = userMapper.findUserByEmail(vo.getPhone());
        }else {
            //手机号登录
            user = userMapper.findUserByPhone(vo.getPhone());
        }

        if (null == user){
            return ResultGenerator.genFailResult(ResultCode.USER_NOT_EXIST,"用户信息不存在[账号可能被停用或删除]");
        }

        if(!Md5Utils.getMd5(vo.getPassword()).equals(user.getPassword())){
            return ResultGenerator.genFailResult(ResultCode.PASSWORD_ERROR,"用户名或密码错误");
        }

        SysUserVo userVo = new SysUserVo();

        List<Object> sysMenuList = new ArrayList<Object>();
        if (null != user.getSysRoleId()){
            sysMenuList = sysMenuService.selectMenuByRoleId(user.getSysRoleId());
            userVo = sysMenuService.selectRoleById(user.getSysRoleId());
        }

        //创建token
        String token = (String) redisService.get(user.getId() + "USERID");

        Boolean loginFlag = false;

        if(StringUtils.isNotBlank(token)){
            //说明已登陆，或直接断网
            redisService.delete(Constants.REDIS_KEY_LOGIN + token);
            redisService.delete(user.getId()+"USERID");
        }else{
            //true首次
            loginFlag=true;
        }
        token = TokenUtil.getToken();

        try {
            sysUserVo.setUserId(user.getId());
            sysUserVo.setPhone(user.getPhone());
            sysUserVo.setEmail(user.getEmail());
            sysUserVo.setToken(token);
            sysUserVo.setExpireTime(System.currentTimeMillis() + 2505600000L);
            sysUserVo.setChannel(vo.getChannel());
            sysUserVo.setUserName(user.getUserName());
            sysUserVo.setSysMenuList(sysMenuList);
            sysUserVo.setRoleId(userVo.getRoleId());
            sysUserVo.setRoleName(userVo.getRoleName());
            //redisService.put(Constant.REDIS_KEY_LOGIN, token, new RedisModel(su.getId(), System.currentTimeMillis() + magConfig.getExpireTime()), magConfig.getExpireTime());
            redisService.setWithExpire(Constants.REDIS_KEY_LOGIN + token, sysUserVo , 2505600000L);
            redisService.set(user.getId()+"USERID",token);
        }catch (Exception e){
            e.printStackTrace();
            Logger.info(this,"登录token存入redis产生异常："+e.getMessage());
            throw new RuntimeException("存入redis异常");
        }
        return ResultGenerator.genSuccessResult(sysUserVo);
    }

    @Override
    public Result captcha() {
        GifCaptcha specCaptcha = new GifCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        System.out.print("登录验证码" + verCode);
        String verifyToken = TokenUtil.getToken();
        // 存入redis并设置过期时间为30秒
        redisService.setWithExpire(Constants.REDIS_KEY_VERFIY + verifyToken, new VerfiyCodeVo(verCode,System.currentTimeMillis() + Constants.verifyCodeForTempValidTime)  , Constants.verifyCodeForTempValidTime);
        CaptchaVo captchaVo = new CaptchaVo();
        captchaVo.setVerifyToken(verifyToken);
        captchaVo.setData(specCaptcha.toBase64());
        // 将key和base64返回给前端
        return ResultGenerator.genSuccessResult(captchaVo);
    }

    @Override
    public Result updateUser(User user) {

        //根据用户名查询是否存在
        User newUser = userMapper.findUserByUserName(user.getUserName(),user.getId());

        //用户名不可重复
        if (null != newUser){
            return ResultGenerator.genFailResult(ResultCode.USER_ALREADY_EXIST,"用户名已存在，请登录");
        }

        user.setUpdatedAt(new Date());
        update(user);
        Result result= ResultGenerator.genSuccessResult();
        result.setData(user);
        return result;
    }

    @Override
    public Result add(User user) {

        User userVo = userMapper.findUserByPhone(user.getPhone());
        if (null != userVo){
            return ResultGenerator.genFailResult(ResultCode.PHONE_ERROR,"手机号已存在");
        }

        user.setCreatedAt(new Date());
        user.setStatus(1);
        user.setRegisterTime(new Date());
        user.setPassword(Md5Utils.getMd5(user.getPassword()));
        save(user);
        return ResultGenerator.genSuccessResult(user);
    }

}
