<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改页面</title>

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
<!--表单异步提交start-->
<script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
<!--表单异步提交end-->
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
<!-- 图片显示start -->
<link href="<%=request.getContextPath()%>/libs/thirdparty/image_view_jd/css/css.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/libs/thirdparty/image_view_jd/js/base.js" type=text/javascript></script>
<script src="<%=request.getContextPath()%>/libs/thirdparty/image_view_jd/js/lib.js" type=text/javascript></script>
<script src="<%=request.getContextPath()%>/libs/thirdparty/image_view_jd/js/163css.js" type=text/javascript></script>
<!-- 图片显示end -->

<!--图片弹窗start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide-with-gallery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide.css" />
<!--图片弹窗end-->

<!-- 图片压缩 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/thumb/binaryajax.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/thumb/exif.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/thumb/jquery.make-thumb.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/thumb/megapix-image.js"></script>
<!-- /图片压缩 -->
<style>
.upload {
	width: 83px;
	height: 34px;
	position: absolute;
	top: 0;
	right: 0;
	z-index: 9;
	opacity: 0
}

.fake-file {
	width: 82px;
	height: 29px;
	line-height: 26px;
	font-size: 18px;
	text-align: center;
	-webkit-box-shadow: inset 0 1px 1px 0 #fff, 0px 1px 1px 0 #FCFCFC;
	border: solid 1px #5F9EA0;
	background: #1E90FF;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #1E90FF),
		color-stop(100%, #EBEBEB) );
	background: -webkit-linear-gradient(top, #DFF8Ff 0, #A0F0Ff 100%);
	border-radius: 3px;
	-webkit-border-radius: 3px
}
</style>
</head>
<body>
	<div id='mainDiv' class="box1" whiteBg="true">
		<form action="<%=request.getContextPath()%>/hisInfo/updateHisInfo" id="updateForm" method="post"
			failAlert="表单填写不正确，请按要求填写！">
			<input id="hisId" name="hisId" type="hidden" value="${hisInfo.hisId}" /> 
			<input type="hidden" id="proId"	name="proId" value="${proBacInfo.proId }" />
			<input type="hidden" id="excFields" name="excFields" value="" />
			<table class="tableStyle" formMode="view">
				<tr>
					<td>位置分类：</td>
					<td>
					<select prompt="请选择" id="posClass" name="posClass" selectedValue="${hisInfo.posClass}" url="<%=request.getContextPath()%>/proClass/querySelectList?tabId=3&&classId=${proBacInfo.classId}" ></select>
					<%-- <div class="selectTree" id="posClass1" name="posClass" selectedValue="${hisInfo.posClass}" data='{"treeNodes":[
						{ "id":"1", "parentId":"0", "name":"现场查验", "open": "true"},
						{ "id":"11", "parentId":"1", "name":"集装"},
						{ "id":"12", "parentId":"1", "name":"现场"},
						{ "id":"13", "parentId":"1", "name":"货物及包装"},
						{ "id":"2", "parentId":"0", "name":"感官"},
						{ "id":"3", "parentId":"0", "name":"标签"},
						{ "id":"4", "parentId":"0", "name":"取样"},
						{ "id":"5", "parentId":"0", "name":"记录"},
						{ "id":"6", "parentId":"0", "name":"出证"},
						{ "id":"7", "parentId":"0", "name":"处置"}
						]}'></div> --%>
						<span class="star">*</span></td>
					</td>
					<td>照片：</td>
					<td><input id="photo" name="photo" type="hidden" value="${hisInfo.photo}" />
						<div style="position: absolute;top: 25px;right: 180px">
							<input id="j-file" keepdefaultstyle="true" class="upload" name="file" type="file" /> 
							<span class="fake-file"	data-ac="active" />选择文件</span><span class="star">*</span></td>
						</div></td>
				</tr>
				<tr>
					<td>说明：</td>
					<td><input id="explains" name="explains" type="text" value="${hisInfo.explains}" /></td>
					<td>正反案例：</td>
					<td><select name="casneg">
							<option value="1" <c:if test='${hisInfo.casneg == 1}'> selected="selected" </c:if>>正</option>
							<option value="2" <c:if test='${hisInfo.casneg == 2}'> selected="selected" </c:if>>反</option>
					</select></td>
				</tr>
				<tr>
					<td>录入时间：</td>
					<td><input id="createDate" name="createDate" value="${hisInfo.createDate}" type="text"
						class="validate[required]" class="dateIcon" onfocus="WdatePicker({skin:themeColor,maxDate:'%y-%M-%d'})" /> 
						<span class="star">*</span></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<table  class="tableStyle" formMode="view">
		      	<tr>
		        	<td style="font-weight: bold;text-align: left;" >扩展属性</td>
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
						<button type="button" onclick="top.Dialog.close();">
							<span class="icon_clear">返回</span>
						</button>
					</td>
				</tr>
			</table>
		</div>
		<div style="position: absolute;top: 250px;left: 30px" id="imgDiv" align="left"></div>
	</div>
	<script type="text/javascript">
	//表单提交
	function initComplete() {
		//初始化属性区域
		initFieldBox();
		
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
			var photo="${hisInfo.photo}";
			if(photo!=null&&photo!=""){
				
			//初始化显示图片
			var newDiv = document.createElement("div");
			newDiv.style.float = "left";
			newDiv.style.width = "200px";
			newDiv.style.marginRight = "15px";
			newDiv.id = "xxx_" + 1;
			var str = '<div class="framegrid nocaption">'
					+ '<a href="'
					+ '<%=request.getContextPath()%>${hisInfo.photo}'
					+ '" class="highslide" onclick="return hs.expand(this)">'
					+ '<div class="boxgrid captionfull"><img  width="200px" height="122px" src="' + '<%=request.getContextPath()%>${hisInfo.photo}' + '"/></div>'
					+ '</a>'
					+ '</div>'
					+ '<div style="margin-left:10px; margin-top: 120px;"><input type="button" onclick="deleteFile(\''
					+ newDiv.id + '\');" value="删除"></div>';
			newDiv.innerHTML = str;
			$("#imgDiv").html(newDiv); 
			}

			//表单提交
			$('#updateForm').submit(
					function() {
						//判断表单的客户端验证时候通过
						var valid = $('#updateForm').validationEngine({
							returnIsValid : true
						});
						if (valid) {
							$(this).ajaxSubmit(
									{
										//表单提交成功后的回调
										success : function(responseText,
												statusText, xhr, $form) {
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
			var a = $("#posClass").attr("relValue");
			if(a == "" || a==null){
				alert("位置分类不能空!");
				return false;
			}else{ 
				/* //提交属性区域
				var s=$("#add_field_table :input").serializeArray();
				$("#excFields").val(JSON.stringify(s)); */
				$("#updateForm").submit();
			}
		};

		$(function() {
			var $file = $('#j-file');
			// thumb

			$file.makeThumb({
				width : 1324,
				height : 1324,
				success : function(dataURL, tSize, file, sSize, fEvt) {

					var $up = $('<input id="baseFile_'+1+'" type="hidden" name="baseFile" />');
					$up.insertAfter($file).val(dataURL);
					var newDiv = document.createElement("div");
					newDiv.style.float = "left";
					newDiv.style.width = "200px";
					newDiv.style.marginRight = "15px";
					newDiv.id = "xxx_" + 1;
					var str = '<div class="framegrid nocaption">'
							+ '<a href="'
							+ dataURL
							+ '" class="highslide" onclick="return hs.expand(this)">'
							+ '<div class="boxgrid captionfull"><img  width="200px" height="122px" src="' + dataURL + '"/></div>'
							+ '</a>'
							+ '</div>'
							+ '<div style="margin-left:10px; margin-top: 120px;"><input type="button" onclick="deleteFile(\''
							+ newDiv.id + '\');" value="删除"></div>';
					newDiv.innerHTML = str;
					$("#imgDiv").html(newDiv);

				}
			});
		});

		function deleteFile(divId) {
			$('#baseFile_' + divId).remove();
			var my = document.getElementById(divId);
			if (my != null) {
				my.parentNode.removeChild(my);
			}
		}
		//初始化属性区域
		function initFieldBox(){
			var classId=$("#hisId").val();
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
								"<td width='25%'><input name='"+field.fieldId+"' type='text' value='"+fieldValue+"' /></td>";
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
	</script>
</body>
</html>
