<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<!--框架必需start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
<link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--鱼眼菜单start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/nav/fishEye.js"></script>
<!--鱼眼菜单end-->

<!--初始化桌面start -->
<script type="text/javascript" src="<%=request.getContextPath()%>/system/tabdesk/js/initDesk.js"></script>
<!--初始化桌面start -->

<!-- 自动完成框start -->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/form/autoComplete.js"></script>
<!-- 自动完成框end -->


<!--拖拽组件start-->
<script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/drag/dragDrop.js"></script>
<!--拖拽组件end-->



<style>
a {
	behavior:url(<%=request.getContextPath()%>/libs/js/method/focus.htc)
}
</style>
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

</script>
</head>
<body style="background-color:#2571a4;">
	<div class="deskdock" id="mydock">
		<div class="deskdock_left"></div>
		<div class="deskdock_center" id="mydockContent">
			<ul>
				
			</ul>
		</div>
		<div class="deskdock_right"></div>
		<div class="clear"></div>
	</div>
	
	<div class="iconnav" id="iconnav">
		<div class="iconnav_left">
		</div>
		<div class="iconnav_center">
			<ul id="iconnavCon" class="iconnavCon"></ul>
		</div>
		<div class="iconnav_right1"></div>
		<div class="iconnav_right3">
			<div class="listBtn_con">
			<a href="javascript:;" onclick="showAllIcon()" class="iconlistBtn" keepDefaultStyle="true" title="全局视图">button</a>
			<a href="javascript:;" onclick="showSearchPanel()" class="findBtn" keepDefaultStyle="true" title="搜索">button</a>
			<div class="clear"></div>
			</div>
		</div>
		<div class="iconnav_right2"></div>
		<div class="clear"></div>
	</div>
	
	<div class="searchPanel" id="searchPanel" style="display:none;">
		<div class="searchPanelCon">
			<input type="text" class="searchInput" id="searchInput" position="mode2"/>
			<a href="javascript:;" onclick="searchHandler()" class="findBtn searchPadding" keepDefaultStyle="true" title="搜索">button</a>
			<div class="clear"></div>
		</div>
	</div>
	
	<a class="addIcon" href="javascript:;" onclick='openAppStore()'></a>
</body>
</html>
