<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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

    <!--修正IE6不支持PNG图start-->
    <style>
        img {
            behavior:url("<%=request.getContextPath()%>/libs/js/method/pngFix/pngbehavior.htc");
        }
    </style>
    <!--修正IE6不支持PNG图end-->

    <!--动画方式入场效果start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/pic/jomino.js"></script>
    <script>
        $(function(){
            $(".navIcon").jomino();
        });
        function customHeightSet(contentHeight){
            $("#scrollContent").height(contentHeight);
        }
    </script>
    <!--动画方式入场效果end-->
</head>
<body>
<img width="100%" height="100%" src="skin/welcom.jpg">
</body>
</html>