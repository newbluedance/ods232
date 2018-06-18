package com.ninetowns.modules.entity;

/**
 * Placard实体类
 * 
 * @author zhouxiang@ninetowns.com
 * 
 */
public class Placard implements java.io.Serializable
{
    
	public static final String TABLE_AS = "placard";
	public static final String AS_placardId = "公告ID";
	public static final String AS_titile = "公告标题";
	public static final String AS_content = "公告内容";
	public static final String AS_state = "公告状态";
	public static final String AS_showPlace = "显示地方";
	public static final String AS_crtUser = "创建人ID";
	public static final String AS_crtTime = "创建时间";
	public static final String AS_updUser = "更新人ID";
	public static final String AS_updTime = "更新时间";

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 公告ID       db_column: F_PLACARD_ID 
     */	
	private String placardId;
    /**
     * 公告标题       db_column: F_TITLE 
     */	
	private String title;
    /**
     * 公告内容       db_column: F_CONTENT 
     */	
	private String content;
    /**
     * 公告状态       db_column: F_STATE 
     */	
	private String state;
    /**
     * 显示地方       db_column: F_SHOW_PLACE 
     */	
	private String showPlace;
    /**
     * 创建人ID       db_column: F_CRT_USER 
     */	
	private String crtUser;
    /**
     * 创建时间       db_column: F_CRT_TIME 
     */	
	private String crtTime;
    /**
     * 更新人ID       db_column: F_UPD_USER 
     */	
	private String updUser;
    /**
     * 更新时间       db_column: F_UPD_TIME 
     */	
	private String updTime;
	//columns END

    public String getPlacardId() {
        return placardId;
    }

    public void setPlacardId(String placardId) {
        this.placardId = placardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getShowPlace() {
        return showPlace;
    }

    public void setShowPlace(String showPlace) {
        this.showPlace = showPlace;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }
}

