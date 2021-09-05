package com.galaxy.project.service;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.Team;


/**
* Created by CodeGenerator on 2020/12/22.
*/
public interface CmsTeamService extends Service<Team> {

    Result add(Team team);

    Result list(Integer page, Integer size, Team team);

    Result detail(Long id);

    Result deleteTeamMember(Long id);
}
