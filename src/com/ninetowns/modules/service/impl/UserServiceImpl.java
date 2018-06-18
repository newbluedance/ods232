package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.dao.UserDao;
import com.ninetowns.modules.entity.Menu;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.service.UserService;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName : UserServiceImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-21 10:26
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageView query(PageView pageView, User user) {
        List<User> list = userDao.query(pageView, user);
        pageView.setRows(list);
        return pageView;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public void modify(User user) {
        userDao.modify(user);
    }

    @Override
    public User getById(String id) {
        return userDao.getById(id);
    }

    @Override
    public int countUser(String userName, String userPassword) {
        return userDao.countUser(userName, userPassword);
    }

    @Override
    public User querySingleUser(String userName) {
        return userDao.querySingleUser(userName);
    }

    @Override
    public List<Map<String, Object>> queryMenusByUser(User user) {
        List<Menu> menuList = userDao.queryMenusByUser(user.getUserId());
        //需要自行对数据进行排序
        List<Map<String, Object>> slist = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < menuList.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", menuList.get(i).getMenuId());
            map.put("parentId", menuList.get(i).getMenuParentId());
            map.put("name", menuList.get(i).getMenuName());
            map.put("existed", true);
            if (menuList.get(i).getMenuParentId().equals("0"))
            {
                map.put("isParent", true);
                map.put("iconSkin", "diy01");
                map.put("icon", menuList.get(i).getMenuIcon());
            }
            else
            {
                map.put("url", menuList.get(i).getMenuUrl());
                map.put("target", menuList.get(i).getMenuTarget());
                map.put("icon", "skin/titlebar_arrow.gif");
                map.put("isParent", false);
                map.put("iconOpen", "<%=request.getContextPath()%>/libs/icons/tree_close.gif");
                map.put("iconClose", "<%=request.getContextPath()%>/libs/icons/tree_open.gif");
            }
            slist.add(map);
        }
        return slist;
    }

    @Override
    public User getSSOByLoginName(String username) {
        return userDao.getSSOByLoginName(username);
    }

    @Override
    public List<Map<String, Object>> queryMainMenuByUser(User user) {
        List<Menu> menuList = userDao.queryMenusByUser(user.getUserId());
        List<Map<String, Object>> slist = new ArrayList<Map<String,Object>>();
        for (Menu menu : menuList) {
            if (menu.getMenuParentId().equals("0")&&!menu.getMenuId().equals("1")) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", menu.getMenuId());
                map.put("parentId", menu.getMenuParentId());
                map.put("name", menu.getMenuName());
                if (menu.getMenuId().equals("21")){
                    map.put("icon", "../../libs/icons/png_128/256.png");
                    map.put("url", "../../proBacInfo/proBacInfo");
                }/*else if (menu.getMenuId().equals("22")){
                    map.put("icon", "../../libs/icons/png_128/004a.png");
                    map.put("url", "../../carryInsp/list");
                }else if (menu.getMenuId().equals("23")){
                    map.put("icon", "../../libs/icons/png_128/005a.png");
                    map.put("url", "../../bl/list");
                }*/else if (menu.getMenuId().equals("24")){
                    map.put("icon", "../../libs/icons/png_128/003.png");
                    map.put("url", "../../entInfo/list");
                }/*else if (menu.getMenuId().equals("25")){
                    map.put("icon", "../../libs/icons/png_128/009a.png");
                    map.put("url", "../../mail/checkList");
                }else if (menu.getMenuId().equals("41")){
                    map.put("icon", "../../libs/icons/png_128/006a.png");
                    map.put("url", "../../catering/toCompanyList");
                }else if (menu.getMenuId().equals("42")){
                    map.put("icon", "../../libs/icons/png_128/008a.png");
                    map.put("url", "../../aerobat/toAerobatBillList");
                }else if (menu.getMenuId().equals("222")){
                    map.put("icon", "../../libs/icons/png_128/015a.png");
                    map.put("url", "../../cfa/toCheckList");
                }else if (menu.getMenuId().equals("223")){
                    map.put("icon", "../../libs/icons/png_128/016a.png");
                    map.put("url", "../../ata/toAtaList");
                }*/

                slist.add(map);
            }
        }
        return slist;
    }

    @Override
    public PageView queryListPage(PageView pageView, User user) {
        List<User> list = userDao.queryListPage(pageView, user);
        pageView.setRows(list);
        return pageView;
    }
}
