<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUinfoIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/" scrollerY="false"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->
    <!-- 日期选择框start -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/form/datePicker/WdatePicker.js"></script>
    <!-- 日期选择框end -->
    <!--数据表格start-->
    <script src="<%=request.getContextPath()%>/libs/js/tainfoe/quiGrid.js" type="text/javascript"></script>
    <!--数据表格end-->
     <!--基本选项卡start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/nav/basicTabModern.js"></script>
    <!--基本选项卡end-->
	<!-- 表单验证start -->
    <script src="<%=request.getContextPath()%>/libs/js/form/validationRule.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/libs/js/form/validation.js" type="text/javascript"></script>
    <!-- 表单验证end -->
    <!--表单异步提交start-->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!--表单异步提交end-->
    <!--图片弹窗start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide-with-gallery.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide.css" />
    <!--图片弹窗end-->
    <!-- 表单start -->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!-- 表单end -->
</head>
<body>
<div id="scrollContent" class="box1" whiteBg="true">
	<table class="tableStyle" formMode="view">
		<tr>
		<td width="150px">报检人员代码：</td>
			<td width="150px">${dp.declPersonCode}</td>
			<td width="150px">企业注册登记代码：</td>
			<td width="150px">${dp.entRegCode }</td>
			<td width="150px">报检人员姓名：</td>
			<td width="150px">
				${dp.declPersonName}
			</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>
			<c:if test="${dp.sex=='F'}">女</c:if>
			<c:if test="${dp.sex=='M'}">男</c:if>
			</td>
			<td>身份证号：</td>
			<td>${dp.id_Card_NO}</td>
			<td>电话：</td>
			<td>${dp.telPhone}</td>
		</tr>
		<tr>
			<td>申请日期：</td>
			<td>${fn:substring(dp.applyDate, 0, 19)}</td>
			<td>培训日期：</td>
			<td>${fn:substring(dp.trainDate, 0, 19)}</td>
			<td>获证日期：</td>
			<td>${fn:substring(dp.permitDate, 0, 19)}</td>
		</tr>
		<tr>
			<td>有效期：</td>
			<td>
				${dp.validPeriod}
			</td>
			<td>考核结论：</td>
			<td>
			${dp.checkConclusion}
			</td>
			<td>年审日期：</td>
			<td>${fn:substring(dp.autidDate, 0, 19)}</td>
		</tr>
		<tr>
			<td>年审结论：</td>
			<td>${dp.auditConclusion}</td>
			<td>是否黑名单：</td>
			<td>
				<c:if test="${dp.blacklistFlag=='Y'}">是</c:if>
				<c:if test="${dp.blacklistFlag=='N'}">否</c:if>
			</td>
			<td>是否封号：</td>
			<td>
				<c:if test="${dp.closeFlag=='Y'}">是</c:if>
				<c:if test="${dp.closeFlag=='N'}">否</c:if>
			</td>  
		</tr>
			<tr>
			<td>操作员代码：</td>
			<td>
			  ${dp.operatorCode}
			</td>
			<td>操作时间：</td>
			<td>${fn:substring(dp.operateDate, 0, 19)}</td>
			<td>备注：</td>
			<td>${dp.remark}</td>
		</tr>
		<tr>
			<td>报检员原代码：</td>
			<td>
				${dp.oldPersonCode}
			</td>
			<td>机构代码：</td>
			<td>${dp.orgCode}</td>
			<td>传输标志：</td>
			<td>		
				${dp.transFlag}
			</td>
		</tr>
		<tr>
			<td>备案标志：</td>
			<td>
				${dp.preFlag}
		   </td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<div class="padding_top10">
		<table class="tableStyle" formMode="transparent">
			<tr>
				<td colspan="4">
					<button type="button" onclick="top.Dialog.close();"><span class="icon_clear">返回</span></button>
				</td>
			</tr>
		</table>
	</div>
	<div style="position: absolute;top: 390px;left: 10px" id="imgDiv" align="left"></div>
</div>
<script type="text/javascript">
var fixedObj = 10;
function customHeightSet(contentHeight) {
    $("#scrollContent").height(contentHeight - fixedObj);
}
var picNum = 0;
 function initComplete(){
 
 }
</script>
</body>
</html>