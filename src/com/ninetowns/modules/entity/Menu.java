package com.ninetowns.modules.entity;

/**
 * Menu实体类
 * 
 * @author zhouxiang@ninetowns.com
 * 
 */
public class Menu implements java.io.Serializable
{
    
	public static final String TABLE_AS = "menu";
	public static final String AS_menuId = "菜单ID";
	public static final String AS_menuName = "菜单名称";
	public static final String AS_menuParentId = "父级菜单ID";
	public static final String AS_menuUrl = "访问地址";
	public static final String AS_menuDesc = "菜单描述";
	public static final String AS_menuLevel = "菜单级别";
	public static final String AS_menuOrder = "同级菜单排序号";
	public static final String AS_projectId = "所属项目编号";
	public static final String AS_menuTarget = "链接target";
	public static final String AS_menuIcon = "图标路径";
	public static final String AS_crtTime = "创建时间";
	public static final String AS_crtUser = "创建人ID";
	public static final String AS_dataUpdTime = "更新时间";
	public static final String AS_dataUpdUser = "更新人ID";
	public static final String AS_dataValidFlag = "有效标识";

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 菜单ID       db_column: F_MENU_ID 
     */	
	private String menuId;
    /**
     * 菜单名称       db_column: F_MENU_NAME 
     */	
	private String menuName;
    /**
     * 父级菜单ID       db_column: F_MENU_PARENT_ID 
     */	
	private String menuParentId;
    /**
     * 访问地址       db_column: F_MENU_URL 
     */	
	private String menuUrl;
    /**
     * 菜单描述       db_column: F_MENU_DESC 
     */	
	private String menuDesc;
    /**
     * 菜单级别       db_column: F_MENU_LEVEL 
     */	
	private String menuLevel;
    /**
     * 同级菜单排序号       db_column: F_MENU_ORDER 
     */	
	private String menuOrder;
    /**
     * 所属项目编号       db_column: F_PROJECT_ID 
     */	
	private String projectId;
    /**
     * 链接target       db_column: F_MENU_TARGET 
     */	
	private String menuTarget;
    /**
     * 图标路径       db_column: F_MENU_ICON 
     */	
	private String menuIcon;
    /**
     * 创建时间       db_column: F_CRT_TIME 
     */	
	private String crtTime;
    /**
     * 创建人ID       db_column: F_CRT_USER 
     */	
	private String crtUser;
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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getMenuTarget() {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
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

