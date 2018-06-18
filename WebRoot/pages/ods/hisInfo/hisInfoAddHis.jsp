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
	
	<!-- 异步上传end -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/ajaxfileupload.js"></script>
    <!-- 异步上传end -->
    <!--图片弹窗start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide-with-gallery.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide.css" />
    <!--图片弹窗end-->
    
	
	<!-- 树形下拉框start -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/form/selectTree.js"></script>
	<!-- 树形下拉框end -->
    
	<style>
		.boxgrid{
            width: 84px;
            height: 122px;
            margin:10px;
            float:left;
            background:#161613;
            border: solid 2px #8399AF;
            overflow: hidden;
            position: relative;
        }
        .upload {
            width: 83px;
            height: 34px;
            z-index: 9;
            opacity: 0;
        }

        .fake-file {
            width: 82px;
            height: 34px;
            line-height: 36px;
            z-index: 2;
            margin-left: -80px;
            font-size: 18px;
            -webkit-box-shadow: inset 0 1px 1px 0 #fff, 0px 1px 1px 0 #FCFCFC;
            box-shadow: inset 0 1px 1px 0 #fff, 0px 1px 1px 0 #FCFCFC;
            border: solid 1px #95E4F3;
            background: #f5f5f5;
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f5f5f5), color-stop(100%, #EBEBEB));
            background: -webkit-linear-gradient(top, #DFF8F7 0, #A0F0F3 100%);
            border-radius: 3px;
            -webkit-border-radius: 3px
        }
    </style>
	
</head>
<body>
	<div id='mainDiv' class="box1" whiteBg="true">
		<form action="<%=request.getContextPath()%>/hisInfo/addHisInfo" id="updateForm" method="post" failAlert="表单填写不正确，请按要求填写！">
			<input type="hidden" id="excFields" name="excFields" value="" />
			<input id="hisId" name="hisId" type="hidden" value="${hisid }"/>
			<input type="hidden" id="proId" name="proId" value="${proBacInfo.proId }" />
			<table class="tableStyle" formMode="view" >
				<tr>
					<td>位置分类：</td>
					<td>
						<select prompt="请选择" id="posClass" name="posClass"  url="<%=request.getContextPath()%>/proClass/querySelectList?tabId=3&&classId=${proBacInfo.classId}" ></select>
						<span class="star">*</span>
					</td>
					<td>上传照片：</td>
					<td>
					<div style="position: absolute;top: 25px;right: 180px">
                        <!-- <input id="j-file" keepdefaultstyle="true" class="upload" name="file" type="file" />
                        <span class="fake-file" data-ac="active" />选择文件</span><span class="star">*</span>
                         -->
                        <input id="cateringPicture_button" onchange="checkImg5();" keepdefaultstyle="true" class="upload" name="file" type="file"/>
                        <span class="fake-file" data-ac="active">选择文件</span><span class="star">*</span>
                    </div>
					</td>
				</tr>
				<tr>
					<td>照片说明：</td>
					<td><input id="explains" name="explains" type="text" value=""/></td>
					<td>正反案例：</td>
					<td>
						<select name="casneg">
							<option value="1">正</option>
							<option value="2">反</option>
						</select>						
					</td>
				</tr>
				<tr>
					<td>录入时间：</td>
					<td><input id="createDate" name="createDate" value="${createDate}" type="text" class="validate[required]"
						class="dateIcon" onfocus="WdatePicker({skin:themeColor,maxDate:'%y-%M-%d'})" /> <span class="star">*</span></td>
					<td></td>
					<td></td>
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
		<div style="position: absolute;top: 250px;left: 30px" id="cateringPicture_div" align="left">
        </div>
	</div>
	<script type="text/javascript">
	var fixedObj = 70;
    function customHeightSet(contentHeight) {
        $("#scrollContent").height(contentHeight - fixedObj);
    }
    function initComplete() {
        //预览图片---点击图片预览大图图片---以下为预览大图图片属性设置
        hs.graphicsDir = '<%=request.getContextPath()%>/libs/thirdparty/highslide/graphics/';
        hs.align = 'center';
        hs.transitions = ['expand', 'crossfade'];
        hs.outlineType = 'rounded-white';
        hs.fadeInOut = true;
        hs.addSlideshow({
            interval: 5000,
            repeat: false,
            useControls: false,
            fixedControls: 'fit',
            overlayOptions: {
                opacity: .75,
                position: 'bottom center',
                hideOnMouseOut: true
            }
        });

	    //表单提交
	    $('#updateForm').submit(function () {
	        //判断表单的客户端验证时候通过
	        var valid = $('#updateForm').validationEngine({returnIsValid: true});
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
	function sub(){
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

    var picNum = 1;
    var filePathIdArr = [];
    function cateringPictureImgUp() {
    	var cateringPicturestate = document.getElementById('cateringPicture_1');
		if (null != cateringPicturestate) deleteFile("cateringPicture_1");
    	
		//picNum++;
		$.ajaxFileUpload({
			url: '<%=request.getContextPath()%>/uploadFile/addUploadFile',            //需要链接到服务器地址
			secureuri: false,
			fileElementId: 'cateringPicture_button',                        //文件选择框的id属性
			dataType: 'json',                                     //服务器返回的格式，可以是json, xml
			data: {tabName:"${hisid }",tabFileName:"cateringPicture",companyFlag:"Y"},
			success: function (data, status)           //相当于java中try语句块的用法
			{
				//添加照片
				var newDiv=document.createElement("div");
				newDiv.style.float="left";
				newDiv.style.width="80px";
				newDiv.style.marginRight="15px";
				newDiv.id="cateringPicture_1";
				var str = '';
				
				if(data.isShow){
					str = '<div class="framegrid nocaption">'
						+ '<a href="' + '<%=request.getContextPath()%>' + data.uploadFile.filePath + '" class="highslide" onclick="return hs.expand(this)">'
						+ '<div class="boxgrid captionfull"><img width="80px" id="img5" name="img5" height="122px" src="' + '<%=request.getContextPath()%>' + data.uploadFile.filePath + '"/></div>'
						+ '</a>'
						+ '</div>'
						+'<div style="margin-left:10px; margin-top: 10px;">'
						+'<input type="button" id="'+data.uploadFile.filePathId+'" onclick="deleteFile(\''+newDiv.id+'\');" value="删除">'
						+'<input type="hidden" id="deleteid" value="'+data.uploadFile.filePathId+'">'
						+'</div>';
				}else{
					str = '<div width="200px" height="122px">'
						+ '<a href="' + '<%=request.getContextPath()%>' + data.uploadFile.filePath + '">'+ data.uploadFile.fileName +'</a>'
						+ '</div>'
						+'<div style="margin-left:10px; margin-top: 10px;">'
						+'<input type="button" name="deleteid" id="'+data.uploadFile.filePathId+'" onclick="deleteFile(\''+newDiv.id+'\');" value="删除">'
						+'<input type="hidden" id="deleteid" value="'+data.uploadFile.filePathId+'">'
						+'</div>';
				}
				newDiv.innerHTML=str;
				document.getElementById("cateringPicture_div").appendChild(newDiv);
			}
		});
    }
    function deleteFile(divId){
    	var hisid = "${hisid }";
        $.post('<%=request.getContextPath()%>/uploadFile/deleteFileByTabId?filePathId=${hisid }', function (result) {
            if(result=="1"){
                filePathIdArr.remove(hisid);
                var my = document.getElementById(divId);
                if (my != null){
                    my.parentNode.removeChild(my);
                }
            }else{
                top.Dialog.alert("删除失败！");
            }
        });
    }

    //重置
    function closeWin() {
        //刷新数据
        top.frmright.refresh(true);
        //关闭窗口
        top.Dialog.close();
    }
    //给js数组添加删除指定值的remove方法
    Array.prototype.indexOf = function(val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) return i;
        }
        return -1;
    };
    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };
    
    
    var diag1 = new Dialog();
    function checkImg5()
    {
		if(document.selection){//判断是否是IE浏览器
			var filePath = document.getElementById('cateringPicture_button').value;
			var arrayUploadFile = filePath.split(".");
			var tempType = (arrayUploadFile[arrayUploadFile.length-1]).toLowerCase();
			if(tempType != "jpg" && tempType != "gif" && tempType != "png" && tempType != "tiff" && tempType != "psd" 
				&& tempType != "jpeg" && tempType != "bmp" && tempType != "ico" && tempType != "wbmp" && tempType != "jpe")
			{
				diag1.URL = "<%=request.getContextPath()%>/pages/ods/hisInfo/imgType.jsp";
		        diag1.Title="上传提示";
		        diag1.Width=290;
		    	diag1.Height=120;
		    	diag1.ButtonAlign="center";
		    	diag1.ShowButtonRow=true;
				diag1.ShowOkButton=false;
				diag1.CancelButtonText="确定";
		    	diag1.show();
		    	return;
			}
			else
			{
				var imgs = document.getElementsByName("img5");
		    	if (imgs.length == 5)
		    	{
		    		diag1.URL = "<%=request.getContextPath()%>/pages/ods/hisInfo/dialogMsg.jsp";
			        diag1.Title="上传提示";
			        diag1.Width=290;
			    	diag1.Height=120;
			    	diag1.ButtonAlign="center";
			    	diag1.ShowButtonRow=true;
					diag1.ShowOkButton=false;
					diag1.CancelButtonText="确定";
			    	diag1.show();
			    	return;
		    	}
		    	else
		    	{
		    		cateringPictureImgUp();
		    	}
			}
        }else{
            var val = document.getElementById('cateringPicture_button').value;
			val = val.split("\\");
			var le = val.length - 1;
			filePath = val[le]
			var arrayUploadFile = filePath.split(".");
			var tempType = (arrayUploadFile[arrayUploadFile.length-1]).toLowerCase();
			if(tempType != "jpg" && tempType != "gif" && tempType != "png" && tempType != "tiff" && tempType != "psd" 
				&& tempType != "jpeg" && tempType != "bmp" && tempType != "ico" && tempType != "wbmp" && tempType != "jpe")
			{
				diag1.URL = "<%=request.getContextPath()%>/pages/ods/hisInfo/imgType.jsp";
		        diag1.Title="上传提示";
		        diag1.Width=290;
		    	diag1.Height=120;
		    	diag1.ButtonAlign="center";
		    	diag1.ShowButtonRow=true;
				diag1.ShowOkButton=false;
				diag1.CancelButtonText="确定";
		    	diag1.show();
		    	return;
			}
			else
			{
				var imgs = document.getElementsByName("img5");
		    	if (imgs.length == 5)
		    	{
		    		diag1.URL = "<%=request.getContextPath()%>/pages/ods/hisInfo/dialogMsg.jsp";
			        diag1.Title="上传提示";
			        diag1.Width=290;
			    	diag1.Height=120;
			    	diag1.ButtonAlign="center";
			    	diag1.ShowButtonRow=true;
					diag1.ShowOkButton=false;
					diag1.CancelButtonText="确定";
			    	diag1.show();
			    	return;
		    	}
		    	else
		    	{
		    		cateringPictureImgUp();
		    	}
			}
        }
    }
	</script>
</body>
</html>
