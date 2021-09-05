package com.galaxy.project.service;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.SysMenu;
import com.galaxy.project.vo.SysUserVo;

import java.util.List;


/**
* Created by CodeGenerator on 2021/04/20.
*/
public interface SysMenuService extends Service<SysMenu> {

    List<Object> selectMenuByRoleId(String sysRoleId);

    SysUserVo selectRoleById(String sysRoleId);
}
