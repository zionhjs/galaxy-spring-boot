package com.galaxy.project.service;

import com.galaxy.project.core.Service;
import com.galaxy.project.model.BlogTag;

import java.util.List;


/**
* Created by CodeGenerator on 2020/12/27.
*/
public interface CmsBlogTagService extends Service<BlogTag> {

    List<String> selectAllTag();
}
