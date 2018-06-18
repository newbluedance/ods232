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
    <!--图片弹窗start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide-with-gallery.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide.css" />
    <!--图片弹窗end-->
</head>
<body>
	<div id='handlerDiv' class="box1" whiteBg="true">
		<table class="tableStyle" formMode="view">
				<tr>
		        	<td style="font-weight: bold;text-align: left;">基础信息</td>
		      	</tr>
		</table>	
		<table class="tableStyle" formMode="view">
			  <tr>
			    <td width="25%" style="text-align:right;">产品编号：</td>
			     <td width="25%" style="text-align:left;" >${proBacInfo.proId }</td>
			    <td width="25%"  style="text-align:right; ">产品名称：</td>
			     <td width="25%"  style="text-align:left; ">${proBacInfo.proName}</td>
			    
			     </tr>
			     
			     <tr >
			     	 <td style="text-align:right;">产品市场名称：</td>
			     <td  style="text-align:left;">${proBacInfo.promName}</td>
			      <td  style="text-align:right;">产品类别：</td>
			      <td  style="text-align:left;">${proBacInfo.className}</td>
			     </tr>
			    
			 
			     <tr>
			      <td   style="text-align:right;">HS编码：</td>
			     <td  style="text-align:left;">${proBacInfo.hsCode}</td>
			      <td   style="text-align:right;">制造商：</td>
			      <td style="text-align:left;">${proBacInfo.maker}</td>
			 	 </tr>
			 	 <tr>
			     	<td  style="text-align:right;">产地：</td>
			     	<td  style="text-align:left;">${proBacInfo.address}</td>
			       <td   style="text-align:right;">品牌：</td>
			       <td  style="text-align:left;">${proBacInfo.brand}</td>
			     </tr>
			      <tr>
			     	<td  style="text-align:right;">产品录入时间：</td>
			     	<td   style="text-align:left;">${proBacInfo.createDate}</td>
			       <td  style="text-align:right;"></td>
			       <td style="text-align:left;"></td>  
			     </tr>
		</table>   
		    <table class="tableStyle" formMode="view" >  
		        <tr>
		        	<td  style="font-weight: bold;text-align: left;">基础信息扩展属性</td>
		      	</tr>
			</table> 	
			<!-- 扩展属性区 -->
			<table id="add_field_table" class="tableStyle" formMode="view">
			</table>  
		     <table class="tableStyle" formMode="view" >  
		        <tr>
		        	<td  style="font-weight: bold;text-align: left;">规范要素</td>
		      	</tr>
			</table> 	
			
			 <table class="tableStyle" formMode="view" >
			      <c:forEach items="${requestScope.list}" var="s" varStatus="status">
			     <tr>
			     <td  style="text-align:right; height:50px;" >
			     		<%-- <c:if test="${s.basisClass==1}">标准</c:if>
			     		<c:if test="${s.basisClass==2}">规范性文件</c:if>
			     		<c:if test="${s.basisClass==3}">警示通报</c:if>
			     		<c:if test="${s.basisClass==4}">检验检疫监管要点</c:if> --%>
			     		${s.basisClass}
			     		</td>
			     		<td style="text-align:left;">
				     		<div class="history">
				     			依据文件：
				     			<c:set value="1" var="zz"></c:set>
								<c:forEach items="${imgList}" var="imgdetail">
									<c:if test="${s.staId==imgdetail.tabId}">
										<div id="cateringPicture_${zz}" style="float: left; width: 80px; margin-right: 15px">
											<div class="framegrid nocaption">
												<a href="javascript:void(0)" onclick="openwin('${imgdetail.filePath}')" style="color:red" class="highslide" onclick="return hs.expand(this)">${imgdetail.fileName }</a>
												录入时间：${s.createDate };
											</div>
										</div>
									</c:if>
									<c:set var="zz" value="${zz + 1}"></c:set>
									</c:forEach>
				     			</div>
				     		</td>	
			 		    </tr>
			     </c:forEach>
			  </table>
		<table class="tableStyle" formMode="view" >
			<tr>
				<td colspan="4" style="text-align: left; font-weight: bold;">审核信息</td>
			</tr>
			<tr>
				<td width="25%">审核人：</td>
				<td width="25%">${proBacInfo.checkNameS}</td>
				<td width="25%">审核意见：</td>
				<td width="25%">${proBacInfo.checkConentS}</td>
			</tr>
			<tr>
				<td width="25%">审核状态：</td>
				<td width="25%">
						<c:if test="${proBacInfo.stateS == 2}">
							审核通过
						</c:if>
						<c:if test="${proBacInfo.stateS == 3}">
							退回
						</c:if>				
				</td>
				<td width="25%">审核时间：</td>
				<td width="25%">${proBacInfo.checkDateS}</td>
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
<style type="text/css">
a {padding-right:6px;}
.history{
 float:left;
 margin-left:20px;
}
.history img{
 float:left;}

.history p{
 float:left;}

</style>
<script type="text/javascript">
function initComplete(){
	//初始化属性区域
	var classId="${proBacInfo.proId}";
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
function openwin(url) {
	window.open ("<%=request.getContextPath()%>" + url, "newwindow", "height=400, width=400, resizable=yes,toolbar=no, menubar=no, scrollbars=yes");
}
</script>
</html>
