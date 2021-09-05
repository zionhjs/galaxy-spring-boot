package com.galaxy.project.web;

import com.galaxy.project.common.BaseController;
import com.galaxy.project.core.Result;
import com.galaxy.project.core.ResultGenerator;
import com.galaxy.project.model.Team;
import com.galaxy.project.service.CmsTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/gateway/cms/team")
@Api(tags = {"/gateway/cms/team"}, description = "团队管理模块")
public class CmsTeamController extends BaseController {

    @Resource
    private CmsTeamService cmsTeamService;

    @ApiOperation(value = "新增团队", notes = "新增团队")
    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public Result add(@RequestBody Team team) {
        return cmsTeamService.add(team);
    }

    @ApiOperation(value = "删除团队", notes = "删除团队")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public Result delete(@RequestParam Long id) {
        return cmsTeamService.deleteTeamMember(id);
    }

    @ApiOperation(value = "修改团队", notes = "修改团队")
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    public Result update(@RequestBody Team team) {
        cmsTeamService.update(team);
        Result result= ResultGenerator.genSuccessResult();
        result.setData(team);
        return result;
    }

    @ApiOperation(value = "获取团队单个详情", notes = "获取团队单个详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.GET})
    public Result detail(@RequestParam Long id) {
        return cmsTeamService.detail(id);
    }

    @ApiOperation(value = "分页查询团队", notes = "分页查询团队")
    @RequestMapping(value = "/findByModal", method = {RequestMethod.POST, RequestMethod.GET})
    public Result list(@RequestParam(defaultValue="1",required=false) Integer page, @RequestParam(defaultValue="20",required=false) Integer size, @RequestBody(required =false) Team team) {
        return cmsTeamService.list(page,size,team);
    }

}
