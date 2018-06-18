package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.ClassField;
import java.util.List;
import com.ninetowns.utils.PageView;

/**
* @FileName :ClassFieldService
* @Author : licf
* @Create Date : 2015-10-12 09:52:36
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/
public interface ClassFieldService{

	public List<ClassField> query(ClassField classField);
	public PageView queryListPage(PageView pageView, ClassField classField);
	public ClassField add(ClassField classField);
	public void delete(String id);
	public void modify(ClassField classField);
	public ClassField getById(String id);
	public List<ClassField> queryRelField(ClassField classField);
}
