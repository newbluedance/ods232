package com.ninetowns.modules.webservice;
import javax.jws.WebService;
@WebService
public interface updateEntInfoService {
	
	public String EntInfoUpdate(String user, String sign, String data) throws Exception;

}
