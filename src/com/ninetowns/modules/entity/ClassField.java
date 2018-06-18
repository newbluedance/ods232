package com.ninetowns.modules.entity;

import java.util.List;

/**
* @FileName :ClassField
* @Author : licf
* @Create Date : 2015-10-12 09:52:36
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public class ClassField implements java.io.Serializable {
	// columns START

	/**
	* 主键 db_column: CFID
	 */
	private String cfId;

	/**
	* 类别id（外键） db_column: CLASSID
	 */
	private String classId;

	/**
	* 属性名 db_column: FIELDKEY
	 */
	private String fieldKey;

	/**
	* 创建时间 db_column: CREATETIME
	 */
	private String createTime;

	/**
	* 创建人 db_column: CREATEUSER
	 */
	private String createUser;

	/**
	* 修改时间 db_column: MODIFYTIME
	 */
	private String modifyTime;

	/**
	* 修改人 db_column: MODIFYUSER
	 */
	private String modifyUser;

	/**
	* 启用状态 db_column: STATE
	 */
	private String state;
	/**
	* 关联表id db_column: TABID
	 */
	private String tabId;

	// columns END
	//查询
	List<String> classIds;

	public String getCfId() {
		return cfId;
	}

	public void setCfId(String cfId) {
		this.cfId = cfId;
	}
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTabId() {
		return tabId;
	}

	public void setTabId(String tabId) {
		this.tabId = tabId;
	}

	public List<String> getClassIds() {
		return classIds;
	}

	public void setClassIds(List<String> classIds) {
		this.classIds = classIds;
	}
	
}