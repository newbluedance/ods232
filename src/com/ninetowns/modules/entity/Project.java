package com.ninetowns.modules.entity;

/**
 * Project实体类
 * 
 * @author zhouxiang@ninetowns.com
 * 
 */
public class Project implements java.io.Serializable
{
    
	public static final String TABLE_AS = "project";
	public static final String AS_projectId = "项目编号";
	public static final String AS_projectName = "项目名称";
	public static final String AS_serverUrl = "服务器地址";
	public static final String AS_isActive = "激活状态";
	public static final String AS_sort = "排序字段";

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 项目编号       db_column: F_PROJECT_ID 
     */	
	private String projectId;
    /**
     * 项目名称       db_column: F_PROJECT_NAME 
     */	
	private String projectName;
    /**
     * 服务器地址       db_column: F_SERVER_URL 
     */	
	private String serverUrl;
    /**
     * 激活状态       db_column: F_IS_ACTIVE 
     */	
	private String isActive;
    /**
     * 排序字段       db_column: F_SORT 
     */	
	private String sort;
	//columns END

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}

