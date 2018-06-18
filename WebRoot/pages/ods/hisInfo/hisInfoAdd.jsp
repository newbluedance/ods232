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
		<form action="<%=request.getContextPath()%>/hisInfo/addHisInfo"  id="addForm" method="post" failAlert="表单填写不正确，请按要求填写！">
			<input type="hidden" id="excFields" name="excFields" value="" />
			<input type="hidden" id="proId" name="proId" value="${proBacInfo.proId }" />
			<table class="tableStyle" formMode="view">
				<tr>
					<td colspan="4" style="font-weight: bold;text-align: left;">基础信息</td>
				</tr>
			<tr>
				<td width="25%" style="text-align:right; font-weight:bold; ">产品编号:</td>
				<td width="25%" style="text-align:left;">${proBacInfo.proId }</td>
				<td width="25%" style="text-align:right; font-weight:bold; ">产品名称:</td>
				<td width="25%" style="text-align:left; ">${proBacInfo.proName}</td>

			</tr>

			<tr>
				<td style="text-align:right;font-weight:bold; ">HS编码:</td>
				<td style="text-align:left;">${proBacInfo.hsCode}</td>
				<td style="text-align:right;font-weight:bold; ">产品类别:</td>
				<td style="text-align:left;">${proBacInfo.className}</td>
			</tr>
			</table>
		</form>
		
		 <div style="margin: 0;padding: 0 3px 0 0;">
       	 	<div id="maingrid"></div>
   		 </div>
		<div class="height_5"></div>
		
	</div>
	
	<script type="text/javascript">
		 var g;
		 var proId = $("#proId").val();
	    function initComplete(){
	    	 g = $("#maingrid").quiGrid({
		            columns: [
		            	{ display: '位置分类',name:'posClass', align: 'center', width: "15%"},
		            	{ display: '上传照片',name:'photo',  align: 'center', width: "15%"},
		                { display: '照片说明', name: 'explains',     align: 'center', width: "15%", isSort:false},
		                { display: '正反案例', name:'casneg',   align: 'center', width: "15%" ,type:"casneg"},
		                { display: '录入时间', name: 'createDate',   align: 'center', width: "20%" ,isSort:false}, 
		                { display: '操作', isAllowHide: false, align: 'center', width: "20%",
		                    //操作列渲染为图标
		                    render: function (rowdata, rowindex, value, column){
		                    	var str1="";        
	                    		str1='<input class="button2" onclick="toUpdate(\'' + rowdata.hisId + '\')" type="button" width="30px" value="修改"/>' 
	                                + '<input class="button2" onclick="toDel(\'' + rowdata.hisId + '\')" type="button" width="30px" value="删除"/>'; 	                             
		                    	return '<div class="padding_top4 padding_left5">'
		                    			+str1
		                                + '</div>';  
		                    	}
		                    }
		            ],
		            url: '<%=request.getContextPath()%>/hisInfo/hisInfoLists?proId='+'${proBacInfo.proId}',
		            pageSize: 10,
		            sortName: '',
		            rownumbers:true,
		            checkbox:false,
		            height: '100%',
		            width:"100%",
		            //顶部图标按钮栏
					toolbar: 
						{
						items: [
			                { text: '新增监管要素', click: toAdd, iconClass: 'icon_add' },
			                { text: '返回', click: goback, iconClass: 'icon_clear' }
			            	]
			        	}
		        });	
	    }
	    $.quiDefaults.Grid.formatters['casneg'] = function (value, column) {
	    	if(value=='1'){
    			return "正";
    		}else if(value=='2'){
    			return "反";
    		}   
	    };


		  //添加
	    function toAdd() {	     
	    		var proId = $("#proId").val();
	    		//alert(proId);
	    	 top.Dialog.open({URL: "<%=request.getContextPath()%>/hisInfo/toAddHis?proId="+proId,Title: "新增监管要素",Width: 960,Height: 450});   
	    }
	     //修改
	    function toUpdate(hisId) {
	    	top.Dialog.open({URL: "<%=request.getContextPath()%>/hisInfo/toUpdate?hisId="+hisId+"&&proId="+proId,Title: "修改",Width: 960,Height: 450});
	    }
	      //删除
	    function toDel(hisId) {
	    	top.Dialog.confirm("确定要删除该记录吗？",function(){
	        	 window.location.href="<%=request.getContextPath()%>/hisInfo/delHisInfo?hisId="+hisId +"&&proId="+proId;
	        });
	    }
		function goback() {
		    window.location.href='<%=request.getContextPath()%>/hisInfo/hisInfo' ;
		}
		 //刷新表格数据并重置排序和页数
	    function refresh(isUpdate){
	        if(!isUpdate){
	            //重置排序
	            g.options.sortName='';
	            g.options.sortOrder="desc";
	            //页号重置为1
	            g.setNewPage(1);
	        }
	        g.loadData();
	    }
	</script>
</body>
</html>
