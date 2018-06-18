package com.ninetowns.modules.controller;

import com.ninetowns.modules.entity.Expects;
import com.ninetowns.core.BaseController;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
import com.ninetowns.modules.service.ExpectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
* @FileName :ExpectsController
* @Author : licf
* @Create Date : 2015-11-04 15:11:46
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
@Controller
@RequestMapping("/expects")
public class ExpectsController extends BaseController{

	@Autowired
	private ExpectsService		expectsService;

	private PageView			pageView;

	/**
	 * 
	 * @return 主页面
	 */
	@RequestMapping("expects")
	public String expects() {
		return "/pages/ods/expects/expectsList";
	}

	/**
	 *
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param expects
	 * @return 主页面列表
	 */
	@RequestMapping("expectsList")
	public @ResponseBody
	Map<String, Object> expectsList(@ModelAttribute Pager pager, String sort, String direction, Expects expects) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		pageView = expectsService.queryListPage(pageView, expects);
		Map<String, Object> results = new Hashtable<String, Object>();
		results.put("pager.pageNo", pageView.getPager().getPageNo());
		results.put("pager.totalRows", pageView.getPager().getTotalRows());
		results.put("rows", pageView.getRows());
		return results;
	}

	/**
	 *
	 * @param model
	 * @param request
	 * @return 到新增页面
	 */
	@RequestMapping("toAdd")
	public String toAdd(Model model, HttpServletRequest request) {
		return "/pages/ods/expects/expectsAdd";
	}

	/**
	 * 
	 * @param model
	 * @param expects
	 * @return 新增完成后到主页面
	 */
	@RequestMapping("addExpects")
	public String addExpects(Model model, Expects expects) {
		expectsService.add(expects);
		return "/pages/ods/expects/expectsList";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到查看页面
	 */
	@RequestMapping("toDetail")
	public String toDetail(Model model, HttpServletRequest request) {
		String exId = request.getParameter("exId");
		System.out.println(exId);
		Expects expects = expectsService.getById(exId);
		System.out.println(expects);
		model.addAttribute("expects", expects);
		return "/pages/ods/expects/expectsDetail";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到修改页面
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Model model, HttpServletRequest request) {
		String exId = request.getParameter("exId");
		Expects expects = expectsService.getById(exId);
		model.addAttribute("expects", expects);
		return "/pages/ods/expects/expectsUpdate";
	}

	/**
	 * 
	 * @param model
	 * @param expects
	 * @return 修改完成后到主页面
	 */
	@RequestMapping("updateExpects")
	public String updateExpects(Model model, Expects expects) {
		expectsService.modify(expects);
		return "/pages/ods/expects/expectsList";
	}
	/**
	 * 
	 * @param model
	 * @param expects
	 * @return 删除完成后到主页面
	 */
	@RequestMapping("del")
	public String del(Model model, Expects expects) {
		expectsService.delete(expects.getExId());
		return "/pages/ods/expects/expectsList";
	}

}
