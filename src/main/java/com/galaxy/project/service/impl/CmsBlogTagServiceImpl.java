package com.galaxy.project.service.impl;

import com.galaxy.project.core.AbstractService;
import com.galaxy.project.dao.CmsBlogTagMapper;
import com.galaxy.project.model.BlogTag;
import com.galaxy.project.service.CmsBlogTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
* Created by CodeGenerator on 2020/12/27.
*/
@Service
@Transactional
public class CmsBlogTagServiceImpl extends AbstractService<BlogTag> implements CmsBlogTagService {

    @Resource
    private CmsBlogTagMapper cmsBlogTagMapper;

    @Override
    public List<String> selectAllTag() {
        return cmsBlogTagMapper.selectAllTag();
    }
}
