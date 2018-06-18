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
	    margin:10px; 
	    position: relative; 
	}
	.contentBox {
		background-color: white;
	}
	.listHead {
		background-color: #3399FF;
		font-weight:bold;
	}
	</style>
    
</head>
<body style="background-color: white;">
	<div class="contentBox">
		<div onclick="change(1)" class="listHead">基本信息</div>
		<div id='handlerDiv1'>
			<table class="tableStyle" formMode="view"  >
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
					<td style="font-weight: bold;text-align: left;">类别属性</td>
				</tr>
	
			</table>
			<!-- 扩展属性区 -->
			<table id="add_field_table" class="tableStyle" formMode="view">
			</table>
			
		</div>
		<div onclick="change(2)" class="listHead">监管要素</div>
		<div id='handlerDiv2'>
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
		</div>
		
		<div onclick="change(3)" class="listHead">技术规范依据</div>
		<div id='handlerDiv3'>
			<table class="tableStyle" formMode="view" >
			      <c:forEach items="${requestScope.staBasList}" var="s" varStatus="status">
			     <tr>
			     <td  style="text-align:right; height:50px;" >
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
		</div>
	</div>
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
</body>
<script type="text/javascript">
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
	function change(f){
		$("#handlerDiv"+f).toggle();
	}
	function openwin(url) {
		window.open ("<%=request.getContextPath()%>" + url, "newwindow", "height=400, width=400, resizable=yes,toolbar=no, menubar=no, scrollbars=yes");
	}
	</script>
</html>
