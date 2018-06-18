<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2014/7/1
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>基本表格模板</title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/" scrollerY="false"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->

    <!--数据表格start-->
    <script src="<%=request.getContextPath()%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
    <!--数据表格end-->

    <!-- 表单start -->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!-- 表单end -->

</head>
<body>
<div class="groupTitle"><span>快速检索用户</span></div>
<form action="<%=request.getContextPath()%>/user/query" id="queryForm" method="post">
    <table>
        <tr>
            <td>登录名：</td>
            <td>
                <input type="text" id="loginName" name="loginName"/>
                <input type="text" style="width:2px;display:none;"/>
            </td>
            <td>姓名：</td>
            <td>
                <input type="text" id="displayName" name="displayName"/>
                <input type="text" style="width:2px;display:none;"/>
            </td>
            <td>
                <button type="button" onclick="searchHandler()"><span class="icon_find">查询</span></button>
            </td>
            <td>
                <button type="button" onclick="resetSearch()"><span class="icon_reload">重置查询</span></button>
            </td>
        </tr>
    </table>
</form>
<div class="groupTitle"><span>待绑定用户</span></div>
<div id="maingrid"></div>

<div class="ali02 padding_top5">
    <form id="linkRole" action="">
        <input type="hidden" id="roleId" name="roleId" value="${roleId}"/>
        <button type="button" class="button" onclick="onSubmitHandler()"><span class="icon_m_06">确认关联</span></button>
    </form>
</div>


<script type="text/javascript">
    var checkedArray = [];
    var checkedTextArray = [];

    var g;
    function initComplete() {
        var checkedArrayList = "${checkedArray}".replace('[','').replace(']','').split(',');
        var checkedTextArrayList = "${checkedTextArray}".replace('[','').replace(']','').split(',');
        for(var i=0;checkedArrayList.length>i;i++){
            checkedArray.push($.trim(checkedArrayList[i]));
            checkedTextArray.push($.trim(checkedTextArrayList[i]));
        }

        g = $("#maingrid").quiGrid({
            columns: [
                { display: '登录名', name: 'loginName', align: 'center', width: "15%"},
                { display: '姓名', name: 'displayName', align: 'center', width: "30%"},
                { display: '职务', name: 'positionCode', align: 'center', width: "15%"},
                { display: '电话', name: 'mobileNO', align: 'center', wdith: "20%"} ,
                { display: '所属部门', name: 'deptCode', align: 'center', width: "20%"}
            ], url: '<%=request.getContextPath()%>/user/query', sortName: 'F_LOGIN_NAME', sortOrder: 'ASC', pageSize: 10, rownumbers: true, checkbox: true, percentWidthMode: true,
            height: 370, width: "99%", isChecked: checkedHandler, onCheckRow: checkRowHandler, onCheckAllRow: checkAllRowHandler
        });

    }

    function findCheckedArray(id) {
        for (var i = 0; checkedArray.length > i; i++) {
            if (checkedArray[i] == id) return i;
        }
        return -1;
    }

    function addCheckedArray(id, name) {

        if (findCheckedArray(id) == -1) {
            checkedArray.push(id);
            checkedTextArray.push(name);
        }
    }

    function removeCheckedArray(id) {
        var i = findCheckedArray(id);
        if (i == -1) return;
        checkedArray.splice(i, 1);
        checkedTextArray.splice(i, 1);
    }

    function checkedHandler(rowdata) {
        if (findCheckedArray(rowdata.userId) == -1) {
            return false;
        }
        return true;
    }

    function checkRowHandler(checked, data) {
        if (checked) addCheckedArray(data.userId, data.displayName);
        else removeCheckedArray(data.userId, data.displayName);
    }

    function checkAllRowHandler(checked) {
        for (var rowid in this.records) {
            if (checked)
                addCheckedArray(this.records[rowid]['userId'], this.records[rowid]['displayName']);
            else
                removeCheckedArray(this.records[rowid]['userId'], this.records[rowid]['displayName']);
        }
    }


    function search() {
//        alert(checkedArray.length);
        top.Dialog.alert("选中文本："+checkedTextArray.join(',')+"<br/>选中id："+checkedArray.join(','));
    }

    //查询
    function searchHandler() {
        var query = $("#queryForm").formToArray();
        g.setOptions({ params: query});
        //页号重置为1
        g.setNewPage(1);
        //刷新表格数据
        g.loadData();
    }

    //重置查询
    function resetSearch() {
        $("#queryForm")[0].reset();
        searchHandler();
    }

    function onSubmitHandler() {
        var roleId = $("#roleId").val();
        $.post("<%=request.getContextPath()%>/role/addUserRole", { "roleId":roleId,"checkedArray": checkedArray.join(",") },
                function (data) {
                    var status = data.status;
                    top.Dialog.alert(data.msg, function () {
                        if (status) {
                            top.frmright.refresh(status);
                            //关闭窗口
                            top.Dialog.close();
                        }
                    });
                }, "json");
    }

</script>
</body>
</html>