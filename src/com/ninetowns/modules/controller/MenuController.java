package com.ninetowns.modules.controller;

import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.Menu;
import com.ninetowns.modules.service.MenuService;
import com.ninetowns.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName : MenuController
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:13
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Controller
@RequestMapping("menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * 进入菜单列表页面
     * @return 进入页面
     */
    @RequestMapping("list")
    public String list(){
        return "/pages/menu/list";
    }

    @RequestMapping("query")
    public @ResponseBody List<Map<String, Object>> query(Menu menu, String roleId){
        List<Map<String, Object>> menuMap = menuService.queryAllByRoleId(menu,roleId);
        return menuMap;
    }

    /**
     * 保存数据
     *
     * @param menu 菜单实体类
     * @return 返回菜单的json数据
     */
    @RequestMapping("add")
    public @ResponseBody Menu add(Menu menu) {
        return menuService.add(menu);
    }

    /**
     * 修改菜单数据
     * @param menu 菜单实体类
     * @return 返回菜单的json数据
     */
    @RequestMapping("modify")
    public @ResponseBody Menu modify(Menu menu) {
        menuService.modify(menu);
        return menu;
    }

    /**
     * 根据菜单ID号删除对应记录
     * @param menuId 菜单ID
     * @return 返回删除状态
     */
    @RequestMapping("delete")
    public @ResponseBody String delete(String menuId){
        String code = "0";
        try{
            menuService.delete(menuId);
            code = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return code;
    }

}
