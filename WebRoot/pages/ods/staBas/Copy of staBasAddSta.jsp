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
		<!-- 树组件start -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.css"></link>
	<!-- 树组件end -->
	<!-- 树形下拉框start -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/form/selectTree.js"></script>
	<!-- 树形下拉框end -->
	
</head>
<body>
	<div id='handlerDiv' class="box1" whiteBg="true">
		<form action="<%=request.getContextPath()%>/staBas/addStaBass" id="addStaForm" method="post" failAlert="表单填写不正确，请按要求填写！">
		<input type="hidden" id="excFields" name="excFields" value="" />
		<input id="staId" name="staId" type="hidden" value=""/>
		<input type="hidden" name="proId"  id="proId" value="${proBacInfo.proId}"/>
			<table class="tableStyle" formMode="view" >
				<tr>
						<td>依据类别:</td>
						<td>
							<select prompt="请选择" url="<%=request.getContextPath()%>/proClass/querySelectList?tabId=4&&classId=${proBacInfo.classId}" name="basisClass" id="basisClass" class="validate[required]"></select>
							<!-- <select  name="basisClass"  > 
									<option value="1">标准</option>
									<option value="2">规范性文件</option>
									<option value="3">警示通报</option>
									<option value="4">检验检疫监管要点</option>
							</select> -->
							<span class="star">*</span>
						
						</td>
						<td>依据文件:</td>
						<td>
                       <input  type="file"  name="uploadfile"  id="uploadfile" keepDefaultStyle="true" title="请选择上传文件"  /><span id="fileName"></span>
                    </td>
				</tr>
				<tr>
						<td>录入时间:</td>
						<td><input id="createDate" name="createDate" value="${createDate}" type="text" class="validate[required]"
						class="dateIcon" onfocus="WdatePicker({skin:themeColor,maxDate:'%y-%M-%d'})"/> <span class="star">*</span></td>
						<td>是否有效:</td>
						<td>
								<select  name="isValid" > 
										<option value="1">有效</option>
										<option value="2">失效</option>
								</select><span class="star" >*</span>
						</td>
				</tr>
				<tr>
						<td>有效日期</td>
						<td><input id="validData" name="validData" value="${validData}" type="text" 
						class="dateIcon" onfocus="WdatePicker({skin:themeColor})"title="请选择有效日期"  /></td>
						
						<td>失效日期</td>
						<td><input id="expiryData" name="expiryData" value="${expiryData}" type="text" 
						class="dateIcon" onfocus="WdatePicker({skin:themeColor})" title="请选择失效日期"  /> </td>
				</tr>
				</table>
				<!-- <table  class="tableStyle" formMode="view">
		      	<tr>
		        	<td style="font-weight: bold;text-align: left;" >扩展属性</td>
		      	</tr>
				
				</table>
					扩展属性区
				<table id="add_field_table" class="tableStyle" formMode="view">
				</table> -->
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
		function initComplete() {
			<%-- //初始化属性区域
			$("#add_field_table").html("");
		     $.post("<%=request.getContextPath()%>/proClass/queryRelField",		//数据提交的地址
		            {"classId" : '${proBacInfo.classId}',
		    	 		"tabId" : "2"
		              },				//提交的数据
		            function(fieldList){									//回调函数
		            	  var exc_field_node="<tr>";
		            	  for(var n in fieldList){  
		                	 var field=fieldList[n];
						  exc_field_node=exc_field_node+
								"<td width='25%'>"+field.fieldKey+"：</td>"+
								"<td width='25%'><input id='excField1' name='"+field.fieldKey+"' type='text' /></td>";
								flag=(parseInt(n)+1) % 2;
								if(flag==0){
									exc_field_node=exc_field_node+"</tr><tr>";
								}
		                   }  
		            	  exc_field_node=exc_field_node+"</tr>";
						$("#add_field_table").append(exc_field_node);	
						$("#add_field_table").render();
		            });	 --%>
		 //表单提交
	    $('#addStaForm').submit(function () {
	   			
	    	
	        //判断表单的客户端验证时候通过
	        var valid = $('#addStaForm').validationEngine({returnIsValid: true});
	        if (valid) {
	            $(this).ajaxSubmit({
	                //表单提交成功后的回调
	                success: function (responseText, statusText, xhr, $form)
	                {
	                    //刷新数据
	                    top.frmright.refresh(false);
	                    //关闭窗口
	                    top.Dialog.close();
	                }
	            });
	        } 	
	        //阻止表单默认提交事件
	        return false;
	    });
	}

	function sub(){
		//提交属性区域
		var s=$("#add_field_table :input").serializeArray();
		$("#excFields").val(JSON.stringify(s));
		$("#addStaForm").submit();
			//时间判断
		/* 	if($("#expiryData").val()<=$("#validData").val()){
					top.Dialog.alert("失效时间不得小于有效时间|提示");
			}else{
				$("#addStaForm").submit();
			} */
			
	};

	</script>
</body>
</html>
