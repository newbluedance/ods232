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
    <style>
	.boxgrid{ 
	    width: 200px; 
	    height: 122px; 
	    margin:5px; 
	    position: relative; 
	}

	</style>
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
			    <input id="proId" name="proId" type="hidden" value="${proBacInfo.proId}" /> 
				<input id="state" name="state"	type="hidden" value="${proBacInfo.state}" />
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
			      <td   style="text-align:right;">hs编码：</td>
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
		        	<td  style="font-weight: bold;text-align: left;">监管要素</td>
		      	</tr>
			</table> 	
			<table class="tableStyle" >
				<tr>
					<c:set var="n" value="0"></c:set> 
			     	<c:forEach items="${list}" var="s" varStatus="status">
					    <c:set var="n" value="${n+1}"></c:set> 
					    <c:if test="${status.count==1 or s.posClass!=list[status.count-2].posClass}">
					    <td  style="text-align:right; font-weight:bold; height:50px;width:200px;">
						     ${s.posClass}
						</td>
					     </c:if>
					     <td style="text-align:left;" >
						     		<div>
						     			<c:set value="1" var="zz"></c:set>
										<c:forEach items="${imgList}" var="imgdetail">
											<c:if test="${s.hisId==imgdetail.tabId}">
												<div id="cateringPicture_${zz}" style="float: left; width: 80px; margin-right: 15px">
													<div class="framegrid nocaption">
														<a href="<%=request.getContextPath()%>${imgdetail.filePath}" class="highslide" onclick="return hs.expand(this)">
															<div class="boxgrid captionfull">
																<img width="80px" height="122px" id="img5" name="img5" src="<%=request.getContextPath()%>${imgdetail.filePath}"/>
															</div>
														</a>
													</div>
												</div>
											</c:if>
											<c:set var="zz" value="${zz + 1}"></c:set>
										</c:forEach>
						     		</div>
						     		<div>
						     			<p>
						     			&nbsp;&nbsp;&nbsp;&nbsp;
						     			<c:if test="${s.casneg==1}">正</c:if><c:if test="${s.casneg==2}">反</c:if>案例<br/>
						     			&nbsp;&nbsp;&nbsp;&nbsp; 照片说明：${s.explains }.
						     			</p>
						     		</div>
					     </td>
					     <c:if test="${status.count!=1 and s.posClass!=list[status.count].posClass or n==3}">
					     	</tr>
							<tr>
							<c:if test="${n==3}"><td></td></c:if>
							<c:set var="n" value="0"></c:set> 
					     </c:if>
					</c:forEach>
				</tr>
			</table>
		<form action="<%=request.getContextPath()%>/hisInfo/updateCheck" id="updateForm" method="post" failAlert="表单填写不正确，请按要求填写！">
		<input type="hidden" id="proId" name="proId" value="${proBacInfo.proId }" />
		<input type="hidden" id="flag" name="flag" value="2" />
		<table class="tableStyle" formMode="view" >
			<tr>
				<td colspan="4" style="text-align: left; font-weight: bold;">审核信息</td>
			</tr>
			<tr>
				<td width="25%">审核人：</td>
				<td width="25%"><input id="checkNameH" name="checkNameH" type="text" value="${user.displayName}" /><span class="star">*</span></td>
				<td width="25%">审核意见：</td>
				<td width="25%"><input id="checkConentH" name="checkConentH" type="text"/></td>
			</tr>
		</table>
		</form>
		<div class="height_5"></div>
		<div class="padding_top10">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td colspan="4">
						<button type="button" onclick="toCheck('${proBacInfo.proId}');"><span class="icon_add">审核通过</span></button> 
						<button type="button" onclick="totuihui('${proBacInfo.proId}');"><span class="icon_add">退回</span></button>
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
	//初始化属性区域
		function initComplete(){
			//图片弹窗
			hs.graphicsDir = '<%=request.getContextPath()%>/libs/thirdparty/highslide/graphics/';
			hs.align = 'center';
			hs.transitions = [ 'expand', 'crossfade' ];
			hs.outlineType = 'rounded-white';
			hs.fadeInOut = true;
			hs.addSlideshow({
				interval : 5000,
				repeat : false,
				useControls : false,
				fixedControls : 'fit',
				overlayOptions : {
					opacity : .75,
					position : 'bottom center',
					hideOnMouseOut : true
				}
			});
		
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
	function toCheck(proId){
			 var valid =document.getElementsByName("checkNameH")[0].value;
	    	 var valid2 =document.getElementsByName("checkConentH")[0].value;
	    	if(valid =="" ){
	        	alert("审核人不能为空!");
	        	return false;
	        }else{	        	
	        	if(confirm("确定要审核通过该记录吗？")){ 
	        		 //window.location.href="<%=request.getContextPath()%>/hisInfo/updateCheck?proId="+proId; 
	        		 $("#flag").val("2");
	        		 $("#updateForm").submit();
	        	}
	        }			
		}
		function totuihui(proId){
			 var valid =document.getElementsByName("checkNameH")[0].value;
	    	 var valid2 =document.getElementsByName("checkConentH")[0].value;
	    	if(valid =="" ){
	        	alert("审核人不能为空!");
	        	return false;
	        }else{	        	
	            if(confirm("确定要退回该记录吗？")){  	           
	        		 //window.location.href="<%=request.getContextPath()%>/hisInfo/updateCheck2?proId="+proId +"&&checkNameH="+valid+"&&checkConentH="+valid2 ;
	        		  $("#flag").val("3");
	        		 $("#updateForm").submit();        	
	        	}   
	        }			
		}
		function goback(){
			history.back();
		}

</script>
</html>
