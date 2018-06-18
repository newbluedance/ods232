package com.ninetowns.modules.entity;

/**
 * UserRole实体类
 * 
 * @author zhouxiang@ninetowns.com
 * 
 */
public class UserRole implements java.io.Serializable
{
    
	public static final String TABLE_AS = "userRole";
	public static final String AS_relaId = "用户角色ID";
	public static final String AS_userId = "fuserId";
	public static final String AS_roleId = "角色ID";
	public static final String AS_dataUpdTime = "数据更新时间";
	public static final String AS_dataUpdUser = "数据更新人";
	public static final String AS_dataValidFlag = "有效标识";

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 用户角色ID       db_column: F_RELA_ID 
     */	
	private String relaId;
    /**
     * fuserId       db_column: F_USER_ID 
     */	
	private String userId;
    /**
     * 角色ID       db_column: F_ROLE_ID 
     */	
	private String roleId;
    /**
     * 数据更新时间       db_column: F_DATA_UPD_TIME 
     */	
	private String dataUpdTime;
    /**
     * 数据更新人       db_column: F_DATA_UPD_USER 
     */	
	private String dataUpdUser;
    /**
     * 有效标识       db_column: F_DATA_VALID_FLAG 
     */	
	private String dataValidFlag;
	//columns END

    public String getRelaId() {
        return relaId;
    }

    public void setRelaId(String relaId) {
        this.relaId = relaId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public String getDataValidFlag() {
        return dataValidFlag;
    }

    public void setDataValidFlag(String dataValidFlag) {
        this.dataValidFlag = dataValidFlag;
    }
}

