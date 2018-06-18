package com.ninetowns.modules.entity;
/**
* @FileName :ExcField
* @Author : licf
* @Create Date : 2015-10-09 21:32:25
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public class ExcField implements java.io.Serializable {
	// columns START

	/**
	* 编号（主键） db_column: FIELDID
	 */
	private String fieldId;

	/**
	* 关联表（1产品基础特征表，2历史信息特征表3规范依据表） db_column: TABLENAME
	 */
	private String tableName;

	/**
	* 关联id db_column: CLASSID
	 */
	private String classId;

	/**
	* 属性名称 db_column: FIELDKEY
	 */
	private String fieldKey;

	/**
	* 属性值 db_column: FIELDVALUE
	 */
	private String fieldValue;

	/**
	* 属性类型（预留） db_column: FIELDTYPE
	 */
	private String fieldType;

	// columns END

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}
	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	@Override
	public String toString() {
		return "ExcField [fieldId=" + fieldId + ", tableName=" + tableName + ", classId=" + classId + ", fieldKey=" + fieldKey + ", fieldValue=" + fieldValue
				+ ", fieldType=" + fieldType + "]";
	}
	
}