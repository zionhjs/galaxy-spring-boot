package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.ShortConnResult;

public interface JmsShortConnResultMapper extends Mapper<ShortConnResult> {

    ShortConnResult getByUrl(String url);
}