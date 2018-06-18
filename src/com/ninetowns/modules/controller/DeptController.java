package com.ninetowns.modules.controller;

import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.Dept;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.service.DeptService;
import com.ninetowns.utils.Common;
import com.ninetowns.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @FileName : DeptController
 * @Author : 周翔
 * @Create Date   : 2014-06-27 20:21
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description : 部门Controller
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    /**
     * 进入部门列表页面
     * @return 进入页面
     */
    @RequestMapping("list")
    public String list(){
        return "/pages/dept/list";
    }

    /**
     * 查询部门信息
     * @param dept 部门
     * @return 返回json数据
     */
    @RequestMapping("query")
    public @ResponseBody List<TreeNode> query(Dept dept){
        List<TreeNode> deptList = deptService.queryAllTree();
//        this.setTreeNodes(new ArrayList<TreeNode>());
//        for(Dept dep : deptList){
//            TreeNode node = deptService.convert(dep);
//            this.getTreeNodes().add(node);
//        }
        return deptList;
    }

    @RequestMapping("modify")
    public @ResponseBody
    Map<String,Object> modify (HttpServletRequest request,String deptId,String deptCode, String deptName,String address,String zipCode,String sortIndex,String deptType)
    {

        User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
        Map<String,Object> results = new HashMap<String, Object>();
        Dept dept = new Dept();
        dept = deptService.getById(deptId);
        dept.setDeptCode(deptCode);
        dept.setDeptName(deptName);
        dept.setAddress(address);
        dept.setZipCode(zipCode);
        dept.setSortIndex(sortIndex);
        dept.setDeptType(deptType);
        dept.setDataUpdTime(new Date());
        dept.setDataUpdUser(user.getLoginName());
        deptService.doUpdate(dept);
        results.put("dept",dept);
        return results;
    }

    @RequestMapping("deleteDept")
    public @ResponseBody
    Map<String,Object> deleteDept (HttpServletRequest request,String deptId)
    {
        Map<String,Object> results = new HashMap<String, Object>();
        deptService.delete(deptId);
//        results.put("dept",dept);
        return results;
    }

    @RequestMapping("queryHave")
    public @ResponseBody
    Map<String,Object> queryHave (HttpServletRequest request,String deptCode)
    {
        Map<String,Object> results = new HashMap<String, Object>();
        int i = deptService.queryDeptCode(deptCode);
        if(i==0)
        {
            results.put("result","empty");
        }else
        if(i!=0)
        {
            results.put("result","have");
        }
//        results.put("result","empty");
//        results.put("result","have");
        return results;
    }

    @RequestMapping("createDept")
    public @ResponseBody
    Map<String,Object> createDept (Dept dept,HttpServletRequest request)
    {
      User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
      String deptCode = "";
      String x = deptService.getMaxCount(dept.getDeptParentId()+"%");
        if(x.equals(dept.getDeptParentId())){
            deptCode = x + "001";
        }else
        {
            DecimalFormat df = new DecimalFormat("000");
            String first = x.substring(0,x.length()-3);
            String second = String.valueOf(df.format(Integer.parseInt(x.substring(x.length()-3,x.length()))+1));
            deptCode = first + second;
        }
        dept.setDeptCode(deptCode);
        dept.setCrtTime(new Date());
        dept.setCrtUser(user.getLoginName());
        dept = deptService.add(dept);
        Map<String,Object> results = new HashMap<String, Object>();
        results.put("dept",dept);
        return results;
    }

}
