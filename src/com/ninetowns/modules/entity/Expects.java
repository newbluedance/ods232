package com.ninetowns.modules.entity;
/**
* @FileName :Expects
* @Author : licf
* @Create Date : 2015-11-04 15:11:46
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public class Expects implements java.io.Serializable {
	// columns START

	/**
	* 主键 db_column: EXID
	 */
	private String exId;

	/**
	* 人员 db_column: EXPECTNAME
	 */
	private String expectName;

	/**
	* 电话 db_column: PHONE
	 */
	private String phone;

	/**
	* 单位 db_column: DEPT
	 */
	private String dept;

	// columns END

	public String getExId() {
		return exId;
	}

	public void setExId(String exId) {
		this.exId = exId;
	}
	public String getExpectName() {
		return expectName;
	}

	public void setExpectName(String expectName) {
		this.expectName = expectName;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Expects [exId=" + exId + ", expectName=" + expectName + ", phone=" + phone + ", dept=" + dept + "]";
	}
	
}