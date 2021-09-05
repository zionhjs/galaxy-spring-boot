package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.SysMenu;
import com.galaxy.project.vo.SysUserVo;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {

    List<Object> selectMenuByRoleId(String sysRoleId);

    SysUserVo selectRoleById(String sysRoleId);

}