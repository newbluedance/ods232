package com.ninetowns.modules.dao;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.RoleMenu;

import java.util.List;

/**
 * @FileName : RoleMenuDao
 * @Author : 周翔
 * @Create Date   : 2014-06-28 09:20
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface RoleMenuDao extends BaseDao<RoleMenu> {
    public Integer addRoleMenuBatch(List<RoleMenu> roleMenuList);

    public List<String> queryMenusByRoleId(String roleId);
}
