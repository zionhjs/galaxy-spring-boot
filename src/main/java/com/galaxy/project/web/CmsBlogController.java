package com.galaxy.project.web;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.ResultGenerator;
import com.galaxy.project.model.Blog;
import com.galaxy.project.service.CmsBlogService;
import com.galaxy.project.utils.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2020/12/23.
*/
@RestController
@RequestMapping("/gateway/cms/blog")
@Api(tags = {"/gateway/cms/blog"}, description = "博客管理模块")
public class CmsBlogController {

    @Resource
    private CmsBlogService cmsBlogService;

    @ApiOperation(value = "首页统一查询", notes = "首页统一查询")
    @RequestMapping(value = "/homeFindByTitle", method = {RequestMethod.POST, RequestMethod.GET})
    public Result homeFindByTitle(@RequestParam(defaultValue="1",required = false) Integer page,
                                  @RequestParam(defaultValue="20",required = false) Integer size,
                                  @RequestBody(required = false) String title) {
        return cmsBlogService.homeFindByTitle(page, size , title);
    }

    @ApiOperation(value = "新增博客", notes = "新增博客")
    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public Result add(@RequestBody Blog blog) {
        return cmsBlogService.add(blog);
    }

    @ApiOperation(value = "删除博客", notes = "删除博客")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public Result delete(@RequestParam Long id) {
        Blog blog=new Blog();
        blog.setId(id);
        blog.setIsDelete(true);
        cmsBlogService.update(blog);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改博客", notes = "修改博客")
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    public Result updateBlog(@RequestBody Blog blog) {
        Logger.info(this, "/blog/updateBlog 修改博客接口入参--->" + blog);
        return cmsBlogService.updateBlog(blog);
    }

    @ApiOperation(value = "获取博客单个详情", notes = "获取博客单个详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.GET})
    public Result detail(@RequestParam Long id) {
        return cmsBlogService.detail(id);
    }


    @ApiOperation(value = "按照时间分页查询博客", notes = "按照时间分页查询博客")
    @RequestMapping(value = "/findByModalOrderByTime", method = {RequestMethod.POST, RequestMethod.GET})
    public Result findByModalOrderByTime(@RequestParam(defaultValue="1",required=false) Integer page,
                                         @RequestParam(defaultValue="20",required=false) Integer size,
                                         @RequestBody(required =false) Blog blog) {
        return cmsBlogService.findByModalOrderByTime(page, size,blog);
    }

    @ApiOperation(value = "分页查询博客", notes = "分页查询博客")
    @RequestMapping(value = "/findByModal", method = {RequestMethod.POST, RequestMethod.GET})
    public Result list(@RequestParam(defaultValue="1",required=false) Integer page, @RequestParam(defaultValue="20",required=false) Integer size, @RequestBody(required =false) Blog blog) {
        return cmsBlogService.list(page, size,blog);
    }
}
