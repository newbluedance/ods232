package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.entity.ExcField;
import java.util.List;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ninetowns.modules.dao.ExcFieldDao;
import com.ninetowns.modules.service.ExcFieldService;

/**
* @FileName :ExcFieldServiceImpl
* @Author : licf
* @Create Date : 2015-10-09 21:32:25
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/

@Transactional
@Service("ExcFieldService")
public class ExcFieldServiceImpl implements ExcFieldService{

	@Autowired
	private ExcFieldDao excFieldDao;

	@Override
	public List<ExcField> query(ExcField excField){
		return excFieldDao.queryAll(excField);
	}
	@Override
	public PageView queryListPage(PageView pageView, ExcField excField){
		List<ExcField> list = excFieldDao.queryListPage(pageView, excField);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public ExcField add(ExcField excField){
		return excFieldDao.add(excField);
	}
	@Override
	public void delete(String id){
		excFieldDao.delete(id);
	}
	@Override
	public void modify(ExcField excField){
		excFieldDao.modify(excField);
	}
	@Override
	public ExcField getById(String id){
		return excFieldDao.getById(id);
	}
	@Override
	public void deleteByClassId(String classId) {
		excFieldDao.deleteByClassId(classId);
	}
}
