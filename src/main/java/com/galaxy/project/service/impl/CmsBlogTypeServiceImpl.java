package com.galaxy.project.service.impl;

import com.galaxy.project.core.AbstractService;
import com.galaxy.project.dao.CmsBlogTypeMapper;
import com.galaxy.project.model.BlogType;
import com.galaxy.project.service.CmsBlogTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* Created by CodeGenerator on 2021/05/09.
*/
@Service
@Transactional
public class CmsBlogTypeServiceImpl extends AbstractService<BlogType> implements CmsBlogTypeService {

    @Resource
    private CmsBlogTypeMapper cmsBlogTypeMapper;

}
