package com.ninetowns.modules.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.HisInfo;
import com.ninetowns.modules.entity.ProBacInfo;
import com.ninetowns.modules.entity.UploadFile;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.service.ExcFieldService;
import com.ninetowns.modules.service.HisInfoService;
import com.ninetowns.modules.service.ProBacInfoService;
import com.ninetowns.modules.service.UploadFileService;
import com.ninetowns.utils.Common;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;

/**
 * @FileName :HisInfoController
 * @Author : licf
 * @Create Date : 2015-10-09 19:44:48
 * @Email : lcfsxg@qq.com
 * @Last Modified :
 * @Description :
 */
@Controller
@RequestMapping("/hisInfo")
public class HisInfoController extends BaseController {

	@Autowired
	private HisInfoService		hisInfoService;

	@Autowired
	private ProBacInfoService	proBacInfoService;

	private PageView			pageView;
	@Autowired
	private ExcFieldService		excFieldService;
	
	@Autowired
    private UploadFileService uploadFileService;

	/**
	 * 
	 * @return 主页面
	 */
	@RequestMapping("hisInfo")
	public String hisInfo() {
		return "/pages/ods/hisInfo/hisInfoList";
	}

	/**
	 * 
	 * @return 审核主页面
	 */
	@RequestMapping("hisInfoCheckConent")
	public String hisInfoCheckConent() {
		return "/pages/ods/hisInfo/hisInfoCheckConentList";
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param hisInfo
	 * @return 审核主页面列表
	 */
	@RequestMapping("hisInfoCheckConentList")
	public @ResponseBody
	Map<String, Object> hisInfoCheckConentList(@ModelAttribute Pager pager, String sort, String direction, ProBacInfo proBacInfo) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		proBacInfo.setState("2");
		List<String> stateHList = new ArrayList<String>();
		stateHList.add("1");
		stateHList.add("2");
		stateHList.add("3");
		proBacInfo.setStateHList(stateHList);
		pageView = proBacInfoService.queryListPageForDesc(pageView, proBacInfo);
		System.out.println("++++++++++++++++++=====" + pageView.getRows());
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
	 * @return 到审核修改页面
	 */
	@RequestMapping("toCheckUpdate")
	public String toCheckUpdate(Model model, HttpServletRequest request, String proId) {
		List list = hisInfoService.queryAllByproId(proId);
		request.setAttribute("list", list);
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		// 用户
		User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
		model.addAttribute("user", user);
		List<UploadFile> imgList = uploadFileService.queryAll(null);
		model.addAttribute("imgList", imgList);
		return "/pages/ods/hisInfo/hisInfoCheckUpdate";
	}

	/**
	 * 
	 * @param model
	 * @param proBacInfo
	 * @return 审核通过后到审核主页面
	 */
	@RequestMapping("updateCheck")
	public String updateCheck(Model model, String proId, ProBacInfo proBacInfo, HttpServletRequest request) {
		String flag = request.getParameter("flag");
		System.out.println("++++++==" + flag);
		if (flag.equals("2")) {
			Date date = new Date();
			SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
			String checkDate = from.format(date);
			proBacInfo.setStateH("2");
			proBacInfo.setCheckDateH(checkDate);
			proBacInfoService.updateStateH(proBacInfo);
		} else if (flag.equals("3")) {
			Date date = new Date();
			SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
			String checkDate = from.format(date);
			proBacInfo.setStateH("3");
			proBacInfo.setCheckDateH(checkDate);
			proBacInfoService.updateStateH(proBacInfo);
		}
		return "/pages/ods/hisInfo/hisInfoCheckConentList";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 审核后到查看页面
	 */
	@RequestMapping("toCheckDetail")
	public String toCheckDetail(Model model, HttpServletRequest request, String proId) {
		List list = hisInfoService.queryAllByproId(proId);
		request.setAttribute("list", list);
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		List<UploadFile> imgList = uploadFileService.queryAll(null);
		model.addAttribute("imgList", imgList);
		return "/pages/ods/hisInfo/hisInfoCheckDetail";
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param hisInfo
	 * @return 主页面列表
	 */
	@RequestMapping("hisInfoList")
	public @ResponseBody
	Map<String, Object> hisInfoList(@ModelAttribute Pager pager, String sort, String direction, ProBacInfo proBacInfo) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		proBacInfo.setState("2");
		pageView = proBacInfoService.queryListPageForDesc(pageView, proBacInfo);
		System.out.println("++++++++++++++++++=====" + pageView.getRows());
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
	public String toAdd(Model model, HttpServletRequest request, String proId) {
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);

		return "/pages/ods/hisInfo/hisInfoAdd";
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param hisInfo
	 * @return 监管信息列表
	 */
	@RequestMapping("hisInfoLists")
	public @ResponseBody
	Map<String, Object> hisInfoLists(@ModelAttribute Pager pager, String sort, String direction, HisInfo hisInfo, String proId) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		hisInfo.setProId(proId);
		System.out.println("++++++++++++++++++=====" + proId);
		pageView = hisInfoService.queryListPage(pageView, hisInfo);
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
	 * @return 到新增HisInfo页面
	 */

	@RequestMapping("toAddHis")
	public String toAddHis(Model model, HttpServletRequest request, String proId) {
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		System.out.println("++++++++++++++++++=====" + proId);
		model.addAttribute("proBacInfo", proBacInfo);
		Date date = new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = from.format(date);
		model.addAttribute("hisid", UUID.randomUUID().toString().replaceAll("-", ""));
		request.setAttribute("createDate", createDate);
		return "/pages/ods/hisInfo/hisInfoAddHis";
	}

	/**
	 * 
	 * @param model
	 * @param hisInfo
	 * @return 新增完成后到主页面
	 */
	@RequestMapping("addHisInfo")
	public String addHisInfo(Model model, HisInfo hisInfo, HttpServletRequest request, Map<String, String> map, String[] baseFile) {
		String proId = request.getParameter("proId");
		
//		UploadFile uf = uploadFileService.getByIdLibs(hisInfo.getHisId());
//		if (null != uf) hisInfo.setPhoto(uf.getFilePath()==null?"":uf.getFilePath());
		
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		hisInfo.setProId(proBacInfo.getProId());
		hisInfo.setProName(proBacInfo.getProName());
		
		List<UploadFile> ufList=uploadFileService.getByIdLibs(hisInfo.getHisId());
		UploadFile uf=null;
		if (ufList!=null&&ufList.size()>0) {
			uf=ufList.get(0);
		}
		String photoName=null;
		if (uf!=null) {
			photoName=uf.getFileName();
		}
		hisInfo.setPhoto(photoName);
		hisInfo = hisInfoService.add(hisInfo);
		List<HisInfo> list = hisInfoService.queryAllByproId(proId);
		if (list.size() > 0) {
			proBacInfo.setStateH("0");
			proBacInfo.setCheckConentH("");
			proBacInfo.setCheckDateH("");
			proBacInfo.setCheckNameH("");
			proBacInfoService.updateStateH(proBacInfo);

		}

		/*// 添加 扩展属性值
		String excFields = request.getParameter("excFields");
		JSONArray jsonArray = JSONArray.fromObject(excFields);
		String classId = hisInfo.getHisId();// 此处关联hisId
		String fieldKey = null;
		String fieldValue = null;
		ExcField excField = new ExcField();
		excField.setClassId(classId);
		for (int i = 0; i < jsonArray.size(); i++) {
			fieldKey = jsonArray.getJSONObject(i).get("name").toString();
			fieldValue = jsonArray.getJSONObject(i).get("value").toString();
			excField.setFieldKey(fieldKey);
			excField.setFieldValue(fieldValue);
			excFieldService.add(excField);
		}*/
		model.addAttribute("proBacInfo", proBacInfo);
		return "/pages/ods/hisInfo/hisInfoAdd";
	}

	/**
	 * /**
	 * 
	 * @param model
	 * @param request
	 * @return 到查看页面
	 */
	@RequestMapping("toDetail")
	public String toDetail(Model model, HttpServletRequest request, String proId) {

		List list = hisInfoService.queryAllByproId(proId);
		
		List<UploadFile> imgList = uploadFileService.queryAll(null);
		model.addAttribute("imgList", imgList);
		
		request.setAttribute("list", list);

		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);

		return "/pages/ods/hisInfo/hisInfoDetail";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到修改页面
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Model model, HttpServletRequest request, String proId) {
		String hisId = request.getParameter("hisId");
		HisInfo hisInfo = hisInfoService.getById(hisId);
		model.addAttribute("hisInfo", hisInfo);

		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		
		UploadFile uf = new UploadFile();
		uf.setDeleteFlag("N");
		uf.setTabId(hisId);
		List<UploadFile> imgList = uploadFileService.queryAll(uf);
		model.addAttribute("imgList", imgList);

		return "/pages/ods/hisInfo/hisInfoUpdate";
	}

	/**
	 * 
	 * @param model
	 * @param hisInfo
	 * @return 修改完成后到主页面
	 */
	@RequestMapping("updateHisInfo")
	public String updateHisInfo(Model model, HisInfo hisInfo, HttpServletRequest request, Map<String, String> map, String[] baseFile) {
		
		List<UploadFile> ufList=uploadFileService.getByIdLibs(hisInfo.getHisId());
		UploadFile uf=null;
		if (ufList!=null&&ufList.size()>0) {
			uf=ufList.get(0);
		}
		if (null != uf) hisInfo.setPhoto(uf.getFilePath()==null?"":uf.getFilePath());
		
		String photoName=null;
		if (uf!=null) {
			photoName=uf.getFileName();
		}
		hisInfo.setPhoto(photoName);
		hisInfoService.modify(hisInfo);

		/*// 编辑产品扩展属性值
		String excFields = request.getParameter("excFields");
		JSONArray jsonArray = JSONArray.fromObject(excFields);
		String fieldValue;
		ExcField excField = new ExcField();

		String excClassId = hisInfo.getHisId();// 此处关联产品Id
		String fieldId;
		excField.setClassId(excClassId);
		for (int i = 0; i < jsonArray.size(); i++) {
			fieldId = jsonArray.getJSONObject(i).get("name").toString();
			fieldValue = jsonArray.getJSONObject(i).get("value").toString();
			excField = excFieldService.getById(fieldId);
			System.out.println("====" + excField);
			excField.setFieldValue(fieldValue);
			excFieldService.modify(excField);
		}*/
		ProBacInfo proBacInfo = proBacInfoService.getById(hisInfo.getProId());
		model.addAttribute("proBacInfo", proBacInfo);
		return "/pages/ods/hisInfo/hisInfoAdd";
	}

	/**
	 * 
	 * @param model
	 * @param hisInfo
	 * @return 删除完成后到主页面
	 */
	@RequestMapping("delHisInfo")
	public String delHisInfo(Model model, HttpServletRequest request, String proId) {
		String hisId = request.getParameter("hisId");
		// 删除原图
		HisInfo hisInfo = hisInfoService.getById(hisId);
		String photo = hisInfo.getPhoto();
		if (photo != null && !"".equals(photo)) {
			File file = new File(request.getSession().getServletContext().getRealPath(photo));
			// 判断目录或文件是否存在
			if (file.exists()) { // 不存在返回 false
				file.delete();
			}
		}
		hisInfoService.delete(hisId);
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		List<HisInfo> list = hisInfoService.queryAllByproId(proId);
		if (list.size() > 0) {
			proBacInfo.setStateH("0");
			proBacInfo.setCheckConentH("");
			proBacInfo.setCheckDateH("");
			proBacInfo.setCheckNameH("");
			proBacInfoService.updateStateH(proBacInfo);

		}
		// 删除无用的属性
		excFieldService.deleteByClassId(hisId);

		return "/pages/ods/hisInfo/hisInfoAdd";
	}

	/**
	 * 
	 * @param model
	 * @param hisInfo
	 * @return 提交完成后到主页面
	 */
	@RequestMapping("toTijiao")
	public String toTijiao(Model model, HttpServletRequest request, String proId) {
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		proBacInfo.setStateH("1");
		proBacInfo.setCheckConentH(null);
		proBacInfo.setCheckDateH(null);
		proBacInfo.setCheckNameH(null);
		proBacInfoService.updateStateH(proBacInfo);

		return "/pages/ods/hisInfo/hisInfoList";
	}

}
