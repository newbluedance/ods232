package com.ninetowns.modules.controller;
import javax.jws.WebService;
/**
 * @FileName :
 * @Author : 宋崇浩
 * @Create Date   :
 * @Email : SongChongHao@ninetowns.com
 * @Last Modified :
 * @Description :
 */
@WebService(targetNamespace="http://webservice.uip.modules.ninetowns.com/")
public interface UipCheckService {
	
	/**
	 * 移动端通过此方法获取统一查验平台的查验任务列表
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 查询到的数据
	 * @throws Exception 抛出异常
	 */
	public String getCheckTaskList(String user, String sign, String data) throws Exception;
	
	/**
	 * 移动端通过此方法获取统一查验平台的查验模板列表，返回的为最新正式使用的查验模板
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 查询到的数据
	 * @throws Exception 抛出异常
	 */
	public String getCheckTempletList(String user, String sign, String data) throws Exception;
	
	/**
	 * 移动端通过此方法获取查验记录表单详细信息
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 查询到的数据
	 * @throws Exception 抛出异常
	 */
	public String getCheckTemplet(String user, String sign, String data) throws Exception;
	
	/**
	 * 移动端通过此方法写入对应的查验任务结果到统一查验平台
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 查询到的数据
	 * @throws Exception 抛出异常
	 */
	public String putCheckResult(String user, String sign, String data) throws Exception;
	/**
	 * 移动端通过此方法写入对应的离线查验任务结果到统一查验平台
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 结果回执信息
	 * @throws Exception 抛出异常
	 */
	public String putOffLineCheckResult(String user, String sign, String data) throws Exception;
	/**
	 * 获取报检单随附单据
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 结果回执信息
	 * @throws Exception 抛出异常
	 */
	public String getAttachList(String user, String sign, String data) throws Exception;
	/**
	 * 获得具体的无纸化单据信息
	 * @param conditions 条件字符串 UUID
	 * @return 查询到的数据
	 * @throws Exception 抛出异常
	 */
	public byte[] getAttachment (String conditions) throws Exception;
	/**
	 * 外部系统（如大闸蟹，场站系统的移动查验端）通过此方法写入对应的离线查验任务结果到统一查验平台，该结果只支持附件形式（PDF，word，excel，jpg）
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 结果回执信息
	 * @throws Exception 抛出异常
	 */
	public String putOutCheckResult(String user, String sign, String data) throws Exception;
	/**
	 * 移动端通过此方法回查已查验任务信息
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 查询到的数据
	 * @throws Exception 抛出异常
	 */
	public String getCheckTaskResponseList(String user, String sign, String data) throws Exception;
	/**
	 * 移动端通过此方法回查已查验任务详细信息
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 查询到的数据
	 * @throws Exception 抛出异常
	 */
	public String getCheckTaskResponse(String user, String sign, String data) throws Exception;
	
	/**
	 * 移动端通过此方法回查特定已查验任务信息
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 查询到的数据
	 * @throws Exception 抛出异常
	 */
	public String getTaskResponseList(String user, String sign, String data) throws Exception;
	/**
	 * 华东把木质包装相关信息写入到智慧检务系统进行结果登记操作
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 结果回执信息
	 * @throws Exception 抛出异常
	 */
	public String putWoodPacks(String user, String sign, String data) throws Exception;
	/**
	 * 用户信息更新接口[平台端主动调用该接口方法]
	 * @param userInfo 需要变更的用户信息对象
	 * @return 操作是否成功
	 * @throws Exception 抛出异常
	 */
	public String userUpdate(String userInfo) throws Exception;
	/**
	 * 组织机构信息更新接口[平台端主动调用该接口方法]
	 * @param orgInfo 需要变更的组织机构信息对象
	 * @return 操作是否成功
	 * @throws Exception 抛出异常
	 */
	public String orgUpdate(String orgInfo) throws Exception;
	/**
	 * 根据企业注册号获取一次性备案信息
	 * @param user 江苏局统一平台用户的ID
	 * @param sign 将约定密码+当前日期yyyyMMddHH24(防止误差，前一小时和后一小时也需要验证通过)进行md5加密
	 * @param data 请求的报文内容json  UTF-8
	 * @return 结果回执信息
	 * @throws Exception 抛出异常
	 */
	public String getAttachsList(String user, String sign, String data) throws Exception;
}
