<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2014/6/30
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title></title>

    <%@include file="/pages/INC_HEAD.jsp"%>

    <!-- 树组件start -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.js"></script>
    <link href="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
    <!-- 树组件 end -->

</head>
<body>
<table width="100%">
    <tr>
        <td class="ver01" width="40%">
            <div id="scrollContent" class="box1">
                <div>
                    <ul id="tree-1" class="ztree"></ul>
                </div>
            </div>
        </td>
        <td class="ver01" width="60%">
            <div class="box1">
                <table class="tableStyle" formMode="line">
                    <tr>
                        <td>选中节点：</td>
                        <td>
                            <input type="text" style="width:300px;" id="selectNode"/>
                            <input type="hidden" id="selectNodeid"/>
                        </td>
                    </tr>
                    <tr>
                        <td>功能描述：</td>
                        <td><input type="text" style="width:300px;" id="nodeDes"/></td>
                    </tr>
                    <tr>
                        <td>链接地址：</td>
                        <td><input type="text" style="width:300px;" id="nodeUrl"/></td>
                    </tr>
                    <tr>
                        <td>图标路径：</td>
                        <td><input type="text" style="width:300px;" id="nodeIcon"/></td>
                    </tr>
                    <tr>
                        <td>同级排序：</td>
                        <td><input type="text" style="width:300px;" id="nodeOrder"/></td>
                    </tr>
                    <tr>
                        <td>链接target：</td>
                        <td><select editable="true" style="width:300px;" autoWidth="true" id="nodeTarget"><option>frmright</option><option>_blank</option><option>_self</option><option>_top</option><option>_parent</option></select></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="button" id="btn_update" value="确定"/>
                            <input type="button" value="取消"/>
                        </td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
</table>

<script type="text/javascript">
var fixedObj=10;

function customHeightSet(contentHeight){
    $("#scrollContent").height(contentHeight-fixedObj);
}

var setting1 = {
    view: {
        addHoverDom: addHoverDom,
        removeHoverDom: removeHoverDom,
        selectedMulti: false
    },
    edit: {
        enable: true,
        renameTitle:"修改",
        removeTitle:"删除"
    },
    callback: {
        onClick: onClick1,
        //不允许拖拽
        beforeDrag: beforeDrag1,
        //修改前确认
        beforeEditName: beforeEditName1,
        //修改完时的处理
        beforeRename: beforeRename1,
        //修改成功后处理
        onRename: onRename1,
        //删除前确认
        beforeRemove: beforeRemove1
    }
};
var zNodes1 =[
    { id:0, parentId:-1, name:"系统导航菜单",open:true,icon:"<%=request.getContextPath()%>/libs/icons/list.gif"}
];

//初始化函数
function initComplete(){
    //$.fn.zTree.init($("#tree-1"), setting1, zNodes1);
    //初始化树
    getMenuTreeData();

    //监听按钮点击事件
    $("#btn_update").click(function(){
        var menuId = $("#selectNodeid").val();
        var menuName = $("#selectNode").val();
        var menuDesc = $("#nodeDes").val();
        var menuUrl = $("#nodeUrl").val();
        var menuIcon = $("#nodeIcon").val();
        var menuOrder = $("#nodeOrder").val();
        var menuTarget = $("#nodeTarget").val();
        var nodes = getTree();
        //var node = nodes.getNodeByTId(menuId);
        var node = nodes.getNodeByParam("id", menuId, null);

        //此处进行ajax后台数据处理
        $.post("<%=request.getContextPath()%>/menu/modify",
                {
                    "menuId" : menuId,
                    "menuName" : menuName,
                    "menuParentId" : node.getParentNode().id,
                    "menuLevel" : node.level,
                    "menuOrder" : menuOrder,
                    "menuTarget" : menuTarget,
                    "projectId" : "1",
                    "menuIcon" : menuIcon,
                    "menuDesc" : menuDesc,
                    "menuUrl" : menuUrl
                },
                function(menu){
                    if(menu != null && menu.menuId != null && menu.menuId != ""){
                        var treeNode = getTree().getNodeByParam("id", menuId, null);
                        treeNode.id = menu.menuId;
                        treeNode.name = menu.menuName;
                        treeNode.desc = menu.menuDesc;
                        treeNode.url = menu.menuUrl;
                        treeNode.icon = menu.menuIcon;
                        treeNode.order = menu.menuOrder;
                        treeNode.target = menu.menuTarget;
                        getTree().updateNode(treeNode, false);
                        setForm(treeNode.name,treeNode.desc,treeNode.url,treeNode.icon,treeNode.order,treeNode.target);
                        top.Dialog.alert("修改节点信息成功！");
                    }else{
                        top.Dialog.alert("修改节点信息失败！");
                    }
                });
    });

}

//获取数据初始化树
function getMenuTreeData(){
    $.ajax({
        type : 'POST',
        url : '<%=request.getContextPath()%>/menu/query',
        data : null,
        success : function(result){
            var nodes = zNodes1.concat(result);
            $.fn.zTree.init($("#tree-1"), setting1, nodes);
        },
        error : function(a){
            top.Dialog.alert("访问服务器端出错！");
        },
        dataType : 'json'
    });
}

//获取树对象
function getTree(){
    return $.fn.zTree.getZTreeObj("tree-1");
}

//点击树节点
function onClick1(event, treeId, treeNode, clickFlag){
    //设置表单的值
    //setForm(treeNode.name,treeNode.desc,treeNode.manager,treeNode.phone);
    setForm(treeNode.name,treeNode.desc,treeNode.url,treeNode.icon,treeNode.order,"frmright");
    $("#selectNodeid").val(treeNode.id);

    //setForm(treeNode.name,"","",);
}

//不允许拖拽
function beforeDrag1(treeId, treeNodes) {
    return false;
}

//确认是否进入编辑状态
function beforeEditName1(treeId, treeNode) {
    if(treeNode.id=="0"){
        top.Dialog.alert("根节点不能修改！");
        return false;
    }
    //else if(getPosition(treeNode.id,noeditArray)!=-1){
    //	top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
    //	return false;
    //}
    var zTree = getTree();
    //var zTree = $.fn.zTree.getZTreeObj("tree-1");
    //选中该节点
    zTree.selectNode(treeNode);
    //设置表单的值
    //setForm(treeNode.name,"","","frmright");
    setForm(treeNode.name,treeNode.desc,treeNode.url,treeNode.icon,treeNode.order,"frmright");
    zTree.editName(treeNode);
    return true;
}

//修改完时处理 不进行后台数据处理
function beforeRename1(treeId, treeNode, newName) {
    if (newName.length == 0) {
        top.Dialog.alert("节点名称不能为空.");
        var zTree = getTree();
        setTimeout(function(){zTree.editName(treeNode)}, 10);
        return false;
    }
    return true;
}
//修改成功后处理
function onRename1(event, treeId, treeNode) {
    //设置表单的值
    //setForm(treeNode.name,"","","frmright");
    //此处进行ajax后台数据处理
    console.log(treeNode);
    if(treeNode.existed){
        updateNode(treeNode);
    }else{
        addNode(treeNode);
    }

}

//添加节点
function addNode(treeNode){
    //设置表单的值
    setForm(treeNode.name,"","","","","frmright");
    var nodes = getTree();
    //尝试使用弹出框的形式添加

    //此处进行ajax后台数据处理
    $.post("<%=request.getContextPath()%>/menu/add",		//数据提交的地址
            {"menuName" : treeNode.name,
             "menuParentId" : treeNode.getParentNode().id,
             "menuLevel" : treeNode.level,
             "menuOrder" : nodes.getNodeIndex(treeNode),
             "menuTarget" : "frmright",
             "projectId" : "1",
             "menuIcon" : treeNode.icon },				//提交的数据
            function(menu){									//回调函数
                if(menu != null && menu.menuId != null && menu.menuId != ""){
                    $("#selectNodeid").val(menu.menuId);
                    treeNode.id = menu.menuId;
                    treeNode.name = menu.menuName;
                    treeNode.existed = true;
                    getTree().updateNode(treeNode, false);
                }else{
                    getTree().removeNode(treeNode, false);
                    setForm("","","","","","frmright");
                    top.Dialog.alert("创建失败！");
                }
            });												//预期返回的数据类型
}


//修改节点名称
function updateNode(treeNode){
    var nodes = getTree();
    //此处进行ajax后台数据处理
    $.post("<%=request.getContextPath()%>/menu/modify",		//数据提交的地址
            {"menuId" : treeNode.id,
                "menuName" : treeNode.name,
                "menuParentId" : treeNode.getParentNode().id,
                "menuLevel" : treeNode.level,
                "menuOrder" : nodes.getNodeIndex(treeNode),
                "menuTarget" : "frmright",
                "projectId" : "1",
                "menuIcon" : treeNode.icon,
                "menuDesc" : treeNode.desc,
                "menuUrl" : treeNode.url
            },
            function(menu){									//回调函数
                if(menu != null && menu.menuId != null && menu.menuId != ""){
                    treeNode.id = menu.menuId;
                    treeNode.name = menu.menuName;
                    setForm(treeNode.name,treeNode.desc,treeNode.url,treeNode.icon,treeNode.order,treeNode.target);
                    getTree().updateNode(treeNode, false);
                    top.Dialog.alert("修改成功！");
                }else{
                    setForm("","","","","","frmright");
                    top.Dialog.alert("修改失败！");
                }
            });												//预期返回的数据类型
}


//确认是否删除+删除处理
function beforeRemove1(treeId, treeNode) {
    if(treeNode.id=="0"){
        top.Dialog.alert("根节点不能删除！");
        return false;
    }
    //else if(getPosition(treeNode.id,noeditArray)!=-1){
    //	top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
    //	return false;
    //}
    //var zTree = $.fn.zTree.getZTreeObj("tree-1");
    var zTree = getTree();
    //选中该节点
    zTree.selectNode(treeNode);
    top.Dialog.confirm("确认删除 节点 -- " + treeNode.name + " 吗？",function()
    {
        //zTree.removeNode(treeNode);
        //此处进行ajax后台数据处理
        $.post("<%=request.getContextPath()%>/menu/delete",
                {"menuId" : treeNode.id},
                function(result){
                    console.log(result);
                    if(result == '1'){
                        zTree.removeNode(treeNode);
                        //设置表单的值
                        setForm("","","","","","frmright");
                    }else{
                        top.Dialog.alert("删除节点失败！");
                    }
                }
        );
    });
    return false;
}

//添加新增按钮
var newCount = 1;
function addHoverDom(treeId, treeNode) {
    if (treeNode.editNameFlag || $("#addBtn_" + treeNode.id).length > 0) return;

    var sObj = $("#" + treeNode.tId + "_span");
    var addStr = "<span class='zbutton add' id='addBtn_" + treeNode.id + "' title='添加' onfocus='this.blur();'></span>";
    sObj.append(addStr);

    var btn = $("#addBtn_" + treeNode.id);
    if (btn){
        btn.bind("click", function(){
            //var zTree = $.fn.zTree.getZTreeObj("tree-1");
            var zTree = getTree();
            var newNode;
            newNode = zTree.addNodes(treeNode, {id:(100 + newCount), parentId:treeNode.id, name:"新增" + (newCount++),icon:"<%=request.getContextPath()%>/libs/icons/mark.gif"});
            if (newNode) {
                zTree.editName(newNode[0]);
                //设置表单的值
                setForm(newNode[0].name,"","","","","frmright");
            }
            return false;
        });
    }
};

function removeHoverDom(treeId, treeNode) {
    $("#addBtn_" + treeNode.id).unbind().remove();
};


function setForm(val1,val2,val3,val4,val5,val6){
    //$("#selectNode").val(val1);
    //$("#nodeDes").val(val2);
    //$("#nodeUrl").val(val3);
    //$("#nodeTarget").attr("editValue",val4);
    //$("#nodeTarget").render();

    $("#selectNode").val(val1 == 'null' ? '' : val1);
    $("#nodeDes").val(val2 == 'null' ? '' : val2);
    $("#nodeUrl").val(val3 == 'null' ? '' : val3);
    $("#nodeIcon").val(val4 == 'null' ? '' : val4);
    $("#nodeOrder").val(val5 == 'null' ? '' : val5);
    $("#nodeTarget").val(val6 == 'null' ? '' : val6);
    $("#nodeTarget").render();
}

</script>

</body>
</html>