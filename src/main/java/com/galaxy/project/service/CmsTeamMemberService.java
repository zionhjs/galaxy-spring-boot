package com.galaxy.project.service;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.TeamMember;

/**
* Created by CodeGenerator on 2020/12/26.
*/
public interface CmsTeamMemberService extends Service<TeamMember> {

    Result delete(Long id);
}
