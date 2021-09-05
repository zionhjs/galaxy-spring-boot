package com.galaxy.project.service.impl;

import com.galaxy.project.dao.SysRoleMapper;
import com.galaxy.project.model.SysRole;
import com.galaxy.project.service.SysRoleService;
import com.galaxy.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* Created by CodeGenerator on 2021/04/20.
*/
@Service
@Transactional
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

}
