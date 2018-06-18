package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.User;
import com.ninetowns.utils.PageView;

import java.util.List;
import java.util.Map;

/**
 * @FileName : UserService
 * @Author : 周翔
 * @Create Date   : 2014-06-21 10:24
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface UserService {
    public PageView query(PageView pageView,User user);

    public PageView queryListPage(PageView pageView,User user);

    public void add(User user);

    public void delete(String id);

    public void modify(User user);

    public User getById(String id);

    public int countUser(String userName,String userPassword);

    public User querySingleUser(String userName);

    public List<Map<String,Object>> queryMenusByUser(User user);

    public User getSSOByLoginName(String username);

    public List<Map<String,Object>> queryMainMenuByUser(User user);
}
