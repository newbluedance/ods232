package com.ninetowns.modules.controller;

import com.ninetowns.core.BaseController;
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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @FileName : UserController
 * @Author : 周翔
 * @Create Date   : 2014-06-21 10:22
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description : 用户的Controller方法操作
 */
@Controller
@RequestMapping("/utils")
public class UtilsController extends BaseController {

    /**
     * 保存数据
     *
     * @param model model
     * @param
     * @return 返回页面
     */
    @RequestMapping("machine")
    public String machine(Model model) {
        return "/pages/utils/machine";
    }
    @RequestMapping("money")
    public String money(Model model) {
        return "/pages/utils/money";
    }

}
