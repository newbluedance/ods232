package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.entity.ProBacInfo;
import java.util.List;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ninetowns.modules.dao.ProBacInfoDao;
import com.ninetowns.modules.service.ProBacInfoService;

/**
* @FileName :ProBacInfoServiceImpl
* @Author : licf
* @Create Date : 2015-10-09 18:48:03
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/

@Transactional
@Service("ProBacInfoService")
public class ProBacInfoServiceImpl implements ProBacInfoService{

	@Autowired
	private ProBacInfoDao proBacInfoDao;

	@Override
	public List<ProBacInfo> query(ProBacInfo proBacInfo){
		return null;
	}
	@Override
	public PageView queryListPage(PageView pageView, ProBacInfo proBacInfo){
		List<ProBacInfo> list = proBacInfoDao.queryListPage(pageView, proBacInfo);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public ProBacInfo add(ProBacInfo proBacInfo){
		return proBacInfoDao.add(proBacInfo);
	}
	@Override
	public void delete(String id){
		proBacInfoDao.delete(id);
	}
	@Override
	public void modify(ProBacInfo proBacInfo){
		proBacInfoDao.modify(proBacInfo);
	}
	@Override
	public ProBacInfo getById(String id){
		return proBacInfoDao.getById(id);
	}
	@Override
	public void updateState(ProBacInfo proBacInfo) {
		proBacInfoDao.updateState(proBacInfo);
	}
	@Override
	public void updateStateH(ProBacInfo proBacInfo) {
		proBacInfoDao.updateStateH(proBacInfo);
	}
	@Override
	public void updateStateS(ProBacInfo proBacInfo) {
		proBacInfoDao.updateStateS(proBacInfo);
	}
	@Override
	public PageView queryCheckListPage(PageView pageView, ProBacInfo proBacInfo) {
		List<ProBacInfo> list = proBacInfoDao.queryCheckListPage(pageView, proBacInfo);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public PageView queryCheckListPageH(PageView pageView, ProBacInfo proBacInfo) {
		List<ProBacInfo> list = proBacInfoDao.queryCheckListPageH(pageView, proBacInfo);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public PageView queryCheckListPageS(PageView pageView, ProBacInfo proBacInfo) {
		List<ProBacInfo> list = proBacInfoDao.queryCheckListPageS(pageView, proBacInfo);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public PageView queryListPageForDesc(PageView pageView, ProBacInfo proBacInfo) {
		List<ProBacInfo> list = proBacInfoDao.queryListPageForDesc(pageView, proBacInfo);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public String queryByMax(String createDate) {
		
		return proBacInfoDao.queryByMax(createDate);
	}
}
