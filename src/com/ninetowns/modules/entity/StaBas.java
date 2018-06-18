package com.ninetowns.modules.entity;
/**
* @FileName :StaBas
* @Author : licf
* @Create Date : 2015-10-09 20:46:02
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public class StaBas implements java.io.Serializable {
	// columns START

	/**
	* 依据编号（主键） db_column: STAID
	 */
	private String staId;

	/**
	* 产品编号（外键） db_column: PROID
	 */
	private String proId;

	/**
	* 产品名称 db_column: PRONAME
	 */
	private String proName;

	/**
	* 依据类别 db_column: BASISCLASS
	 */
	private String basisClass;

	/**
	* 依据文件 db_column: BASEFILE
	 */
	private String baseFile;

	/**
	* 正反案例 db_column: CASNEG
	 */
	private String casneg;

	/**
	* 产品录入时间 db_column: CREATEDATE
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
	/**
	 * 失效日期 db_column:EXPIRYDATA
	 * @return
	 */
	private  String expiryData;
	
	/**
	 * 是否有效 db_column:ISVALID
	 * @return
	 */
	private String isValid;
	
	/**
	 * 有效日期 db_column:VALIDDATA
	 * @return
	 */
	private String validData;
	
	// columns END

	public String getExpiryData() {
		return expiryData;
	}

	public void setExpiryData(String expiryData) {
		this.expiryData = expiryData;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	
	public String getValidData() {
		return validData;
	}

	public void setValidData(String validData) {
		this.validData = validData;
	}

	public String getStaId() {
		return staId;
	}

	public void setStaId(String staId) {
		this.staId = staId;
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
	public String getBasisClass() {
		return basisClass;
	}

	public void setBasisClass(String basisClass) {
		this.basisClass = basisClass;
	}
	public String getBaseFile() {
		return baseFile;
	}

	public void setBaseFile(String baseFile) {
		this.baseFile = baseFile;
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
		return "StaBas [staId=" + staId + ", proId=" + proId + ", proName=" + proName + ", basisClass=" + basisClass + ", baseFile=" + baseFile + ", casneg="
				+ casneg + ", createDate=" + createDate + ", state=" + state + ", checkDate=" + checkDate + ", checkConent=" + checkConent + ", checkName="
				+ checkName + ",expiryData="+expiryData+",isValid="+isValid+",validData="+validData+"]";
	}
	
	
}