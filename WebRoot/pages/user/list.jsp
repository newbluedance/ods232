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

    <!--树组件start -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.js"></script>
    <link href="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
    <!--树组件end -->

    <!--布局控件start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/nav/layout.js"></script>
    <!--布局控件end-->

    <!--数据表格start-->
    <script src="<%=request.getContextPath()%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
    <!--数据表格end-->

    <!-- 表单start -->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!-- 表单end -->
    <style type="text/css">
        .l-layout-center {
            border: none !important;
        }

        .l-layout-left {
            border-bottom: none !important;
        }

        .l-layout-drophandle-left {
            width: 10px;
        }
    </style>
</head>
<body>
<div id="layout1">
    <div id="leftCon" position="left" style="" panelTitle="组织机构树">
        <div class="orgTreeContainer">
            <ul id="tree" class="ztree"></ul>
        </div>
    </div>
    <div id="centerCon" position="center" style="">
        <div class="box2" panelTitle="查询" showStatus="false">
            <form action="<%=request.getContextPath()%>/user/query" id="queryForm" method="post">
                <input type="hidden" id="parentId" name="deptCode" value=""/>
                <table>
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input type="text" id="searchInput" name="displayName"/>
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
        </div>
        <div class="padding_right5">
            <div id="dataBasic"></div>
        </div>
    </div>
</div>


<script type="text/javascript">
//设定不可编辑的节点id
var noeditArray = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"];


//定义grid
var grid = null;
//定义选中的树节点
var selectTreeNode = null;

//定义树节点初始数据
var nodes = [
    { id: "0", parentId: -1, name: "组织结构树", open: true, icon: "<%=request.getContextPath()%>/libs/icons/home.gif"}
];

//树属性配置
var selectionSetting = {
    view: {
        dblClickExpand: true
    },
    callback: {
        onClick: zTreeSelect
    }
};
//初始化函数
function initComplete() {
    //当提交表单刷新本页面时关闭弹窗
    top.Dialog.close();

    $("#layout1").layout({ leftWidth: 180, onEndResize: function () {
        grid.resetWidth();
    }});

    //初始化tree
    initTree();

    //初始化grid组件
    initGrid();

    //监听查询框的回车事件
    $("#searchInput").keydown(function (event) {
        if (event.keyCode == 13) {
            searchHandler();
        }
    })
}

//初始化tree处理
function initTree() {
    $.ajax({
        type: 'POST',
        url: '<%=request.getContextPath()%>/dept/query',
        data: null,
        success: function (result) {
            nodes = nodes.concat(result);
            $.fn.zTree.init($("#tree"), selectionSetting, nodes);
        },
        error: function (a) {
            top.Dialog.alert("访问服务器端出错！");
        },
        dataType: 'json'
    });
}

//初始化Grid处理
function initGrid() {
    grid = $("#dataBasic").quiGrid({
        columns: [
            { display: '登录名', name: 'loginName', align: 'center', width: "8%"},
            { display: '姓名', name: 'displayName', align: 'center', width: "12%"},
            { display: '职务', name: 'positionCode', align: 'center', width: "12%"},
            { display: '电话', name: 'mobileNO', align: 'center', wdith: "26%"} ,
            { display: '电子邮箱', name: 'email', align: 'center', wdith: "27%"} ,
            { display: '所属部门', name: 'deptCode', align: 'center', width: "17%"},
            { display: '操作', isAllowHide: false, align: 'center', width: "12%",
                render: function (rowdata, rowindex, value, column) {
                    return '<div class="padding_top4 padding_left5">'
                            + '<span class="img_list hand" title="查看" onclick="onView(' + rowdata.userId + ')"></span>'
                            + '<span class="img_edit hand" title="修改" onclick="onEdit(' + rowdata.userId + ')"></span>'
                            + '<span class="img_delete hand" title="删除" onclick="onDelete(' + rowdata.userId + ',' + rowindex + ')"></span>'
                            + '</div>';
                }
            }
        ],
        url: '<%=request.getContextPath()%>/user/query', sortName: 'F_LOGIN_NAME', sortOrder: 'ASC', rownumbers: true, checkbox: true,
        height: '100%', width: "100%", pageSize: 10, percentWidthMode: true,

        toolbar: {
            items: [
                {text: '新增', click: addUnit, iconClass: 'icon_add'},
                { line: true },
                {text: '批量删除', click: deleteUnit, iconClass: 'icon_delete'}
//                { line: true },
//                {text: '导入', click: showImportDialog, iconClass: 'icon_import'},
//                { line: true },
//                {text: '导出当前页', click: exportPageData, iconClass: 'icon_export'},
//                { line: true },
//                {text: '导出全部', click: exportTotalData, iconClass: 'icon_export'}
            ]
        }
    });
}


//新增
function addUnit() {
    var orgId = $("#parentId").val();
    top.Dialog.open({
        URL: "<%=request.getContextPath()%>/user/toAdd?orgId=" + orgId,
        Title: "添加", Width: 930, Height:600});
}
//查看
function onView(rowid) {
    top.Dialog.open({
        URL: "<%=request.getContextPath()%>/userAction.do?method=getUserDetail&userinfor.userId=" + rowid,
        Title: "查看", Width: 550, Height: 400});
}
//修改
function onEdit(rowid) {
    if (getPosition(rowid, noeditArray) != -1) {
        top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
        return false;
    }
    top.Dialog.open({
        URL: "<%=request.getContextPath()%>/sample/unit/user-management-contentAjax.jsp?userId=" + rowid,
        Title: "修改", Width: 550, Height: 400});
}
//删除
function onDelete(rowid, rowidx) {
    if (getPosition(rowid, noeditArray) != -1) {
        top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
        return false;
    }
    top.Dialog.confirm("确定要删除该记录吗？", function () {
        //删除记录
        $.post("<%=request.getContextPath()%>/userAction.do?method=deleteUser",
                {"ids": rowid},
                function (result) {
                    handleResult(result);
                }, "json");
        //刷新表格数据
        grid.loadData();
    });
}


//批量删除
function deleteUnit() {
    top.Dialog.alert("为保证数据的完整性，演示版中禁用了批量删除。");
    return;
    var rows = grid.getSelectedRows();
    var rowsLength = rows.length;

    if (rowsLength == 0) {
        top.Dialog.alert("请选中要删除的记录!");
        return;
    }
    top.Dialog.confirm("确定要删除吗？", function () {
        $.post("<%=request.getContextPath()%>/userAction.do?method=deleteUser",
                //获取所有选中行
                getSelectIds(grid),
                function (result) {
                    handleResult(result);
                },
                "json");
    });
}


//删除后的提示
function handleResult(result) {
    if (result == 1) {
        top.Dialog.alert("删除成功！", null, null, null, 1);
        grid.loadData();
    } else {
        top.Dialog.alert("删除失败！");
    }
}

//获取所有选中行获取选中行的id 格式为 ids=1&ids=2
function getSelectIds(grid) {
    var selectedRows = grid.getSelectedRows();
    var selectedRowsLength = selectedRows.length;
    var ids = "";

    for (var i = 0; i < selectedRowsLength; i++) {
        ids += selectedRows[i].userId + ",";
    }
    return {"ids": ids};
}

//导入
function showImportDialog() {
    top.Dialog.open({Title: "导入用户信息",
        Message: "请上传excel文件",
        URL: "<%=request.getContextPath()%>/sample/unit/uploadFile.jsp?type=1",
        Width: 350, Height: 130});
}

//导出本页
function exportPageData() {
    exportData(true);
}

//导出全部
function exportTotalData() {
    exportData(false);
}

//导出处理
function exportData(isPage) {
    var pageNo = grid.options.page;
    var pagerSize = grid.options.pageSize;
    var sort = grid.options.sortName;
    var direction = grid.options.sortOrder;
    var parentid = $("#parentId").val();
    var userName = $("#userName").val();
    var url = "<%=request.getContextPath()%>/userAction.do?method=exportData";
    if (isPage) {
        url += "&pager.pageSize=" + pagerSize;
        url += "&pager.pageNo=" + pageNo;
        url += "&sort=" + sort;
        url += "&direction=" + direction;
        url += "&isPage=1";
    } else {
        url += "&isPage=0";
    }
    url += "&parentId=" + parentid;
    url += "&userinfor.userName" + userName;

    window.location = url;
}


//点击树节点刷选对应的表格数据
function zTreeSelect(event, treeId, treeNode) {
    var query = null;
    selectTreeNode = treeNode;
    query = {'deptCode': treeNode.id};
    $("#parentId").val(treeNode.id);
    grid.setOptions({ params: query});
    //页号重置为1
    grid.setNewPage(1);
    //刷新表格数据
    grid.loadData();
}


//查询
function searchHandler() {
    var query = $("#queryForm").formToArray();
    grid.setOptions({ params: query});
    //页号重置为1
    grid.setNewPage(1);
    //刷新表格数据
    grid.loadData();
}

//重置查询
function resetSearch() {
    $("#queryForm")[0].reset();
    searchHandler();
}

//刷新表格数据并重置排序和页数
function refresh(isUpdate) {
    if (!isUpdate) {
        //重置排序
        grid.options.sortName = 'F_LOGIN_NAME';
        grid.options.sortOrder = "ASC";
        //页号重置为1
        grid.setNewPage(1);
    }

    grid.loadData();
}

//处理高度自适应，每次浏览器尺寸变化时触发
function customHeightSet(contentHeight) {
    $(".cusBoxContent").height(contentHeight - 55)
    $(".orgTreeContainer").height(contentHeight - 30);
}

</script>
</body>
</html>