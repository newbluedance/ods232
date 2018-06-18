package com.ninetowns.modules.dao;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.Menu;
import com.ninetowns.modules.entity.User;

import java.util.List;

/**
 * @FileName : UserDao
 * @Author : 周翔
 * @Create Date   : 2014-06-21 10:27
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface UserDao extends BaseDao<User> {
    public int countUser(String userName,String userPassword);

    public User querySingleUser(String userName);

    public List<Menu> queryMenusByUser(String userId);

    public User getSSOByLoginName(String username);
}
