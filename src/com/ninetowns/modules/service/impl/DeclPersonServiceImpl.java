package com.ninetowns.modules.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninetowns.modules.dao.DeclPersonDao;
import com.ninetowns.modules.dao.EntInfoDao;
import com.ninetowns.modules.entity.DeclPerson;
import com.ninetowns.modules.entity.EntInfo;
import com.ninetowns.modules.service.DeclPersonService;
import com.ninetowns.modules.service.EntInfoService;
import com.ninetowns.utils.PageView;

@Service("DeclPersonService")
public class DeclPersonServiceImpl implements DeclPersonService{
@Autowired
private DeclPersonDao declPersonDao;

@Override
public DeclPerson getById(String declPersonCode) {
	// TODO Auto-generated method stub
	return declPersonDao.getById(declPersonCode);
}

@Override
public PageView queryListPage(PageView pageView, DeclPerson declPerson) {
	 List<DeclPerson> list = declPersonDao.queryListPage(pageView, declPerson);
     pageView.setRows(list);
     return pageView;
}
}
