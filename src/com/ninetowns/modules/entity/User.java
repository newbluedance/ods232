package com.ninetowns.modules.entity;

/**
 * @FileName : User
 * @Author : 周翔
 * @Create Date   : 2014-06-19 09:58
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :用户实体类
 */
public class User implements java.io.Serializable {
    public static final String TABLE_AS = "user";
    public static final String AS_userId = "用户ID";
    public static final String AS_LoginName = "登录名称";
    public static final String AS_loginPwd = "登录密码";
    public static final String AS_firstName = "姓名_首";
    public static final String AS_middleName = "姓名_中";
    public static final String AS_displayName = "显示名称";
    public static final String AS_sex = "性别";
    public static final String AS_email = "电子邮箱";
    public static final String AS_idCardNo = "身份证号";
    public static final String AS_telephone = "联系电话";
    public static final String AS_telephoneShort = "联系电话_短号";
    public static final String AS_mobileNO = "移动电话";
    public static final String AS_mobileNOShort = "移动电话_短号";
    public static final String AS_crtTime = "创建时间";
    public static final String AS_crtUser = "创建人ID";
    public static final String AS_deptId = "单位编号";
    public static final String AS_isNewUser = "是否新用户";
    public static final String AS_dataUpdTime = "更新时间";
    public static final String AS_dataUpdUser = "更新人ID";
    public static final String AS_dataValidFlag = "有效标识";
    public static final String AS_loginStatus = "登录状态";
    public static final String AS_logoutType = "登出类型";
    public static final String AS_deptCode = "部门";
    public static final String AS_positionCode = "职位";
    public static final String AS_currentOrgid = "当前所属局";
    public static final String AS_adminFlag = "是否管理员";
    public static final String AS_staffNo = "工号";
    public static final String AS_nation = "民族";
    public static final String AS_nativePlace = "籍贯";
    public static final String AS_apparat = "政治面貌";
    public static final String AS_birthday = "出生日期";
    public static final String AS_education = "文化程度";
    public static final String AS_finishTime = "毕业时间";
    public static final String AS_finishSchool = "毕业院校";
    public static final String AS_specialty = "所学专业";

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;

    //columns START
    /**
     * 用户ID       db_column: F_USER_ID
     */
    private String userId;
    /**
     * 登录名称       db_column: F_LOGIN_NAME
     */
    private String loginName;
    /**
     * 登录密码       db_column: F_LOGIN_PWD
     */
    private String loginPwd;
    /**
     * 姓名_首       db_column: F_FIRST_NAME
     */
    private String firstName;
    /**
     * 姓名_中       db_column: F_MIDDLE_NAME
     */
    private String middleName;
    /**
     * 显示名称       db_column: F_DISPLAY_NAME
     */
    private String displayName;
    /**
     * 性别       db_column: F_SEX
     */
    private String sex;
    /**
     * 电子邮箱       db_column: F_EMAIL
     */
    private String email;
    /**
     * 身份证号       db_column: F_ID_CARD_NO
     */
    private String idCardNo;
    /**
     * 联系电话       db_column: F_TELEPHONE
     */
    private String telephone;
    /**
     * 联系电话_短号       db_column: F_TELEPHONE_SHORT
     */
    private String telephoneShort;
    /**
     * 移动电话       db_column: F_MOBILE_NO
     */
    private String mobileNo;
    /**
     * 移动电话_短号       db_column: F_MOBILE_NO_SHORT
     */
    private String mobileNoShort;
    /**
     * 创建时间       db_column: F_CRT_TIME
     */
    private String crtTime;
    /**
     * 创建人ID       db_column: F_CRT_USER
     */
    private String crtUser;
    /**
     * 单位编号       db_column: F_DEPT_ID
     */
    private String deptId;
    /**
     * 是否新用户       db_column: F_IS_NEW_USER
     */
    private String isNewUser;
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
    /**
     * 登录状态       db_column: F_LOGIN_STATUS
     */
    private String loginStatus;
    /**
     * 登出类型       db_column: F_LOGOUT_TYPE
     */
    private String logoutType;
    /**
     * 部门       db_column: F_DEPT_CODE
     */
    private String deptCode;
    /**
     * 职位       db_column: F_POSITION_CODE
     */
    private String positionCode;
    /**
     * 当前所属局       db_column: F_CURRENT_ORGID
     */
    private String currentOrgid;
    /**
     * 是否管理员       db_column: F_ADMIN_FLAG
     */
    private String adminFlag;
    /**
     * 工号       db_column: F_STAFF_NO
     */
    private String staffNo;
    /**
     * 民族       db_column: F_NATION
     */
    private String nation;
    /**
     * 籍贯       db_column: F_NATIVE_PLACE
     */
    private String nativePlace;
    /**
     * 政治面貌       db_column: F_APPARAT
     */
    private String apparat;
    /**
     * 出生日期       db_column: F_BIRTHDAY
     */
    private String birthday;
    /**
     * 文化程度       db_column: F_EDUCATION
     */
    private String education;
    /**
     * 毕业时间       db_column: F_FINISH_TIME
     */
    private String finishTime;
    /**
     * 毕业院校       db_column: F_FINISH_SCHOOL
     */
    private String finishSchool;
    /**
     * 所学专业       db_column: F_SPECIALTY
     */
    private String specialty;

    private String userType;

    private String deptIds;
    //columns END

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephoneShort() {
        return telephoneShort;
    }

    public void setTelephoneShort(String telephoneShort) {
        this.telephoneShort = telephoneShort;
    }

    public String getMobileNoShort() {
        return mobileNoShort;
    }

    public void setMobileNoShort(String mobileNoShort) {
        this.mobileNoShort = mobileNoShort;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getIsNewUser() {
        return isNewUser;
    }

    public void setIsNewUser(String isNewUser) {
        this.isNewUser = isNewUser;
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

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getLogoutType() {
        return logoutType;
    }

    public void setLogoutType(String logoutType) {
        this.logoutType = logoutType;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getCurrentOrgid() {
        return currentOrgid;
    }

    public void setCurrentOrgid(String currentOrgid) {
        this.currentOrgid = currentOrgid;
    }

    public String getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(String adminFlag) {
        this.adminFlag = adminFlag;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getApparat() {
        return apparat;
    }

    public void setApparat(String apparat) {
        this.apparat = apparat;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getFinishSchool() {
        return finishSchool;
    }

    public void setFinishSchool(String finishSchool) {
        this.finishSchool = finishSchool;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }

}
