package com.ninetowns.modules.controller;

import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.service.UserService;
import com.ninetowns.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @FileName : BackgroundController
 * @Author : 周翔
 * @Create Date   : 2014-06-21 10:41
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Controller
@RequestMapping("/")
public class BackgroundController {

    @Autowired
    private UserService userService;

    /**
     * @return
     */
    @RequestMapping ("login")
    public String login(Model model,HttpServletRequest request)
    {
        return "/system/flatBlue_login/login";
//        return "/system/login";
    }

    @RequestMapping ("logout")
    public String logout(HttpServletRequest request){
        Object o = request.getSession().getAttribute(Common.LOGIN_USER);
        if(null != o){
            //销毁该用户的Session
            request.getSession().removeAttribute(Common.LOGIN_USER);
        }
        return "redirect:login";
    }

    @RequestMapping("loginCheck")
    public String loginCheck(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        User users = null;
        try {
            HttpSession session = request.getSession();
            User uu = (User) session.getAttribute(Common.LOGIN_USER);

            if (uu != null){
                if (username.equals(uu.getLoginName())&&password.equals(uu.getLoginPwd())) {
                    return "redirect:main";
                    /*if (uu.getUserType().trim().equals("3")) {
                        return "redirect:backdoor";
                    } else if (uu.getUserType().trim().equals("0")) {
                        return "redirect:main";
                    }*/
                }
            }

            if (Common.isEmpty(username) || Common.isEmpty(password)) {
                request.setAttribute("error", "用户名或密码不能为空！");
                return "/system/flatBlue_login/login";
//                return "/system/login";
            }
            // 验证用户账号与密码是否正确
            users = userService.querySingleUser(username);

            if (users == null){
                //获得平台登录账户
                User bauser = userService.getSSOByLoginName(username);
                if (bauser == null){
                    request.setAttribute("error", "用户不存在，请联系管理员！");
//                    return "/system/login";
                    return "/system/flatBlue_login/login";
                }
                users = new User();
                users = bauser;
                try {
                    userService.add(bauser);
                } catch (Exception e) {
                    request.setAttribute("error", "导入SSO用户异常，请联系管理员！");
//                    return "/system/login";
                    return "/system/flatBlue_login/login";
                }

            }
            if (!users.getLoginPwd().equals(password)) {
                request.setAttribute("error", "用户或密码不正确！");
//                return "/system/login";
                return "/system/flatBlue_login/login";
            }

            // 当验证都通过后，把用户信息放在session里
            request.getSession().setAttribute(Common.LOGIN_USER, users);
           /* // 记录登录信息
            UserLoginList userLoginList = new UserLoginList();
            userLoginList.setUserId(users.getUserId());
            userLoginList.setLoginIp(Common.toIpAddr(request));
            userLoginListService.add(userLoginList);*/
        } catch (Exception ae) {
            request.setAttribute("error", "登录异常，请联系管理员！");
//            return "/system/login";
            return "/system/flatBlue_login/login";
        }
//        if (users.getUserType().trim().equals("3")) {
//            return "redirect:backdoor";
//        }
        return "redirect:main";
    }

    /**
     * @return
     */
    @RequestMapping ("main")
    public String index(Model model)
    {
        return "/system/blue1_accordion/main";
    }

    @RequestMapping ("backdoor")
    public String backdoor(Model model)
    {
        return "/system/blue1_accordion/main";
    }
}
