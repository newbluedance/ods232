<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增页面</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
<link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/" scrollerY="ture" />
<link rel="stylesheet" type="text/css" id="customSkin" />
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
		<form action="<%=request.getContextPath()%>/proBacInfo/addProBacInfo" id="addForm" method="post"
			failAlert="表单填写不正确，请按要求填写！">
			<input type="hidden" id="excFields" name="excFields" value="" />
			<table class="tableStyle" formMode="view">
				<tr>
		        	<td style="font-weight: bold;text-align: left;" colspan="4">基础信息</td>
		      	</tr>
				<tr>
					<td width='25%'>hs编码：</td>
					<td width='25%'><input id="hsCode" name="hsCode" type="text" /></td>
					<td width='25%'>产品名称：</td>
					<td width='25%'><input id="proName" name="proName" type="text" /> </td>
				</tr>
				<tr>
					<td>产品市场名称：</td>
					<td><input id="promName" name="promName" type="text" /></td>
					<td>产品类别：</td>
					<td><input id="classId" name="classId" type="hidden" />
						<div class="selectTree" url="<%=request.getContextPath()%>/proClass/proClassList" id="selectTree1"></div> <span
						class="star">*</span></td>

				</tr>
				<tr>
					<td>制作商：</td>
					<td><input id="maker" name="maker" type="text" /></td>
					<td>产地：</td>
					<td><input id="address" name="address" type="text" /></td>
				</tr>
				<tr>
					<td>品牌：</td>
					<td><input id="brand" name="brand" type="text" /></td>
					<td>产品录入时间：</td>
					<td><input id="createDate" name="createDate" value="${createDate}" type="text" class="validate[required]"
						class="dateIcon" onfocus="WdatePicker({skin:themeColor,maxDate:'%y-%M-%d'})" /> <span class="star">*</span></td>
				</tr>
			</table>
			<table  class="tableStyle" formMode="view">
		      	<tr>
		        	<td style="font-weight: bold;text-align: left;" >基础信息扩展属性</td>
		      	</tr>
				
			</table>
				<!-- 扩展属性区 -->
			<table id="add_field_table" class="tableStyle" formMode="view">
				
			</table>
		</form>
		<div class="height_5"></div>
		<div class="padding_top10">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td colspan="4">
						<button type="button" onclick="sub();" value="保存">
							<span class="icon_add">保存</span>
						</button>
						<button type="button" onclick="goback();">
							<span class="icon_clear">返回</span>
						</button>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<script type="text/javascript">
		function initComplete() {
			//绑定change事件
			$("#selectTree1").bind(
					"change",
					function() {

						if (!$(this).attr("relValue")) {
						//	top.Dialog.alert("请选择节点");
						} else {
							$("#classId").val($(this).attr("relValue"));
							//初始化属性区域
							$("#add_field_table").html("");
						     $.post("<%=request.getContextPath()%>/proClass/queryRelField",		//数据提交的地址
						            {"classId" : $(this).attr("relValue"),
						    	 		"tabId" : "0"
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
												if(fieldList.length==1){
													exc_field_node=exc_field_node+"<td></td><td></td>";
												}
						            	  exc_field_node=exc_field_node+"</tr>";
										$("#add_field_table").append(exc_field_node);	
										$("#add_field_table").render();
						            });	

						}

					});

		}

		function sub() {
			var classid = $("#classId").val();
			//alert(classid);
			if(classid == '0' || classid == ""){
				alert("产品类别不能为空!");
				return false;
			}else{
				var s=$("#add_field_table :input").serializeArray();
				$("#excFields").val(JSON.stringify(s));
				$('#addForm').submit();
			}
		}

		function goback() {
			history.back();
		}
	</script>
</body>
</html>
