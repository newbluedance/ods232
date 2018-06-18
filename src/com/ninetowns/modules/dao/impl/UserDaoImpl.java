package com.ninetowns.modules.dao.impl;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.dao.UserDao;
import com.ninetowns.modules.entity.Menu;
import com.ninetowns.modules.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName : UserDaoImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-21 10:28
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public int countUser(String userName, String userPassword) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("userName", userName);
        map.put("userPassword", userPassword);
        return (Integer)getSqlSession().selectOne("User.countUser",map);
    }

    @Override
    public User querySingleUser(String userName) {
        return (User)getSqlSession().selectOne("User.queryUserName",userName);
    }

    @Override
    public List<Menu> queryMenusByUser(String userId) {
        return getSqlSession().selectList("User.queryMenusByUser",userId);
    }

    @Override
    public User getSSOByLoginName(String username) {
        return getSqlSession().selectOne("User.getSSOByLoginName",username+"@jsciq.gov.cn");
    }
}
