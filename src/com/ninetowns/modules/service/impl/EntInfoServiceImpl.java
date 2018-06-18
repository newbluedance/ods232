package com.ninetowns.modules.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninetowns.modules.dao.EntInfoDao;
import com.ninetowns.modules.entity.EntInfo;
import com.ninetowns.modules.service.EntInfoService;
import com.ninetowns.utils.PageView;

@Service("EntInfoService")
public class EntInfoServiceImpl implements EntInfoService{
@Autowired
private EntInfoDao entInfoDao;
	@Override
	public EntInfo getById(String entRegCode) {
		// TODO Auto-generated method stub
		return entInfoDao.getById(entRegCode);
	}

	@Override
	public PageView queryListPage(PageView pageView, EntInfo entInfo) {
		// TODO Auto-generated method stub
		 List<EntInfo> list = entInfoDao.queryListPage(pageView, entInfo);
	        pageView.setRows(list);
	        return pageView;
	        
	}

	@Override
	public EntInfo add(EntInfo entInfo) {
		// TODO Auto-generated method stub
		return entInfoDao.add(entInfo);
	}

}
