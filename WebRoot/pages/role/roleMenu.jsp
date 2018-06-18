<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2014/7/1
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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

    <!--树组件start -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.js"></script>
    <link href="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
    <!--树组件end -->


</head>
<body>

<div class="groupTitle"><span>资源树</span></div>
<div id="scrollContent">
    <ul id="tree-1" class="ztree"></ul>
</div>

<div class="ali02 padding_top5">
    <input type="hidden" id="roleId" name="roleId" value="${roleId}"/>
    <button type="button" class="button" onclick="onSubmitHandler()"><span class="icon_m_06">确认关联</span></button>
</div>

<script type="text/javascript">

    var setting1 = {
        check: {
            enable: true
        }
    };

    var zNodes1 = [
        { id:0, parentId:0, name:"系统导航列表",icon:"<%=request.getContextPath()%>/libs/icons/list.gif",open:true}
    ];


    function initComplete(){
        $.ajax({
            type : 'POST',
            url : '<%=request.getContextPath()%>/menu/query?roleId='+'${roleId}',
            data : null,
            success : function(result){
                for(var i = 0 ;i<result.length;i++){
                    delete result[i].url;
                    result[i].open = true;
                }
                var nodes = zNodes1.concat(result);
                $.fn.zTree.init($("#tree-1"), setting1, nodes);
            },
            error : function(a){
                top.Dialog.alert("访问服务器端出错！");
            },
            dataType : 'json'
        });
    }

    //选择结果
    function getSelectValue(){

        //获取zTree对象
        var zTree = $.fn.zTree.getZTreeObj("tree-1");
        //得到选中的数据集
        var checkedNodes = zTree.getCheckedNodes(true);
        //得到未选中的数据集
        var checkedNodes2 = zTree.getCheckedNodes(false);

        var msg = "";
        var msg2 = "";

        for(var i = 0; checkedNodes.length > i ; i++){
            msg += "," + checkedNodes[i].id;
        }
        if(msg == ""){
            msg = "无选择";
        }else{
            msg = msg.substring(1);
        }

        for(var j = 0;checkedNodes2.length > j; j++){
            msg2 = msg2 + "," + checkedNodes2[j].id;
        }
        if(msg2 == ""){
            msg2 = "无选择";
        }else{
            msg2 = msg2.substring(1);
        }

//        top.Dialog.alert("已选中:<br/>"+msg+"<br/>未选中：<br/>"+msg2);
//        top.Dialog.close()

    }

    function onSubmitHandler() {
        //获取zTree对象
        var zTree = $.fn.zTree.getZTreeObj("tree-1");
        //得到选中的数据集
        var checkedNodes = zTree.getCheckedNodes(true);

        var msg = "";

        for(var i = 0; checkedNodes.length > i ; i++){
            if(checkedNodes[i].id != "0") {
                msg += "," + checkedNodes[i].id;
            }
        }
        if(msg != ""){
            msg = msg.substring(1);
        }

        var roleId = $("#roleId").val();
        $.post("<%=request.getContextPath()%>/role/addRoleMenu", { "roleId":roleId,"checkedArray": msg },
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

    var fixObjHeight=90;
    function customHeightSet(contentHeight){
        $("#scrollContent").height(contentHeight-fixObjHeight);
    }

</script>
</html>
