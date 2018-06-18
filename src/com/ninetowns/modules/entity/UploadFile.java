package com.ninetowns.modules.entity;

import java.util.Date;

/**
 * RoleMenu实体类
 *
 * @author zhouxiang@ninetowns.com
 *
 */
public class UploadFile implements java.io.Serializable
{
    private String filePathId;
    private String tabName;
    private String tabId;
    private String tabFileName;
    private String fileType;
    private String filePath;
    private String remark;
    private String uploadUser;
    private Date uploadDate;
    private String deleteFlag;
    private String fileName;
    private String status;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePathId() {
        return filePathId;
    }

    public void setFilePathId(String filePathId) {
        this.filePathId = filePathId;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public String getTabFileName() {
        return tabFileName;
    }

    public void setTabFileName(String tabFileName) {
        this.tabFileName = tabFileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

