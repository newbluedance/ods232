package com.ninetowns.modules.controller;

import com.ninetowns.modules.entity.HisInfo;
import com.ninetowns.modules.entity.ProBacInfo;
import com.ninetowns.modules.entity.StaBas;
import com.ninetowns.modules.entity.UploadFile;
import com.ninetowns.core.BaseController;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
import com.ninetowns.modules.service.ClassFieldService;
import com.ninetowns.modules.service.HisInfoService;
import com.ninetowns.modules.service.ProBacInfoService;
import com.ninetowns.modules.service.ProClassService;
import com.ninetowns.modules.service.StaBasService;
import com.ninetowns.modules.service.UploadFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
* @FileName :StaBasController
* @Author : licf
* @Create Date : 2015-10-09 20:46:02
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
@Controller
@RequestMapping("/proStaBas")
public class ProStaBasController extends BaseController{

	@Autowired
	private StaBasService		staBasService;
	
	@Autowired
	private ProBacInfoService		proBacInfoService;
	
	@Autowired
	private HisInfoService		hisInfoService;

	@Autowired
	private ProClassService		proClassService;
	
	@Autowired
	private ClassFieldService		classFieldService;

	@Autowired
    private UploadFileService uploadFileService;
	private PageView			pageView;

	/**
	 * 
	 * @return 主页面
	 */
	@RequestMapping("proStaBas")
	public String proStaBas() {
		return "/pages/ods/proStaBas/proStaBasList";
	}

	/**
	 *
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param proStaBas
	 * @return 主页面列表
	 */
	@RequestMapping("proStaBasList")
	public @ResponseBody
	Map<String, Object> proStaBasList(@ModelAttribute Pager pager, String sort, String direction, ProBacInfo proBacInfo) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		proBacInfo.setState("2");
		proBacInfo.setStateH("2");
		proBacInfo.setStateS("2");
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
	 * @param proStaBas
	 * @return 查看页面
	 */
	@RequestMapping("toDetail")
	public String toDetail(Model model, HttpServletRequest request) {
		String proId = request.getParameter("proId");
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		
			List list = hisInfoService.queryAllByproId(proId);
		
		List<UploadFile> imgList = uploadFileService.queryAll(null);
		model.addAttribute("imgList", imgList);
		
		request.setAttribute("list", list);
		
		StaBas staBas=new StaBas();
		staBas.setProId(proId);
		List<StaBas> staBasList=staBasService.query(staBas);
		model.addAttribute("staBasList", staBasList);
		
		return "/pages/ods/proStaBas/proStaBasDetail";
	}

	
}
