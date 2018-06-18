package com.ninetowns.modules.entity;

import java.util.Date;

/**
 * Dept实体类
 * 
 * @author zhouxiang@ninetowns.com
 * 
 */
public class Dept implements java.io.Serializable
{
    
	public static final String TABLE_AS = "dept";
	public static final String AS_deptId = "部门ID";
	public static final String AS_deptCode = "部门机构代码";
	public static final String AS_deptName = "部门名称";
	public static final String AS_deptParentId = "上级组织";
	public static final String AS_deptType = "组织类型";
	public static final String AS_sortIndex = "排序编号";
	public static final String AS_crtTime = "创建时间";
	public static final String AS_crtUser = "创建人";
	public static final String AS_dataUpdTime = "数据更新时间";
	public static final String AS_dataUpdUser = "数据更新人";
	public static final String AS_address = "地址";
	public static final String AS_zipCode = "邮政编码";
	public static final String AS_dataValidFlag = "有效标识";

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 部门ID       db_column: F_DEPT_ID 
     */	
	private String deptId;
    /**
     * 部门机构代码       db_column: F_DEPT_CODE 
     */	
	private String deptCode;
    /**
     * 部门名称       db_column: F_DEPT_NAME 
     */	
	private String deptName;
    /**
     * 上级组织       db_column: F_DEPT_PARENT_ID 
     */	
	private String deptParentId;
    /**
     * 组织类型       db_column: F_DEPT_TYPE 
     */	
	private String deptType;
    /**
     * 排序编号       db_column: F_SORT_INDEX 
     */	
	private String sortIndex;
    /**
     * 创建时间       db_column: F_CRT_TIME 
     */	
	private Date crtTime;
    /**
     * 创建人       db_column: F_CRT_USER 
     */	
	private String crtUser;
    /**
     * 数据更新时间       db_column: F_DATA_UPD_TIME 
     */	
	private Date dataUpdTime;
    /**
     * 数据更新人       db_column: F_DATA_UPD_USER 
     */	
	private String dataUpdUser;
    /**
     * 地址       db_column: F_ADDRESS 
     */	
	private String address;
    /**
     * 邮政编码       db_column: F_ZIP_CODE 
     */	
	private String zipCode;
    /**
     * 有效标识       db_column: F_DATA_VALID_FLAG 
     */	
	private String dataValidFlag;
	//columns END

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptParentId() {
        return deptParentId;
    }

    public void setDeptParentId(String deptParentId) {
        this.deptParentId = deptParentId;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(String sortIndex) {
        this.sortIndex = sortIndex;
    }



    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }



    public String getDataUpdUser() {
        return dataUpdUser;
    }

    public void setDataUpdUser(String dataUpdUser) {
        this.dataUpdUser = dataUpdUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDataValidFlag() {
        return dataValidFlag;
    }

    public void setDataValidFlag(String dataValidFlag) {
        this.dataValidFlag = dataValidFlag;
    }

    public Date getDataUpdTime() {

        return dataUpdTime;
    }

    public void setDataUpdTime(Date dataUpdTime) {
        this.dataUpdTime = dataUpdTime;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}

