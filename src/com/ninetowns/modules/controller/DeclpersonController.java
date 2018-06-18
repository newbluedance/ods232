package com.ninetowns.modules.controller;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.DeclPerson;
import com.ninetowns.modules.service.DeclPersonService;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
/**
 * 报检人员控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("DeclPerson")
public class DeclpersonController extends BaseController {
	@Autowired
	private DeclPersonService declPersonService;
	@RequestMapping("queryList")
	public @ResponseBody Map<String, Object> queryList
    (@ModelAttribute Pager pager
	, HttpServletRequest request
	, DeclPerson l , String sort
	, String direction)
	
			{
		PageView pageView = new PageView(pager.getPageNo(),pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		pageView = declPersonService.queryListPage(pageView, l);
		
		Map<String,Object> results = new Hashtable<String, Object>();
		results.put("pager.pageNo", pageView.getPager().getPageNo());
		results.put("pager.totalRows", pageView.getPager().getTotalRows());
		results.put("rows", pageView.getRows());
		System.out.println(pageView.getRows());
		return results;

	}
	@RequestMapping("see")
	public String see(HttpServletRequest request,Model model,String declPersonCode){
		DeclPerson dp=declPersonService.getById(declPersonCode);
		model.addAttribute("dp",dp);
		return "/pages/ods/EntInfo/seeDel";
	}

}
