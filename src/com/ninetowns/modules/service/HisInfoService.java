package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.HisInfo;
import com.ninetowns.modules.entity.ProBacInfo;

import java.util.List;
import com.ninetowns.utils.PageView;

/**
* @FileName :HisInfoService
* @Author : licf
* @Create Date : 2015-10-09 19:44:48
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface HisInfoService{

	public List<HisInfo> query(HisInfo hisInfo);
	public PageView queryListPage(PageView pageView,HisInfo hisInfo);
	public HisInfo add(HisInfo hisInfo);
	public void delete(String id);
	public void modify(HisInfo hisInfo);
	public HisInfo getById(String id);
	
	public List<HisInfo> queryAllByproId(String proId);
}
