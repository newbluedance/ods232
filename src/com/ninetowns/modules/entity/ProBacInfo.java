package com.ninetowns.modules.entity;

import java.util.List;

/**
* @FileName :ProBacInfo
* @Author : licf
* @Create Date : 2015-10-09 18:48:03
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public class ProBacInfo implements java.io.Serializable {
	// columns START

	/**
	* 产品编号 db_column: PROID
	 */
	private String proId;

	/**
	* hs编码 db_column: HSCODE
	 */
	private String hsCode;

	/**
	* 产品名称 db_column: PRONAME
	 */
	private String proName;

	/**
	* 产品市场名称 db_column: PROMNAME
	 */
	private String promName;

	/**
	* 产品类别 db_column: CLASSID
	 */
	private String classId;

	/**
	* 制作商 db_column: MAKER
	 */
	private String maker;

	/**
	* 产地 db_column: ADDRESS
	 */
	private String address;

	/**
	* 品牌 db_column: BRAND
	 */
	private String brand;

	/**
	* 产品录入时间 db_column: CREATEDATE
	 */
	private String createDate;

	/**
	* 状态 db_column: STATE
	 */
	private String state;

	/**
	* 审核时间 db_column: CHECKDATE
	 */
	private String checkDate;

	/**
	* 审核意见 db_column: CHECKCONENT
	 */
	private String checkConent;

	/**
	* 审核人 db_column: CHECKNAME
	 */
	private String checkName;
	

	/**
	* 状态 db_column: STATE
	 */
	private String stateH;

	/**
	* 审核时间 db_column: CHECKDATE
	 */
	private String checkDateH;

	/**
	* 审核意见 db_column: CHECKCONENT
	 */
	private String checkConentH;

	/**
	* 审核人 db_column: CHECKNAME
	 */
	private String checkNameH;
	
	
	/**
	* 状态 db_column: STATE
	 */
	private String stateS;

	/**
	* 审核时间 db_column: CHECKDATE
	 */
	private String checkDateS;

	/**
	* 审核意见 db_column: CHECKCONENT
	 */
	private String checkConentS;

	/**
	* 审核人 db_column: CHECKNAME
	 */
	private String checkNameS;
	
	/**
	* 产品类别 显示属性
	 */
	private String className;
	/**
	* 多种状态 用于查询
	 */
	private List<String> stateList;
	/**
	* 多种状态 用于查询
	 */
	private List<String> stateHList;
	/**
	* 多种状态 用于查询
	 */
	private List<String> stateSList;
	// columns END
	
	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getHsCode() {
		return hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getPromName() {
		return promName;
	}

	public void setPromName(String promName) {
		this.promName = promName;
	}
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getCheckConent() {
		return checkConent;
	}

	public void setCheckConent(String checkConent) {
		this.checkConent = checkConent;
	}
	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	
	public String getStateH() {
		return stateH;
	}

	public void setStateH(String stateH) {
		this.stateH = stateH;
	}

	public String getCheckDateH() {
		return checkDateH;
	}

	public void setCheckDateH(String checkDateH) {
		this.checkDateH = checkDateH;
	}

	public String getCheckConentH() {
		return checkConentH;
	}

	public void setCheckConentH(String checkConentH) {
		this.checkConentH = checkConentH;
	}

	public String getCheckNameH() {
		return checkNameH;
	}

	public void setCheckNameH(String checkNameH) {
		this.checkNameH = checkNameH;
	}

	public String getStateS() {
		return stateS;
	}

	public void setStateS(String stateS) {
		this.stateS = stateS;
	}

	public String getCheckDateS() {
		return checkDateS;
	}

	public void setCheckDateS(String checkDateS) {
		this.checkDateS = checkDateS;
	}

	public String getCheckConentS() {
		return checkConentS;
	}

	public void setCheckConentS(String checkConentS) {
		this.checkConentS = checkConentS;
	}

	public String getCheckNameS() {
		return checkNameS;
	}

	public void setCheckNameS(String checkNameS) {
		this.checkNameS = checkNameS;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}


	public List<String> getStateList() {
		return stateList;
	}

	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}

	public List<String> getStateHList() {
		return stateHList;
	}

	public void setStateHList(List<String> stateHList) {
		this.stateHList = stateHList;
	}

	public List<String> getStateSList() {
		return stateSList;
	}

	public void setStateSList(List<String> stateSList) {
		this.stateSList = stateSList;
	}

	@Override
	public String toString() {
		return "ProBacInfo [proId=" + proId + ", hsCode=" + hsCode + ", proName=" + proName + ", promName=" + promName + ", classId=" + classId + ", maker="
				+ maker + ", address=" + address + ", brand=" + brand + ", createDate=" + createDate + ", state=" + state + ", checkDate=" + checkDate
				+ ", checkConent=" + checkConent + ", checkName=" + checkName + ", stateH=" + stateH + ", checkDateH=" + checkDateH + ", checkConentH="
				+ checkConentH + ", checkNameH=" + checkNameH + ", stateS=" + stateS + ", checkDateS=" + checkDateS + ", checkConentS=" + checkConentS
				+ ", checkNameS=" + checkNameS + ", className=" + className + "]";
	}

	
}