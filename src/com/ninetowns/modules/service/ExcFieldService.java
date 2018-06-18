package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.ExcField;
import java.util.List;
import com.ninetowns.utils.PageView;

/**
* @FileName :ExcFieldService
* @Author : licf
* @Create Date : 2015-10-09 21:32:25
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface ExcFieldService{

	public List<ExcField> query(ExcField excField);
	public PageView queryListPage(PageView pageView, ExcField excField);
	public ExcField add(ExcField excField);
	public void delete(String id);
	public void modify(ExcField excField);
	public ExcField getById(String id);
	public void deleteByClassId(String classId);
}
