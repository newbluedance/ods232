<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<title></title>
<!--框架必需start-->
<link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/libs/skins/modernBlue/style.css" rel="stylesheet" type="text/css" id="theme" themeColor="modernBlue" autoFormat="false" selInputHeight="28" selButtonWidth="29" defaultSelWidth="160" fileBtnWidth="60" defaultFileInputWidth="222" defaultGridHeaderHeight="32" defaultGridRowHeight="32" defaultFontSize="14" defaultPageSelWidth="55" defaultFilterItemHeight="28" defaultFontFamily="微软雅黑"/>
<link href="<%=request.getContextPath()%>/system/tabdesk/skin/style.css" rel="stylesheet" type="text/css" id="skin" skinPath="system/tabdesk/skin/"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/main.js"></script>
<!--框架必需end-->

<!--主页初始化start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/system/tabdesk/js/initIndex.js"></script>
<!--主页初始化end-->

<!--动态选项卡start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/nav/dynamicTab.js"></script>
<!--动态选项卡end-->

<!--弹窗组件start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/drag.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/popup/dialog.js"></script>
<!--弹窗组件end-->

<!--即时通讯相关start -->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=request.getContextPath()%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/system/tabdesk/js/chat.js"></script>
<!--即时通讯相关end -->

<!-- 树型抽屉导航start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/system/tabdesk/js/treeAccordion.js"></script>
<!-- 树型抽屉导航end -->

<!--分隔条start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/nav/spliter.js"></script>
<!--分隔条end-->
<style type="text/css">
	.ztree li button.diy01_ico_open, .ztree li button.diy01_ico_close,.ztree li button.diy01_ico_docu{width:24px;height:24px;}
</style>
<style type="text/css">
html{
	overflow:hidden;
}
body{
	overflow:hidden;
}
a {
	behavior:url(<%=request.getContextPath()%>/libs/js/method/focus.htc)
}
</style>
<script type="text/javascript">
function bookmarksite(title, url){
    if (window.sidebar) // firefox
        window.sidebar.addPanel(title, url, "");
    else 
        if (window.opera &amp;&amp; window.print) { // opera
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
</script>
</head>
<body>
<div class="desktop" style="position:absolute;">
	<div class="titleBg">
		<div class="info">
				欢迎 ${LOGIN_USER.displayName} 用户，今天是
			<script type="text/javascript">
				var weekDayLabels = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
				var now = new Date();
			    var year=now.getFullYear();
				var month=now.getMonth()+1;
				var day=now.getDate();
			    var currentime = year+"年"+month+"月"+day+"日 "+weekDayLabels[now.getDay()];
				document.write(currentime)
			</script>
		</div>
		<div class="function">
			<ul>
				<li class="icon3"><a  onclick='top.Dialog.open({URL:"include/skin.html",Title:"更换背景",Modal:false,ResizeResetPosition:false,ShowMinButton:true,Width:720,Height:460,MinToTask:true,ID:"changebg"});'>更换背景</a></li>
				<li class="icon1"><a  onclick='top.Dialog.open({URL:"include/message.html",Title:"消息提醒",Modal:false,ResizeResetPosition:false,ShowMinButton:true,MinToTask:true,ID:"message"});'>消息提醒</a></li>
				<li class="icon2"><a  onclick='top.Dialog.confirm("确定要退出系统吗",function(){window.location="logout"});'>退出系统</a></li>
				<div class="clear"></div>
			</ul>
		</div>
		<div class="top_title">空港一站式服务平台</div>
	</div>
</div>
<div id="allIconContainer"></div>
<div style="padding:31px 0 0 0;">
<div id="tab_menu"></div>
<table cellpadding="0" cellspacing="0" width="100%" border="0">
	<tr>
		<td class="ver01">
		<div style="width:200px;display:none;" id="leftMenu">
			<ul id="treeDemo" class="ztree ztree_accordition"></ul>
			<div style="padding:0 0 0 120px;">
				<span class="icon_home hand" onclick="backHome()">返回首页</span>
			</div>
		</div>
		</td>
		<!--分隔栏区域start-->
		<td class="spliter main_shutiao" id="spliter" targetId="leftMenu" beforeClickTip="收缩面板" afterClickTip="展开面板" beforeClickClass="bs_leftArr" afterClickClass="bs_rightArr">
		</td>
		<!--分隔栏区域end-->
		<td style="width:100%;" class="ver01" >
		<div id="page" style="width:100%;"></div>
		</td>
	</tr>
</table>
</div>

	<div class="chat_main" id="chat_main">
		<div class="chat_top" >
			<div class="chat_top_arr"><a id="topArr" onfocus="this.blur()"><span class="img_btn_up" id="icon_arr"></span></a></div>
			<div class="chat_top_line1">当前在线好友：10人</div>
			<div class="chat_top_line2">
				<label class="float_left">用户名:张小三</label> 
				<input class="float_right btnStyle"  type="button" value="查看信息" onclick="viewInfo()"/> 
				<label  class="float_right padding_right2 padding_top1">状态：隐身 </label> 
				<div class="clear"></div>
			</div>
			<div class="chat_top_line3">
				<table width="100%">
					<tr>
						<td width="90%" class="ali03"><label for="searchKey"><input type="text" class="textinput textinputChat" id="searchKey" value=""></label></td>
						<td><span class="img_find hand" title="点击查找节点" keepDefaultStyle="true" onclick="findNode2()"></span></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="chat_middle">
			<div class="chat_middleCon">
				<div>
				    <ul id="treeDemo2" class="ztree"></ul>
				</div>
			</div>
			<div class="padding_left40">
				<span class="icon_add hand" onclick="addFriend()">添加好友</span>
				<span class="icon_find hand" onclick="searchRoom()">搜索聊天室</span>
				<br/>
			</div>
		</div>
		<div class="chat_bottom"></div>
	</div>
<!--窗口任务栏区域start-->
<div id="dialogTask" class="dialogTaskBg" style="display:none;"></div>
<!--窗口任务栏区域end-->

</body>
</html>
