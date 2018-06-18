<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/" scrollerY="false"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->

    <!-- 树型抽屉导航start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.js"></script>
    <link href="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/nav/treeAccordion_normal.js"></script>
    <!-- 树型抽屉导航end -->
    <style>
        .ztree li span.zbutton.diy01_ico_open, .ztree li span.zbutton.diy01_ico_close, .ztree li span.zbutton.diy01_ico_docu {
            width: 19px !important;
            height: 27px !important;
            padding-top: 0;
        }
    </style>
    <script type="text/javascript">
        var zNodes = [
            { id: 3001, parentId: 0, name: "援外管理", iconOpen: "skin/titlebar_arrow_up.png", iconClose: "skin/titlebar_arrow_down.png", icon: "skin/titlebar_arrow_right.png", iconSkin: "diy01"},
            { id: 101, parentId: 3001, name: "一览表申请", url: "<%=request.getContextPath()%>/cfa/toGatherEntList", target: "frmright", iconOpen: "<%=request.getContextPath()%>/libs/icons/tree_close.gif", iconClose: "<%=request.getContextPath()%>/libs/icons/tree_open.gif", icon: "skin/titlebar_arrow.gif"},
            <%--{ id: 102, parentId: 3001, name: "现场查验", url: "<%=request.getContextPath()%>/cfa/toApplyList", target: "frmright", iconOpen: "<%=request.getContextPath()%>/libs/icons/tree_close.gif", iconClose: "<%=request.getContextPath()%>/libs/icons/tree_open.gif", icon: "skin/titlebar_arrow.gif"},--%>
            <%--{ id: 103, parentId: 3001, name: "口岸查验", url: "<%=request.getContextPath()%>/cfa/toApplySwopList", target: "frmright", iconOpen: "<%=request.getContextPath()%>/libs/icons/tree_close.gif", iconClose: "<%=request.getContextPath()%>/libs/icons/tree_open.gif", icon: "skin/titlebar_arrow.gif"},--%>
            { id: 103, parentId: 3001, name: "查验申请", url: "<%=request.getContextPath()%>/cfa/toApplySwopList", target: "frmright", iconOpen: "<%=request.getContextPath()%>/libs/icons/tree_close.gif", iconClose: "<%=request.getContextPath()%>/libs/icons/tree_open.gif", icon: "skin/titlebar_arrow.gif"},
            { id: 104, parentId: 3001, name: "修改密码", url: "<%=request.getContextPath()%>/ent/toUpdatePassword", target: "frmright", iconOpen: "<%=request.getContextPath()%>/libs/icons/tree_close.gif", iconClose: "<%=request.getContextPath()%>/libs/icons/tree_open.gif", icon: "skin/titlebar_arrow.gif"}
        ];
    </script>
</head>

<body leftFrame="true">
<div>
    <ul id="treeDemo" class="ztree ztree_accordition"></ul>
</div>
</body>
</html>