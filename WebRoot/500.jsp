<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0029)http://www.leadto.com.cn/22.hm -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>系统内部错误</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!--<META http-equiv=refresh content=2;url=http://www.ninetowns.com/>-->
		<style type="text/css">
			BODY {
				PADDING-RIGHT: 0px;
				PADDING-LEFT: 35px;
				BACKGROUND: url(<%=request.getContextPath()%>/images/photoback.gif) repeat-x left top;
				PADDING-BOTTOM: 0px;
				MARGIN: 0px;
				FONT: 12px Arial, Helvetica, sans-serif;
				COLOR: #333;
				PADDING-TOP: 35px
			}
			
			A {
				COLOR: #007ab7;
				TEXT-DECORATION: none
			}
			
			A:hover {
				COLOR: #007ab7;
				TEXT-DECORATION: none
			}
			
			A:hover {
				COLOR: #de1d6a
			}
			
			.hidehr {
				DISPLAY: none
			}
			
			.show12 {
				PADDING-RIGHT: 0px;
				DISPLAY: block;
				PADDING-LEFT: 0px;
				PADDING-BOTTOM: 0px;
				MARGIN: 5px 0px;
				PADDING-TOP: 0px
			}
			
			.show13 {
				PADDING-RIGHT: 0px;
				DISPLAY: block;
				PADDING-LEFT: 0px;
				PADDING-BOTTOM: 0px;
				MARGIN: 5px 0px;
				PADDING-TOP: 0px
			}
			
			.show12 A {
				BORDER-RIGHT: #bfdeed 1px solid;
				PADDING-RIGHT: 6px;
				BORDER-TOP: #bfdeed 1px solid;
				DISPLAY: inline-block;
				PADDING-LEFT: 6px;
				BACKGROUND: #d8ebf4;
				PADDING-BOTTOM: 2px;
				OVERFLOW: hidden;
				BORDER-LEFT: #bfdeed 1px solid;
				LINE-HEIGHT: 17px;
				PADDING-TOP: 2px;
				BORDER-BOTTOM: #bfdeed 1px solid;
				HEIGHT: 16px
			}
			
			.show13 A {
				BORDER-RIGHT: #bfdeed 1px solid;
				PADDING-RIGHT: 6px;
				BORDER-TOP: #bfdeed 1px solid;
				DISPLAY: inline-block;
				PADDING-LEFT: 6px;
				BACKGROUND: #d8ebf4;
				PADDING-BOTTOM: 2px;
				OVERFLOW: hidden;
				BORDER-LEFT: #bfdeed 1px solid;
				LINE-HEIGHT: 17px;
				PADDING-TOP: 2px;
				BORDER-BOTTOM: #bfdeed 1px solid;
				HEIGHT: 16px
			}
			
			.show12 A:hover {
				BORDER-RIGHT: #ea5e96 1px solid;
				BORDER-TOP: #ea5e96 1px solid;
				BACKGROUND: #fce8f0;
				BORDER-LEFT: #ea5e96 1px solid;
				COLOR: #de1d6a;
				BORDER-BOTTOM: #ea5e96 1px solid;
				TEXT-DECORATION: none
			}
			
			.show13 A:hover {
				BORDER-RIGHT: #ea5e96 1px solid;
				BORDER-TOP: #ea5e96 1px solid;
				BACKGROUND: #fce8f0;
				BORDER-LEFT: #ea5e96 1px solid;
				COLOR: #de1d6a;
				BORDER-BOTTOM: #ea5e96 1px solid;
				TEXT-DECORATION: none
			}
			
			.show12 A {
				FONT-WEIGHT: normal;
				FONT-SIZE: 12px
			}
			
			.show13 A {
				BORDER-RIGHT: #ed268c 1px solid;
				BORDER-TOP: #ed268c 1px solid;
				BACKGROUND: #dd137b;
				BORDER-LEFT: #ed268c 1px solid;
				COLOR: #fff;
				BORDER-BOTTOM: #ed268c 1px solid
			}
			
			.img404 {
				PADDING-RIGHT: 0px;
				PADDING-LEFT: 0px;
				BACKGROUND: url(<%=request.getContextPath()%>/images/404.gif) no-repeat left top;
				FLOAT: left;
				PADDING-BOTTOM: 0px;
				MARGIN: 0px;
				WIDTH: 80px;
				PADDING-TOP: 0px;
				POSITION: relative;
				HEIGHT: 90px
			}
			
			H2 {
				PADDING-RIGHT: 0px;
				PADDING-LEFT: 0px;
				FONT-SIZE: 16px;
				FLOAT: left;
				PADDING-BOTTOM: 25px;
				MARGIN: 0px;
				WIDTH: 80%;
				LINE-HEIGHT: 0;
				PADDING-TOP: 25px;
				BORDER-BOTTOM: #ccc 1px solid;
				POSITION: relative
			}
			
			H3.wearesorry {
				PADDING-RIGHT: 0px;
				PADDING-LEFT: 0px;
				FONT-WEIGHT: normal;
				FONT-SIZE: 10px;
				LEFT: 117px;
				PADDING-BOTTOM: 0px;
				MARGIN: 0px;
				COLOR: #ccc;
				LINE-HEIGHT: 10px;
				PADDING-TOP: 0px;
				POSITION: absolute;
				TOP: 70px
			}
			
			.content {
				CLEAR: both;
				PADDING-RIGHT: 0px;
				PADDING-LEFT: 0px;
				FONT-SIZE: 13px;
				LEFT: 80px;
				FLOAT: left;
				PADDING-BOTTOM: 0px;
				MARGIN: 0px;
				WIDTH: 80%;
				LINE-HEIGHT: 19px;
				PADDING-TOP: 0px;
				POSITION: relative;
				TOP: -30px
			}
			
			.content UL {
				PADDING-RIGHT: 35px;
				PADDING-LEFT: 35px;
				PADDING-BOTTOM: 20px;
				MARGIN: 0px;
				PADDING-TOP: 10px
			}
			
			.show12 UL {
				PADDING-RIGHT: 0px;
				PADDING-LEFT: 0px;
				PADDING-BOTTOM: 0px;
				MARGIN: 0px 0px 0px 20px;
				PADDING-TOP: 0px;
				LIST-STYLE-TYPE: none
			}
			
			.show14 UL LI {
				MARGIN-BOTTOM: 5px
			}
			</style>

		<meta content="MSHTML 6.00.2900.5880" name="GENERATOR"/>
	</head>
	<body>
		<h1 class="hidehr">
			当前在系统中找不到你要的内容。
		</h1>
		<div class="img404">
		</div>
		<h2>
			抱歉，发生系统内部错误,不能处理你的请求……
		</h2>
		<h3 class="wearesorry">
			We're sorry but internal system error occurred, could not process your request...
		</h3>
		<div class="content">
			系统暂时没法自动处理这个错误,可能原因是：
			<ul>
				<li>
                    <c:if test="${not empty exception}">${exception}</c:if>
				</li>
				<li>
					<a title="返回上一个页面" href="javascript:history.back(-1)">返回上一页</a>
				</li>
			</ul>
		</div>
		<span style="VISIBILITY: hidden"></span>


	</body>
</html>