package com.ninetowns.modules.controller;
import net.sf.json.JSONObject;
public class DeclClient {

	public static void main(String[] args) throws Exception {
//		String data = "{'DECLNO':'999999999998','CHECKRESULT':'1','CIQDEPTCODE':'0903','CIQUSERID':'suy','ORGCODE':'320100'}";
//        JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
//        svr.setServiceClass(UipCheckService.class);
//        svr.setAddress("http://218.94.80.88:5080/wis/services/UipCheckService");
//        UipCheckService hw = (UipCheckService) svr.create();
//        String res = hw.putWoodPacks("suy", "njciq518", data);
//        System.out.println("====" + res);
		
		String date = "{'result':'0','desc':'写入结果成功.','data':''}";
		JSONObject jsonArr = JSONObject.fromObject( date );
		System.out.println(jsonArr.getString("result"));
		System.out.println(jsonArr.getString("desc"));
		
	}
}
