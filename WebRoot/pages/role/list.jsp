<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2014/6/30
  Time: 18:44
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

    <!--中型图标库start-->
    <link href="<%=request.getContextPath()%>/libs/css/framework/icon-m.css" rel="stylesheet" type="text/css"/>
    <!--中型图标库end-->
</head>
<body>

<div class="padding_right5">
    <div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
        <div class="center">
            <div class="left">
                <div class="right">
                    <div class="padding_top5 padding_left10">
                        <a href="javascript:;" onclick="addRole();"><span class="icon_add">新增</span></a>

                        <div class="box_tool_line"></div>
                        <a href="javascript:;" onclick="deleteRole();"><span class="icon_delete">删除</span></a>

                        <div class="clear"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="maingrid"></div>
</div>
<script type="text/javascript">

    //数据表格使用
    var g;
    function initComplete() {
        g = $("#maingrid").quiGrid({
            columns: [
                { display: '角色名称', name: 'roleName', align: 'center', width: "20%"},
                { display: '角色描述', name: 'roleDesc', align: 'center', width: "30%"},
                { display: '所属项目', name: 'projectId', align: 'center', width: "30%"},
                { display: '角色类型', name: 'roleType', align: 'center', width: "20%" },
                { display: '操作', isSort: false, width: 350, render: function (rowdata, rowindex, value) {
                    var h = "";
                    h += "<a onclick='modifyRole("+rowdata.roleId+")'><span class='icon_edit'>角色修改</span></a> ";
                    h += "<a onclick='userrel(" + rowdata.roleId + ")'><span class='icon_user'>角色关联用户</span></a> ";
                    h += "<a onclick='resrel(" + rowdata.roleId + ")'><span class='icon_list'>角色关联资源</span></a> ";

                    return h;
                }
                }
            ], url: '<%=request.getContextPath()%>/role/query', sortName: 'F_ROLE_ID', pageSize: 10, rownumbers: true, checkbox: true, percentWidthMode: true,
            height: '100%', width: "100%"
        });
    }

    function userrel(id) {
        top.Dialog.open({URL: "<%=request.getContextPath()%>/role/userRole?roleId="+id, Title: "关联用户", Width: 900, Height: 550});
    }

    function resrel(id) {
        top.Dialog.open({URL: "<%=request.getContextPath()%>/role/roleMenu?roleId="+id, Title: "关联资源", Width: 350, Height: 400});
    }

    function addRole() {
        top.Dialog.open({URL: "<%=request.getContextPath()%>/pages/role/addRole.jsp", Title: "新增角色", Width: 480, Height: 200});
    }

    function modifyRole(id) {
        top.Dialog.open({URL: "<%=request.getContextPath()%>/role/modifyRole?roleId="+id, Title: "修改角色", Width: 480, Height: 200});
    }

    function deleteRole() {
        top.Dialog.confirm("确认删除",function()
        {
            var ids = "";
            var rows = g.getSelectedRows();
            for( i=0 ; rows.length  > i ; i++){
                ids += rows[i].roleId +",";
            }
            $.post("<%=request.getContextPath()%>/role/doDelete",
                    {"ids" : ids},
                    function(result){
                        if(result.status){
                            top.frmright.refresh(result.status);
                        }else{

                        }
                        top.Dialog.alert(result.msg);
                    }
            );

        });
    }

    //刷新表格数据并重置排序和页数
    function refresh(isUpdate){
        if(!isUpdate){
            //重置排序
            g.options.sortName='F_ROLE_ID';
            g.options.sortOrder="desc";
            //页号重置为1
            g.setNewPage(1);
        }

        g.loadData();
    }
</script>
</body>
</html>