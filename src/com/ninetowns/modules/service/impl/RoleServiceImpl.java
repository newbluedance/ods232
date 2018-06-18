package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.dao.RoleDao;
import com.ninetowns.modules.dao.RoleMenuDao;
import com.ninetowns.modules.dao.UserRoleDao;
import com.ninetowns.modules.entity.Role;
import com.ninetowns.modules.entity.RoleMenu;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.entity.UserRole;
import com.ninetowns.modules.service.RoleService;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @FileName : RoleServiceImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:36
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    public RoleDao roleDao;

    @Autowired
    public UserRoleDao userRoleDao;

    @Autowired
    public RoleMenuDao roleMenuDao;

    @Override
    public PageView queryListPage(PageView pageView, Role role) {
        List<Role> list = roleDao.queryListPage(pageView, role);
        pageView.setRows(list);
        return pageView;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public void addUserRole(List<UserRole> userRoleList, String roleId) {
        userRoleDao.delete(roleId);
        Integer i = userRoleDao.addUserRoleBatch(userRoleList);
        System.out.println("添加了 " + i+" 条用户角色表信息");
    }

    @Override
    public List<User> queryUsersByRoleId(String roleId) {
        return userRoleDao.queryUsersByRoleId(roleId);
    }

    @Override
    public void addRoleMenu(List<RoleMenu> roleMenuList, String roleId) {
        roleMenuDao.delete(roleId);
        Integer i = roleMenuDao.addRoleMenuBatch(roleMenuList);
        System.out.println("添加了 " + i+" 条用户角色表信息");
    }

    @Override
      public Role getById(String roleId) {
        return roleDao.getById(roleId);
    }

    @Override
    public void modify(Role role) {
        roleDao.modify(role);
    }


    public int getURCount(String s){
        return roleDao.getURCount(s);
    }

    public int getRMCount(String s){
        return roleDao.getRMCount(s);
    }

    public void  delete (String s){
         roleDao.delete(s);
    }
}
