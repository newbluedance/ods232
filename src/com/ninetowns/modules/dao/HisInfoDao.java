package com.ninetowns.modules.dao;

import java.util.List;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.HisInfo;

/**
* @FileName :HisInfoDao
* @Author : licf
* @Create Date : 2015-10-09 19:44:48
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface HisInfoDao extends BaseDao<HisInfo>{
	public List<HisInfo> queryAllByproId(String proId);
}
