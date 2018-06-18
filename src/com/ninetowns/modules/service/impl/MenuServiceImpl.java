package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.dao.MenuDao;
import com.ninetowns.modules.dao.RoleMenuDao;
import com.ninetowns.modules.entity.Menu;
import com.ninetowns.modules.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName : MenuServiceImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:19
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public List<Menu> queryAll(Menu menu) {
        return menuDao.queryAll(menu);
    }

    @Override
    public Menu add(Menu menu) {
        return menuDao.add(menu);
    }

    @Override
    public void modify(Menu menu) {
        menuDao.modify(menu);
    }

    @Override
    public void delete(String menuId) {
        menuDao.delete(menuId);
    }

    @Override
    public List<Map<String, Object>> queryAllByRoleId(Menu menu, String roleId) {
        List<String> menuIds = new ArrayList<String>();
        if (roleId != null) {
            menuIds = roleMenuDao.queryMenusByRoleId(roleId);
        }
        List<Menu> menuList = menuDao.queryAll(menu);
        List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
        for (Menu me : menuList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", me.getMenuId());
            map.put("name", me.getMenuName());
            map.put("parentId", me.getMenuParentId());
            map.put("desc", me.getMenuDesc());
            map.put("target", me.getMenuTarget());
            map.put("url", me.getMenuUrl());
            map.put("icon", me.getMenuIcon());
            map.put("order", me.getMenuOrder());
            map.put("existed", true);
            if (me.getMenuLevel().equals("1")) {
                map.put("isParent", "true");
                map.put("iconSkin", "diy01");
            } else {
                map.put("isParent", false);
            }
            if (menuIds.contains(me.getMenuId())){
                map.put("checked",true);
            }
            mapList.add(map);
        }
        return mapList;
    }
}
