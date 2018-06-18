package com.ninetowns.interceptor;

import com.ninetowns.modules.entity.User;
import com.ninetowns.utils.Common;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @FileName : HandlerInterceptor
 * @Author : 周翔
 * @Create Date   : 2014-06-25 14:19
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public class ControllerInterceptor extends HandlerInterceptorAdapter {

    /**
     * 在Controller方法前进行拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getContextPath();
        String uri = request.getRequestURI().substring(path.length());
//        System.out.println(uri + ", method:" + request.getParameter("method"));
        User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
        if (user != null ) {
            return true;
        } else {
            if (uri.equals("/logout") || uri.contains("/login") || uri.equals("/") || uri.equals("/loginCheck")
                    ||uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".jpg")||uri.endsWith(".bmp")) {
                return true;
            } else {
                //request.getRequestDispatcher("/system/login.jsp").forward(request, response);
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter writer = response.getWriter();
                if (path.equals("")){
                    path = "/";
                }
                writer.write("<script type='text/javascript'>" + "alert('您已经登录超时，请重新登录！');" + "setTimeout(function(){" + "top.window.location='" + path + "';" + "},1000);" + "</script>");
//                System.out.println("<script type='text/javascript'>" + "alert('您已经登录超时，请重新登录！');" + "setTimeout(function(){" + "top.window.location='" + path + "';" + "},1000);" + "</script>");
                writer.flush();
                writer.close();
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("HandlerInterceptor.postHandle");
    }

    /**
     * 在Controller方法后进行拦截
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("HandlerInterceptor.afterCompletion");
    }

}
