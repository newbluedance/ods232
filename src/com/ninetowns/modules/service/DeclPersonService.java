package com.ninetowns.modules.service;
import com.ninetowns.modules.entity.DeclPerson;
import com.ninetowns.utils.PageView;

public interface DeclPersonService {
	public PageView queryListPage(PageView pageView,DeclPerson declPerson);
	public DeclPerson getById(String declPersonCode);

}
