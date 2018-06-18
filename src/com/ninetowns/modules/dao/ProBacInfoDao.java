package com.ninetowns.modules.dao;

import java.util.List;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.ProBacInfo;
import com.ninetowns.utils.PageView;

/**
* @FileName :ProBacInfoDao
* @Author : licf
* @Create Date : 2015-10-09 18:48:03
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface ProBacInfoDao extends BaseDao<ProBacInfo>{
	public void updateState(ProBacInfo proBacInfo);
	public void updateStateH(ProBacInfo proBacInfo);
	public void updateStateS(ProBacInfo proBacInfo);
	public List<ProBacInfo> queryCheckListPage(PageView pageView, ProBacInfo proBacInfo);
	public List<ProBacInfo> queryCheckListPageH(PageView pageView, ProBacInfo proBacInfo);
	public List<ProBacInfo> queryCheckListPageS(PageView pageView, ProBacInfo proBacInfo);
	public List<ProBacInfo> queryListPageForDesc(PageView pageView, ProBacInfo proBacInfo);
	public String queryByMax(String createDate);
}
