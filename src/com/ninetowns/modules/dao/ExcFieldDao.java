package com.ninetowns.modules.dao;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.ExcField;

/**
* @FileName :ExcFieldDao
* @Author : licf
* @Create Date : 2015-10-09 21:32:25
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface ExcFieldDao extends BaseDao<ExcField>{
	public void deleteByClassId(String classId);
}
