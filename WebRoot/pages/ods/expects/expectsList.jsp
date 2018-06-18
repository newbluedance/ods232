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
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/" scrollerY="false"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->
    <!-- 日期选择框start -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/form/datePicker/WdatePicker.js"></script>
    <!-- 日期选择框end -->
    <!--数据表格start-->
    <script src="<%=request.getContextPath()%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
    <!--数据表格end-->
    <!-- 表单start -->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!-- 表单end -->
    <!--表单异步提交start-->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!--表单异步提交end-->
    
    <!--弹窗组件start-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/drag.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/dialog.js"></script>
	<!--弹窗组件end-->
</head>
<body>
	<div class="box2" panelTitle="查询" id="searchPanel">
	    <form action="<%=request.getContextPath()%>/expects/expectsList" id="queryForm" method="post">
	        <table>
	            <tr>
	            	<td align="right">专家姓名：</td>
	                <td>
	                    <label for="expectName"><input type="text" id="expectName" name="expectName" /></label>
	                    <label>
	                        <input type="text" style="width:2px;display:none;"/>
	                    </label>
	                </td>
	                <td align="right">单位：</td>
	                <td>
	                    <label for="dept"><input type="text" id="dept" name="dept" /></label>
	                    <label>
	                        <input type="text" style="width:2px;display:none;"/>
	                    </label>
	                </td>
	                <td><button type="button" onclick="searchHandler()"><span class="icon_find">查询</span></button></td>
	                <td><button type="button"  onclick="resetSearch()" id="resetButton"><span class="icon_reload">重置</span></button></td>
	            </tr>
	        </table>
	    </form>
	</div>
    <div style="margin: 0;padding: 0 5px 0 0;">
        <div id="maingrid"></div>
    </div>
	<script type="text/javascript">
	    var g;
	    function initComplete(){
	        g = $("#maingrid").quiGrid({
	            columns: [
	                { display: '人员', name: 'expectName', align: 'center', width: "25%"},
	                { display: '单位 ', name: 'dept', align: 'center', width: "25%"},
	                { display: '电话', name: 'phone',   align: 'center', width: "25%"},
	                { display: '操作', isAllowHide: false, align: 'center', width: "20%",
	                    //操作列渲染为图标
	                    render: function (rowdata, rowindex, value, column){
	                    	return '<div class="padding_top4 padding_left5">'
	                                + '<input class="button2" onclick="toUpdate(\'' + rowdata.exId + '\')" type="button" width="30px" value="修改"/>'
	                                + '<input class="button2" onclick="toDetail(\'' + rowdata.exId + '\')" type="button" width="45px" value="查看"/>'
	                                 + '<input class="button2" onclick="del(\'' + rowdata.exId + '\')" type="button" width="45px" value="删除"/>'
	                                + '</div>';
	                    	}
	                    }
	            ],
	            url: '<%=request.getContextPath()%>/expects/expectsList',
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
		                { text: '新增', click: toAdd, iconClass: 'icon_add' }
		            ]
		        	}
	        });
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
	    function toAdd(exId) {
	        top.Dialog.open({URL: "<%=request.getContextPath()%>/expects/toAdd?exId="+exId,Title: "登记凭证",Width: 960,Height: 450});
	    }
		//查看
	    function toDetail(exId) {
	        top.Dialog.open({URL: "<%=request.getContextPath()%>/expects/toDetail?exId="+exId,Title: "查看",Width: 960,Height: 450});
	    }
		
	    //修改
	    function toUpdate(exId) {
	    	top.Dialog.open({URL: "<%=request.getContextPath()%>/expects/toUpdate?exId="+exId,Title: "修改",Width: 960,Height: 450});
	    }
	     //删除
	    function del(exId) {
	    	top.Dialog.confirm("确定要删除该记录吗？",function(){
	        	 window.location.href="<%=request.getContextPath()%>/expects/del?exId="+exId ;
	        });
	    }
	     //重置查询
	     function resetSearch() {
	         $("#queryForm")[0].reset();
	         searchHandler();
	     }
	
	     //查询
	     function searchHandler(){
	         var query = $("#queryForm").formToArray();
	         g.setOptions({ params : query});
	         //页号重置为1
	         g.setNewPage(1);
	         //刷新表格数据
	         g.loadData();
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
