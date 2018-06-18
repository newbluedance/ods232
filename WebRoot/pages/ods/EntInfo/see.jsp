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
		<td width="150px">企业注册编码：</td>
			<td width="150px">${info.entRegCode}</td>
			<td width="150px">企业中文名称：</td>
			<td width="150px">${info.entCname }</td>
			<td width="150px">企业英文名称：</td>
			<td width="150px">
				${info.entEname}
			</td>
		</tr>
		<tr>
			<td>企业注册日期：</td>
			<td>${fn:substring(info.regDate, 0, 19)}</td>
			<td>地址：</td>
			<td>${info.address}</td>
			<td>邮编：</td>
			<td>${info.postCode}</td>
		</tr>
		<tr>
			<td>联系方式：</td>
			<td>${info.telephone}</td>
			<td>传真：</td>
			<td> ${info.fax}</td>
			<td>邮箱：</td>
			<td>${info.email}</td>
		</tr>
		<tr>
			<td>法人：</td>
			<td>
				${info.legalPerson }
			</td>
			<td>联系人：</td>
			<td>
			${info.contactor}
			</td>
			<td>行政区划代码：</td>
			<td>${info.admiPlaceCode}</td>
		</tr>
		<tr>
			<td>海关注册代码：</td>
			<td>${info.customRegCode}</td>
			<td>技术监督注册代码：</td>
			<td>${info.techRegCode}</td>
			<td>企业类别代码：</td>
			<td>${info.entTypeCode}</td>  
		</tr>
			<tr>
			<td>企业性质代码：</td>
			<td>
			  ${info.entProperty}
			</td>
			<td>企业分类管理代码：</td>
			<td>${info.levelClassCode}</td>
			<td>组织机构代码编号：</td>
			<td>${info.techRegNo}</td>
		</tr>
		<tr>
			<td>进出口经营权限：</td>
			<td>
				 <c:if test="${info.entryExitLicense=='Y'}">有</c:if>
				 <c:if test="${info.entryExitLicense=='N'}">无</c:if>
			</td>
			<td>经营范围：</td>
			<td>${info.businessScope }</td>
			<td>检验方式代码：</td>
			<td>		
				${info.inspModeCode}
			</td>
		</tr>
		<tr>
			<td>托收方式代码：</td>
			<td>
				${info.timeFeeModeCode}
		   </td>
			<td>开户银行：</td>
			<td>${info.bank}</td>
			<td>开户账号：</td>
			<td>${info.bankAccount}</td>
		</tr>
		<tr>
			<td>年审日期：</td>
			<td>
				${fn:substring(info.autidDate, 0, 19)}
			</td>
			<td>年审结果：</td>
			<td>${info.auditConclusion}</td>
			<td>是否拉入黑名单：</td>
			<td>
					 <c:if test="${info.blacklistFlag=='Y'}">是</c:if>
					 <c:if test="${info.blacklistFlag=='N'}">否</c:if>
			</td>
		</tr>
		<tr>
			<td>是否被停用：</td>
			<td>
				 <c:if test="${info.closeFlag=='Y'}">是</c:if>
				 <c:if test="${info.closeFlag=='N'}">否</c:if>
			</td>
			<td>评论：</td>
			<td>${info.remark}</td>
			<td>操作员代码：</td>
			<td>${info.operatorCode }</td>
		</tr>
		<tr>
			<td>操作时间：</td>
			<td>
			   ${fn:substring(info.operateDate, 0, 19)}
			</td>
			<td>原企业注册号：</td>
			<td>${info.oldEntCode}</td>
			<td>机构代码：</td>
			<td>${info.orgCode}</td>
		</tr>
		<tr>
			<td>运输标记：</td>
			<td>
				${info.transFlag}
			</td>
			<td>是否外拨单位标志：</td>
			<td>
				 <c:if test="${info.outerFlag=='Y'}">是</c:if>
				 <c:if test="${info.outerFlag=='N'}">否</c:if>
			</td>
			<td>是否初始化：</td>
			<td>
			    <c:if test="${info.preFlag=='Y'}">是</c:if>
				<c:if test="${info.preFlag=='N'}">否</c:if>
			</td>
		</tr>
		<tr>
			<td>转换国家代码：</td>
			<td>
				${info.investCountryCode}
			</td>
			<td>是否出境电子报检：</td>
			<td>
				<c:if test="${info.edeclFlag=='Y'}">是</c:if>
				<c:if test="${info.edeclFlag=='N'}">否</c:if>
			</td>
			<td>是否入境电子报检：</td>
			<td>
				<c:if test="${info.ideclFlag=='Y'}">是</c:if>
				<c:if test="${info.ideclFlag=='N'}">否</c:if>	
			</td>
		</tr>
		<tr>
			<td>是否出境电子通关：</td>
			<td>
				<c:if test="${info.epassFlag=='Y'}">是</c:if>
				<c:if test="${info.epassFlag=='N'}">否</c:if>	
			</td>
			<td>是否入境电子通关：</td>
			<td>
				<c:if test="${info.ipassFlag=='Y'}">是</c:if>
				<c:if test="${info.ipassFlag=='N'}">否</c:if>	
			</td>
			<td>是否电子报检自动审单：</td>
			<td>
				<c:if test="${info.autoCheckFlag=='Y'}">是</c:if>
				<c:if test="${info.autoCheckFlag=='N'}">否</c:if>	
			</td>
		</tr>
		<tr>
			<td>是否绿色通道资格：</td>
			<td>
				<c:if test="${info.autoPassFlag=='Y'}">是</c:if>
				<c:if test="${info.autoPassFlag=='N'}">否</c:if>	
			</td>
			<td>是否生产企业：</td>
			<td>
				<c:if test="${info.prodFlag=='Y'}">是</c:if>
			    <c:if test="${info.prodFlag=='N'}">否</c:if>	
			</td>
			<td>是否通过ISO9000：</td>
			<td>
				<c:if test="${info.iso9000Flag=='Y'}">是</c:if>
			    <c:if test="${info.iso9000Flag=='N'}">否</c:if>	
			</td>
		</tr>
		<tr>
			<td>是否包装电子报检：</td>
			<td>
				<c:if test="${info.pdeclFlag=='Y'}">是</c:if>
				<c:if test="${info.pdeclFlag=='N'}">否</c:if>	
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