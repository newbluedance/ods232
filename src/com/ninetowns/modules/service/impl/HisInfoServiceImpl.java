package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.entity.HisInfo;
import com.ninetowns.modules.entity.ProBacInfo;

import java.util.List;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ninetowns.modules.dao.HisInfoDao;
import com.ninetowns.modules.service.HisInfoService;

/**
* @FileName :HisInfoServiceImpl
* @Author : licf
* @Create Date : 2015-10-09 19:44:48
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/

@Transactional
@Service("HisInfoService")
public class HisInfoServiceImpl implements HisInfoService{

	@Autowired
	private HisInfoDao hisInfoDao;

	@Override
	public List<HisInfo> query(HisInfo hisInfo){
		return hisInfoDao.queryAll(hisInfo);
	}
	@Override
	public PageView queryListPage(PageView pageView, HisInfo hisInfo){
		List<HisInfo> list = hisInfoDao.queryListPage(pageView, hisInfo);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public HisInfo add(HisInfo hisInfo){
		return hisInfoDao.add(hisInfo);
	}
	@Override
	public void delete(String id){
		hisInfoDao.delete(id);
	}
	@Override
	public void modify(HisInfo hisInfo){
		hisInfoDao.modify(hisInfo);
	}
	@Override
	public HisInfo getById(String id){
		return hisInfoDao.getById(id);
	}
	@Override
	public List<HisInfo> queryAllByproId(String proId) {
		
		return hisInfoDao.queryAllByproId(proId);
	}
}
