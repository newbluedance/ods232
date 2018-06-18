<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="white"/>
   <!--  <meta http-equiv="X-UA-Compatible" content="IE=9" /> -->
	<title></title>
	<!--框架必需start-->
	<link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link href="<%=request.getContextPath()%>/libs/skins/blue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="blue" positionTarget="positionContent" selInputHeight="32" selButtonWidth="35" defaultSelWidth="200" fileBtnWidth="60" defaultFileInputWidth="200" defaultGridHeaderHeight="34" defaultGridRowHeight="38" defaultFontSize="14" defaultPageSelWidth="55" defaultFilterItemHeight="32" dialogWidthFix="0" defaultSelItemHeight="32" defaultFontFamily="宋体"/>
	<link href="<%=request.getContextPath()%>/system/blue1_accordion/skin/style.css" rel="stylesheet" type="text/css" id="skin" skinPath="system/blue1_accordion/skin/"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/main.js"></script>
	<!--框架必需end-->
	<!--弹窗组件start-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/drag.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/dialog.js"></script>
	<!--弹窗组件end-->
	<!--弹出式提示框start-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/messager.js"></script>
	<!--弹出式提示框end-->
	<!--分隔条start-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/nav/spliter.js"></script>
	<!--分隔条end-->
<script>
function bookmarksite(title, url){
    if (window.sidebar) // firefox
        window.sidebar.addPanel(title, url, "");
    else 
        if (window.opera && window.print) { // opera
            var elem = document.createElement('a');
            elem.setAttribute('href', url);
            elem.setAttribute('title', title);
            elem.setAttribute('rel', 'sidebar');
            elem.click();
        }
        else 
            if (document.all)// ie
                window.external.AddFavorite(url, title);
}
function windowClose(){
	window.opener=null;
	window.open('', '_self'); //IE7必需的.
	window.close();
}
function backHome(){
	document.getElementById("frmleft").contentWindow.homeHandler();
}
//$(function(){
//	setTimeout(function(){
//		$.messager.show('通知','通知信息内容','10000','');
//	},2000);
//})
</script>
<style>
a {behavior:url(<%=request.getContextPath()%>/libs/js/method/focus.htc)}
</style>
</head>
<body>
<div id="mainFrame">
<!--头部与导航start-->
<div id="hbox">
	<div id="bs_bannercenter">
	<div id="bs_bannerright">
	<div id="bs_bannerleft">
       <!--  <div style="padding-top: 10px; width: 470px; float:right;">
			<iframe allowtransparency="true" frameborder="0" width="380" height="64" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=2&d=2&bd=0&k=&f=ffffff&q=0&e=0&a=0&c=58238&w=410&h=64&align=center"></iframe>
        </div> -->
        <div class="bs_function" style="width: 120px; padding-top: 0px;float:right;">
			<span class="icon_home hand" style="margin-bottom: 10px;" onclick='window.location="main"'>首页</span>
			<a class=" hand" style="background-image: url(<%=request.getContextPath()%>/libs/icons/docx.png);background-repeat: no-repeat;padding: 0 5px 0 18px;" href="<%=request.getContextPath()%>/odsManual.docx" target="_new">帮助</a>
            <span class="icon_exit hand" onclick='top.Dialog.confirm("确定要退出系统吗",function(){window.location="logout"});'>退出</span>
        </div>
        <%-- <div id="air"  style="display: block;z-index: 999;background: url('<%=request.getContextPath()%>/libs/images/weather_bg.gif') no-repeat;width:298px;height:55px;  margin-top: 15px; float: right; position: relative;left:380px;"></div>
        <div id="city" style="display: block;z-index: 999;background: url('<%=request.getContextPath()%>/libs/images/weather_bg.gif') no-repeat;width:70px;height:55px;margin-top: 15px; float: right; position: relative;left:380px; "></div> --%>
	</div>
	</div>
	</div>
	<div id="bs_navcenter">
	<div id="bs_navleft">
	<div id="bs_navright">
		<div class="bs_nav">
			<div class="float_left padding_top2 padding_left5 white">
				 欢迎 ${LOGIN_USER.displayName} ，今天是
				<script>
					var weekDayLabels = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
					var now = new Date();
				    var year=now.getFullYear();
					var month=now.getMonth()+1;
					var day=now.getDate();
				    var currentime = weekDayLabels[now.getDay()];
					document.write(currentime);
				</script>
			</div>		
			<div class="float_left" style="padding:2px 0 0 20px;" id="positionContent"></div>	
			<div class="float_right padding_top2 padding_right5">
				<div class="bs_navleft">
					<li class="fontTitle">字号:</li>
					<li class="fontChange"><span><a href="javascript:;" setFont="16">大</a></span></li>
					<li class="fontChange"><span><a href="javascript:;" setFont="14">中</a></span></li>
					<li class="fontChange"><span><a href="javascript:;" setFont="12">小</a></span></li>
					<div class="clear"></div>	
				</div>	
				<div class="bs_navleft" style="padding-right:10px;">
					<li class="fontTitle">字体:</li>
					<li class="fontFamily"><span><a href="javascript:;" setFont="宋体">宋</a></span></li>
					<li class="fontFamily"><span><a href="javascript:;" setFont="微软雅黑">雅</a></span></li>
					<div class="clear"></div>	
				</div>	
				<span class="icon_fullscreen hand" id="fullSrceen" hideNav="true">开启全屏</span>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	</div>
	</div>
</div>


<table width="100%" cellpadding="0" cellspacing="0" class="table_border0">
	<tr>
		<!--左侧区域start-->
		<td id="hideCon" class="ver01 ali01">
			<div id="lbox">
				<div id="lbox_topcenter">
				<div id="lbox_topleft">
				<div id="lbox_topright">
				</div>
				</div>
				</div>
				<div id="lbox_middlecenter">
				<div id="lbox_middleleft">
				<div id="lbox_middleright">
					<div id="bs_left">
						<IFRAME height="100%" width="100%"  frameBorder=0 id=frmleft name=frmleft src="<%=request.getContextPath()%>/system/blue1_accordion/left.jsp"  allowTransparency="true"></IFRAME>
					</div>
					<!--更改左侧栏的宽度需要修改id="bs_left"的样式-->
				</div>
				</div>
				</div>
				<div id="lbox_bottomcenter">
				<div id="lbox_bottomleft">
				<div id="lbox_bottomright">
					<div class="lbox_foot"></div>
				</div>
				</div>
				</div>
			</div>
		</td>
		<!--左侧区域end-->
		<!--分隔栏区域start-->
		<td class="spliter main_shutiao" targetId="hideCon" beforeClickTip="收缩面板" afterClickTip="展开面板" beforeClickClass="bs_leftArr" afterClickClass="bs_rightArr"></td>
		<!--分隔栏区域end-->
		<!--右侧区域start-->
		<td class="ali01 ver01"  width="100%">
			<div id="rbox">
				<div id="rbox_topcenter">
				<div id="rbox_topleft">
				<div id="rbox_topright">
				</div>
				</div>
				</div>
				<div id="rbox_middlecenter">
				<div id="rbox_middleleft">
				<div id="rbox_middleright">
					<div id="bs_right">
						<IFRAME height="100%" width="100%" frameBorder=0 id=frmright name=frmright src="<%=request.getContextPath()%>/system/blue1_accordion/open.jsp"  allowTransparency="true"></IFRAME>
					</div>
				</div>
				</div>
				</div>
				<div id="rbox_bottomcenter" >
				<div id="rbox_bottomleft">
				<div id="rbox_bottomright">
				</div>
				</div>
				</div>
			</div>
		</td>
		<!--右侧区域end-->
	</tr>
</table>
<!--头部与导航end-->


<!--尾部区域start-->
<div id="fbox">
	<div id="bs_footcenter">
	<div id="bs_footleft">
	<div id="bs_footright">
        Copyright © 江苏出入境检验局 版权所有 Powered by NineTowns.
    </div>
	</div>
	</div>
</div>
</div>
<!--尾部区域end-->

<!--浏览器resize事件修正start-->
<div id="resizeFix"></div>
<!--浏览器resize事件修正end-->

<!--窗口任务栏区域start-->
<div id="dialogTask" class="dialogTaskBg" style="display:none;"></div>
<!--窗口任务栏区域end-->

<!--载进度条start-->
<div class="progressBg" id="progress" style="display:none;"><div class="progressBar"></div></div>
<!--载进度条end-->
</body>
</html>
