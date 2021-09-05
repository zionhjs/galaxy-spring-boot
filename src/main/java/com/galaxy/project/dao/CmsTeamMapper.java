package com.galaxy.project.dao;


import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.Team;

import java.util.List;

public interface CmsTeamMapper extends Mapper<Team> {

    List<Team> list(Team team);

    Integer getCountById(Long id);
}