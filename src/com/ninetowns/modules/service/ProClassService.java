package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.Menu;
import com.ninetowns.modules.entity.ProClass;
import java.util.List;
import java.util.Map;

import com.ninetowns.utils.PageView;

/**
* @FileName :ProClassService
* @Author : licf
* @Create Date : 2015-10-09 22:17:15
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface ProClassService{

	public List<ProClass> query(ProClass proClass);
	public PageView queryListPage(PageView pageView, ProClass proClass);
	public ProClass add(ProClass proClass);
	public void delete(String id);
	public void modify(ProClass proClass);
	public ProClass getById(String id);
	public List<Map<String, Object>> queryAllByClassId(ProClass proClass, String classId);
}
