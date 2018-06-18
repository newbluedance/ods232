package com.ninetowns.modules.dao.impl;

import java.util.List;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.entity.StaBas;
import org.springframework.stereotype.Repository;
import com.ninetowns.modules.dao.StaBasDao;

/**
* @FileName :StaBasDao
* @Author : licf
* @Create Date : 2015-10-09 20:46:02
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
@Repository("StaBasDao")
public class StaBasDaoImpl extends BaseDaoImpl<StaBas> implements StaBasDao{

	@Override
	public List<StaBas> queryAllByproId(String proId) {
	
		return getSqlSession().selectList(this.getClassName()+".queryAllByproId",proId);
	}

}
