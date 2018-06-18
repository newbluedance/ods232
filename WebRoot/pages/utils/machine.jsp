<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <!--框架必需end-->

    <%--//新增--%>
    <%--function machine() {--%>
    <%--top.Dialog.open({--%>
    <%--URL: "./utils/machine",--%>
    <%--Title: "计算器", Width:475, Height: 400--%>
    <%--});--%>
    <%--}--%>

    <style>
        body,ul{ margin:0px; padding:0px;}
        body{
            background: #AF6332;
            background-color: #E6E6E6;

        }

        li{ list-style:none;}
        .fl{ float:left;}
        .fr{ float:right;}
        .clearfix:after{ content:""; display:block;clear:both}
        .clearfix{zoom:1;}
        /*是用inset可以将外部阴影改成内部阴影;若要实现内外阴影同时存在，将其并在一行用逗号隔开*/
        .calBox{
            width: 460px;
            padding-bottom: 10px;
            background: #FDFDFD;
            border-radius: 5px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -230px;
            margin-top: -225px;
            box-shadow: 0px 0px 10px rgba(153,153,153,0.8),0px 0px 10px rgba(0,0,0,0.5) inset;
            -webkit-box-shadow: 0px 0px 10px rgba(153,153,153,0.8),0px 0px 10px rgba(0,0,0,0.5) inset;
            background: #F9F9F9;
            overflow: hidden
        }
        input.f{ width:406px; height:82px; margin:10px 7px 0px; border-radius:5px; border:1px solid #64655F; box-shadow:0px 5px 2px rgba(157,157,145,0.8) inset; -webkit-box-shadow:0px 5px 2px rgba(157,157,145,0.8) inset; outline:none; background:#FCFDEB; text-align:right; font-family:"微软雅黑"; font-size:50px; padding:0px 10px;}
        ul{}
        li{ list-style:none; width:74px; height:34px; line-height:34px; text-align:center; font-size: 30px;font-family:"微软雅黑"; border:1px solid #8B8B8B; border-radius:5px; background:url(img/calBg) repeat-x; float:left; margin:12px 6px 0px;}
        .one li{ height:44px; background:url(<%=request.getContextPath()%>/system/flatBlue_accordion/skin/buttonImg/calBg1.jpg) repeat-x; line-height:44px;cursor:pointer;}
        .one .orange{ background:url(<%=request.getContextPath()%>/system/flatBlue_accordion/skin/buttonImg/calBg2.jpg) repeat-x; border:1px solid #875733;}
        .one .black{ background:url(<%=request.getContextPath()%>/system/flatBlue_accordion/skin/buttonImg/calBg3.jpg) repeat-x; border:1px solid #363636; color:#fff;}
        .one .gray{ background:url(<%=request.getContextPath()%>/system/flatBlue_accordion/skin/buttonImg/calBg4.jpg) repeat-x; border:1px solid #5F6366;}
        .zero{ width:160px;}
        .one .deng{ background:url(<%=request.getContextPath()%>/system/flatBlue_accordion/skin/buttonImg/calBg5.jpg); height:100px;}
        .twoBox{ width:353px; overflow:hidden; }
        .two{ width:358px;}
        .calBox .three { margin:0px}
        .calu{ padding:0px 10px; width:470px;}
    </style>

</head>

<body>
<div style="position: absolute;top:230px;left:238px;display: ">
<div class="calBox">
    <div class="calu">
        <input type="text" id="text" class="f">
        <ul class="one clearfix">
            <li class="orange on">开机</li>
            <li class="orange off">关机</li>
            <li class="orange clea">清屏</li>
            <li class="black zheng">+/-</li>
            <li class="black rec">1/x</li>
            <li class="num">7</li>
            <li class="num">8</li>
            <li class="num">9</li>
            <li class="gray oper">/</li>
            <li class="black oper">%</li>
            <li class="num">4</li>
            <li class="num">5</li>
            <li class="num">6</li>
            <li class="gray oper">*</li>
            <li class="black sq">√</li>
            <!--  -->
        </ul>
        <div class="clearfix">
            <div class="twoBox fl">
                <ul class="one fl two">
                    <li class="num">1</li>
                    <li class="num">2</li>
                    <li class="num">3</li>
                    <li class="gray oper">-</li>
                    <li class="zero num">0</li>
                    <li class="num">.</li>
                    <li class="gray oper">+</li>
                </ul>
            </div>
            <ul class="one three clearfix fl">
                <li class="black deng fl">=</li>
            </ul>
        </div>
    </div>
</div>
<input type="text" id="per" style="display:none">
<input type="text" id="text1" style="display:none">
</div>


<!--copy begin here:-->
<style type="text/css">
    #fx_convert_1 br {display:none;}
</style>
<%--<style type="text/css">#fx_convert_1 br {display:none;}</style><div style="width:160px;text-align:center;" id="fx_convert_1"><div id="xcolorc1_1" style="border:1px solid #000;background-color:#94abf0;padding: 0px 0px;margin: 0px 0px;align:center;overflow:hidden;"><div id="xcolorc1_2" style="font-size:12px;color:#183a00;line-height:16px;font-family: arial; font-weight:bold;background:#94abf0;padding: 3px 1px;text-align:center;"><a href="http://www.forexq.net/USD" alt="USD 美元 汇率换算" title="USD 美元 汇率换算" id="forex2_linkc1" style="color:#000000;font-size:14px;text-decoration:none;line-height:16px;font-family: arial;" ><img src="http://www.forexq.net/images/USD.gif" border="0" style="margin:0;padding:0;border:0;" />美元 汇率换算</a></div><script src="http://www.forexq.net/z.php?z=cn_USDc1&c=94abf0&tz=Asia/Shanghai&tf=1"></script></div><div style="text-align:center;"><a href="http://www.forexq.net/" style="font-size:12px;">汇率换算</a></div></div>--%>
<script>
    function findArr(a, c) {
        for (var b = 0; b < a.length; b++) {
            if (a[b] == c) {
                return true
            }
        }
        return false
    }
    function getClass(d, f) {
        if (document.getElementsByClassName) {
            return d.getElementsByClassName(f)
        } else {
            var a = [];
            var e = document.getElementsByTagName("*");
            for (var c = 0; c < e.length; c++) {
                var b = e[c].className.split(" ");
                if (findArr(b, f)) {
                    a.push(e[c])
                }
            }
            return a
        }
    };
    window.onload = function() {
        var aNum = getClass(document, 'num');
        var oText = document.getElementById('text');
        var aPer = getClass(document, 'oper');
        var oPer = document.getElementById('per');
        var oText1 = document.getElementById('text1');
        var oDeng = getClass(document, 'deng')[0];
        var oSq = getClass(document, 'sq')[0];
        var oRec = getClass(document, 'rec')[0];
        var oZheng = getClass(document, 'zheng')[0];
        var oOn = getClass(document, 'on')[0];
        var oOff = getClass(document, 'off')[0];
        var oClea = getClass(document, 'clea')[0];
        var bOnOrOffClick = false;

        function fnNum(a) {

            var bClear = false;
            oText.value = '0'

            for (var i = 0; i < aNum.length; i++) {
                aNum[i].onclick = function() {
                    if (!bOnOrOffClick) return;

                    if (bClear) {

                        bClear = false;
                    }

                    if (oText.value.indexOf('.') != -1) {
                        if (this.innerHTML == '.') {
                            return;
                        }
                    }
                    if (oPer.value && oText.value && oText1.value == '') {
                        oText1.value = oText.value;
                        oText.value = '';
                    }

                    var re = /^0\.{1}\d+$/;
                    var re1 = /^([0]\d+)$/;
                    oText.value += this.innerHTML;

                    if (re.test(oText.value)) {
                        return;
                    }

                    if (re1.test(oText.value)) {
                        oText.value = this.innerHTML;
                    }
                }
                //符号部分的添加
                for (var j = 0; j < aPer.length; j++) {
                    aPer[j].onclick = function() {

                        if (oText.value && oPer.value && oText1.value) {
                            var n = eval(oText1.value + oPer.value + oText.value);
                            oText.value = n;
                            oText1.value = '';
                        }
                        oPer.value = this.innerHTML;
                    }

                }
                //点击等号的时候
                oDeng.onclick = function() {
                    //+-*/%的情况
                    if (oText1.value == '' && oPer.value == '' && oText.value == '') {
                        return;
                    }
                    var n = eval(oText1.value + oPer.value + oText.value);
                    oText.value = n;
                    oText1.value = '';
                    oPer.value = '';
                    bClear = true;
                }
                //点击开根号的时候
                oSq.onclick = function() {
                    var m = Math.sqrt(oText.value);
                    oText.value = m;
                }
                //点击倒数的时候
                oRec.onclick = function() {
                    var a = 1 / oText.value;

                    if (oText.value == '0') {
                        a = '正无穷'
                    }
                    oText.value = a;
                }
                //正负号的时候
                oZheng.onclick = function() {
                    if (oText.value > 0) {
                        oText.value = -oText.value;
                    } else {
                        oText.value = -oText.value;
                    }
                }
                //清屏的时候
                oClea.onclick = function() {
                    oText.value = '0';
                    oText1.value = '';
                    oPer.value = '';
                }
            }
        }
        //on时
        oOn.onclick = function() {
            bOnOrOffClick = true;
            fnNum(bOnOrOffClick);
        }

        //off时
        oOff.onclick = function() {
            bOnOrOffClick = false;
            fnNum(bOnOrOffClick);
            oText.value = '';
        }
    }
</script>
</body>
</html>