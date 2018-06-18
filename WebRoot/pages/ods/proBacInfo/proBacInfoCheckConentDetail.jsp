<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/" scrollerY="ture"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->
</head>
<body>
	<div id='handlerDiv' class="box1" whiteBg="true" >
<table class="tableStyle" formMode="view" >
			<input id="proId" name="proId" type="hidden" value="${proBacInfo.proId}" /> 
			<input id="state" name="state"	type="hidden" value="${proBacInfo.state}" />
	<tr>
		<td colspan="4" style="text-align: left; font-weight: bold;">基本信息</td>
	</tr>
	<tr>
		<td width="25%">产品编号：</td>
		<td width="25%">${proBacInfo.proId}</td>		
		<td width="25%">产品名称：</td>
		<td width="25%">${proBacInfo.proName}</td>
	</tr>
	<tr>
		<td>hs编码：</td>
		<td>${proBacInfo.hsCode}</td>		
		<td>产品类别：</td>
		<td>${proBacInfo.className}</td>
	</tr>
	<tr>
		<td>制作商：</td>
		<td>${proBacInfo.maker}</td>
		<td>产地：</td>
		<td>${proBacInfo.address}</td>
	</tr>
	<tr>
		<td>品牌：</td>
		<td>${proBacInfo.brand}</td>
		<td>产品市场名称：</td>
		<td>${proBacInfo.promName}</td>
	</tr>
	<tr>
		<td>产品录入时间：</td>
		<td>${proBacInfo.createDate}</td>
		<td></td>
		<td></td>
	</tr>
</table>
<table class="tableStyle" formMode="view">
			<tr>
				<td style="font-weight: bold;text-align: left;">基础信息扩展属性</td>
			</tr>

		</table>
		<!-- 扩展属性区 -->
		<table id="add_field_table" class="tableStyle" formMode="view">
		</table>
<table class="tableStyle" formMode="view" >
	<tr>
		<td colspan="4" style="text-align: left; font-weight: bold;">审核信息</td>
	</tr>
	<tr>
		<td width="25%">审核人：</td>
		<td width="25%">${proBacInfo.checkName}</td>
		<td width="25%">审核意见：</td>
		<td width="25%">${proBacInfo.checkConent}</td>
	</tr>
	<tr>
		<td width="25%">审核状态：</td>
		<td width="25%">
				<c:if test="${proBacInfo.state == 2}">
					审核通过
				</c:if>
				<c:if test="${proBacInfo.state == 3}">
					退回
				</c:if>				
		</td>
		<td width="25%">审核时间：</td>
		<td width="25%">${proBacInfo.checkDate}</td>
	</tr>
</table>
		
		<div class="height_5"></div>
		<div class="padding_top10">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td colspan="4">
						<button type="button" onclick="goback();"><span class="icon_clear">返回</span></button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
	
		//初始化属性区域
		function initComplete(){
			var classId=$("#proId").val();
			$("#add_field_table").html("");
		     $.post("<%=request.getContextPath()%>/proClass/queryClassFieldFromExc",		//数据提交的地址
		            {"classId" : classId
		              },				//提交的数据
		            function(fieldList){									//回调函数
		            	 var exc_field_node="<tr>";
		            	 for(var n in fieldList){  
		            		var field=fieldList[n];
			                var fieldValue=(field.fieldValue==null)?"":field.fieldValue;
						  	exc_field_node=exc_field_node+
								"<td width='25%'>"+field.fieldKey+"：</td>"+
								"<td width='25%'>"+fieldValue+"</td>";
								flag=(parseInt(n)+1) % 2;
								if(flag==0){
									exc_field_node=exc_field_node+"</tr><tr>";
								}
		                   	}  
		            		exc_field_node=exc_field_node+"</tr>";
							$("#add_field_table").append(exc_field_node);
							$("#add_field_table").render();
		            });	
		}
	function goback(){
			history.back();
		}
	
	</script>
</html>
