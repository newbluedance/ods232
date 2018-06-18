package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.Expects;
import java.util.List;
import com.ninetowns.utils.PageView;

/**
* @FileName :ExpectsService
* @Author : licf
* @Create Date : 2015-11-04 15:11:46
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface ExpectsService{

	public List<Expects> query(Expects expects);
	public PageView queryListPage(PageView pageView, Expects expects);
	public Expects add(Expects expects);
	public void delete(String id);
	public void modify(Expects expects);
	public Expects getById(String id);
}
