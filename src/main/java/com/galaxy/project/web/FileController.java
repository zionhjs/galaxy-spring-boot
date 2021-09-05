package com.galaxy.project.web;

import com.galaxy.project.core.Result;
import com.galaxy.project.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName FileController
 * @Description //TODO
 * @Author cjm
 * @Date 2021/2/23 10:21
 * @Version 1.0
 **/
@RestController
@RequestMapping("/file")
@Api(tags = {"/file"},description="文件上传模块")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "上传单个文件", notes = "上传单个文件")
    @RequestMapping(value = "/uploadSingle", method = {RequestMethod.POST})
    public Result uploadSingle(HttpServletRequest request,MultipartFile file){
        return fileService.uploadSingle(request,file);
    }

    @ApiOperation(value = "导出", notes = "导出")
    @RequestMapping(value = "/export", method = {RequestMethod.GET})
    //直接在浏览器访问就可实现导出
    public void export(HttpServletRequest request, HttpServletResponse response) {
        fileService.export(request,response);
    }

}
