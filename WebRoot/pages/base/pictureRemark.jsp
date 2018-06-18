<%--
  Created by IntelliJ IDEA.
  User: houxianghua
  Date: 14-7-10
  Time: 下午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>配餐申请</title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->
</head>
<body>
<fieldset>
    <legend></legend>
    <table class="tableStyle" formMode="transparent" footer="normal">
        <tr>
            <td width="20%">
                备注：
            </td>
            <td width="80%">
                <textarea id="remark" style="width:300px;height:60px;" autoHeight="true"></textarea>
            </td>
        </tr>
    </table>
</fieldset>
</body>
</html>