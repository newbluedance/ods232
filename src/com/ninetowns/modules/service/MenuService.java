package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * @FileName : MenuService
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:18
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface MenuService {
    public List<Menu> queryAll(Menu menu);

    public Menu add(Menu menu);

    public void modify(Menu menu);

    public void delete(String menuId);

    public List<Map<String, Object>> queryAllByRoleId(Menu menu, String roleId);
}
