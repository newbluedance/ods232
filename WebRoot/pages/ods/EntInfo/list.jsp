<%--
  Created by IntelliJ IDEA.
  User: m
  Date: 2014/7/9
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>企业信息统计</title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->

    <!--数据表格start-->
    <script src="<%=request.getContextPath()%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
    <!--数据表格end-->

    <!--表单异步提交start-->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!--表单异步提交end-->

    <style>
        .btn_bgbg{ border:none;font-size:18px;height:32px;
            background: url("<%=request.getContextPath()%>/system/flatBlue_accordion/skin/btn_bgbg.jpg") repeat-x;
        }
    </style>
</head>
<body>
<div class="box2" panelTitle="企业信息" id="searchPanel">
    <form action="<%=request.getContextPath()%>/entInfo/queryList" id="queryForm" method="post">
        <table>
            <tr>
                <td align="right">企业注册编码：</td>
                <td>
                    <label for="searchInput"><input type="text" id="searchInput" name="entRegCode" /></label>
                    <label><input type="text" style="width:2px;display:none;"/></label>
                </td>
                <td align="right">企业中文名称：</td>
                <td>
                    <label for="searchState"><input type="text" id="searchState" name="entCname" /></label>
                    <label><input type="text" style="width:2px;display:none;"/></label>
                </td>
                <td align="right">法人：</td>
              	<td>
                    <label for="searchNation"><input type="text" name="legalPerson" /></label>
                    <label><input type="text" style="width:2px;display:none;"/></label>
                </td>
              
                <td ><button type="button" onclick="searchHandler()"><span class="icon_find">查询</span></button></td>
                <td ><button type="button" onclick="resetSearch()"><span class="icon_reload">重置</span></button></td>
            </tr>
            <tr>
            <td align="left">是否黑名单：</td>
                <td>
                  <select name="blacklistFlag">
                  <option value="" selected="selected">---请选择---</option>
                  <option value="Y">是 </option>
                  <option value="N">否 </option>
                  </select> 
                </td>
                <td align="left">是否停用：</td>
                <td>
                <select name="closeFlag">
                  <option value="" selected="selected">---请选择---</option>
                  <option value="Y">是 </option>
                  <option value="N">否 </option>
                 </select>
                </td>
              
            </tr>

        </table>
    </form>
</div>

<div class="padding_right5">
    <div id="dataBasic"></div>
</div>

<script type="text/javascript">
    //设定不可编辑的节点id
    var noeditArray = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"];


    //grid
    var grid = null;

    function initComplete(){
        //当提交表单刷新本页面时关闭弹窗
        top.Dialog.close();

        grid = $("#dataBasic").quiGrid({
            columns:[
                { display: '企业注册编码', name: 'entRegCode',     align: 'center', width: "10%"},
                { display: '企业中文名称', name: 'entCname', 	 align: 'center', width: "20%"},
                { display: '法人', name: 'legalPerson', 	 align: 'center', width: "12%" ,type: 'legalPerson'},
                { display: '联系方式', name: 'telephone', 	 align: 'center', width: "18%" ,type: 'telephone'},
                { display: '是否黑名单', name: 'blacklistFlag', 	 align: 'center', width: "8%" ,type: 'telephone'
                ,render:function(value){
                if(value.blacklistFlag=='Y')
                return("是");
                else return("否");
                }
                
                },
                { display: '是否停用', name: 'closeFlag', 	 align: 'center', width: "10%" ,type: 'telephone' ,
                render:function(value){
                if(value.closeFlag=='Y')
                return("是");
                else return("否");}},
                { display: '注册时间', name: 'regDate', 	 align: 'center', width: "10%" ,type: 'regDate',
                   render:function(value){
	            		if (null != value.regDate&& value.regDate != ""){
	            			if(value.regDate instanceof Date){
								return new Date(value.regDate).format("yyyy-MM-dd");
							}else{
								return value.regDate.substr(0, 10);
							}
	            		}else{
	            			return '<span style="color:red">--</span>';
	            		}
					}},
                { display: '操作', isAllowHide: false, align: 'center', width:"12%",
                    render: function (rowdata, rowindex, value, column){
		                  return '<div class="padding_top4 padding_left5">'
		                + '<input type="button" style="width:45px;" value="查看" class="button2" onclick="onView(\'' + rowdata.entRegCode + '\')" />'
		                + '<input type="button" style="width:45px;" value="报检信息" class="button2" onclick="onViewDecl(\'' + rowdata.entRegCode + '\')" />'
		                + '</div>';
		                
	                }
                }
            ],
            url: '<%=request.getContextPath()%>/entInfo/queryList',rownumbers:true,checkbox:false,
            height: '100%', width:"100%",pageSize:10,percentWidthMode:true,
        });
        

        //监听查询框的回车事件
        $("#searchInput").keydown(function(event){
            if(event.keyCode==13){
                searchHandler();
            }
        })
        $("#searchState").keydown(function(event){
            if(event.keyCode==13){
                searchHandler();
            }
        })

        $("#searchPanel").bind("stateChange",function(e,state){
            grid.resetHeight();
        });
    }

    //新增
    function addUnit() {
        top.Dialog.open({
        URL: "<%=request.getContextPath()%>/bl/toadd",
        Title: "新增",
        Width: 960,
        Height: 560
        });
    }

    //查看
    function onView(rowid){
        top.Dialog.open({
        URL: "<%=request.getContextPath()%>/entInfo/see?entRegCode=" + rowid,
        Title: "查看",
        Width: 960,
        Height: 560
        });
    }
     //查看
    function onViewDecl(rowid){
        top.Dialog.open({
        URL: "<%=request.getContextPath()%>/entInfo/seeDecl?entRegCode=" + rowid,
        Title: "查看报检信息",
        Width: 960,
        Height: 560
        });
    }
    

    //修改
    function onEdit(rowid){
        top.Dialog.open({
        URL: "<%=request.getContextPath()%>/bl/toUpdate?holdBackNo=" + rowid,
        Title: "修改",
        Width: 960,
        Height: 560
        });
    }
    //删除
    function onDelete(rowid){
        top.Dialog.confirm("确定要删除该记录吗？",function(){
            //删除记录
            $.post("<%=request.getContextPath()%>/mail/deleteMail",{"mailId":rowid},
                    function(result){
                        handleResult(result.status);
                    },"json");
            //刷新表格
            grid.loadData();
        });
    }
     //打印
    function onPrint(rowid){
        top.Dialog.open({
            URL: "<%=request.getContextPath()%>/bl/print?holdBackNo="+rowid,
            Title: "打印",
            Width: 1000,
            Height: 600
        });
    }


    //批量删除
    function deleteUnit() {
        var rows = grid.getSelectedRows();
        var rowsLength = rows.length;

        if(rowsLength == 0) {
            top.Dialog.alert("请选中要删除的记录!");
            return;
        }
        top.Dialog.confirm("确定要删除吗？",function(){
            $.post("<%=request.getContextPath()%>/mail/delete",
                    //获取所有选中行
                    getSelectId(grid),
                    function(result){
                        handleResult(result);
                    },
                    "json");
        });
    }
    //删除后的提示
    function handleResult(result){
        if(result == 1){
            top.Dialog.alert("删除成功！",null,null,null,1);
            grid.loadData();
        }else{
            top.Dialog.alert("删除失败！");
        }
    }

    //获取所有选中行获取选中行的id 格式为 ids=1&ids=2
    function getSelectId(grid) {
        var selectedRows = grid.getSelectedRows();
        var selectedRowsLength = selectedRows.length;
        var ids = "";

        for(var i = 0;i<selectedRowsLength;i++) {
            ids += selectedRows[i].placardId + ",";
        }
        return {"ids":ids};
    }


    //查询
    function searchHandler(){
        var query = $("#queryForm").formToArray();
        grid.setOptions({ params : query});
        //页号重置为1
        grid.setNewPage(1);
        grid.loadData();//加载数据
    }

    //重置查询
    function resetSearch(){
        $("#queryForm")[0].reset();
        $('#search').click();
    }

    //刷新表格数据并重置排序和页数
    function refresh(isUpdate){
        if(!isUpdate){
            //重置排序
            grid.options.sortName='F_CHECK_DATE';
            grid.options.sortOrder="desc";
            //页号重置为1
            grid.setNewPage(1);
        }

        grid.loadData();
    }

</script>
</body>
</html>