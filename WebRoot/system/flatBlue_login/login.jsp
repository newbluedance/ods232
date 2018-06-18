<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>江苏检验检疫三库</title>
<link href="system/flatBlue_login/skin/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="libs/js/jquery.js"></script>
</head>
<body class="body_bg">
<div class="center">
   <div class="con">
		<form id="loginForm" name="loginForm" action="<%=request.getContextPath()%>/loginCheck"  method="post" class="login_form" style="_padding-top:60px;">
		<div class="con_r">
			<ul>
                <li><h3 class="h">用户名：</h3><input type="text" id="username" name="username" class="input_bg"/></li>
                <li><h3 class="h"><span>密</span><span class="w">码：</span></h3><input type="password" id="password" name="password" class="input_bg"/></li>
                <li class="clear"><a><input type="button" onclick="login()" value="" class="btn_bg" /></a></li>
                <li class="clear"><span id="login_info" class="f_left" style="color: red;">${error}</span></li>
            </ul>
        </div>
        </form>
    </div> 
    <div class="clear footer">
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
