package com.ninetowns.modules.dao.impl;

import java.util.List;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.entity.HisInfo;


import org.springframework.stereotype.Repository;
import com.ninetowns.modules.dao.HisInfoDao;

/**
* @FileName :HisInfoDao
* @Author : licf
* @Create Date : 2015-10-09 19:44:48
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
@Repository("HisInfoDao")
public class HisInfoDaoImpl extends BaseDaoImpl<HisInfo> implements HisInfoDao{

	@Override
	public List<HisInfo> queryAllByproId(String proId) {
		
		return getSqlSession().selectList(this.getClassName()+".queryAllByproId",proId);
	}

}
