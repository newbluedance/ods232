<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
<link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->
<!-- 树型抽屉导航start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/nav/treeAccordion_normal.js"></script>
<!-- 树型抽屉导航end -->
<style>
	.ztree li span.zbutton.diy01_ico_open, .ztree li span.zbutton.diy01_ico_close{width:24px!important;height:24px!important;padding-top:0;}
	.ztree li span.zbutton.ico_open{margin-right:2px; background-position:-127px -80px; vertical-align:top; *vertical-align:middle}
	.ztree li span.zbutton.ico_close{margin-right:2px; background-position:-127px -64px; vertical-align:top; *vertical-align:middle}
</style>
<script type="text/javascript">
    function initComplete() {
        $.post('<%=request.getContextPath()%>/user/queryMenus', {}, function (result) {
            var zNodes = result;
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo")
        }, "json");
        showContent();
    }
    var fixedObj=60;
	function customHeightSet(contentHeight){
		$("#scrollContent").height(contentHeight-fixedObj);
	}
</script>
</head>
<body leftFrame="true">
<div class="padding_top5 ali02" style="height:55px; display: none">
<table width="100%">
	<tr>
		<td width="85%" class="ali03"><input type="text" id="searchKey" value=""/></td>
		<td><span class="img_find hand" title="点击查找节点" keepDefaultStyle="true" onclick="findNode()"></span></td>
	</tr>
	<tr>
		<td colspan="2" class="ali02"><a onclick="showAll()">全部展开</a>&nbsp;&nbsp;<a onclick="hideAll()">全部收缩</a></td>
	</tr>
</table>
</div>
<div id="scrollContent" style="overflow-x:hidden;">
	<div>
		<ul id="treeDemo" class="ztree ztree_accordition"></ul>
	</div>
</div>
</body>
</html>