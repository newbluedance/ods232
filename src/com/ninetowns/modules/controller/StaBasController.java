package com.ninetowns.modules.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.ProBacInfo;
import com.ninetowns.modules.entity.StaBas;
import com.ninetowns.modules.entity.UploadFile;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.service.ExcFieldService;
import com.ninetowns.modules.service.ProBacInfoService;
import com.ninetowns.modules.service.StaBasService;
import com.ninetowns.modules.service.UploadFileService;
import com.ninetowns.utils.Common;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;

/**
 * @FileName :StaBasController
 * @Author : licf
 * @Create Date : 2015-10-09 20:46:02
 * @Email : lcfsxg@qq.com
 * @Last Modified :
 * @Description :
 */
@Controller
@RequestMapping("/staBas")
public class StaBasController extends BaseController {

	@Autowired
	private StaBasService		staBasService;
	@Autowired
	private ProBacInfoService	proBacInfoService;

	private PageView			pageView;

	@Autowired
	private ExcFieldService		excFieldService;

	@Autowired
	private UploadFileService	uploadFileService;

	/**
	 * 
	 * @return 主页面
	 */
	@RequestMapping("staBas")
	public String staBas() {
		return "/pages/ods/staBas/staBasList";
	}

	/**
	 * 
	 * @return 审核页面
	 */
	@RequestMapping("staBasCheckConent")
	public String staBasCheckConent() {
		return "/pages/ods/staBas/staBasCheckConentList";
	}

	/**
	 * 
	 * @param pager
	 * @param sort
	 * @param direction
	 * @param staBas
	 * @return 审核主页面列表
	 */
	@RequestMapping("staBasCheckConentList")
	public @ResponseBody
	Map<String, Object> staBasCheckConentList(@ModelAttribute Pager pager, String sort, String direction, ProBacInfo proBacInfo) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		proBacInfo.setState("2");
		List<String> stateHList = new ArrayList<String>();
		stateHList.add("1");
		stateHList.add("2");
		stateHList.add("3");
		proBacInfo.setStateSList(stateHList);
		pageView = proBacInfoService.queryListPageForDesc(pageView, proBacInfo);
		// System.out.println("++++++++++++++++++=====" + pageView.getRows());
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
	 * @param staBas
	 * @return 主页面列表
	 */
	@RequestMapping("queryproBacList")
	public @ResponseBody
	Map<String, Object> staBasList(@ModelAttribute Pager pager, String sort, String direction, ProBacInfo proBacInfo) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		proBacInfo.setState("2");
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
	 * @param hisInfo
	 * @return 规范信息列表
	 */
	@RequestMapping("queryStaBasList")
	public @ResponseBody
	Map<String, Object> staBasLists(@ModelAttribute Pager pager, String sort, String direction, StaBas staBas, String proId) {
		pageView = new PageView(pager.getPageNo(), pager.getPageSize());
		pageView.setSort(sort);
		pageView.setDirection(direction);
		staBas.setProId(proId);

		pageView = staBasService.queryListPage(pageView, staBas);
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
		Date date = new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = from.format(date);
		request.setAttribute("createDate", createDate);
		return "/pages/ods/staBas/staBasAdd";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到新增StaBasAddSta页面
	 */
	@RequestMapping("staBasAddSta")
	public String staBasAddSta(Model model, HttpServletRequest request, String proId) {
		proId = request.getParameter("proId");
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		// System.out.println("============================"+proId);
		model.addAttribute("proBacInfo", proBacInfo);
		Date date = new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = from.format(date);
		request.setAttribute("createDate", createDate);
		model.addAttribute("staId", UUID.randomUUID().toString().replaceAll("-", ""));
		return "/pages/ods/staBas/staBasAddSta";
	}

	/**
	 * 
	 * @param model
	 * @param staBas
	 * @return 新增完成后到主页面
	 */
	@RequestMapping("addStaBas")
	public String addStaBas(Model model, StaBas staBas) {

		staBasService.add(staBas);
		return "/pages/ods/staBas/staBasAdd";
	}

	/**
	 * 
	 * @param model
	 * @param staBas
	 * @return 新增完成后到主页面
	 */
	@RequestMapping("addStaBass")
	public String addStaBass(@RequestParam(value = "uploadfile", required = false) MultipartFile uploadfile, Model model, StaBas staBas,
			HttpServletRequest request) {
		String proId = request.getParameter("proId");
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		//
		// System.out.println("uploadfile====" + uploadfile);
		//
		// String parPath = null;
		// String sonPath = null;
		// String baseFile = null;
		// if (null != uploadfile) {
		// System.out.println("uploadfileOriginalFilename====" +
		// uploadfile.getOriginalFilename());
		// if (null != uploadfile.getOriginalFilename() &&
		// uploadfile.getOriginalFilename().length() > 0) {
		// parPath =
		// request.getSession().getServletContext().getRealPath("upload" +
		// "/staBas/");
		// try {
		// if (!(new File(parPath).isDirectory())) {
		// new File(parPath).mkdir();
		// }
		// } catch (Exception e) {
		// System.out.println("can not make directory");
		// }
		// sonPath =
		// request.getSession().getServletContext().getRealPath("upload" +
		// "/staBas/" + staBas.getProId() + "/");
		// try {
		// SaveFileFromInputStream(uploadfile.getInputStream(), sonPath,
		// uploadfile.getOriginalFilename());
		// baseFile = "/upload" + "/staBas/" + staBas.getProId() + "/" +
		// uploadfile.getOriginalFilename();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }
		// staBas.setBaseFile(baseFile);
		// 读文件名
		List<UploadFile> ufList = uploadFileService.getByIdLibs(staBas.getStaId());
		String fileName="";
		if (ufList != null) {
			for (UploadFile uploadFile2 : ufList) {
				fileName =fileName+ uploadFile2.getFileName();
				
			}
		}

		staBas.setBaseFile(fileName);
		staBas.setProId(proBacInfo.getProId());
		staBas.setProName(proBacInfo.getProName());
		staBas = staBasService.add(staBas);
		List<StaBas> list = staBasService.queryAllByproId(proId);
		if (list.size() > 0) {
			proBacInfo.setStateS("0");
			proBacInfo.setCheckConentS("");
			proBacInfo.setCheckDateS("");
			proBacInfo.setCheckNameS("");
			proBacInfoService.updateStateS(proBacInfo);

		}
		/*
		 * // 添加 扩展属性值 String excFields = request.getParameter("excFields");
		 * System.out.println(excFields); JSONArray jsonArray =
		 * JSONArray.fromObject(excFields); String classId =
		 * staBas.getStaId();// 此处关联staId String fieldKey = null; String
		 * fieldValue = null; ExcField excField = new ExcField();
		 * excField.setClassId(classId); for (int i = 0; i < jsonArray.size();
		 * i++) { fieldKey = jsonArray.getJSONObject(i).get("name").toString();
		 * fieldValue = jsonArray.getJSONObject(i).get("value").toString();
		 * excField.setFieldKey(fieldKey); excField.setFieldValue(fieldValue);
		 * excFieldService.add(excField); }
		 */

		model.addAttribute("proBacInfo", proBacInfo);
		return "/pages/ods/staBas/staBasAdd";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到查看页面
	 */
	@RequestMapping("toDetail")
	public String toDetail(Model model, HttpServletRequest request, String proId) {

		List list = staBasService.queryAllByproId(proId);
		// model.addAttribute("list", list);
		// System.out.println("++++++++++++++++++====="+list.size());
		/*
		 * for(int i=0;i<list.size();i++){ Map map=(HashMap)list.get(i); }
		 */
		request.setAttribute("list", list);
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);

		List<UploadFile> imgList = uploadFileService.queryAll(null);
		model.addAttribute("imgList", imgList);

		return "/pages/ods/staBas/staBasDetail";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到修改页面
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Model model, HttpServletRequest request) {
		String staId = request.getParameter("staId");
		StaBas staBas = staBasService.getById(staId);
		model.addAttribute("staBas", staBas);

		UploadFile uf = new UploadFile();
		uf.setTabId(staId);
		List<UploadFile> imgList = uploadFileService.queryAll(uf);
		model.addAttribute("imgList", imgList);

		ProBacInfo proBacInfo = proBacInfoService.getById(staBas.getProId());
		model.addAttribute("proBacInfo", proBacInfo);
		return "/pages/ods/staBas/staBasUpdate";
	}

	/**
	 * 
	 * @param model
	 * @param staBas
	 * @return 修改完成后到主页面
	 */
	@RequestMapping("updateStaBas")
	public String updateStaBas(@RequestParam(value = "uploadfile", required = false) MultipartFile uploadfile, Model model, StaBas staBas,
			HttpServletRequest request) {
		// System.out.println("----uploadfile:" + uploadfile);
		System.out.println("----staBas:" + staBas);
		// //
		// String parPath = null;
		// String sonPath = null;
		// String baseFile = null;
		// if (null != uploadfile) {
		// if (null != uploadfile.getOriginalFilename() &&
		// uploadfile.getOriginalFilename().length() > 0) {
		// parPath =
		// request.getSession().getServletContext().getRealPath("upload" +
		// "/staBas/");
		// try {
		// if (!(new java.io.File(parPath).isDirectory())) {
		// new java.io.File(parPath).mkdir();
		// }
		// } catch (Exception e) {
		// System.out.println("can not make directory");
		// }
		// sonPath =
		// request.getSession().getServletContext().getRealPath("upload" +
		// "/staBas/" + staBas.getProId() + "/");
		// try {
		// SaveFileFromInputStream(uploadfile.getInputStream(), sonPath,
		// uploadfile.getOriginalFilename());
		// baseFile = "/upload" + "/staBas/" + staBas.getProId() + "/" +
		// uploadfile.getOriginalFilename();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// staBas.setBaseFile(baseFile);
		// }
		// }
		//
		// System.out.println(staBas);
		// 读文件名
		List<UploadFile> ufList = uploadFileService.getByIdLibs(staBas.getStaId());
		String fileName = null;
		if (ufList != null) {
			for (UploadFile uploadFile2 : ufList) {
				fileName =fileName+ uploadFile2.getFileName();
				
			}
		}

		staBas.setBaseFile(fileName);
		staBasService.modify(staBas);
		/*
		 * // 编辑产品扩展属性值 String excFields = request.getParameter("excFields");
		 * JSONArray jsonArray = JSONArray.fromObject(excFields); String
		 * fieldValue; ExcField excField = new ExcField();
		 * 
		 * String excClassId = staBas.getStaId();// 此处关联产品Id String fieldId;
		 * excField.setClassId(excClassId); for (int i = 0; i <
		 * jsonArray.size(); i++) { fieldId =
		 * jsonArray.getJSONObject(i).get("name").toString(); fieldValue =
		 * jsonArray.getJSONObject(i).get("value").toString(); excField =
		 * excFieldService.getById(fieldId); System.out.println("====" +
		 * excField); excField.setFieldValue(fieldValue);
		 * excFieldService.modify(excField); }
		 */
		ProBacInfo proBacInfo = proBacInfoService.getById(staBas.getProId());
		model.addAttribute("proBacInfo", proBacInfo);
		return "/pages/ods/staBas/staBasAdd";
	}

	/**
	 * 
	 * @param model
	 * @param hisInfo
	 * @return 删除完成后到主页面
	 */
	@RequestMapping("delStaBas")
	public String delStaBas(Model model, HttpServletRequest request, String proId, String staId) {
		// String staId = request.getParameter("staId");
		staBasService.delete(staId);
		// System.out.println("++++++++++++++++++====="+proId);
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		List<StaBas> list = staBasService.queryAllByproId(proId);
		// System.out.println("++++++++++++++++++====="+list.size());
		if (list.size() > 0) {
			proBacInfo.setStateS("0");
			proBacInfo.setCheckConentS("");
			proBacInfo.setCheckDateS("");
			proBacInfo.setCheckNameS("");
			proBacInfoService.updateStateS(proBacInfo);

		}
		// 删除无用filepath
		uploadFileService.delete(staId);
		
		// 删除无用的属性
		excFieldService.deleteByClassId(staId);
		return "/pages/ods/staBas/staBasAdd";
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
		proBacInfo.setStateS("1");
		proBacInfo.setCheckConentS(null);
		proBacInfo.setCheckDateS(null);
		proBacInfo.setCheckNameS(null);
		proBacInfoService.updateStateS(proBacInfo);
		return "/pages/ods/staBas/staBasList";
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
		// 用户
		User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
		model.addAttribute("user", user);
		List<UploadFile> imgList = uploadFileService.queryAll(null);
		model.addAttribute("imgList", imgList);
		return "/pages/ods/proBacInfo/proBacInfoCheckConentAdd";
	}

	/**
	 * 
	 * @param model
	 * @param proBacInfo
	 * @return 审核通过后到审核主页面
	 */
	@RequestMapping("updateCheck")
	public String updateCheck(Model model, ProBacInfo proBacInfo, String proId, HttpServletRequest request) {
		String flag = request.getParameter("flag");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++" + flag);
		if (flag.equals("2")) {
			proBacInfo.setProId(proId);
			System.out.println(proBacInfo);
			Date date = new Date();
			SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
			String checkDate = from.format(date);
			proBacInfo.setStateS("2");
			proBacInfo.setCheckDateS(checkDate);
			proBacInfoService.updateStateS(proBacInfo);
		} else if (flag.equals("3")) {
			proBacInfo.setProId(proId);
			System.out.println(proBacInfo);
			Date date = new Date();
			SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
			String checkDate = from.format(date);
			proBacInfo.setStateS("3");
			proBacInfo.setCheckDateS(checkDate);
			proBacInfoService.updateStateS(proBacInfo);
		}

		return "/pages/ods/staBas/staBasCheckConentList";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 审核后到查看页面
	 */
	@RequestMapping("toCheckDetail")
	public String toCheckDetail(Model model, HttpServletRequest request, String proId) {
		List list = staBasService.queryAllByproId(proId);
		request.setAttribute("list", list);
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		List<UploadFile> imgList = uploadFileService.queryAll(null);
		model.addAttribute("imgList", imgList);
		return "/pages/ods/staBas/staBasCheckConenDetail";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return 到审核修改页面
	 */
	@RequestMapping("toCheckUpdate")
	public String toCheckUpdate(Model model, HttpServletRequest request, String proId) {
		List list = staBasService.queryAllByproId(proId);
		request.setAttribute("list", list);
		ProBacInfo proBacInfo = proBacInfoService.getById(proId);
		model.addAttribute("proBacInfo", proBacInfo);
		// 用户
		User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
		model.addAttribute("user", user);
		List<UploadFile> imgList = uploadFileService.queryAll(null);
		model.addAttribute("imgList", imgList);
		return "/pages/ods/staBas/staBasCheckConenUpdate";
	}

	@RequestMapping("downloadFile")
	public void downloadFile(String fileName, HttpServletResponse response, HttpServletRequest request) {
		fileName = request.getSession().getServletContext().getRealPath(fileName);
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		System.out.println(fileName);

		String[] namearr = fileName.split("\\\\");
		response.setHeader("Content-Disposition", "attachment;fileName=" + namearr[namearr.length - 1]);
		try {
			File file = new File(fileName);
			System.out.println(file.getAbsolutePath());
			InputStream inputStream = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[1024];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 上传文件工具类
	public void SaveFileFromInputStream(InputStream stream, String path, String filename) throws Exception {
		try {
			if (!(new java.io.File(path).isDirectory())) {
				new java.io.File(path).mkdir();
			}
		} catch (SecurityException e) {
			System.out.println("can not make directory");
		}
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(path + "/" + filename);
			byte[] buffer = new byte[1024 * 1024];
			// int bytesum = 0;
			int byteread = 0;
			while ((byteread = stream.read(buffer)) != -1) {
				// bytesum += byteread;
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
			fs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		stream.close();
	}
}
