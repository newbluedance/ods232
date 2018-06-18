package com.ninetowns.modules.entity;

import java.util.Date;

/**
 * @fileName 企业信息表
 * @author 马振勇
 *
 */

public class EntInfo implements java.io.Serializable {
	public static final String TABLE_AS = "企业详细信息表";
	public static final String AS_EntRegCode = "企业注册编码";
	public static final String AS_RegDate = "注册时间";
	public static final String AS_EntCname = "企业中文名称";
	public static final String AS_EntEname = "企业英文名称";
	public static final String AS_EntShortName = "企业简介";
	public static final String AS_Address = "地址";
	public static final String AS_PostCode = "邮编";
	public static final String AS_Telephone = "联系方式";
	public static final String AS_Fax = "传真";
	public static final String AS_Email = "邮箱";
	public static final String AS_LegalPerson = "法人";
	public static final String AS_Contactor = "联系人";
	public static final String AS_AdmiPlaceCode = "行政区号";
	public static final String AS_CustomRegCode = "海关注册号";
	public static final String AS_TechRegCode = "组织机构代码";
	public static final String AS_EntTypeCode = "企业类型";
	public static final String AS_EntProperty = "产地证企业";
	public static final String AS_LevelClassCode = "级别代码";
	public static final String AS_EntryExitLicense = "进出口经营权";
	public static final String AS_BusinessScope = "业务范围";
	public static final String AS_InspModeCode = "报检模式代码";
	public static final String AS_TimeFeeModeCode = "时间收费模式代码";
	public static final String AS_Bank = "开户银行";
	public static final String AS_BankAccount = "开户账号";
	public static final String AS_AutidDate = "年审日期";
	public static final String AS_AuditConclusion = "年审结果";
	public static final String AS_BlacklistFlag = "是否拉入黑名单";
	public static final String AS_CloseFlag = "是否被停用";
	public static final String AS_Remark = "评论";
	public static final String AS_OperatorCode = "操作员代码";
	public static final String AS_OperateDate = "操作时间";
	public static final String AS_OldEntCode = "原企业注册号";
	public static final String AS_OrgCode = "机构代码";
	public static final String AS_TransFlag = "运输标记";
	public static final String AS_OuterFlag = "是否外拨单位标志";
	public static final String AS_PreFlag = "是否初始化";
	public static final String AS_InvestCountryCode = "转换国家代码";
	public static final String AS_EdeclFlag = "是否出境电子报检";
	public static final String AS_IdeclFlag = "是否入境电子报检";
	public static final String AS_EpassFlag = "是否出境电子通关";
	public static final String AS_IpassFlag = "是否入境电子通关";
	public static final String AS_AutoCheckFlag = "是否电子报检自动审单";
	public static final String AS_AutoPassFlag = "是否绿色通道资格";
	public static final String AS_ProdFlag = "是否生产企业";
	public static final String AS_Iso9000Flag = "是否通过ISO9000";
	public static final String AS_PdeclFlag = "是否包装电子报检";
	public static final String AS_TechRegNo = "组织机构代码编号";
	private String DeclPersonName;

    /**
     * 用于确定导出EXCEL的列
     */
    public static final String[] EXPORT_HEADERS ={
         //columns START
          "entRegCode:企业注册编码"
          ,
          "regDate:注册时间"
          ,
          "entCname:企业中文名称"
          ,
          "entEname:企业英文名称"
          ,
          "entShortName:企业简介"
          ,
          "address:地址"
          ,
          "postCode:邮编"
          ,
          "telephone:联系方式"
          ,
          "fax:传真"
          ,
          "email:邮箱"
          ,
          "legalPerson:法人"
          ,
          "contactor:联系人"
          ,
          "admiPlaceCode:行政区号"
          ,
          "customRegCode:海关注册号"
          ,
          "techRegCode:组织机构代码"
          ,
          "entTypeCode:企业类型"
          ,
          "entProperty:产地证企业"
          ,
          "levelClassCode:级别代码"
          ,
          "entryExitLicense:进出口经营权"
          ,
          "businessScope:业务范围"
          ,
          "inspModeCode:报检模式代码"
          ,
          "timeFeeModeCode:时间收费模式代码"
          ,
          "bank:开户银行"
          ,
          "bankAccount:开户账号"
          ,
          "autidDate:年审日期"
          ,
          "auditConclusion:年审结果"
          ,
          "blacklistFlag:是否拉入黑名单"
          ,
          "closeFlag:是否被停用"
          ,
          "remark:评论"
          ,
          "operatorCode:操作员代码"
          ,
          "operateDate:操作时间"
          ,
          "oldEntCode:原企业注册号"
          ,
          "orgCode:机构代码"
          ,
          "transFlag:运输标记"
          ,
          "outerFlag:是否外拨单位标志"
          ,
          "preFlag:是否初始化"
          ,
          "investCountryCode:转换国家代码"
          ,
          "edeclFlag:是否出境电子报检"
          ,
          "ideclFlag:是否入境电子报检"
          ,
          "epassFlag:是否出境电子通关"
          ,
          "ipassFlag:是否入境电子通关"
          ,
          "autoCheckFlag:是否电子报检自动审单"
          ,
          "autoPassFlag:是否绿色通道资格"
          ,
          "prodFlag:是否生产企业"
          ,
          "iso9000Flag:是否通过ISO9000"
          ,
          "pdeclFlag:是否包装电子报检"
          ,
          "techRegNo:组织机构代码编号"
          
        };
	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 企业注册编码       db_column: ENT_REG_CODE 
     */	
	private String entRegCode;
	private Date regDate1;
	public Date getRegDate1() {
		return regDate1;
	}
	public void setRegDate1(Date regDate1) {
		this.regDate1 = regDate1;
	}
	public Date getAutidDate1() {
		return autidDate1;
	}
	public void setAutidDate1(Date autidDate1) {
		this.autidDate1 = autidDate1;
	}
	public Date getOperateDate1() {
		return operateDate1;
	}
	public void setOperateDate1(Date operateDate1) {
		this.operateDate1 = operateDate1;
	}
	private Date autidDate1;
	private Date operateDate1;
    public String getEntRegCode() {
		return entRegCode;
	}
	public void setEntRegCode(String entRegCode) {
		this.entRegCode = entRegCode;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getEntCname() {
		return entCname;
	}
	public void setEntCname(String entCname) {
		this.entCname = entCname;
	}
	public String getEntEname() {
		return entEname;
	}
	public void setEntEname(String entEname) {
		this.entEname = entEname;
	}
	public String getEntShortName() {
		return entShortName;
	}
	public void setEntShortName(String entShortName) {
		this.entShortName = entShortName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getContactor() {
		return contactor;
	}
	public void setContactor(String contactor) {
		this.contactor = contactor;
	}
	public String getAdmiPlaceCode() {
		return admiPlaceCode;
	}
	public void setAdmiPlaceCode(String admiPlaceCode) {
		this.admiPlaceCode = admiPlaceCode;
	}
	public String getCustomRegCode() {
		return customRegCode;
	}
	public void setCustomRegCode(String customRegCode) {
		this.customRegCode = customRegCode;
	}
	public String getTechRegCode() {
		return techRegCode;
	}
	public void setTechRegCode(String techRegCode) {
		this.techRegCode = techRegCode;
	}
	public String getEntTypeCode() {
		return entTypeCode;
	}
	public void setEntTypeCode(String entTypeCode) {
		this.entTypeCode = entTypeCode;
	}
	public String getEntProperty() {
		return entProperty;
	}
	public void setEntProperty(String entProperty) {
		this.entProperty = entProperty;
	}
	public String getLevelClassCode() {
		return levelClassCode;
	}
	public void setLevelClassCode(String levelClassCode) {
		this.levelClassCode = levelClassCode;
	}
	public String getEntryExitLicense() {
		return entryExitLicense;
	}
	public void setEntryExitLicense(String entryExitLicense) {
		this.entryExitLicense = entryExitLicense;
	}
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	public String getInspModeCode() {
		return inspModeCode;
	}
	public void setInspModeCode(String inspModeCode) {
		this.inspModeCode = inspModeCode;
	}
	public String getTimeFeeModeCode() {
		return timeFeeModeCode;
	}
	public void setTimeFeeModeCode(String timeFeeModeCode) {
		this.timeFeeModeCode = timeFeeModeCode;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getAutidDate() {
		return autidDate;
	}
	public void setAutidDate(String autidDate) {
		this.autidDate = autidDate;
	}
	public String getAuditConclusion() {
		return auditConclusion;
	}
	public void setAuditConclusion(String auditConclusion) {
		this.auditConclusion = auditConclusion;
	}
	public String getBlacklistFlag() {
		return blacklistFlag;
	}
	public void setBlacklistFlag(String blacklistFlag) {
		this.blacklistFlag = blacklistFlag;
	}
	public String getCloseFlag() {
		return closeFlag;
	}
	public void setCloseFlag(String closeFlag) {
		this.closeFlag = closeFlag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getOldEntCode() {
		return oldEntCode;
	}
	public void setOldEntCode(String oldEntCode) {
		this.oldEntCode = oldEntCode;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getTransFlag() {
		return transFlag;
	}
	public void setTransFlag(String transFlag) {
		this.transFlag = transFlag;
	}
	public String getOuterFlag() {
		return outerFlag;
	}
	public void setOuterFlag(String outerFlag) {
		this.outerFlag = outerFlag;
	}
	public String getPreFlag() {
		return preFlag;
	}
	public void setPreFlag(String preFlag) {
		this.preFlag = preFlag;
	}
	public String getInvestCountryCode() {
		return investCountryCode;
	}
	public void setInvestCountryCode(String investCountryCode) {
		this.investCountryCode = investCountryCode;
	}
	public String getEdeclFlag() {
		return edeclFlag;
	}
	public void setEdeclFlag(String edeclFlag) {
		this.edeclFlag = edeclFlag;
	}
	public String getIdeclFlag() {
		return ideclFlag;
	}
	public void setIdeclFlag(String ideclFlag) {
		this.ideclFlag = ideclFlag;
	}
	public String getEpassFlag() {
		return epassFlag;
	}
	public void setEpassFlag(String epassFlag) {
		this.epassFlag = epassFlag;
	}
	public String getIpassFlag() {
		return ipassFlag;
	}
	public void setIpassFlag(String ipassFlag) {
		this.ipassFlag = ipassFlag;
	}
	public String getAutoCheckFlag() {
		return autoCheckFlag;
	}
	public void setAutoCheckFlag(String autoCheckFlag) {
		this.autoCheckFlag = autoCheckFlag;
	}
	public String getAutoPassFlag() {
		return autoPassFlag;
	}
	public void setAutoPassFlag(String autoPassFlag) {
		this.autoPassFlag = autoPassFlag;
	}
	public String getProdFlag() {
		return prodFlag;
	}
	public void setProdFlag(String prodFlag) {
		this.prodFlag = prodFlag;
	}
	public String getIso9000Flag() {
		return iso9000Flag;
	}
	public void setIso9000Flag(String iso9000Flag) {
		this.iso9000Flag = iso9000Flag;
	}
	public String getPdeclFlag() {
		return pdeclFlag;
	}
	public void setPdeclFlag(String pdeclFlag) {
		this.pdeclFlag = pdeclFlag;
	}
	
	public String getOrgCodeDl() {
		return orgCodeDl;
	}
	public void setOrgCodeDl(String orgCodeDl) {
		this.orgCodeDl = orgCodeDl;
	}
	public static String getTableAs() {
		return TABLE_AS;
	}
	public static String getAsEntregcode() {
		return AS_EntRegCode;
	}
	public static String getAsRegdate() {
		return AS_RegDate;
	}
	public static String getAsEntcname() {
		return AS_EntCname;
	}
	public static String getAsEntename() {
		return AS_EntEname;
	}
	public static String getAsEntshortname() {
		return AS_EntShortName;
	}
	public static String getAsAddress() {
		return AS_Address;
	}
	public static String getAsPostcode() {
		return AS_PostCode;
	}
	public static String getAsTelephone() {
		return AS_Telephone;
	}
	public static String getAsFax() {
		return AS_Fax;
	}
	public static String getAsEmail() {
		return AS_Email;
	}
	public static String getAsLegalperson() {
		return AS_LegalPerson;
	}
	public static String getAsContactor() {
		return AS_Contactor;
	}
	public static String getAsAdmiplacecode() {
		return AS_AdmiPlaceCode;
	}
	public static String getAsCustomregcode() {
		return AS_CustomRegCode;
	}
	public static String getAsTechregcode() {
		return AS_TechRegCode;
	}
	public static String getAsEnttypecode() {
		return AS_EntTypeCode;
	}
	public static String getAsEntproperty() {
		return AS_EntProperty;
	}
	public static String getAsLevelclasscode() {
		return AS_LevelClassCode;
	}
	public static String getAsEntryexitlicense() {
		return AS_EntryExitLicense;
	}
	public static String getAsBusinessscope() {
		return AS_BusinessScope;
	}
	public static String getAsInspmodecode() {
		return AS_InspModeCode;
	}
	public static String getAsTimefeemodecode() {
		return AS_TimeFeeModeCode;
	}
	public static String getAsBank() {
		return AS_Bank;
	}
	public static String getAsBankaccount() {
		return AS_BankAccount;
	}
	public static String getAsAutiddate() {
		return AS_AutidDate;
	}
	public static String getAsAuditconclusion() {
		return AS_AuditConclusion;
	}
	public static String getAsBlacklistflag() {
		return AS_BlacklistFlag;
	}
	public static String getAsCloseflag() {
		return AS_CloseFlag;
	}
	public static String getAsRemark() {
		return AS_Remark;
	}
	public static String getAsOperatorcode() {
		return AS_OperatorCode;
	}
	public static String getAsOperatedate() {
		return AS_OperateDate;
	}
	public static String getAsOldentcode() {
		return AS_OldEntCode;
	}
	public static String getAsOrgcode() {
		return AS_OrgCode;
	}
	public static String getAsTransflag() {
		return AS_TransFlag;
	}
	public static String getAsOuterflag() {
		return AS_OuterFlag;
	}
	public static String getAsPreflag() {
		return AS_PreFlag;
	}
	public static String getAsInvestcountrycode() {
		return AS_InvestCountryCode;
	}
	public static String getAsEdeclflag() {
		return AS_EdeclFlag;
	}
	public static String getAsIdeclflag() {
		return AS_IdeclFlag;
	}
	public static String getAsEpassflag() {
		return AS_EpassFlag;
	}
	public static String getAsIpassflag() {
		return AS_IpassFlag;
	}
	public static String getAsAutocheckflag() {
		return AS_AutoCheckFlag;
	}
	public static String getAsAutopassflag() {
		return AS_AutoPassFlag;
	}
	public static String getAsProdflag() {
		return AS_ProdFlag;
	}
	public static String getAsIso9000flag() {
		return AS_Iso9000Flag;
	}
	public static String getAsPdeclflag() {
		return AS_PdeclFlag;
	}
	public static String getAsTechregno() {
		return AS_TechRegNo;
	}
	public static String[] getExportHeaders() {
		return EXPORT_HEADERS;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setDeclPersonName(String declPersonName) {
		DeclPersonName = declPersonName;
	}
	public String getDeclPersonName() {
		return DeclPersonName;
	}
	public void setTechRegNo(String techRegNo) {
		this.techRegNo = techRegNo;
	}
	public String getTechRegNo() {
		return techRegNo;
	}
	/**
     * 注册时间       db_column: REG_DATE 
     */	
	private String regDate;
    /**
     * 企业中文名称       db_column: ENT_CNAME 
     */	
	private String entCname;
    /**
     * 企业英文名称       db_column: ENT_ENAME 
     */	
	private String entEname;
    /**
     * 企业简介       db_column: ENT_SHORT_NAME 
     */	
	private String entShortName;
    /**
     * 地址       db_column: ADDRESS 
     */	
	private String address;
    /**
     * 邮编       db_column: POST_CODE 
     */	
	private String postCode;
    /**
     * 联系方式       db_column: TELEPHONE 
     */	
	private String telephone;
    /**
     * 传真       db_column: FAX 
     */	
	private String fax;
    /**
     * 邮箱       db_column: EMAIL 
     */	
	private String email;
    /**
     * 法人       db_column: LEGAL_PERSON 
     */	
	private String legalPerson;
    /**
     * 联系人       db_column: CONTACTOR 
     */	
	private String contactor;
    /**
     * 行政区号       db_column: ADMI_PLACE_CODE 
     */	
	private String admiPlaceCode;
    /**
     * 海关注册号       db_column: CUSTOM_REG_CODE 
     */	
	private String customRegCode;
    /**
     * 组织机构代码       db_column: TECH_REG_CODE 
     */	
	private String techRegCode;
    /**
     * 企业类型       db_column: ENT_TYPE_CODE 
     */	
	private String entTypeCode;
    /**
     * 产地证企业       db_column: ENT_PROPERTY 
     */	
	private String entProperty;
    /**
     * 级别代码       db_column: LEVEL_CLASS_CODE 
     */	
	private String levelClassCode;
    /**
     * 进出口经营权       db_column: ENTRY_EXIT_LICENSE 
     */	
	private String entryExitLicense;
    /**
     * 业务范围       db_column: BUSINESS_SCOPE 
     */	
	private String businessScope;
    /**
     * 报检模式代码       db_column: INSP_MODE_CODE 
     */	
	private String inspModeCode;
    /**
     * 时间收费模式代码       db_column: TIME_FEE_MODE_CODE 
     */	
	private String timeFeeModeCode;
    /**
     * 开户银行       db_column: BANK 
     */	
	private String bank;
    /**
     * 开户账号       db_column: BANK_ACCOUNT 
     */	
	private String bankAccount;
    /**
     * 年审日期       db_column: AUTID_DATE 
     */	
	private String autidDate;
    /**
     * 年审结果       db_column: AUDIT_CONCLUSION 
     */	
	private String auditConclusion;
    /**
     * 是否拉入黑名单       db_column: BLACKLIST_FLAG 
     */	
	private String blacklistFlag;
    /**
     * 是否被停用       db_column: CLOSE_FLAG 
     */	
	private String closeFlag;
    /**
     * 评论       db_column: REMARK 
     */	
	private String remark;
    /**
     * 操作员代码       db_column: OPERATOR_CODE 
     */	
	private String operatorCode;
    /**
     * 操作时间       db_column: OPERATE_DATE 
     */	
	private String operateDate;
    /**
     * 原企业注册号       db_column: OLD_ENT_CODE 
     */	
	private String oldEntCode;
    /**
     * 机构代码       db_column: ORG_CODE 
     */	
	private String orgCode;
    /**
     * 运输标记       db_column: TRANS_FLAG 
     */	
	private String transFlag;
    /**
     * 是否外拨单位标志       db_column: OUTER_FLAG 
     */	
	private String outerFlag;
    /**
     * 是否初始化       db_column: PRE_FLAG 
     */	
	private String preFlag;
    /**
     * 转换国家代码       db_column: INVEST_COUNTRY_CODE 
     */	
	private String investCountryCode;
    /**
     * 是否出境电子报检       db_column: E_DECL_FLAG 
     */	
	private String edeclFlag;
    /**
     * 是否入境电子报检       db_column: I_DECL_FLAG 
     */	
	private String ideclFlag;
    /**
     * 是否出境电子通关       db_column: E_PASS_FLAG 
     */	
	private String epassFlag;
    /**
     * 是否入境电子通关       db_column: I_PASS_FLAG 
     */	
	private String ipassFlag;
    /**
     * 是否电子报检自动审单       db_column: AUTO_CHECK_FLAG 
     */	
	private String autoCheckFlag;
    /**
     * 是否绿色通道资格       db_column: AUTO_PASS_FLAG 
     */	
	private String autoPassFlag;
    /**
     * 是否生产企业       db_column: PROD_FLAG 
     */	
	private String prodFlag;
    /**
     * 是否通过ISO9000       db_column: ISO9000_FLAG 
     */	
	private String iso9000Flag;
    /**
     * 是否包装电子报检       db_column: P_DECL_FLAG 
     */	
	private String pdeclFlag;
    /**
     * 组织机构代码编号       db_column: TECH_REG_NO 
     */
	private String techRegNo;
	/**
     * 代理机构代码       db_column: ORG_CODE_DL
     */	
	private String orgCodeDl;
	//columns END


}
