<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <!--修正IE6不支持PNG图start-->
    <style>
        img {
            behavior:url("/qui/libs/js/method/pngFix/pngbehavior.htc");
        }
    </style>
    <!--修正IE6不支持PNG图end-->

</head>
<body>
<table width="100%">
    <tr>
        <td class="ver01" width="35%">
            <div id="scrollContent" class="box1">
                <div>
                    <ul id="tree-1" class="ztree"></ul>
                </div>
            </div>
        </td>
        <td width="5%"></td>
        <td class="ver01" width="60%">
            <div class="box1">
                <table class="tableStyle" formMode="line">
                    <tr>
                        <td>选中节点：</td>
                        <td>
                            <input type="hidden" style="width:300px;" id="deptId"/><!-- deptName -->
                            <input type="text" style="width:300px;" id="selectNode"/><!-- deptName -->
                        </td>
                    </tr>
                    <tr>
                        <td>部门编号：</td>
                        <td>
                            <input type="text" style="width:300px;" id="selectNodeid"/><!-- deptNo -->
                        </td>
                    </tr>
                    <tr>
                        <td>部门地址：</td>
                        <td><input type="text" style="width:300px;" id="nodeAddr"/></td><!-- deptAddr -->
                    </tr>
                    <%--<tr>--%>
                        <%--<td>部门电话：</td>--%>
                        <%--<td><input type="text" style="width:300px;" id="nodeTel"/></td><!-- deptTel -->--%>
                    <%--</tr>--%>
                    <tr>
                        <td>部门邮编：</td>
                        <td><input type="text" style="width:300px;" id="nodePostcode"/></td><!-- deptPostCode -->
                    </tr>
                    <%--<tr>--%>
                        <%--<td>部门传真：</td>--%>
                        <%--<td><input type="text" style="width:300px;" id="nodeFax"/></td><!-- deptFax -->--%>
                    <%--</tr>--%>
                    <tr>
                        <td>排序字段：</td>
                        <td><input type="text" style="width:300px;" id="nodeSort"/></td><!-- deptSort -->
                    </tr>
                    <tr>
                        <td>部门属性：</td>
                        <td>
                            <select editable="true" style="width:300px;" autoWidth="true" id="nodeLeader">
                                <option value="001">普通部门</option>
                                <option value="002">领导部门</option>
                            </select>
                        </td><!-- leaderGroup -->
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
        showRenameBtn: false,
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
    { id:0, parentId:-1, name:"部门管理",open:true,icon:"<%=request.getContextPath()%>/libs/icons/home.gif"}
];

var oldcode = "";

//初始化函数
function initComplete(){
    //$.fn.zTree.init($("#tree-1"), setting1, zNodes1);
    //初始化树
    getDeptTreeData();

    //监听按钮点击事件
    $("#btn_update").click(function(){

        $.post("<%=request.getContextPath()%>/dept/queryHave",
                {
                "deptCode" : $("#selectNodeid").val()
                },
                function(data){
                    if(data.result=="empty")
                    {

                        var deptId = $("#deptId").val();
                        var deptCode = $("#selectNodeid").val();

                        var deptName = $("#selectNode").val();
                        var address = $("#nodeAddr").val();
                        var zipCode = $("#nodePostcode").val();
                        var sortIndex = $("#nodeSort").val();
                        var nodeLeader = $("#nodeLeader").val();
                        var nodes = getTree();
                        //var node = nodes.getNodeByTId(deptId);
                        var node = nodes.getNodeByParam("id", deptCode, null);
//        alert(node.parentId);
                        //此处进行ajax后台数据处理
                        $.post("<%=request.getContextPath()%>/dept/modify",
                                {
                                    "deptId" : deptId,
                                    "deptCode" : deptCode,
                                    "deptName" : deptName,
                                    "address" : address,
                                    "zipCode" : zipCode,
                                    "sortIndex" : sortIndex,
                                    "deptType" : nodeLeader
                                },
                                function(data){
////                    var data=eval("("+dept+")"); //由JSON字符串转换为JSON对象
                                    dept = data.dept;
                                    if(dept != null && dept.deptId != null && dept.deptId != ""){
                                        var treeNode = getTree().getNodeByParam("id", oldcode, null);
//                        alert(oldcode);
                                        treeNode.id = dept.deptCode;
                                        treeNode.name = dept.deptName;
                                        treeNode.addr = dept.address;
                                        treeNode.zipCode = dept.zipCode;
                                        treeNode.sort = dept.sortIndex;
                                        treeNode.deptType = dept.deptType;
//                        console.log(treeNode);
                                        getTree().updateNode(treeNode, false);
                                        setForm(dept.deptName,dept.deptCode,dept.address,dept.zipCode,dept.sortIndex,dept.deptType);
                                        oldcode = deptCode;
                                        top.Dialog.alert("修改节点信息成功！");
                                    }else{
                                        top.Dialog.alert("修改节点信息失败！");
                                    }
                                });
                    }else
                    if(data.result=="have")
                    {
                        $("#selectNodeid").val(oldcode);
                        return  top.Dialog.alert("部门编号重复，修改编号不成功。编号："+oldcode+"可用");
                    }
                });

    });

}

//获取数据初始化树
function getDeptTreeData(){
    $.ajax({
        type : 'POST',
        url : '<%=request.getContextPath()%>/dept/query',
        data : null,
        success : function(result){
//            console.log(result);
            var nodes = zNodes1.concat(result);
//            console.log(nodes);
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
//    setForm(treeNode.name,treeNode.no,treeNode.addr,treeNode.tel,treeNode.postcode,treeNode.fax,treeNode.sort,treeNode.leader);
    setForm(treeNode.name,treeNode.no,treeNode.addr,treeNode.mailPath,treeNode.sort,treeNode.menuType);
    $("#selectNodeid").val(treeNode.id);
    $("#deptId").val(treeNode.deptId);
    oldcode = treeNode.id;
    //setForm(treeNode.name,"","",);
}

//不允许拖拽
function beforeDrag1(treeId, treeNodes) {
    return false;
}

//确认是否进入编辑状态
function beforeEditName1(treeId, treeNode) {
    if(treeNode.id=="0"){
        top.Dialog.alert("该节点不能修改！");
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
    setForm(treeNode.name,treeNode.no,treeNode.addr,treeNode.tel,treeNode.postcode,treeNode.fax,treeNode.sort,treeNode.leader);
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
    //console.log(treeNode);
    if(treeNode.existed){
        updateNode(treeNode);
    }else{
        addNode(treeNode);
    }

}

//添加节点
function addNode(treeNode){
    //设置表单的值
    setForm(treeNode.name,"","","","1","001");
    var nodes = getTree();
//    alert(treeNode.getParentNode().id);
    //尝试使用弹出框的形式添加

    //此处进行ajax后台数据处理
    $.post("<%=request.getContextPath()%>/dept/createDept.action",		//数据提交的地址
            {
                "deptName" : treeNode.name,
                "deptParentId" : treeNode.getParentNode().id,
                "sortIndex" : nodes.getNodeIndex(treeNode),
                "deptType" : "001"
            },				//提交的数据
            function(data){									//回调函数
//                var data=eval("("+dept+")"); //由JSON字符串转换为JSON对象
                dept = data.dept;
                if(dept != null && dept.deptCode != null && dept.deptCode != ""){
                    $("#selectNodeid").val(dept.deptCode);
                    treeNode.id = dept.deptCode;
                    treeNode.name = dept.deptName;
                    treeNode.sortIndex = dept.sortIndex;
                    treeNode.existed = true;
                    getTree().updateNode(treeNode, false);
                }else{
                    getTree().removeNode(treeNode, false);
                    setForm("","","","","","","","0");
                    top.Dialog.alert("创建失败！");
                }
            });												//预期返回的数据类型
}

//修改节点名称
function updateNode(treeNode){
    var nodes = getTree();
    //此处进行ajax后台数据处理
    $.post("<%=request.getContextPath()%>/modifyDept.action",		//数据提交的地址
            {
                "dept.deptCode" : treeNode.id,
                "dept.deptName" : treeNode.name,
                "dept.deptAddr" : treeNode.addr,
                "dept.deptPostcode" : treeNode.postcode,
                "dept.deptTel" : treeNode.tel,
                "dept.deptFax" : treeNode.fax,
                "dept.deptSort" : treeNode.sort,
                "dept.deptParentId" : treeNode.getParentNode().id,
                "dept.leaderGroup" : treeNode.leader,
                "dept.deptNo" : treeNode.no
            },
            function(dept){									//回调函数
                var data=eval("("+dept+")"); //由JSON字符串转换为JSON对象
                dept = data.dept;
                if(dept != null && dept.deptCode != null && dept.deptCode != ""){
                    treeNode.id = dept.deptCode;
                    treeNode.name = dept.deptName;
                    treeNode.leader = dept.leaderGroup;
                    setForm(treeNode.name,treeNode.no,treeNode.addr,treeNode.tel,treeNode.postcode,treeNode.fax,treeNode.sort,treeNode.leader);
                    getTree().updateNode(treeNode, false);
                    top.Dialog.alert("修改成功！");
                }else{
                    setForm("","","","","","","","0");
                    top.Dialog.alert("修改失败！");
                }
            });												//预期返回的数据类型
}


//确认是否删除+删除处理
function beforeRemove1(treeId, treeNode) {
//    console.log(treeNode);
//    alert(treeNode.deptId);
//    if(treeNode.id=="0"||treeNode.no=="3201"){
//        top.Dialog.alert("该节点不能删除！");
//        return false;
//    }
    //else if(getPosition(treeNode.id,noeditArray)!=-1){
    //	top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
    //	return false;
    //}
    //var zTree = $.fn.zTree.getZTreeObj("tree-1");
    var zTree = getTree();
    //选中该节点
    zTree.selectNode(treeNode);
    top.Dialog.confirm("确认删除 部门 -- " + treeNode.name + " 吗？",function()
    {
        //zTree.removeNode(treeNode);
        //此处进行ajax后台数据处理
        $.post("<%=request.getContextPath()%>/dept/deleteDept.action",
                {"deptId" : treeNode.deptId},
                function(result){
//                    if(result.trim() == '1'){
                        zTree.removeNode(treeNode);
                        //设置表单的值
                        setForm("","","","","","","","0");
//                    }else{
//                        top.Dialog.alert("删除节点失败！");
//                    }
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

                $("#selectNodeid").val("");
                $("#deptId").val("");

                setForm(newNode[0].name,"","","","","0");
            }
            return false;
        });
    }
};

function removeHoverDom(treeId, treeNode) {
    $("#addBtn_" + treeNode.id).unbind().remove();
};

function setForm(val1,val2,val3,val4,val5,val6){
    $("#selectNode").val(val1 == 'null' ? '' : val1);
    $("#nodeNo").val(val2 == 'null' ? '' : val2);
    $("#nodeAddr").val(val3 == 'null' ? '' : val3);
//    $("#nodeTel").val(val4 == 'null' ? '' : val4);
    $("#nodePostcode").val(val4 == 'null' ? '' : val4);
//    $("#nodeFax").val(val6 == 'null' ? '' : val6);
    $("#nodeSort").val(val5 == 'null' ? '' : val5);
    $("#nodeLeader").val(val6 == 'null' ? '' : val6);
    $("#nodeLeader").render();
}

</script>

</body>
</html>