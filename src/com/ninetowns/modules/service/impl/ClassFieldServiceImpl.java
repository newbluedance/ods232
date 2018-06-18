package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.entity.ClassField;
import com.ninetowns.modules.entity.ProClass;

import java.util.ArrayList;
import java.util.List;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.stringtemplate.v4.compiler.CodeGenerator.list_return;

import com.ninetowns.modules.dao.ClassFieldDao;
import com.ninetowns.modules.dao.ProClassDao;
import com.ninetowns.modules.service.ClassFieldService;

/**
* @FileName :ClassFieldServiceImpl
* @Author : licf
* @Create Date : 2015-10-12 09:52:36
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/

@Transactional
@Service("ClassFieldService")
public class ClassFieldServiceImpl implements ClassFieldService{

	@Autowired
	private ClassFieldDao classFieldDao;
	
	@Autowired
	private ProClassDao proClassDao;

	@Override
	public List<ClassField> query(ClassField classField){
		return classFieldDao.queryAll(classField);
	}
	@Override
	public PageView queryListPage(PageView pageView, ClassField classField){
		List<ClassField> list = classFieldDao.queryListPage(pageView, classField);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public ClassField add(ClassField classField){
		return classFieldDao.add(classField);
	}
	@Override
	public void delete(String id){
		classFieldDao.delete(id);
	}
	@Override
	public void modify(ClassField classField){
		classFieldDao.modify(classField);
	}
	@Override
	public ClassField getById(String id){
		return classFieldDao.getById(id);
	}
	@Override
	public List<ClassField> queryRelField(ClassField classField) {
		List<String> classIds=new ArrayList<String>();
		String id=classField.getClassId();
		while (!"-1".equals(id)){
			classIds.add(id);
			if (!"0".equals(id)) {
			}
			id=proClassDao.getById(id).getParentId();
		} 
		classField.setClassIds(classIds);
		classField.setClassId(null);
		List<ClassField> fieldList =classFieldDao.queryAll(classField);
		return fieldList;
	}
}
