<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新增页面</title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/" scrollerY="ture"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->
    <!-- 日期选择框start -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/form/datePicker/WdatePicker.js"></script>
    <!-- 日期选择框end -->
    <!--数据表格start-->
    <script src="<%=request.getContextPath()%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
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
    <!--弹窗组件start-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/drag.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/dialog.js"></script>
	<!--弹窗组件end-->
</head>
<body>
	<div id='handlerDiv' class="box1" whiteBg="true">
		<form action="<%=request.getContextPath()%>/expects/addExpects" id="addForm" method="post" failAlert="表单填写不正确，请按要求填写！">
			<table class="tableStyle" formMode="view" >
				<tr>
					<td>人员：</td>
					<td><input id="expectName" name="expectName" type="text" /></td>
					<td>电话：</td>
					<td><input id="phone" name="phone" type="text" /></td>
				</tr>
				<tr>
					<td>单位：</td>
					<td><input id="dept" name="dept" type="text" /></td>
					<td></td><td></td>
				</tr>
			</table>
		</form>
		<div class="height_5"></div>
		<div class="padding_top10">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td colspan="4">
						<button type="button" onclick="sub();" value="保存"><span class="icon_add" >保存</span></button>
						<button type="button" onclick="top.Dialog.close();"><span class="icon_clear">返回</span></button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<script type="text/javascript">
		//表单提交
		function initComplete() {
		    //表单提交
		    $('#addForm').submit(function () {
		        //判断表单的客户端验证时候通过
		        var valid = $('#addForm').validationEngine({returnIsValid: true});
		        if (valid) {
		            $(this).ajaxSubmit({
		                //表单提交成功后的回调
		                success: function (responseText, statusText, xhr, $form)
		                {
		                    //刷新数据
		                    top.frmright.refresh(true);
		                    //关闭窗口
		                    top.Dialog.close();
		                }
		            });
		        }
		        //阻止表单默认提交事件
		        return false;
		    });
		}
		function sub() {
		    	$('#addForm').submit();
		}
	</script>
</body>
</html>
