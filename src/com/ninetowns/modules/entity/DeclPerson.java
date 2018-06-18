package com.ninetowns.modules.entity;
/**
 * 报检人员信息表
 * @author 马振勇
 *
 */
public class DeclPerson  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String declPersonCode;
	@Override
	public String toString() {
		return "DeclPerson [applyDate=" + applyDate + ", auditConclusion="
				+ auditConclusion + ", autidDate=" + autidDate
				+ ", blacklistFlag=" + blacklistFlag + ", checkConclusion="
				+ checkConclusion + ", closeFlag=" + closeFlag
				+ ", declPersonCode=" + declPersonCode + ", declPersonName="
				+ declPersonName + ", entRegCode=" + entRegCode
				+ ", id_Card_NO=" + id_Card_NO + ", oldPersonCode="
				+ oldPersonCode + ", operateDate=" + operateDate
				+ ", operatorCode=" + operatorCode + ", orgCode=" + orgCode
				+ ", permitDate=" + permitDate + ", preFlag=" + preFlag
				+ ", remark=" + remark + ", sex=" + sex + ", telPhone="
				+ telPhone + ", trainDate=" + trainDate + ", transFlag="
				+ transFlag + ", validPeriod=" + validPeriod + "]";
	}
	private String entRegCode;//企业注册代码
	private String declPersonName;//报检人员姓名
	private String sex;//性别
	private String id_Card_NO;
	private String telPhone;
	private String applyDate;
	private String trainDate;
	private String permitDate;
	private String validPeriod;
	private String checkConclusion;
	private String autidDate;
	private String auditConclusion;
	private String blacklistFlag;
	private String closeFlag;
	private String operatorCode;
	private String operateDate;
	private String remark;
	private String oldPersonCode;
	private String orgCode;
	private String transFlag;
	private String preFlag;
	public String getDeclPersonCode() {
		return declPersonCode;
	}
	public void setDeclPersonCode(String declPersonCode) {
		this.declPersonCode = declPersonCode;
	}
	public String getEntRegCode() {
		return entRegCode;
	}
	public void setEntRegCode(String entRegCode) {
		this.entRegCode = entRegCode;
	}
	public String getDeclPersonName() {
		return declPersonName;
	}
	public void setDeclPersonName(String declPersonName) {
		this.declPersonName = declPersonName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId_Card_NO() {
		return id_Card_NO;
	}
	public void setId_Card_NO(String idCardNO) {
		id_Card_NO = idCardNO;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getTrainDate() {
		return trainDate;
	}
	public void setTrainDate(String trainDate) {
		this.trainDate = trainDate;
	}
	public String getPermitDate() {
		return permitDate;
	}
	public void setPermitDate(String permitDate) {
		this.permitDate = permitDate;
	}
	public String getValidPeriod() {
		return validPeriod;
	}
	public void setValidPeriod(String validPeriod) {
		this.validPeriod = validPeriod;
	}
	public String getCheckConclusion() {
		return checkConclusion;
	}
	public void setCheckConclusion(String checkConclusion) {
		this.checkConclusion = checkConclusion;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOldPersonCode() {
		return oldPersonCode;
	}
	public void setOldPersonCode(String oldPersonCode) {
		this.oldPersonCode = oldPersonCode;
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
	public String getPreFlag() {
		return preFlag;
	}
	public void setPreFlag(String preFlag) {
		this.preFlag = preFlag;
	}

}
