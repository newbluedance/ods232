package com.ninetowns.modules.entity;
/**
* @FileName :HisInfo
* @Author : licf
* @Create Date : 2015-10-09 19:44:48
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public class HisInfo implements java.io.Serializable {
	// columns START

	/**
	* 编号（主键） db_column: HISID
	 */
	private String hisId;

	/**
	* 产品编号（外键关联基础表） db_column: PROID
	 */
	private String proId;

	/**
	* 产品名称 db_column: PRONAME
	 */
	private String proName;

	/**
	* 位置分类 db_column: POSCLASS
	 */
	private String posClass;

	/**
	* 照片 db_column: PHOTO
	 */
	private String photo;

	/**
	* 说明 db_column: EXPLAINS
	 */
	private String explains;

	/**
	* 正反案例 db_column: CASNEG
	 */
	private String casneg;

	/**
	* 录入时间 db_column: CREATEDATE
	 */
	private String createDate;

	/**
	* 状态 db_column: STATE
	 */
	private String state;

	/**
	* 审核时间 db_column: CHECKDATE
	 */
	private String checkDate;

	/**
	* 审核意见 db_column: CHECKCONENT
	 */
	private String checkConent;

	/**
	* 审核人 db_column: CHECKNAME
	 */
	private String checkName;

	// columns END

	public String getHisId() {
		return hisId;
	}

	public void setHisId(String hisId) {
		this.hisId = hisId;
	}
	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getPosClass() {
		return posClass;
	}

	public void setPosClass(String posClass) {
		this.posClass = posClass;
	}
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getExplains() {
		return explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}
	public String getCasneg() {
		return casneg;
	}

	public void setCasneg(String casneg) {
		this.casneg = casneg;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getCheckConent() {
		return checkConent;
	}

	public void setCheckConent(String checkConent) {
		this.checkConent = checkConent;
	}
	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	@Override
	public String toString() {
		return "HisInfo [hisId=" + hisId + ", proId=" + proId + ", proName=" + proName + ", posClass=" + posClass + ", photo=" + photo + ", explains="
				+ explains + ", casneg=" + casneg + ", createDate=" + createDate + ", state=" + state + ", checkDate=" + checkDate + ", checkConent="
				+ checkConent + ", checkName=" + checkName + "]";
	}
	
	
}