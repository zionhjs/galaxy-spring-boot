package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.TeamMember;

import java.util.List;

public interface CmsTeamMemberMapper extends Mapper<TeamMember> {

    List<TeamMember> selectTeamMemberByTeamId(Long teamId);

    void updateTeamMemberByTeamId(Long teamId);
}