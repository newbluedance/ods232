package com.ninetowns.modules.entity;

/**
 * UserLog实体类
 * 
 * @author zhouxiang@ninetowns.com
 * 
 */
public class UserLog implements java.io.Serializable
{
    
	public static final String TABLE_AS = "userLog";
	public static final String AS_urlgId = "用户日志ID";
	public static final String AS_operationId = "操作人ID";
	public static final String AS_operationTime = "操作时间";
	public static final String AS_sessionId = "sessionID号";
	public static final String AS_ip = "ip地址";
	public static final String AS_operationName = "操作名称";
	public static final String AS_operationResult = "操作结果";
	public static final String AS_during = "时长";

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
	
	//columns START
    /**
     * 用户日志ID       db_column: F_URLG_ID 
     */	
	private String urlgId;
    /**
     * 操作人ID       db_column: F_OPERATION_ID 
     */	
	private String operationId;
    /**
     * 操作时间       db_column: F_OPERATION_TIME 
     */	
	private String operationTime;
    /**
     * sessionID号       db_column: F_SESSION_ID 
     */	
	private String sessionId;
    /**
     * ip地址       db_column: F_IP 
     */	
	private String ip;
    /**
     * 操作名称       db_column: F_OPERATION_NAME 
     */	
	private String operationName;
    /**
     * 操作结果       db_column: F_OPERATION_RESULT 
     */	
	private String operationResult;
    /**
     * 时长       db_column: F_DURING 
     */	
	private String during;
	//columns END

    public String getUrlgId() {
        return urlgId;
    }

    public void setUrlgId(String urlgId) {
        this.urlgId = urlgId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public String getDuring() {
        return during;
    }

    public void setDuring(String during) {
        this.during = during;
    }
}

