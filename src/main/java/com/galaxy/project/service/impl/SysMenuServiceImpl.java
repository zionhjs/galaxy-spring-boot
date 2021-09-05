package com.galaxy.project.service.impl;

import com.galaxy.project.dao.SysMenuMapper;
import com.galaxy.project.model.SysMenu;
import com.galaxy.project.service.SysMenuService;
import com.galaxy.project.core.AbstractService;
import com.galaxy.project.vo.SysUserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
* Created by CodeGenerator on 2021/04/20.
*/
@Service
@Transactional
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<Object> selectMenuByRoleId(String roleId) {
        return sysMenuMapper.selectMenuByRoleId(roleId);
    }

    @Override
    public SysUserVo selectRoleById(String sysRoleId) {
        return sysMenuMapper.selectRoleById(sysRoleId);
    }
}
