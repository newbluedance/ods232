package com.ninetowns.modules.entity;

/**
 * RoleMenu实体类
 * 
 * @author zhouxiang@ninetowns.com
 * 
 */
public class RoleMenu implements java.io.Serializable
{
    
	public static final String TABLE_AS = "roleMenu";
	public static final String AS_murlId = "菜单角色ID";
	public static final String AS_menuId = "菜单ID";
	public static final String AS_roleId = "角色ID";
	public static final String AS_dataUpdTime = "更新时间";
	public static final String AS_dataUpdUser = "更新人ID";
	public static final String AS_dataValidFlag = "有效标识";

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 菜单角色ID       db_column: F_MURL_ID 
     */	
	private String murlId;
    /**
     * 菜单ID       db_column: F_MENU_ID 
     */	
	private String menuId;
    /**
     * 角色ID       db_column: F_ROLE_ID 
     */	
	private String roleId;
    /**
     * 更新时间       db_column: F_DATA_UPD_TIME 
     */	
	private String dataUpdTime;
    /**
     * 更新人ID       db_column: F_DATA_UPD_USER 
     */	
	private String dataUpdUser;
    /**
     * 有效标识       db_column: F_DATA_VALID_FLAG 
     */	
	private String dataValidFlag;
	//columns END

    public String getMurlId() {
        return murlId;
    }

    public void setMurlId(String murlId) {
        this.murlId = murlId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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

