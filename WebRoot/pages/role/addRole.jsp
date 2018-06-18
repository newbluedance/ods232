<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2014/7/1
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->

    <!-- 表单验证start -->
    <script src="<%=request.getContextPath()%>/libs/js/form/validationRule.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/libs/js/form/validation.js" type="text/javascript"></script>
    <!-- 表单验证end -->

    <!-- 表单异步提交start -->
    <script src="<%=request.getContextPath()%>/libs/js/form/form.js" type="text/javascript"></script>
    <!-- 表单异步提交end -->

</head>
<body>
<div class="box1" id="formContent" whiteBg="true">
    <form action="<%=request.getContextPath()%>/role/add" id="createForm" method="post">
        <table class="tableStyle" formMode="transparent">
            <tr>
                <td width="150">角色名：</td>
                <td><input type="text" id="roleName" name="roleName" class="validate[required]"/><span
                        class="star">*</span></td>
            </tr>
            <tr>
                <td>角色描述：</td>
                <td><input type="text" id="roleDesc" name="roleDesc" class="validate[required]"/><span
                        class="star">*</span></td>
            </tr>
            <%--<tr>
                <td>所属项目：</td>
                <td><input type="text" id="projectId" name="projectId" class="validate[required]"/><span class="star">*</span></td>
            </tr>--%>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交" />
                    <input type="button" value="取消" onclick='top.Dialog.close();'/>
                </td>
            </tr>
        </table>
    </form>
</div>

<script type="text/javascript">

    function initComplete() {
        //表单异步提交处理
        $('#createForm').submit(function () {
            //判断表单的客户端验证时候通过
            //var valid = $("#createUser").validationEngine('validate');
            var valid = $('#createForm').validationEngine({returnIsValid: true});
            if (valid) {
                $(this).ajaxSubmit({
                    dataType: "json",
                    //表单提交成功后的回调
                    success: function (responseText, statusText, xhr, $form) {
                        //console.log(responseText)
                        var status = responseText.status;
                        top.Dialog.alert(responseText.msg, function () {

                            if (status) {
                                //刷新数据
                                //parent.window.location.reload();
                                top.frmright.refresh(status);

                                //关闭窗口
                                top.Dialog.close();
                            } else {

                            }

                        });
                    }
                });
            }

            //阻止表单默认提交事件
            return false;
        });
    }
</script>
</body>
</html>