package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.entity.StaBas;
import java.util.List;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ninetowns.modules.dao.StaBasDao;
import com.ninetowns.modules.service.StaBasService;

/**
* @FileName :StaBasServiceImpl
* @Author : licf
* @Create Date : 2015-10-09 20:46:02
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/

@Transactional
@Service("StaBasService")
public class StaBasServiceImpl implements StaBasService{

	@Autowired
	private StaBasDao staBasDao;

	@Override
	public List<StaBas> query(StaBas staBas){
		return staBasDao.queryAll(staBas);
	}
	@Override
	public PageView queryListPage(PageView pageView, StaBas staBas){
		List<StaBas> list = staBasDao.queryListPage(pageView, staBas);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public StaBas add(StaBas staBas){
		return staBasDao.add(staBas);
	}
	@Override
	public void delete(String id){
		staBasDao.delete(id);
	}
	@Override
	public void modify(StaBas staBas){
		staBasDao.modify(staBas);
	}
	@Override
	public StaBas getById(String id){
		return staBasDao.getById(id);
	}
	@Override
	public List<StaBas> queryAllByproId(String proId) {
		// TODO Auto-generated method stub
		return staBasDao.queryAllByproId(proId);
	}
}
