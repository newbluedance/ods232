package com.ninetowns.modules.entity;

/**
 * UserMenu实体类
 * 
 * @author zhouxiang@ninetowns.com
 * 
 */
public class UserMenu implements java.io.Serializable
{
    
	public static final String TABLE_AS = "userMenu";
	public static final String AS_urmuId = "用户菜单ID";
	public static final String AS_userId = "用户ID";
	public static final String AS_menuId = "菜单ID";
	public static final String AS_dataUpdTime = "更新时间";
	public static final String AS_dataUpdUser = "更新人ID";
	public static final String AS_dataValidFlag = "有效标识";

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 用户菜单ID       db_column: F_URMU_ID 
     */	
	private String urmuId;
    /**
     * 用户ID       db_column: F_USER_ID 
     */	
	private String userId;
    /**
     * 菜单ID       db_column: F_MENU_ID 
     */	
	private String menuId;
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

    public String getUrmuId() {
        return urmuId;
    }

    public void setUrmuId(String urmuId) {
        this.urmuId = urmuId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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

