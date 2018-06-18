package com.ninetowns.modules.controller;

import com.ninetowns.modules.entity.ClassField;
import com.ninetowns.modules.entity.ExcField;
import com.ninetowns.modules.entity.ProClass;
import com.ninetowns.modules.entity.QuiSelect;
import com.ninetowns.core.BaseController;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
import com.ninetowns.modules.service.ClassFieldService;
import com.ninetowns.modules.service.ExcFieldService;
import com.ninetowns.modules.service.ProClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * @FileName :ProClassController
 * @Author : licf
 * @Create Date : 2015-10-09 22:17:15
 * @Email : lcfsxg@qq.com
 * @Last Modified :
 * @Description :
 */
@Controller
@RequestMapping("/proClass")
public class ProClassController extends BaseController {

	@Autowired
	private ProClassService		proClassService;

	@Autowired
	private ClassFieldService	classFieldService;
	@Autowired
	private ExcFieldService		excFieldService;

	private PageView			pageView;

	/**
	 * 
	 * @return 主页面
	 */
	@RequestMapping("proClass")
	public String proClass() {
		return "/pages/ods/proClass/proClassList";
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param proClass
	 * @return 主页面列表
	 */
	@RequestMapping("proClassList")
	public @ResponseBody
	List<Map<String, Object>> proClassList(@ModelAttribute Pager pager, String sort, String direction, ProClass proClass, String classId) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		mapList = proClassService.queryAllByClassId(proClass, classId);
		return mapList;
	}

	/**
	 * 
	 * @param model
	 * @param proClass
	 * @return 新增完成后到主页面
	 */
	@RequestMapping("addProClass")
	public @ResponseBody
	ProClass addProClass(Model model, ProClass proClass) {
		return proClassService.add(proClass);
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到查看页面
	 */
	@RequestMapping("toDetail")
	public String toDetail(Model model, HttpServletRequest request) {
		String classId = request.getParameter("classId ");
		ProClass proClass = proClassService.getById(classId);
		model.addAttribute("proClass", proClass);
		return "/pages/ods/proClass/proClassDetail";
	}

	/**
	 * 
	 * @param model
	 * @param proClass
	 * @return 修改完成后到主页面
	 */
	@RequestMapping("updateProClass")
	public @ResponseBody
	ProClass updateProClass(Model model, ProClass proClass) {
		proClassService.modify(proClass);
		return proClass;
	}

	/**
	 * 删除对应记录
	 * 
	 * @param
	 * @return 返回删除状态
	 */
	@RequestMapping("deleteProClass")
	public @ResponseBody
	String deleteProClass(String classId) {
		String code = "0";
		try {
			proClassService.delete(classId);
			code = "1";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}

	/**
	 * 
	 * @param model
	 * @param classField
	 * @return 新增shuxing
	 */
	@RequestMapping("addClassField")
	public @ResponseBody
	ClassField addClassField(Model model, ClassField classField) {
		String cfId = classField.getCfId();
		if (cfId != null && !"".equals(cfId)) {
			classFieldService.modify(classField);
		} else {
			classField = classFieldService.add(classField);
		}
		return classField;
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param
	 * @return 根据ClassId
	 */
	@RequestMapping("queryClassField")
	public @ResponseBody
	List<ClassField> queryClassField(@ModelAttribute Pager pager, String sort, String direction, ClassField classField) {
		List<ClassField> fieldList = classFieldService.query(classField);
		return fieldList;
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param
	 * @return 根据ClassId获得所有祖辈关联的
	 */
	@RequestMapping("queryRelField")
	public @ResponseBody
	List<ClassField> queryRelField(@ModelAttribute Pager pager, String sort, String direction, ClassField classField) {
		List<ClassField> fieldList = classFieldService.queryRelField(classField);
		return fieldList;
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param
	 * @return 根据ClassId获得selectlist
	 */
	@RequestMapping("querySelectList")
	public @ResponseBody
	List<QuiSelect> querySelectList(@ModelAttribute Pager pager, String sort, String direction, ClassField classField) {
		System.out.println(classField.getClassId());
		System.out.println(classField.getTabId());
		List<ClassField> fieldList = classFieldService.queryRelField(classField);
		System.out.println(fieldList);
		List<QuiSelect> qsList = new ArrayList<QuiSelect>();
		for (ClassField classField2 : fieldList) {
			QuiSelect qs = new QuiSelect();
			qs.setKey(classField2.getFieldKey());
			qs.setValue(classField2.getFieldKey());
			qsList.add(qs);
		}

		return qsList;
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param
	 * @return
	 */
	@RequestMapping("queryClassFieldFromExc")
	public @ResponseBody
	List<ExcField> queryClassFieldFromExc(@ModelAttribute Pager pager, String sort, String direction, ExcField excField) {
		List<ExcField> fieldList = new ArrayList<ExcField>();
		fieldList = excFieldService.query(excField);
		return fieldList;
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param
	 * @return
	 */
	@RequestMapping("deleteClassField")
	public @ResponseBody
	ClassField deleteClassField(@ModelAttribute Pager pager, String sort, String direction, ClassField classField) {
		classFieldService.delete(classField.getCfId());
		return classField;
	}

}
