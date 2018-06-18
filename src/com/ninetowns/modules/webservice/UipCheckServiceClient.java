package com.ninetowns.modules.webservice;
import java.beans.Encoder;
import java.net.URLDecoder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ninetowns.utils.MD5;

/**
 * @FileName :
 * @Author : 宋崇浩
 * @Create Date   :
 * @Email : SongChongHao@ninetowns.com
 * @Last Modified :
 * @Description :
 */
public class UipCheckServiceClient {

	public static void main(String[] args) {
        try {
        	AnalysisMsg analysisMsg = new AnalysisMsg();
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-services.xml");
			updateEntInfoService client = (updateEntInfoService) context.getBean("updateEntInfoServiceClient");
			String sign = new MD5().getMD5ofStr("602!!*wang" + AnalysisMsg.format());
			System.out.println(sign);
			String data = "{'ENT_REG_CODE': 'reg2015123','TECH_REG_CODE': '3201','REG_DATE': '','ENT_CNAME': '宋崇浩','ENT_ENAME': 'sch','ENT_SHORT_NAME': '','ADDRESS': '测试人','POST_CODE': '','TELEPHONE': '','FAX': '3','EMAIL': '','LEGAL_PERSON': '马振勇','CONTACTOR': '','ADMI_PLACE_CODE': '','CUSTOM_REG_CODE': '','ENT_TYPE_CODE': '','ENT_PROPERTY': '','LEVEL_CLASS_CODE': '','ENTRY_EXIT_LICENSE': '','BUSINESS_SCOPE': '','TIME_FEE_MODE_CODE': '','INSP_MODE_CODE': '','BANK': '','BANK_ACCOUNT': '','AUTID_DATE': '2015-11-04 00:00:00','AUDIT_CONCLUSION': '','BLACKLIST_FLAG': '','CLOSE_FLAG': '','REMARK': '','OPERATOR_CODE': '','OPERATE_DATE': '2015-11-04 00:00:00','OLD_ENT_CODE': '','ORG_CODE': '','TRANS_FLAG': '','OUTER_FLAG': '','PRE_FLAG': '','INVEST_COUNTRY_CODE': '','E_DECL_FLAG': '','I_DECL_FLAG': '','E_PASS_FLAG': '','I_PASS_FLAG': '','AUTO_CHECK_FLAG': '','AUTO_PASS_FLAG': '','PROD_FLAG': '','ISO9000_FLAG': '','P_DECL_FLAG':'','TECH_REG_NO':''}";
			String message = client.EntInfoUpdate("admin", "", data);
			System.out.println("======" + message);
		} catch (Exception e) {
			System.out.println("出错啦" + e.getMessage());
		}
    }
}
