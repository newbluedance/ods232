package com.ninetowns.modules.controller;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.smartcardio.ATR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.EntInfo;
import com.ninetowns.modules.service.EntInfoService;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
/**
 * 企业控制层
 * @author 马振勇
 *
 */
@Controller
@RequestMapping("entInfo")
public class EntInfoController extends BaseController {
	@Autowired
	private EntInfoService entInfoService;

	/**
	 * 主页面
	 */
	@RequestMapping("list")
	public String list (Model model){
		return "/pages/ods/EntInfo/list";
	}
	/**
	 * 查询页面
	 */
	@RequestMapping("queryList")
	public @ResponseBody Map<String, Object> queryList
    (@ModelAttribute Pager pager
	, HttpServletRequest request
	, EntInfo l , String sort
	, String direction)
	
			{
		PageView pageView = new PageView(pager.getPageNo(),pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		pageView = entInfoService.queryListPage(pageView, l);
		Map<String,Object> results = new Hashtable<String, Object>();
		results.put("pager.pageNo", pageView.getPager().getPageNo());
		results.put("pager.totalRows", pageView.getPager().getTotalRows());
		results.put("rows", pageView.getRows());
		return results;

	}
	@RequestMapping("see")
	public String see(HttpServletRequest request,Model model,String entRegCode){
		EntInfo info=entInfoService.getById(entRegCode);
		model.addAttribute("info",info);
		return "/pages/ods/EntInfo/see";
	}
	@RequestMapping("seeDecl")
	public String seeDecl(HttpServletRequest request,Model model,String entRegCode){
		EntInfo info=entInfoService.getById(entRegCode);
		model.addAttribute("info",info);
		return "/pages/ods/EntInfo/Declpersonlist";
	}
}
