<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
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

    <!-- 日期选择框start -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/form/datePicker/WdatePicker.js"></script>
    <!-- 日期选择框end -->

    <!--数据表格start-->
    <script src="<%=request.getContextPath()%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
    <!--数据表格end-->
    <!-- 表单start -->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!-- 表单end -->
    <style>
        .btn_bgbg{ border:none;font-size:18px;height:32px;
            background: url("<%=request.getContextPath()%>/system/flatBlue_accordion/skin/btn_bgbg.jpg") repeat-x;
        }
    </style>
</head>
<body>
<div id="scrollContent" class="box1" whiteBg="true">
    <form action="/user/add" method="post" id="updatePassword" target="frmright" failAlert="表单填写不正确，请按要求填写！">
        <table>
            123:${orgId}
            <tr>
                <td>分支局</td>
                <td>
                    <%--<select name="debarOne" id="one"  url="<%=request.getContextPath()%>/user/?pid=32"--%>
                            <%--selectedValue="0"--%>
                            <%--prompt="--------请选择--------"--%>
                            <%--childId="two"--%>
                            <%--childDataPath="<%=request.getContextPath()%>/mail/getDebarJson?pid=" >--%>
                    <%--</select>--%>
                </td>

                <td>部门</td>
                <%--<td> <select name="debarTwo" id="two"   prompt="--------请选择--------"  selectedValue="0"></select></td>--%>

                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>登录名称</td>
                <td><input type="text" name="loginName" /></td>

                <td>登录密码</td>
                <td><input type="text" name="loginPwd" /></td>

                <td>显示名称</td>
                <td><input type="text" name="displayName" /></td>
            </tr>

            <tr>
                <td>性别</td>
                <td><input type="text" name="sex" /></td>

                <td>电子邮箱</td>
                <td><input type="text" name="email" /></td>

                <td>身份证号</td>
                <td><input type="text" name="idCardNo" /></td>
            </tr>

            <tr>
                <td>联系电话</td>
                <td><input type="text" name="telephone" /></td>

                <td>联系电话_短号</td>
                <td><input type="text" name="telephoneShort" /></td>

                <td></td>
                <td></td>
            </tr>

            <tr>
                <td>移动电话</td>
                <td><input type="text" name="mobileNo" /></td>

                <td>移动电话_短号</td>
                <td><input type="text" name="mobileNoShort" /></td>

                <td></td>
                <td></td>
            </tr>

            <tr>
                <td></td>
                <td></td>

                <td></td>
                <td></td>

                <td></td>
                <td></td>
            </tr>

        </table>
    </form>
</div>

<script type="text/javascript">
    //初始化函数
    function initComplete() {


    }
</script>
</body>

</html>
