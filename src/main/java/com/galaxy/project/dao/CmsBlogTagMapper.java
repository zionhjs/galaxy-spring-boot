package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.BlogTag;

import java.util.List;

public interface CmsBlogTagMapper extends Mapper<BlogTag> {

    List<String> selectAllTag();
}