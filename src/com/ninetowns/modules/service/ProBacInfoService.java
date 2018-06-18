package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.ProBacInfo;
import java.util.List;
import com.ninetowns.utils.PageView;

/**
* @FileName :ProBacInfoService
* @Author : licf
* @Create Date : 2015-10-09 18:48:03
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface ProBacInfoService{

	public List<ProBacInfo> query(ProBacInfo proBacInfo);
	public PageView queryListPage(PageView pageView, ProBacInfo proBacInfo);
	public PageView queryListPageForDesc(PageView pageView, ProBacInfo proBacInfo);
	public ProBacInfo add(ProBacInfo proBacInfo);
	public void delete(String id);
	public void modify(ProBacInfo proBacInfo);
	public ProBacInfo getById(String id);
	
	public void updateState(ProBacInfo proBacInfo);
	public void updateStateH(ProBacInfo proBacInfo);
	public void updateStateS(ProBacInfo proBacInfo);
	public PageView queryCheckListPage(PageView pageView, ProBacInfo proBacInfo);
	public PageView queryCheckListPageH(PageView pageView, ProBacInfo proBacInfo);
	public PageView queryCheckListPageS(PageView pageView, ProBacInfo proBacInfo);
	public String  queryByMax(String createDate);
}
