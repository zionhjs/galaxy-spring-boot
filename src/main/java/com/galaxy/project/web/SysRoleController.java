package com.galaxy.project.web;
import com.galaxy.project.core.Result;
import com.galaxy.project.core.ResultGenerator;
import com.galaxy.project.model.SysRole;
import com.galaxy.project.service.SysRoleService;
import io.swagger.annotations.Api;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import java.util.List;
import java.util.Date;

/**
* Created by CodeGenerator on 2021/04/20.
*/
@RestController
@RequestMapping("/sys/role")
@Api(tags = {"/sys/role"}, description = "角色管理模块")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @ApiOperation(value = "新增", notes = "新增")
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Result add(@RequestBody SysRole sysRole) {
        //获取当前时间为新增时间
        sysRole.setCreatedAt(new Date());
        //逻辑删除 false标识未删除
        sysRole.setIsDelete(false);
        //添加到数据库
        sysRoleService.save(sysRole);
        //构造返回前端的数据
        Result result=ResultGenerator.genSuccessResult();
        result.setData(sysRole);
        return result;
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result delete(@RequestParam Long id) {
        //声明对象
        SysRole sysRole=new SysRole();
        //根据id逻辑删除
        sysRole.setId(id);
        sysRole.setIsDelete(true);
        //逻辑删除
        sysRoleService.update(sysRole);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody SysRole sysRole) {
        //获取当前时间为修改时间
        sysRole.setUpdatedAt(new Date());
        //根据id修改排解方案 id必穿
        sysRoleService.update(sysRole);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(sysRole);
        return result;
    }

    @ApiOperation(value = "获取单个详情", notes = "获取单个详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    public Result detail(@RequestParam Long id) {
        //根据id查询角色详情
        SysRole sysRole = sysRoleService.findById(id);
        //返回查询的单个详情
        return ResultGenerator.genSuccessResult(sysRole);
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/findByModal", method = {RequestMethod.POST,RequestMethod.GET})
    public Result list(@RequestParam(defaultValue="1",required=false) Integer page, @RequestParam(defaultValue="20",required=false) Integer size, @RequestBody(required =false) SysRole sysRole) {
        PageHelper.startPage(page, size);
        sysRole.setIsDelete(false);
        List<SysRole> list = sysRoleService.findByModel(sysRole);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
