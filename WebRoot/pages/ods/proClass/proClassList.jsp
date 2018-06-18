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
        <td class="ver01" width="40%" rowspan="4">
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
                        <td>图标路径：</td>
                        <td><input type="text" style="width:300px;" id="nodeIcon"/></td>
                    </tr>
                    <tr>
                        <td>同级排序：</td>
                        <td><input type="text" style="width:300px;" id="nodeOrder"/></td>
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
    <tr>
        <td class="ver01" width="60%">
            <div  class="box1">
                <table id="add_field_table0" class="tableStyle" formMode="line" mode="list">
                    <tr>
                        <td>
                         <span>基础信息-扩展属性</span>   <input type="button" id="btn_add_field0" value="添加属性" onclick="addFieldInput(0)" />
                        </td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
    
    <!-- <tr>
        <td class="ver01" width="60%">
            <div  class="box1">
                <table id="add_field_table1" class="tableStyle" formMode="line" mode="list">
                    <tr>
                        <td style="text-align: left">
                         <span>监管要素扩展属性</span>   <input type="button" id="btn_add_field1" value="添加属性" onclick="addFieldInput(1)" />
                        </td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
    <tr>
        <td class="ver01" width="60%">
            <div  class="box1">
                <table id="add_field_table2" class="tableStyle" formMode="line" mode="list">
                    <tr>
                        <td>
                         <span>规范依据扩展属性</span>   <input type="button" id="btn_add_field2" value="添加属性" onclick="addFieldInput(2)" />
                        </td>
                    </tr>
                </table>
            </div>
        </td>
    </tr> -->
    
    <tr>
        <td class="ver01" width="60%">
            <div  class="box1">
                <table id="add_field_table3" class="tableStyle" formMode="line" mode="list">
                    <tr>
                        <td style="text-align: left">
                         <span>监管要素-位置分类</span>   <input type="button" id="btn_add_field3" value="添加属性" onclick="addFieldInput(3)" />
                        </td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
    <tr>
        <td class="ver01" width="60%">
            <div  class="box1">
                <table id="add_field_table4" class="tableStyle" formMode="line" mode="list">
                    <tr>
                        <td>
                         <span>规范依据-依据分类</span>   <input type="button" id="btn_add_field4" value="添加属性" onclick="addFieldInput(4)" />
                        </td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
</table>

<script type="text/javascript">
//添加一个属性填写区域
function addFieldInput(flag){
	var classId = $("#selectNodeid").val();
	 if(classId==null||classId==""){
		 alert("请选择节点");
		 return;
	 }
	var n=Number($(".field_order"+flag+":last").text())+1;
	var exc_field_node="<tr class='field_excbox' id='tr"+n+"'>"+
					        "<td><label class='field_order"+flag+"'>"+n+"</label>:"+
					            "<input type='text' id='exc_field"+n+"' value=''/>"+
					            "<input type='button' onclick='addExcField("+n+","+flag+")' value='新增'/>"+
					            "<input type='button' onclick='resetExcField("+n+","+flag+")' value='取消'/>"+
					        "</td>"+
					    "</tr>";
	$("#add_field_table"+flag).append(exc_field_node);	
	//绑定回车事件
    $('#exc_field'+n).bind('keypress',function(event){
        if(event.keyCode == "13")    
        {
            alert('你输入的内容为：');
        }
    });
					    
}
//添加属性
function addExcField(n,flag){
	 var classId = $("#selectNodeid").val();
	 if(classId==null||classId==""){
		 alert("请选择节点");
		 return;
	 }
	 var fieldKey = $("#add_field_table"+flag+" #exc_field"+n).val();
	 var cfId=$("#add_field_table"+flag+" #cfId"+n).val();
	//此处进行ajax后台数据处理
    $.post("<%=request.getContextPath()%>/proClass/addClassField",
            {
    			"cfId" : cfId,
                "classId" : classId,
                "fieldKey" : fieldKey,
                "tabId" : flag
            },
            function(classField){
            	excFieldBoxInit(classField.classId);
            }); 
}
//删除一个属性填写区域
function resetExcField(n,flag){
	$("#add_field_table"+flag+" #tr"+n).remove();
}
//删除属性
function deleteExcField(n,flag){
	var cfId=$("#add_field_table"+flag+" #cfId"+n).val();
	var classId=$("#selectNodeid").val();
	//此处进行ajax后台数据处理
    $.post("<%=request.getContextPath()%>/proClass/deleteClassField",
            {
    			"cfId" : cfId,
    			"classId" : classId
            },
            function(classField){
            	excFieldBoxInit(classField.classId);
            }); 
}


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
var zNodes1 =[];

//初始化函数
function initComplete(){
    //初始化树
    getMenuTreeData();

    //监听按钮点击事件
    $("#btn_update").click(function(){
        var classId = $("#selectNodeid").val();
        var className = $("#selectNode").val();
        var classDesc = $("#nodeDes").val();
        var classIcon = $("#nodeIcon").val();
        var priority = $("#nodeOrder").val();
        var nodes = getTree();
        var node = nodes.getNodeByParam("id", classId, null);
        var parentId=-1;
        if(node.getParentNode()!=null){
        parentId=node.getParentNode().id;
        }
        //此处进行ajax后台数据处理
        $.post("<%=request.getContextPath()%>/proClass/updateProClass",
                {
                    "classId" : classId,
                    "className" : className,
                    "parentId" : parentId,
                   "classDesc" : classDesc,
                    "classIcon" : classIcon,
                    "priority" : priority
                },
                function(menu){
                     if(menu != null && menu.classId != null && menu.classId != ""){
                        var treeNode = getTree().getNodeByParam("id", classId, null);
                        treeNode.id = menu.classId;
                        treeNode.name = menu.className;
                        treeNode.desc = menu.classDesc;
                        treeNode.icon = menu.classIcon;
                        treeNode.order = menu.priority;
                        getTree().updateNode(treeNode, false);
                        setForm(treeNode.name,treeNode.desc,treeNode.icon,treeNode.order);
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
        url : '<%=request.getContextPath()%>/proClass/proClassList',
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
    setForm(treeNode.name,treeNode.desc,treeNode.icon,treeNode.order);
    $("#selectNodeid").val(treeNode.id);
  	//初始化属性区域
  	var classId=treeNode.id;
  	excFieldBoxInit(classId);			
}
//初始化属性区域
function excFieldBoxInit(classId){
  	$(".field_excbox").remove();
     $.post("<%=request.getContextPath()%>/proClass/queryClassField",		//数据提交的地址
            {"classId" : classId
              },				//提交的数据
            function(fieldList){									//回调函数
                 for(var s in fieldList){  
                	 var field=fieldList[s];
                	 var flag=field.tabId;
                	 var n=Number($(".field_order"+flag+":last").text())+1;
                	 var exc_field_node="<tr class='field_excbox' id='tr"+n+"'>"+
				        "<td><label class='field_order"+flag+"'>"+n+"</label>:"+
				        "<input type='hidden' name='cfId' id='cfId"+n+"' value='"+field.cfId+"'/>"+
				            "<input type='text' id='exc_field"+n+"' value='"+field.fieldKey+"'/>"+
				            "<input type='button' onclick='addExcField("+n+","+flag+")' value='修改'/>"+
				            "<input type='button' onclick='deleteExcField("+n+","+flag+")' value='删除'/>"+
				        "</td>"+
				    "</tr>";
					$("#add_field_table"+flag).append(exc_field_node);	
                   }  
            });				
	
}

//不允许拖拽
function beforeDrag1(treeId, treeNodes) {
    return false;
}

//确认是否进入编辑状态
function beforeEditName1(treeId, treeNode) {
    if(treeNode==null){
        top.Dialog.alert("根节点不能修改！");
        return false;
    }
    //}
    var zTree = getTree();
    //选中该节点
    zTree.selectNode(treeNode);
    //设置表单的值
    setForm(treeNode.name,treeNode.desc,treeNode.icon,treeNode.order);
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
    setForm(treeNode.name,"","","");
    var nodes = getTree();
    //尝试使用弹出框的形式添加
    //此处进行ajax后台数据处理
    $.post("<%=request.getContextPath()%>/proClass/addProClass",		//数据提交的地址
            {"className" : treeNode.name,
             "parentId" : treeNode.getParentNode().id,
             "classLevel" : treeNode.level,
             "priority" : nodes.getNodeIndex(treeNode),
             "classIcon" : treeNode.icon},			//提交的数据
            function(proClass){									//回调函数
                 if(proClass != null && proClass.classId != null && proClass.classId != ""){
                    $("#selectNodeid").val(proClass.classId);
                    treeNode.id = proClass.classId;
                    treeNode.name = proClass.className;
                    treeNode.existed = true;
                    getTree().updateNode(treeNode, false);
                }else{
                    getTree().removeNode(treeNode, false);
                    setForm("","","","");
                    top.Dialog.alert("创建失败！");
                }  ;
            });												//预期返回的数据类型
}


//修改节点名称
function updateNode(treeNode){
    var nodes = getTree();
    //此处进行ajax后台数据处理
    $.post("<%=request.getContextPath()%>/proClass/updateProClass",		//数据提交的地址
            {"classId" : treeNode.id,
    		"className" : treeNode.name,
	        "parentId" : treeNode.getParentNode().id,
	        "classLevel" : treeNode.level,
	        "priority" : nodes.getNodeIndex(treeNode),
	        "classIcon" : treeNode.icon 
            },
            function(proClass){		
                if(proClass != null && proClass.classId != null && proClass.classId != ""){
                    treeNode.id = proClass.classId;
                    treeNode.name = proClass.className;
                    setForm(treeNode.name,treeNode.desc,treeNode.icon,treeNode.order);
                    getTree().updateNode(treeNode, false);
                    top.Dialog.alert("修改成功！");
                }else{
                    setForm("","","","");
                    top.Dialog.alert("修改失败！");
                };
            });												//预期返回的数据类型
}


//确认是否删除+删除处理
function beforeRemove1(treeId, treeNode) {
    if(treeNode.id=="0"){
        top.Dialog.alert("根节点不能删除！");
        return false;
    }
    var zTree = getTree();
    //选中该节点
    zTree.selectNode(treeNode);
    top.Dialog.confirm("确认删除节点 -- " + treeNode.name + " 吗？",function()
    {
        //zTree.removeNode(treeNode);
        //此处进行ajax后台数据处理
        $.post("<%=request.getContextPath()%>/proClass/deleteProClass",
                {"classId" : treeNode.id},
                function(result){
                    console.log(result);
                    if(result == '1'){
                        zTree.removeNode(treeNode);
                        //设置表单的值
                        setForm("","","","");
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
            var zTree = getTree();
            var newNode;
            newNode = zTree.addNodes(treeNode, {id:(100 + newCount), parentId:treeNode.id, name:"新增" + (newCount++),icon:"<%=request.getContextPath()%>/libs/icons/mark.gif"});
            if (newNode) {
                zTree.editName(newNode[0]);
                //设置表单的值
                setForm(newNode[0].name,"","","");
            }
            return false;
        });
    }
};

function removeHoverDom(treeId, treeNode) {
    $("#addBtn_" + treeNode.id).unbind().remove();
};


function setForm(val1,val2,val3,val4){

    $("#selectNode").val(val1 == 'null' ? '' : val1);
    $("#nodeDes").val(val2 == 'null' ? '' : val2);
    $("#nodeIcon").val(val3 == 'null' ? '' : val3);
    $("#nodeOrder").val(val4 == 'null' ? '' : val4);
    
    
};

</script>

</body>
</html>