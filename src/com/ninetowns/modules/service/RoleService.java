package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.Role;
import com.ninetowns.modules.entity.RoleMenu;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.entity.UserRole;
import com.ninetowns.utils.PageView;

import java.util.List;

/**
 * @FileName : RoleService
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:36
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface RoleService {
    public PageView queryListPage(PageView pageView, Role role);

    public void add(Role role);

    public void addUserRole(List<UserRole> userRoleList, String roleId);

    public List<User> queryUsersByRoleId(String roleId);

    public void addRoleMenu(List<RoleMenu> roleMenuList, String roleId);


    public Role getById(String roleId);

    public void modify(Role role);

    public int getURCount(String s);

    public int getRMCount(String s);

    public void delete(String s);
}
