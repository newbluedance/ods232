package com.ninetowns.modules.dao;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.entity.UserRole;

import java.util.List;

/**
 * @FileName : UserRoleDao
 * @Author : 周翔
 * @Create Date   : 2014-06-28 09:24
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface UserRoleDao extends BaseDao<UserRole> {
    public int addUserRoleBatch(List<UserRole> userRoleList);

    public List<User> queryUsersByRoleId(String roleId);
}
