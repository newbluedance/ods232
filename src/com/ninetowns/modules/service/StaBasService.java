package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.StaBas;
import java.util.List;
import com.ninetowns.utils.PageView;

/**
* @FileName :StaBasService
* @Author : licf
* @Create Date : 2015-10-09 20:21:04
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface StaBasService{

	public List<StaBas> query(StaBas staBas);
	public PageView queryListPage(PageView pageView, StaBas staBas);
	public StaBas add(StaBas staBas);
	public void delete(String id);
	public void modify(StaBas staBas);
	public StaBas getById(String id);
	public List<StaBas> queryAllByproId(String proId);
}
