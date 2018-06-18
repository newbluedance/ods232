package com.ninetowns.modules.dao;

import java.util.List;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.StaBas;

/**
* @FileName :StaBasDao
* @Author : licf
* @Create Date : 2015-10-09 20:21:04
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface StaBasDao extends BaseDao<StaBas>{
				 public List<StaBas> queryAllByproId(String proId);
}
