package com.galaxy.project.service.impl;

import com.galaxy.project.constants.Constant;
import com.galaxy.project.core.Result;
import com.galaxy.project.core.ResultCode;
import com.galaxy.project.core.ResultGenerator;
import com.galaxy.project.service.FileService;
import com.galaxy.project.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName FileServiceImpl
 * @Description //TODO
 * @Author cjm
 * @Date 2020/11/27 17:40
 * @Version 1.0
 **/
@Service
public class FileServiceImpl implements FileService {

    /*@Value("${file.url}")
    private String uploadDir;*/

    private static String uploadDir = Constant.OS_PREFIX;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @Override
    public Result uploadSingle(HttpServletRequest request,MultipartFile file) {
        if (null == file) {
            return ResultGenerator.genFailResult(ResultCode.FILE_BULL_ERROR,"文件不能为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        String filePath = uploadDir;
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            String path;
            //判断系统是否包含D，如果包含D的话，服务为Windows环境
            if (uploadDir.contains("D")){
                // request.getScheme() 获取请求的协议名称
                // request.getServerName() 获取请求的域名
                // request.getServerPort() 获取请求的端口号
                path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/file/"  + dest.getName();
            }else {
                //Linux环境
                path = Constants.LINUX_FILE_USER + request.getServerPort() + "/file/" + dest.getName();
            }
            return ResultGenerator.genSuccessResult(path);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultGenerator.genFailResult(ResultCode.FILEUPLOAD_ERROR,"文件上传失败");
    }

    @Override
    public void export(HttpServletRequest request, HttpServletResponse response) {

        /*List<ExportVo> exportVoList = userMapper.selectExport();
        String[] titles = {"预约成功时间", "预约客人名称", "停车场名称", "停车场地址" , "车位名字"};
        try {
        } catch (Exception e) {
            Logger.info(this, "=====》预约成功的用户信息" + e );
        }*/
    }

}
