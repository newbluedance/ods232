package com.ninetowns.modules.entity;
/**
* @FileName :ProClass
* @Author : licf
* @Create Date : 2015-10-09 22:17:15
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public class ProClass implements java.io.Serializable {
	// columns START

	/**
	* null db_column: CLASSID
	 */
	private String classId;

	/**
	* null db_column: CLASSNAME
	 */
	private String className;

	/**
	* null db_column: PARENTID
	 */
	private String parentId;

	/**
	* null db_column: PRIORITY
	 */
	private String priority;

	/**
	* null db_column: CLASSDESC
	 */
	private String classDesc;

	/**
	* null db_column: CLASSLEVEL
	 */
	private String classLevel;

	/**
	* null db_column: CLASSICON
	 */
	private String classIcon;

	/**
	* null db_column: CREATETIME
	 */
	private String createTime;

	/**
	* null db_column: CREATEUSER
	 */
	private String createUser;

	/**
	* null db_column: MODIFYTIME
	 */
	private String modifyTime;

	/**
	* null db_column: MODIFYUSER
	 */
	private String modifyUser;

	/**
	* null db_column: STATE
	 */
	private String state;

	// columns END

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}
	public String getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}
	public String getClassIcon() {
		return classIcon;
	}

	public void setClassIcon(String classIcon) {
		this.classIcon = classIcon;
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

	@Override
	public String toString() {
		return "ProClass [classId=" + classId + ", className=" + className + ", parentId=" + parentId + ", priority=" + priority + ", classDesc=" + classDesc
				+ ", classLevel=" + classLevel + ", classIcon=" + classIcon + ", createTime=" + createTime + ", createUser=" + createUser + ", modifyTime="
				+ modifyTime + ", modifyUser=" + modifyUser + ", state=" + state + "]";
	}
	
	
}