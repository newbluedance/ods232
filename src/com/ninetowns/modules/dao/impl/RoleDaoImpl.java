package com.ninetowns.modules.dao.impl;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.dao.RoleDao;
import com.ninetowns.modules.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * @FileName : RoleDaoImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:38
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

    @Override
    public int getURCount(String s) {
        return (Integer)getSqlSession().selectOne("Role.getURCount",s);
    }

    @Override
    public int getRMCount(String s) {
        return (Integer)getSqlSession().selectOne("Role.getRMCount",s);
    }
}
