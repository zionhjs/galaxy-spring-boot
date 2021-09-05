package com.galaxy.project.service.impl;

import com.galaxy.project.core.AbstractService;
import com.galaxy.project.core.Result;
import com.galaxy.project.core.ResultGenerator;
import com.galaxy.project.dao.CmsTeamMemberMapper;
import com.galaxy.project.model.TeamMember;
import com.galaxy.project.service.CmsTeamMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* Created by CodeGenerator on 2020/12/26.
*/
@Service
@Transactional
public class CmsTeamMemberServiceImpl extends AbstractService<TeamMember> implements CmsTeamMemberService {
    @Resource
    private CmsTeamMemberMapper cmsTeamMemberMapper;

    @Override
    public Result delete(Long id) {

        TeamMember teamMember=new TeamMember();
        teamMember.setId(id);
        teamMember.setIsDelete(true);
        update(teamMember);
        return ResultGenerator.genSuccessResult();
    }
}
