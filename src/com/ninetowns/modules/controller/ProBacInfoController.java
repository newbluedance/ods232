package com.ninetowns.modules.controller;

import com.ninetowns.modules.entity.ExcField;
import com.ninetowns.modules.entity.ProBacInfo;
import com.ninetowns.modules.entity.User;
import com.ninetowns.core.BaseController;
import com.ninetowns.utils.Common;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
import com.ninetowns.modules.service.ExcFieldService;
import com.ninetowns.modules.service.ProBacInfoService;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

/**
 * @FileName :ProBacInfoController
 * @Author : licf
 * @Create Date : 2015-10-09 18:48:03
 * @Email : lcfsxg@qq.com
 * @Last Modified :
 * @Description :
 */
@Controller
@RequestMapping("/proBacInfo")
public class ProBacInfoController extends BaseController {

	@Autowired
	private ProBacInfoService	proBacInfoService;
	
	@Autowired
	private ExcFieldService excFieldService;

	private PageView			pageView;

	/**
	 * 
	 * @return 主页面
	 */
	@RequestMapping("proBacInfo")
	public String proBacInfo() {
		return "/pages/ods/proBacInfo/proBacInfoList";
	}

	/**
	 * 
	 * @return 审核页面
	 */
	@RequestMapping("proBacInfoCheckConent")
	public String proBacInfoCheckConent() {
		return "/pages/ods/proBacInfo/proBacInfoCheckConentList";
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param proBacInfo
	 * @return 主页面列表
	 */
	@RequestMapping("proBacInfoList")
	public @ResponseBody
	Map<String, Object> proBacInfoList(@ModelAttribute Pager pager, String sort, String direction, ProBacInfo proBacInfo) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		pageView = proBacInfoService.queryListPageForDesc(pageView, proBacInfo);
		Map<String, Object> results = new Hashtable<String, Object>();
		results.put("pager.pageNo", pageView.getPager().getPageNo());
		results.put("pager.totalRows", pageView.getPager().getTotalRows());
		results.put("rows", pageView.getRows());
		return results;
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param proBacInfo
	 * @return 审核主页面列表
	 */
	@RequestMapping("proBacInfoCheckConentList")
	public @ResponseBody
	Map<String, Object> proBacInfoCheckConentList(@ModelAttribute Pager pager, String sort, String direction, ProBacInfo proBacInfo) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		List<String> stateList=new ArrayList<String>();
		stateList.add("1");
		stateList.add("2");
		stateList.add("3");
		proBacInfo.setStateList(stateList);
		pageView = proBacInfoService.queryListPageForDesc(pageView, proBacInfo);
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
		Date date = new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = from.format(date);
		request.setAttribute("createDate", createDate);
		return "/pages/ods/proBacInfo/proBacInfoAdd";
	}

	/**
	 * 
	 * @param model
	 * @param proBacInfo
	 * @return 新增完成后到主页面
	 */
	@RequestMapping("addProBacInfo")
	public String addProBacInfo(Model model, ProBacInfo proBacInfo, HttpServletRequest request) {
		String year = request.getParameter("createDate");
		String y = year.replace("-", "");
		String yy = y.substring(2, 6);

		String a = year.substring(0, year.length()-3); 
		System.out.println("+++++++++++++++"+a);

		String no = proBacInfoService.queryByMax(a);
		System.out.println("+++++++++++++++"+no);
		if(no == "" || no == null){
			no = yy.trim()+"000001";
		}else {
			no =String.valueOf(Long.parseLong(no.trim())+1);
		}
		System.out.println("+++++++++++++++"+no);
		//添加产品
		proBacInfo.setProId(no);
		proBacInfo.setState("0");
		proBacInfo=proBacInfoService.add(proBacInfo);
		
		//添加产品扩展属性值
		String excFields = request.getParameter("excFields");
		JSONArray jsonArray = JSONArray.fromObject(excFields);
		String classId=proBacInfo.getProId();//此处关联产品Id
		String fieldKey = null;
		String fieldValue = null;
		ExcField excField=new ExcField();
		excField.setClassId(classId);
		for (int i = 0; i < jsonArray.size(); i++) {
			fieldKey = jsonArray.getJSONObject(i).get("name").toString();
			fieldValue = jsonArray.getJSONObject(i).get("value").toString();
			excField.setFieldKey(fieldKey);
			excField.setFieldValue(fieldValue);
			excFieldService.add(excField);
		}

		return "/pages/ods/proBacInfo/proBacInfoList";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到查看页面
	 */
	@RequestMapping("toDetail")
	public String toDetail(Model model, HttpServletRequest request) {
		String proId = request.getParameter("proId");
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		return "/pages/ods/proBacInfo/proBacInfoDetail";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到修改页面
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Model model, HttpServletRequest request) {
		String proId = request.getParameter("proId");
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		return "/pages/ods/proBacInfo/proBacInfoUpdate";
	}

	/**
	 * 
	 * @param model
	 * @param proBacInfo
	 * @return 修改完成后到主页面
	 */
	@RequestMapping("updateProBacInfo")
	public String updateProBacInfo(Model model, ProBacInfo proBacInfo, HttpServletRequest request) {
		
		
		//编辑产品扩展属性值
				String excFields = request.getParameter("excFields");
				JSONArray jsonArray = JSONArray.fromObject(excFields);
				String fieldValue;
				ExcField excField=new ExcField();
				
				String excClassId=proBacInfo.getProId();//此处关联产品Id
				if (proBacInfo.getClassId()!=null&&proBacInfo.getClassId().equals(proBacInfoService.getById(excClassId).getClassId())) {//类别不变
					String fieldId;
					excField.setClassId(excClassId);
					for (int i = 0; i < jsonArray.size(); i++) {
						fieldId = jsonArray.getJSONObject(i).get("name").toString();
						fieldValue = jsonArray.getJSONObject(i).get("value").toString();
						excField=excFieldService.getById(fieldId);
						System.out.println("===="+excField);
						excField.setFieldValue(fieldValue);
						excFieldService.modify(excField);
					}
				}else{//类别改变
					//删除无用的属性
					excFieldService.deleteByClassId(excClassId);
					//添加产品扩展属性值
					String fieldKey;
					excField.setClassId(excClassId);
					for (int i = 0; i < jsonArray.size(); i++) {
						fieldKey = jsonArray.getJSONObject(i).get("name").toString();
						fieldValue = jsonArray.getJSONObject(i).get("value").toString();
						excField.setFieldKey(fieldKey);
						excField.setFieldValue(fieldValue);
						excFieldService.add(excField);
					}
				}
				
				proBacInfo.setState("0");
				proBacInfoService.modify(proBacInfo);
		return "/pages/ods/proBacInfo/proBacInfoList";
	}

	/**
	 * 
	 * @param model
	 * @param hisInfo
	 * @return 删除完成后到主页面
	 */
	@RequestMapping("delProBacInfo")
	public String delProBacInfo(Model model, HttpServletRequest request) {
		String proId = request.getParameter("proId");
		proBacInfoService.delete(proId);
		//删除无用的属性
		excFieldService.deleteByClassId(proId);
		return "/pages/ods/proBacInfo/proBacInfoList";
	}

	/**
	 * 
	 * @param model
	 * @param hisInfo
	 * @return 提交完成后到主页面
	 */
	@RequestMapping("toTijiao")
	public String toTijiao(Model model, HttpServletRequest request) {
		String proId = request.getParameter("proId");
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		proBacInfo.setState("1");
		proBacInfo.setCheckConent(null);
		proBacInfo.setCheckDate(null);
		proBacInfo.setCheckName(null);
		proBacInfoService.updateState(proBacInfo);

		return "/pages/ods/proBacInfo/proBacInfoList";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到审核详情页面
	 */
	@RequestMapping("toCheck")
	public String toCheck(Model model, HttpServletRequest request) {
		String proId = request.getParameter("proId");
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		//用户
		User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
		model.addAttribute("user", user);
		return "/pages/ods/proBacInfo/proBacInfoCheckConentAdd";
	}

	/**
	 * 
	 * @param model
	 * @param proBacInfo
	 * @return 审核通过后到审核主页面
	 */
	@RequestMapping("updateCheck")
	public String updateCheck(Model model, String proId, ProBacInfo proBacInfo) {
		// ProBacInfo proBacInfo=proBacInfoService.getById(proId);

		proBacInfo.setProId(proId);
		System.out.println(proBacInfo);
		Date date = new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
		String checkDate = from.format(date);
		proBacInfo.setCheckDate(checkDate);
		proBacInfoService.updateState(proBacInfo);
		return "/pages/ods/proBacInfo/proBacInfoCheckConentList";
	}

	

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 审核后到查看页面
	 */
	@RequestMapping("toCheckDetail")
	public String toCheckDetail(Model model, HttpServletRequest request) {
		String proId = request.getParameter("proId");
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		return "/pages/ods/proBacInfo/proBacInfoCheckConentDetail";
	}

}
