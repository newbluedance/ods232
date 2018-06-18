package com.ninetowns.modules.dao.impl;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.entity.ExcField;
import org.springframework.stereotype.Repository;
import com.ninetowns.modules.dao.ExcFieldDao;

/**
* @FileName :ExcFieldDao
* @Author : licf
* @Create Date : 2015-10-09 21:32:25
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
@Repository("ExcFieldDao")
public class ExcFieldDaoImpl extends BaseDaoImpl<ExcField> implements ExcFieldDao{

	@Override
	public void deleteByClassId(String classId) {
		// TODO Auto-generated method stub
		getSqlSession().delete(this.getClassName()+".deleteByClassId",classId);
	}

}
