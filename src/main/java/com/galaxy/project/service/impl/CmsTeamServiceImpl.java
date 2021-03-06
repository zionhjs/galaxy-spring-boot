package com.galaxy.project.service.impl;

import com.galaxy.project.core.AbstractService;
import com.galaxy.project.core.Result;
import com.galaxy.project.core.ResultCode;
import com.galaxy.project.core.ResultGenerator;
import com.galaxy.project.dao.CmsTeamMapper;
import com.galaxy.project.dao.CmsTeamMemberMapper;
import com.galaxy.project.model.Team;
import com.galaxy.project.service.CmsTeamMemberService;
import com.galaxy.project.service.CmsTeamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
* Created by CodeGenerator on 2020/12/22.
*/
@Service
@Transactional
public class CmsTeamServiceImpl extends AbstractService<Team> implements CmsTeamService {

    @Resource
    private CmsTeamMapper cmsTeamMapper;

    @Autowired
    private CmsTeamMemberService cmsTeamMemberService;

    @Autowired
    private CmsTeamMemberMapper cmsTeamMemberMapper;

    @Override
    public Result add(Team team) {
        //添加团队
        team.setCreatedAt(new Date());
        team.setIsDelete(false);
        save(team);
        //批量添加团队成员
        if (null != team.getTeamMemberList()){
            if (team.getTeamMemberList().size() > 0){
                cmsTeamMemberService.save(team.getTeamMemberList());
            }
        }
        Result result = ResultGenerator.genSuccessResult();
        result.setData(team);
        return result;
    }

    @Override
    public Result list(Integer page, Integer size, Team team) {
        PageHelper.startPage(page, size);
        List<Team> list = cmsTeamMapper.list(team);
        for (Team d:list) {
            d.setTeamMemberList(cmsTeamMemberMapper.selectTeamMemberByTeamId(d.getId()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @Override
    public Result detail(Long id) {
        Team team = findById(id);
        if (null != team){
            team.setTeamMemberList(cmsTeamMemberMapper.selectTeamMemberByTeamId(team.getId()));
        }
        return ResultGenerator.genSuccessResult(team);
    }

    @Override
    public Result deleteTeamMember(Long id) {

        Integer rows = cmsTeamMapper.getCountById(id);
        if (rows == 0){
            return ResultGenerator.genFailResult(ResultCode.TEAM_NOT_EXIST,"team不存在或者已删除");
        }

        Team team = new Team();
        team.setId(id);
        team.setIsDelete(true);
        update(team);

        //批量删除成员
        cmsTeamMemberMapper.updateTeamMemberByTeamId(id);

        return ResultGenerator.genSuccessResult();
    }
}
