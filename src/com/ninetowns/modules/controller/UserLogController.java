package com.ninetowns.modules.controller;

import com.ninetowns.core.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @FileName : UserLogController
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:41
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Controller
@RequestMapping("userLog")
public class UserLogController extends BaseController {

    @RequestMapping("list")
    public String list(){
        return "/pages/userLog/list";
    }
}
