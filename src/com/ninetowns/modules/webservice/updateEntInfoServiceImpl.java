package com.ninetowns.modules.webservice;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import webservice.log.LoggerUtil;

import com.ninetowns.modules.entity.EntInfo;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.service.EntInfoService;
import com.ninetowns.modules.service.UserService;
@WebService
public class updateEntInfoServiceImpl implements updateEntInfoService {
@Autowired
private UserService userService;
@Autowired
private EntInfoService entInfoService;
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public String EntInfoUpdate(String user, String sign, String data) throws Exception {
		JSONObject jsonObj = new JSONObject();
		AnalysisMsg analysisMsg = new AnalysisMsg();
		try{
//			User u=userService.getById(user==null?"":user);
//		//判断当前用户是否为约定用户
//			if(null==u){
//				jsonObj.put("result", "1");
//				jsonObj.put("desc", "上传企业数据失败:传入的用户账号不正确,请确认.");
//				jsonObj.put("data", "");
//			return analysisMsg.toUTF8(jsonObj.toString());
//			}
		if (null == data || data.trim().length() == 0)
			{
				jsonObj.put("result", "1");
				jsonObj.put("desc", "上传企业数据失败:传入的数据为空,请确认.");
			jsonObj.put("data", "");
				return analysisMsg.toUTF8(jsonObj.toString());
			}
			
			JSONObject node=JSONObject.fromObject(data);
			if (null == node.getString("ENT_REG_CODE") || node.getString("ENT_REG_CODE").trim().length() == 0)
			{
			jsonObj.put("result", "1");
				jsonObj.put("desc", "企业上传送样数据失败:传入的企业ENT_REG_CODE为空,请确认.");
				jsonObj.put("data", "");
				return analysisMsg.toUTF8(jsonObj.toString());
		}
		    EntInfo e= new EntInfo();
			e.setEntRegCode(node.getString("ENT_REG_CODE")==null?"":node.getString("ENT_REG_CODE"));
			e.setAddress(node.getString("ADDRESS")==null?"":node.getString("ADDRESS"));
			e.setAdmiPlaceCode(node.getString("ADMI_PLACE_CODE")==null?"":node.getString("ADMI_PLACE_CODE"));
			e.setAuditConclusion(node.getString("AUDIT_CONCLUSION")==null?"":node.getString("AUDIT_CONCLUSION"));
			e.setAutidDate1(node.getString("AUTID_DATE")==null||node.getString("AUTID_DATE").length()==0?simpleDateFormat.parse(simpleDateFormat.format(new Date())):simpleDateFormat.parse(node.getString("AUTID_DATE")));
			e.setAutoCheckFlag(node.getString("AUTO_CHECK_FLAG")==null?"":node.getString("AUTO_CHECK_FLAG"));
			e.setAutoPassFlag(node.getString("AUTO_PASS_FLAG")==null?"":node.getString("AUTO_PASS_FLAG"));
			e.setBank(node.getString("BANK")==null?"":node.getString("BANK"));
			e.setBankAccount(node.getString("BANK_ACCOUNT")==null?"":node.getString("BANK_ACCOUNT"));
			e.setBlacklistFlag(node.getString("BLACKLIST_FLAG")==null?"":node.getString("BLACKLIST_FLAG"));
			e.setBusinessScope(node.getString("BUSINESS_SCOPE")==null?"":node.getString("BUSINESS_SCOPE"));
			e.setCloseFlag(node.getString("CLOSE_FLAG")==null?"":node.getString("CLOSE_FLAG"));
			e.setContactor(node.getString("CONTACTOR")==null?"":node.getString("CONTACTOR"));
			e.setCustomRegCode(node.getString("CUSTOM_REG_CODE")==null?"":node.getString("CUSTOM_REG_CODE"));
			e.setEdeclFlag(node.getString("E_DECL_FLAG")==null?"":node.getString("E_DECL_FLAG"));
			e.setEmail(node.getString("EMAIL")==null?"":node.getString("EMAIL"));
			e.setEntCname(node.getString("ENT_CNAME")==null?"":node.getString("ENT_CNAME"));
			e.setEntEname(node.getString("ENT_ENAME")==null?"":node.getString("ENT_ENAME"));
			e.setEntProperty(node.getString("ENT_PROPERTY")==null?"":node.getString("ENT_PROPERTY"));
		    e.setEntryExitLicense(node.getString("ENTRY_EXIT_LICENSE")==null?"":node.getString("ENTRY_EXIT_LICENSE"));
		    e.setEntShortName(node.getString("ENT_SHORT_NAME")==null?"":node.getString("ENT_SHORT_NAME"));
		    e.setEntTypeCode(node.getString("ENT_TYPE_CODE")==null?"":node.getString("ENT_TYPE_CODE"));
		    e.setEpassFlag(node.getString("E_PASS_FLAG")==null?"":node.getString("E_PASS_FLAG"));
		    e.setFax(node.getString("FAX")==null?"":node.getString("FAX"));
		    e.setIdeclFlag(node.getString("I_DECL_FLAG")==null?"":node.getString("I_DECL_FLAG"));
		    e.setInspModeCode(node.getString("INSP_MODE_CODE")==null?"":node.getString("INSP_MODE_CODE"));
		    e.setInvestCountryCode(node.getString("INVEST_COUNTRY_CODE")==null?"":node.getString("INVEST_COUNTRY_CODE"));
		    e.setIpassFlag(node.getString("I_PASS_FLAG")==null?"":node.getString("BANK"));
		    e.setIso9000Flag(node.getString("ISO9000_FLAG")==null?"":node.getString("ISO9000_FLAG"));
		    e.setLegalPerson(node.getString("LEGAL_PERSON")==null?"":node.getString("LEGAL_PERSON"));
		    e.setLevelClassCode(node.getString("LEVEL_CLASS_CODE")==null?"":node.getString("LEVEL_CLASS_CODE"));
		    e.setOldEntCode(node.getString("OLD_ENT_CODE")==null?"":node.getString("OLD_ENT_CODE"));
		    e.setOperateDate1(node.getString("OPERATE_DATE")==null||node.getString("OPERATE_DATE").length()==0?simpleDateFormat.parse(simpleDateFormat.format(new Date())):simpleDateFormat.parse(node.getString("OPERATE_DATE")));
		    e.setOperatorCode(node.getString("OPERATOR_CODE")==null?"":node.getString("OPERATOR_CODE"));
		    e.setOrgCode(node.getString("ORG_CODE")==null?"":node.getString("ORG_CODE"));
		    e.setOuterFlag(node.getString("OUTER_FLAG")==null?"":node.getString("OUTER_FLAG"));
		    e.setPdeclFlag(node.getString("P_DECL_FLAG")==null?"":node.getString("P_DECL_FLAG"));
		    e.setPostCode(node.getString("POST_CODE")==null?"":node.getString("POST_CODE"));
		    e.setPreFlag(node.getString("PRE_FLAG")==null?"":node.getString("PRE_FLAG"));
		    e.setProdFlag(node.getString("PROD_FLAG")==null?"":node.getString("PROD_FLAG"));
		    e.setRegDate1( node.getString("REG_DATE")==null||node.getString("REG_DATE").length()==0?simpleDateFormat.parse(simpleDateFormat.format(new Date())):simpleDateFormat.parse(node.getString("REG_DATE")));
		    e.setRemark(node.getString("REMARK")==null?"":node.getString("REMARK"));
		    e.setTechRegCode(node.getString("TECH_REG_CODE")==null?"":node.getString("TECH_REG_CODE"));
		    e.setTechRegNo(node.getString("TECH_REG_NO")==null?"":node.getString("TECH_REG_NO"));
		    e.setTelephone(node.getString("TELEPHONE")==null?"":node.getString("TELEPHONE"));
		    e.setTimeFeeModeCode(node.getString("TIME_FEE_MODE_CODE")==null?"":node.getString("TIME_FEE_MODE_CODE"));
		    e.setTransFlag(node.getString("TRANS_FLAG")==null?"":node.getString("TRANS_FLAG"));
		    entInfoService.add(e);
		    jsonObj.put("result", "0");
			jsonObj.put("desc", "企业数据上传成功.");
			jsonObj.put("data", "");
			return analysisMsg.toUTF8(jsonObj.toString());
		}
		catch (Exception e) 
		{
			jsonObj.put("result", "1");
			jsonObj.put("desc", "企业上传送样数据失败:系统出现未知错误:" + e.getMessage());
			LoggerUtil.writeLoggMessage("putLibSample---UipCheckServiceImpl", "企业上传送样数据失败:系统出现未知错误:" + e.getMessage());
			jsonObj.put("data", "");
			return analysisMsg.toUTF8(jsonObj.toString());
		}
		
	}

}
