package com.ninetowns.modules.controller;

import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.Project;
import com.ninetowns.modules.service.ProjectService;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Hashtable;
import java.util.Map;

/**
 * @FileName : ProjectController
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:27
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Controller
@RequestMapping("project")
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("list")
    public String list(){
        return "/pages/project/list";
    }


    @RequestMapping("query")
    public @ResponseBody Map<String,Object> query(@ModelAttribute Pager pager,String sort,String direction, String deptCode, Project project) {
        PageView pageView = new PageView(pager.getPageNo(),pager.getPageSize());
        pageView.setSort(sort);
        pageView.setDirection(direction);

//        String[] ids = deptService.queryDeptCodeByParentId(deptCode == null ? "3201" :deptCode);
//        user.setDeptIds(Common.createBlock(ids));

//        user.setDeptCode();
        pageView = projectService.queryListPage(pageView, project);
        Map<String,Object> results = new Hashtable<String, Object>();
        results.put("pager.pageNo", pageView.getPager().getPageNo());
        results.put("pager.totalRows", pageView.getPager().getTotalRows());
        results.put("rows", pageView.getRows());
        results.put("sort", pageView.getSort());
        results.put("direction", pageView.getDirection());
        return results;
    }

}
