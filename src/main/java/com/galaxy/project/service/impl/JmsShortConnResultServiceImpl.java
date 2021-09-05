package com.galaxy.project.service.impl;

import com.galaxy.project.core.AbstractService;
import com.galaxy.project.dao.JmsShortConnResultMapper;
import com.galaxy.project.model.ShortConnResult;
import com.galaxy.project.service.JmsShortConnResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* Created by CodeGenerator on 2021/01/04.
*/
@Service
@Transactional
public class JmsShortConnResultServiceImpl extends AbstractService<ShortConnResult> implements JmsShortConnResultService {

    @Resource
    private JmsShortConnResultMapper jmsShortConnResultMapper;

    @Override
    public ShortConnResult getByUrl(String url) {
        return jmsShortConnResultMapper.getByUrl(url);
    }
}
