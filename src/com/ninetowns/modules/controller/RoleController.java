package com.ninetowns.modules.controller;

import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.Role;
import com.ninetowns.modules.entity.RoleMenu;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.entity.UserRole;
import com.ninetowns.modules.service.RoleService;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @FileName : RoleController
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:34
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("list")
    public String list(){
        return "/pages/role/list";
    }

    @RequestMapping("query")
    public @ResponseBody Map<String,Object> query(@ModelAttribute Pager pager,String sort,String direction, String deptCode, Role role) {
        PageView pageView = new PageView(pager.getPageNo(),pager.getPageSize());
        pageView.setSort(sort);
        pageView.setDirection(direction);
        pageView = roleService.queryListPage(pageView, role);
        Map<String,Object> results = new Hashtable<String, Object>();
        results.put("pager.pageNo", pageView.getPager().getPageNo());
        results.put("pager.totalRows", pageView.getPager().getTotalRows());
        results.put("rows", pageView.getRows());
        results.put("sort", pageView.getSort());
        results.put("direction", pageView.getDirection());
        return results;
    }

    @RequestMapping("userRole")
    public String userRole(HttpServletRequest request,String roleId){
        List<User> userList = roleService.queryUsersByRoleId(roleId);
        List<String> checkedArray = new ArrayList<String>();
        List<String> checkedTextArray = new ArrayList<String>();
        for (User user : userList) {
            checkedArray.add(user.getUserId());
            checkedTextArray.add(user.getDisplayName());
        }
        request.setAttribute("roleId", roleId);
        request.setAttribute("checkedArray", checkedArray);
        request.setAttribute("checkedTextArray", checkedTextArray);
        return "/pages/role/userRole";
    }

    @RequestMapping("modifyRole")
    public String modifyRole(HttpServletRequest request,String roleId){
        Role role = roleService.getById(roleId);
        request.setAttribute("roleId", role.getRoleId());
        request.setAttribute("roleDesc", role.getRoleDesc());
        request.setAttribute("roleName", role.getRoleName());
        return "/pages/role/modifyRole";
    }

    @RequestMapping("add")
    public @ResponseBody Map<String, Object> add(Role role) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","操作失败！");
        map.put("status",false);
        try {
            roleService.add(role);
            map.put("msg","操作成功！");
            map.put("status",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("addUserRole")
    public @ResponseBody Map<String, Object> addUserRole(String roleId, String[] checkedArray) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","操作失败！");
        map.put("status",false);
        try {
            List<UserRole> userRoleList = new ArrayList<UserRole>();
            for (String userId : checkedArray) {
                if (!userId.equals("")){
                    UserRole userRole = new UserRole();
                    userRole.setRoleId(roleId);
                    userRole.setUserId(userId);
                    userRole.setDataValidFlag("001");
                    userRoleList.add(userRole);
                }
            }
            roleService.addUserRole(userRoleList,roleId);
            map.put("msg", "操作成功！");
            map.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    @RequestMapping("doUpdate")
    public @ResponseBody Map<String, Object> doUpdate(Role roles) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","操作失败！");
        map.put("status",false);
        try {
            Role role = new Role();
            role = roleService.getById(roles.getRoleId());
            role.setRoleDesc(roles.getRoleDesc());
            role.setRoleName(roles.getRoleName());
            roleService.modify(role);
            map.put("msg", "操作成功！");
            map.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("doDelete")
    public @ResponseBody Map<String, Object> doDelete(String ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","操作失败！");
        map.put("status",false);
        try {
            String sUrc = "";
            String sRmc = "";
            String[] id = ids.split(",");
            for(int i = 0 ; i < id.length ; i++){
                Role role = new Role();
                role = roleService.getById(id[i]);
                int urc = roleService.getURCount(id[i]); //用户关联
                int rmc = roleService.getRMCount(id[i]); //菜单关联
                if(urc > 0){
                    sUrc +=  role.getRoleName() + ",";
                }
                if(rmc > 0){
                    sRmc +=  role.getRoleName() + ",";
                }
            }
            String left = "";
            String right = "";
            if(!sUrc.equals("")){
                 left = sUrc+"的用户关联";
            }
            if(!sRmc.equals("")){
                 right = sRmc+"的菜单关联";
            }
            String all ="若要删除，请取消" + left + "；" + right;
            if(left.equals("")&&right.equals("")){
                for(int i = 0 ; i < id.length ; i++){
                    roleService.delete(id[i]);
                }
                map.put("msg","操作成功");
                map.put("status",true);
            }else {
                map.put("msg",all);
                map.put("status",false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("roleMenu")
    public String roleMenu(HttpServletRequest request,String roleId){
        request.setAttribute("roleId",roleId);
        return "pages/role/roleMenu";
    }

    @RequestMapping("addRoleMenu")
    public @ResponseBody Map<String, Object> addRoleMenu(String roleId, String[] checkedArray) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","操作失败！");
        map.put("status",false);
        try {
            List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
            for (String menuId : checkedArray){
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menuId);
                roleMenu.setDataValidFlag("001");
                roleMenuList.add(roleMenu);
            }
            roleService.addRoleMenu(roleMenuList,roleId);
            map.put("msg", "操作成功！");
            map.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
