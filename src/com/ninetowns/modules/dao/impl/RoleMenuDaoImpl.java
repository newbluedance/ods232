package com.ninetowns.modules.dao.impl;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.dao.RoleMenuDao;
import com.ninetowns.modules.entity.RoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @FileName : RoleMenuDaoImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-28 09:21
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Repository("roleMenuDao")
public class RoleMenuDaoImpl extends BaseDaoImpl<RoleMenu> implements RoleMenuDao {

    @Override
    public Integer addRoleMenuBatch(List<RoleMenu> roleMenuList) {
        return getSqlSession().insert("RoleMenu.addRoleMenuBatch",roleMenuList);
    }

    @Override
    public List<String> queryMenusByRoleId(String roleId) {
        return getSqlSession().selectList("RoleMenu.queryMenusByRoleId",roleId);
    }
}
