package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.EntInfo;
import com.ninetowns.utils.PageView;

public interface EntInfoService {
	public PageView queryListPage(PageView pageView,EntInfo entInfo);
	public EntInfo getById(String entRegCode);
	public EntInfo add(EntInfo entInfo);

}
