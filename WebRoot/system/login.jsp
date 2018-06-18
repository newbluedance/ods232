<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>江苏检验检疫三库</title>
<link href="system/login/css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="libs/js/jquery.js"></script>
</head>

<body>
<div class="center">
	<div class="top"><img src="system/login/images/logo.jpg" /></div>
    <div class="con_l f_left"><img src="system/login/images/con_l.jpg" /></div>
    <div class="con_r f_right" >
        <form id="loginForm" name="loginForm" action="<%=request.getContextPath()%>/loginCheck"  method="post" class="login_form" style="_padding-top:60px;">
            <ul >
                    <li><h3 class="h" style="_width:56px;  float:left;font:normal 13px; line-height:40px; height:20px;_line-height:30px; font-size: 13px;">用户名：</h3><input type="text" id="username" name="username" class="input_bg"/></li>
                    <li><h3 class="h" style="width:55px;  float:left;font:normal 13px; line-height:40px; height:20px;_line-height:30px; font-size: 13px;"><span style=" width:26px; display:block; float:left;">密</span><span class="w" style=" width:17px; display:block; float:left;">码：</span></h3><input type="password" id="password" name="password" class="input_bg"/></li>
                    <%--<li><span class="f_left">验证码：<input type="text" class="input_bg2"/></span><a href="#"><img src="system/login/images/login_code.jpg" class="code f_left"/></a><a href="#" class="code_a f_left">换一张？</a></li>--%>
                    <li class="clear"><a><input type="button" onclick="login()" value="" class="btn_bg" /></a></li>
                    <li class="clear"><span id="login_info" class="f_left" style="color: red;">${error}</span></li>
            </ul>
        </form>
    </div>
    <div class="footer clear">
        <p> Copyright <span>&copy;</span> 江苏出入境检验局 版权所有 Powered by NineTowns. </p>
    </div>
</div>
<script>
    $(function(){
        document.getElementById("username").focus();
        $("#username").keydown(function(event){
            if(event.keyCode==13){
                login()
            }
        })
        $("#password").keydown(function(event){
            if(event.keyCode==13){
                login()
            }
        })

    })
	//登录
	function login() {
        var userName = $("#username").val();
        var userPassword = $("#password").val();
        if(userName=="" || userPassword==""){
            alert("用户名或密码不能为空");
            return false;
        }
        document.loginForm.submit();
	}

    //按回车键
    document.onkeydown=function(){
        if (event.keyCode == 13){
            login();
        }
    };
</script>
</body>
</html>
