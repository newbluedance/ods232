package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.entity.Expects;
import java.util.List;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ninetowns.modules.dao.ExpectsDao;
import com.ninetowns.modules.service.ExpectsService;

/**
* @FileName :ExpectsServiceImpl
* @Author : licf
* @Create Date : 2015-11-04 15:11:46
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/

@Transactional
@Service("ExpectsService")
public class ExpectsServiceImpl implements ExpectsService{

	@Autowired
	private ExpectsDao expectsDao;

	@Override
	public List<Expects> query(Expects expects){
		return null;
	}
	@Override
	public PageView queryListPage(PageView pageView, Expects expects){
		List<Expects> list = expectsDao.queryListPage(pageView, expects);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public Expects add(Expects expects){
		return expectsDao.add(expects);
	}
	@Override
	public void delete(String id){
		expectsDao.delete(id);
	}
	@Override
	public void modify(Expects expects){
		expectsDao.modify(expects);
	}
	@Override
	public Expects getById(String id){
		return expectsDao.getById(id);
	}
}
