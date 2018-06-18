<%--
  Created by IntelliJ IDEA.
  User: 宋崇浩
  Date:
  Time:
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->
    <!-- 表单验证start -->
    <script src="<%=request.getContextPath()%>/libs/js/form/validationRule.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/libs/js/form/validation.js" type="text/javascript"></script>
    <!-- 表单验证end -->
    <!--表单异步提交start-->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!--表单异步提交end-->
    <!-- 日期控件start -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/form/datePicker/WdatePicker.js"></script>
    <!-- 日期控件end -->
   
    <!--数据表格start-->
    <script src="<%=request.getContextPath()%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
    <!--数据表格end-->
   
</head>
<body>
        <input type="hidden" value="${info.entRegCode}"/>
        <div class="padding_right5">
    <div id="maingrid"></div>
</div>
<script type="text/javascript">
    var g;
    function initComplete() {
        g = $("#maingrid").quiGrid({
            columns: [
                { display: '企业注册编码', name: 'entRegCode',     align: 'center', width: "30%"},
                { display: '身份证', name: 'id_Card_NO', 	 align: 'center', width: "20%"},
                { display: '报检人员机构', name: 'declPersonCode', 	 align: 'center',  width:"20%"} ,
                { display: '报检人员姓名', name: 'declPersonName', 	 align: 'center', width: "18%"} ,
                   { display: '操作', isAllowHide: false, align: 'center', width:"12%",
                    render: function (rowdata, rowindex, value, column){
		                  return '<div class="padding_top4 padding_left5">'
		                + '<input type="button" style="width:45px;" value="查看" class="button2" onclick="onView(\'' + rowdata.declPersonCode + '\')" />'
		                + '</div>';
		                
	                }
                }     
            ],
            url: '<%=request.getContextPath()%>/DeclPerson/queryList?entRegCode=${info.entRegCode}',
            sortName: 'guid',sortOrder:'desc', rownumbers: true, height: '280px', width: "100%", pageSize: 5, percentWidthMode:true
        });
    }
    
    //查询
    function searchHandler() {
        //得到查询参数
        var query = $("#queryForm").formToArray();
        //将查询参数传给grid表格
        g.setOptions({ params: query});
        //页号重置为1
        g.setNewPage(1);
        //重新加载数据
        g.loadData();
    }

    //重置
    function resetHandler() {
        //表单常规元素还原
        //$("#queryForm")[0].reset();
        //下拉框还原
        $("#myForm").find("select").render();
        //重新查询
        searchHandler();
    }
    
    //刷新表格 表单提交的回调
    function afterFormSubmit() {
        g.loadData();
    }
    function onView(rowid){
        top.Dialog.open({
        URL: "<%=request.getContextPath()%>/DeclPerson/see?declPersonCode=" + rowid,
        Title: "查看",
        Width: 960,
        Height: 560
        });
    }

    //刷新表格数据并重置排序和页数
   
	
</script>

        <fieldset style="text-align: center;">
        	<legend>操作</legend>
        	<button type="button" id="res" onclick="top.Dialog.close();" title="返回" value="返回"><span class="icon_btn_left">&nbsp;返&nbsp;回&nbsp;</span></button>
        </fieldset>
</body>
</html>