package com.ninetowns.modules.dao.impl;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.dao.UserRoleDao;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @FileName : UserRoleDaoImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-28 09:25
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {
    @Override
    public int addUserRoleBatch(List<UserRole> userRoleList) {
        return getSqlSession().insert("UserRole.addUserRoleBatch", userRoleList);
    }

    @Override
    public List<User> queryUsersByRoleId(String roleId) {
        return getSqlSession().selectList("UserRole.queryUsersByRoleId",roleId);
    }
}
