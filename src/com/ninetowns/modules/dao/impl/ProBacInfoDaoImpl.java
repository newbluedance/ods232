package com.ninetowns.modules.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.entity.ProBacInfo;
import org.springframework.stereotype.Repository;
import com.ninetowns.modules.dao.ProBacInfoDao;
import com.ninetowns.utils.PageView;

/**
* @FileName :ProBacInfoDao
* @Author : licf
* @Create Date : 2015-10-09 18:48:03
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
@Repository("ProBacInfoDao")
public class ProBacInfoDaoImpl extends BaseDaoImpl<ProBacInfo> implements ProBacInfoDao{
	
	@Override
	public void updateState(ProBacInfo proBacInfo) {
		getSqlSession().update(this.getClassName()+ ".updateState", proBacInfo);
		
	}
	@Override
	public void updateStateH(ProBacInfo proBacInfo) {
		getSqlSession().update(this.getClassName()+ ".updateStateH", proBacInfo);
		
	}
	@Override
	public void updateStateS(ProBacInfo proBacInfo) {
		getSqlSession().update(this.getClassName()+ ".updateStateS", proBacInfo);
		
	}
	@Override
	public List<ProBacInfo> queryCheckListPage(PageView pageView, ProBacInfo proBacInfo) {
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("paging", pageView);
        map.put("t", proBacInfo);
        return getSqlSession().selectList(this.getClassName()+".queryCheckListPage",map);
	}
	@Override
	public List<ProBacInfo> queryCheckListPageH(PageView pageView, ProBacInfo proBacInfo) {
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("paging", pageView);
        map.put("t", proBacInfo);
        return getSqlSession().selectList(this.getClassName()+".queryCheckListPageH",map);
	}
	@Override
	public List<ProBacInfo> queryCheckListPageS(PageView pageView, ProBacInfo proBacInfo) {
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("paging", pageView);
        map.put("t", proBacInfo);
        return getSqlSession().selectList(this.getClassName()+".queryCheckListPageS",map);
	}
	@Override
	public List<ProBacInfo> queryListPageForDesc(PageView pageView, ProBacInfo proBacInfo) {
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("paging", pageView);
        map.put("t", proBacInfo);
        return getSqlSession().selectList(this.getClassName()+".queryListPageForDesc",map);
	}
	@Override
	public String queryByMax(String createDate) {
		return getSqlSession().selectOne(this.getClassName()+".queryByMax", createDate);
		
	}
	

}
