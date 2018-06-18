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
    <!-- 树组件start -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.css"></link>
	<!-- 树组件end -->
	<!-- 树形下拉框start -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/form/selectTree.js"></script>
	<!-- 树形下拉框end -->
    <!--弹窗组件start-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/drag.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/dialog.js"></script>
	<!--弹窗组件end-->
</head>
<body>
	<div class="box2" panelTitle="查询" id="searchPanel">
	    <form action="<%=request.getContextPath()%>/staBas/staBasCheckConentList" id="queryForm" method="post">
	        <table>
	            <tr>
	            	<td align="right">产品编号：</td>
	                <td>
	                    <label for="proId"><input type="text" id="proId" name="proId" /></label>
	                    <label>
	                        <input type="text" style="width:2px;display:none;"/>
	                    </label>
	                </td>
	                <td align="right">产品名称：</td>
	                <td>
	                    <label for="proName"><input type="text" id="proName" name="proName" /></label>
	                    <label>	                   
	                        <input type="text" style="width:2px;display:none;"/>
	                    </label>
	                </td>
	                <td align="right">hs编码：</td>
	                <td>
	                    <label for="hsCode"><input type="text" id="hsCode" name="hsCode" /></label>
	                    <label>	                   
	                        <input type="text" style="width:2px;display:none;"/>
	                    </label>
	                </td>
	            </tr>
	            <tr>
	            	<td align="right">产品类别：</td>
	                <td>
	                     <div class="selectTree" url="<%=request.getContextPath()%>/proClass/proClassList" id="selectTree1" name="classId"></div>
	                    <label>
	                        <input type="text" style="width:2px;display:none;"/>
	                    </label>
	                </td>
	                <td align="right">录入时间：</td>
	                <td>
	                    <label for="createDate"><input class="date" type="text" id="createDate" name="createDate" /></label>
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
	            	{ display: '产品编号', name: 'proId',     align: 'center', width: "10%", isSort:false},
	            	{ display: 'hs编码', name: 'hsCode',     align: 'center', width: "10%", isSort:false},
	                { display: '产品名称', name: 'proName',     align: 'center', width: "10%", isSort:false},
	                 { display: '产品类别', name: 'className',   align: 'center', width: "10%" , isSort:false},
	                { display: '录入时间', name: 'createDate',   align: 'center', width: "10%" ,isSort:false},
	                { display: '制作商', name: 'maker',   align: 'center', width: "10%" ,isSort:false},
	                 { display: '审核时间', name: 'checkDateS', align: 'center', width: "10%",isSort:false},	
	                  { display: '审核人', name: 'checkNameS', align: 'center', width: "10%",isSort:false},	 
	                { display: '审核状态', isAllowHide: false, align: 'center', width: "10%",
	                	render: function (rowdata, rowindex, value, column){
	                		var str1="";
	                		var str2="";
	                		var str3="";
	                		if(rowdata.stateS == '1'){
	                			str1="未审核";
	                		}else if(rowdata.stateS == '2'){
	                			str2="审核通过"; 
	                		}else if(rowdata.stateS == '3'){
	                			str3="退回"; 
	                		}  
	                		return '<div class="padding_top4 padding_left5">'
	                    			+str1
	                    			+str2
	                    			+str3
	                                + '</div>';	                    	
	                	}
	                },	       	                
	                { display: '操作', isAllowHide: false, align: 'center', width: "10%",
	                    //操作列渲染为图标
	                    render: function (rowdata, rowindex, value, column){
	                    	var str1="";
	                    	var str2="";
	                    	if(rowdata.stateS == '1'){
	                    		str1='<input class="button2" onclick="toCheckUpdate(\'' + rowdata.proId + '\')" type="button" width="30px" value="审核"/>' ;
	                               
	                    	}else if(rowdata.stateS=='2' || rowdata.stateS=='3'){
	                    		str2='<input class="button2" onclick="toCheckDetail(\'' + rowdata.proId + '\')" type="button" width="45px" value="查看"/>';
	                    	}
	                    	return '<div class="padding_top4 padding_left5">'
	                    			+str1
	                    			+str2
	                                + '</div>';
	                    	}
	                    }
	             ],
	             url: '<%=request.getContextPath()%>/staBas/staBasCheckConentList',
	            pageSize: 10,
	            sortName: '',
	            rownumbers:true,
	            checkbox:false,
	            height: '100%',
	            width:"100%"
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
	      //审核
	      function toCheckUpdate(proId) {
	       
	         window.location.href="<%=request.getContextPath()%>/staBas/toCheckUpdate?proId="+proId;
	    }
		
		//查看
	     function toCheckDetail(proId) {
	    	 window.location.href="<%=request.getContextPath()%>/staBas/toCheckDetail?proId="+proId;
	    	
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
