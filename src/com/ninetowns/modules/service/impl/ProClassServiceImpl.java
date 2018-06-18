package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.entity.Menu;
import com.ninetowns.modules.entity.ProClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ninetowns.modules.dao.ProClassDao;
import com.ninetowns.modules.service.ProClassService;

/**
* @FileName :ProClassServiceImpl
* @Author : licf
* @Create Date : 2015-10-09 22:17:15
* @Email : lcfsxg@qq.com
* @Last Modified :
* @Description :
*/

@Transactional
@Service("ProClassService")
public class ProClassServiceImpl implements ProClassService{

	@Autowired
	private ProClassDao proClassDao;

	@Override
	public List<ProClass> query(ProClass proClass){
		return null;
	}
	@Override
	public PageView queryListPage(PageView pageView, ProClass proClass){
		List<ProClass> list = proClassDao.queryListPage(pageView, proClass);
		pageView.setRows(list);
		return pageView;
	}
	@Override
	public ProClass add(ProClass proClass){
		return proClassDao.add(proClass);
	}
	@Override
	public void delete(String id){
		proClassDao.delete(id);
	}
	@Override
	public void modify(ProClass proClass){
		proClassDao.modify(proClass);
	}
	@Override
	public ProClass getById(String id){
		return proClassDao.getById(id);
	}
	@Override
	public List<Map<String, Object>> queryAllByClassId(ProClass proClass, String classId) {
		List<String> classIds = new ArrayList<String>();
		List<ProClass> menuList = proClassDao.queryAll(proClass);
        List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
        for (ProClass pClass : menuList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", pClass.getClassId());
            map.put("name", pClass.getClassName());
            map.put("parentId", pClass.getParentId());
            map.put("desc", pClass.getClassDesc());
            map.put("order", pClass.getPriority());
            map.put("icon", pClass.getClassIcon());
            map.put("existed", true);
            if ("1".equals(pClass.getClassDesc())) {
                map.put("isParent", "true");
                map.put("iconSkin", "diy01");
            } else {
                map.put("isParent", false);
            }
            if (classIds.contains(pClass.getClassId())){
                map.put("checked",true);
            }
            mapList.add(map);
        }
        return mapList;
	}
}
