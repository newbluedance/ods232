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
		<form action="<%=request.getContextPath()%>/staBas/addStaBass" id="addForm" method="post" failAlert="表单填写不正确，请按要求填写！">
		<input type="hidden" name="proId"  id="proId" value="${proBacInfo.proId}" />
		<input type="hidden" id="excFields" name="excFields" value="" />
			<table class="tableStyle" formMode="view" >
				<tr>
					<td colspan="4" style="font-weight: bold;text-align: left;">基础信息</td>
				</tr>
				<tr>
					<td width="25%;">产品编号：</td>
					<td width="25%;">
						${proBacInfo.proId }
					</td>
					<td width="25%;">产品名称：</td>
					<td width="25%;">${proBacInfo.proName }</td>
				</tr>
				<tr>
					<td>hs编码：</td>
					<td>
						${proBacInfo.hsCode}
					</td>
					<td>产品类型：</td>
					<td>
						${proBacInfo.className}
					</td>
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
		var proId=$("#proId").val();
	    function initComplete(){
	    	 g = $("#maingrid").quiGrid({
		            columns: [
	         			   	{ display: '依据类别', name: 'basisClass',     align: 'center', width: "13%"},
			            	{ display: '依据文件', name:'baseFile',   align: 'center', width: "15%"},
			                { display: '录入时间', name: 'createDate',   align: 'center', width: "15%"}, 
			                { display: '有效日期', name: 'validData',   align: 'center', width: "15%" }, 
			                { display: '失效日期', name: 'expiryData',   align: 'center', width: "15%"}, 
			                { display: '是否有效', name: 'isValid',   align: 'center', width: "13%" ,type:"isValid"},
			           		{ display: '操作', isAllowHide: false, align: 'center', width: "14%", 
               			 			 //操作列渲染为图标
			                    render: function (rowdata, rowindex, value, column){
			                      var str1="";
			                      str1= '<input class="button2" onclick="toUpdate(\'' + rowdata.staId + '\')" type="button" width="30px" value="修改"/>'	                               
                             			     + '<input class="button2" onclick="del(\'' + rowdata.staId + '\')" type="button" width="45px" value="删除"/>';'</div>';
                             		 return '<div class="padding_top4 padding_left5">'
                             		 		+str1
                             		 		+'</div>';
									   }
               				 }
		            ],
		          	url: '<%=request.getContextPath()%>/staBas/queryStaBasList?proId='+proId,
		            pageSize: 10,
		            sortName: '',
		            rownumbers:true,
		            checkbox:false,
		            height: '100%',
		            width:"100%",
		            //顶部图标按钮栏
		        	toolbar:
		        	{
		        		items:[
		        				{text:"新增规范依据 ",click:toAddSta,iconClass:'icon_add'},
		        				{text:"返回 ",click:goback,iconClass:'icon_clear'}
		        		]
		        	}
		        } );
	    	 $.quiDefaults.Grid.formatters['isValid'] = function (value, column) {
	    		 if(value=="1"){
     				return "有效";
	     		}else if(value=="2"){
	     			return "失效";
	     		}
			    };
	    	 /* $.quiDefaults.Grid.formatters['basisClass'] = function (value, column) {
	    		 if(value=="1"){
	   			 	return "标准";
	   			 }else if(value=="2"){
	   				return "规范性文件";
	   			 }else if(value=="3"){
	   				return "警示通报";
	   			 }else if(value=="4"){
	   				return "检验检疫监管要点";
	   			 }
			    }; */
		        
		        
	       <%--  //初始化属性区域
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
    	            });	 --%>
		        
	        //监听查询框的回车事件
	        $("#passengerName").keydown(function(event){
	            if(event.keyCode==13){
	                searchHandler();
	            }
	        });
	        $("#searchPanel").bind("stateChange", function (e, state) {
	            g.resetHeight();
	        });
	    
	   }
	     //添加
	    function toAddSta() {
	   		top.Dialog.open({URL: "<%=request.getContextPath()%>/staBas/staBasAddSta?proId="+'${proBacInfo.proId }',Title: "新增",Width: 960,Height: 450});
	    }
	     //删除
	    function del(staId) {
	    	top.Dialog.confirm("确定要删除该记录吗？",function(){
	        	 window.location.href="<%=request.getContextPath()%>/staBas/delStaBas?staId="+staId +"&&proId="+proId;
	        });
	    }
	    //修改
	    function toUpdate(staId) {
	    	top.Dialog.open({URL: "<%=request.getContextPath()%>/staBas/toUpdate?staId="+staId,Title: "修改",Width: 960,Height: 450});
	    }
		//返回
		function goback() {
			  window.location.href='<%=request.getContextPath()%>/staBas/staBas' ;
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
