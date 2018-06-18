package com.ninetowns.modules.dao;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.Role;

/**
 * @FileName : RoleDao
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:38
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface RoleDao extends BaseDao<Role> {
    public int getURCount(String s);

    public int getRMCount(String s);
}
