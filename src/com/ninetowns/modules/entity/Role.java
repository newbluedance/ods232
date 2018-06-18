package com.ninetowns.modules.entity;

/**
 * Role实体类
 * 
 * @author zhouxiang@ninetowns.com
 * 
 */
public class Role implements java.io.Serializable
{
    
	public static final String TABLE_AS = "role";
	public static final String AS_roleId = "角色ID";
	public static final String AS_roleName = "角色名";
	public static final String AS_dataUpdTime = "数据更新时间";
	public static final String AS_dataUpdUser = "数据更新人";
	public static final String AS_roleType = "角色类型";
	public static final String AS_projectId = "所属项目";

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 角色ID       db_column: F_ROLE_ID 
     */	
	private String roleId;
    /**
     * 角色名       db_column: F_ROLE_NAME 
     */	
	private String roleName;
    /**
     * 数据更新时间       db_column: F_DATA_UPD_TIME 
     */	
	private String dataUpdTime;
    /**
     * 数据更新人       db_column: F_DATA_UPD_USER 
     */	
	private String dataUpdUser;
    /**
     * 角色类型       db_column: F_ROLE_TYPE 
     */	
	private String roleType;
    /**
     * 所属项目       db_column: F_PROJECT_ID 
     */	
	private String projectId;

    /**
     * 角色描述       db_column: F_ROLE_DESC
     */
    private String roleDesc;
	//columns END

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDataUpdTime() {
        return dataUpdTime;
    }

    public void setDataUpdTime(String dataUpdTime) {
        this.dataUpdTime = dataUpdTime;
    }

    public String getDataUpdUser() {
        return dataUpdUser;
    }

    public void setDataUpdUser(String dataUpdUser) {
        this.dataUpdUser = dataUpdUser;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}

