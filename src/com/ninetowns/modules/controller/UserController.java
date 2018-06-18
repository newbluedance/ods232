package com.ninetowns.modules.controller;

import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.Dept;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.service.DeptService;
import com.ninetowns.modules.service.UserService;
import com.ninetowns.utils.Common;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @FileName : UserController
 * @Author : 周翔
 * @Create Date   : 2014-06-21 10:22
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description : 用户的Controller方法操作
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    /**
     * 进入用户列表页面
     *
     * @return 进入页面
     */
    @RequestMapping("list")
    public String list() {
        return "/pages/user/list";
    }

    /**
     * 存放返回界面的model
     *
     * @param pager     分页实体类
     * @param sort      排序字段
     * @param direction desc/asc
     * @param user      用户实体类
     * @return json值
     */
    @RequestMapping("query")
    public
    @ResponseBody
    Map<String, Object> query(@ModelAttribute Pager pager, String sort, String direction, String deptCode, User user) {
        PageView pageView = new PageView(pager.getPageNo(), pager.getPageSize());
        pageView.setSort(sort);
        pageView.setDirection(direction);
        if ("".equals(deptCode)) {
            deptCode = null;
        }
        String[] ids = deptService.queryDeptCodeByParentId(deptCode == null ? "3201" : deptCode);
        user.setDeptIds(Common.createBlock(ids));

//        user.setDeptCode();
        pageView = userService.queryListPage(pageView, user);
        Map<String, Object> results = new Hashtable<String, Object>();
        results.put("pager.pageNo", pageView.getPager().getPageNo());
        results.put("pager.totalRows", pageView.getPager().getTotalRows());
        results.put("rows", pageView.getRows());
        if (pageView.getSort() != null) {
            results.put("sort", pageView.getSort());
        }
        if (pageView.getDirection() != null) {
            results.put("direction", pageView.getDirection());
        }
        return results;
    }

    /**
     * 保存数据
     *
     * @param model model
     * @param user  用户实体类
     * @return 返回页面
     */
    @RequestMapping("add")
    public String add(Model model, User user) {
        userService.add(user);
        return "redirect:query";
    }

    @RequestMapping("toAdd")
    public String toAdd(Model model, String orgId) {
//        if(!orgId.equals("")){
//            List<Dept> deptList = deptService.getByPid(orgId);
//        }
        model.addAttribute("orgId", orgId);
        return "/pages/user/toAdd";
    }

    /**
     *
     *
     * @param
     * @param
     * @return
     */
//    @RequestMapping("getDeptAjax")
//    public @ResponseBody Map<String,Object> getDeptAjax(String pid) {
//        List<PostDebar> postDebarList = new ArrayList<PostDebar>();
//        postDebarList = postMailService.queryPostDebarList(pid,"pId");
//        List<Map<String, Object>> rlist = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < postDebarList.size() ; i++) {
//            Map<String,Object> rs = new Hashtable<String, Object>();
//            rs.put("value",postDebarList.get(i).getDebarId());
//            rs.put("key",postDebarList.get(i).getDebarName());
//            rlist.add(rs);
//        }
//
//        Map<String,Object> results = new Hashtable<String, Object>();
//        results.put("list", rlist);
//        return results;
//    }

    /**
     * 跑到新增界面
     *
     * @return 返回页面
     */
    @RequestMapping("addUI")
    public String addUI() {
        return "/pages/user/add";
    }

    /**
     * 删除
     *
     * @param model  model
     * @param userId 用户ID
     * @return 返回页面
     */
    @RequestMapping("deleteById")
    public String deleteById(Model model, String userId) {
        userService.delete(userId);
        return "redirect:query";
    }

    /**
     * 修改界面
     *
     * @param model  model
     * @param userId 用户ID
     * @param type   类型
     * @return 页面
     */
    @RequestMapping("getById")
    public String getById(Model model, String userId, int type) {
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        /*List<Roles> roles=rolesService.findAll();
        model.addAttribute("roles", roles);*/
        if (type == 1) {
            return "/pages/user/edit";
        } else {
            return "/pages/user/show";
        }
    }

    /**
     * 更新类型
     *
     * @param model model
     * @return
     */
    @RequestMapping("update")
    public String update(Model model, User user/*,UserRoles userRoles*/) {
        userService.modify(user);
       /* if(userRoles.getRoleId()!=null)
            rolesService.saveUserRole(userRoles);*/
        return "redirect:query";
    }

    @RequestMapping("password")
    public String password() {
        return "/pages/user/password";
    }

    @RequestMapping("modifyPassword")
    public
    @ResponseBody
    String modifyPassword(HttpServletRequest request, String oldPwd, String userPwd) {
        String code = "0";//默认不成功
        try {
            User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
            if (user.getLoginPwd().equals(oldPwd)) {
                user.setLoginPwd(userPwd);
            }
            userService.modify(user);
            code = "1";//操作成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 删除所选的
     *
     * @param model model
     * @return 返回页面
     */
    @RequestMapping("deleteAll")
    public String deleteAll(Model model, String[] check) {
        for (String string : check) {
            userService.delete(string);
        }
        return "redirect:query";
    }

    /**
     * 给用户分配角色界面
     *
     * @return 返回页面
     */
    @RequestMapping("userRole")
    public String userRole(Model model, String userId) {
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        /*List<Roles> roles = rolesService.findAll();
        model.addAttribute("roles", roles);*/
        return "/pages/user/userRole";
    }

    @RequestMapping("queryMenus")
    public @ResponseBody List<Map<String, Object>> queryMenus(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
        List<Map<String, Object>> menuMap = userService.queryMenusByUser(user);
        return menuMap;
    }

    @RequestMapping("queryMainMenu")
    public @ResponseBody List<Map<String, Object>> queryMainMenu(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
        List<Map<String, Object>> menuMap = userService.queryMainMenuByUser(user);
        return menuMap;
    }

}
