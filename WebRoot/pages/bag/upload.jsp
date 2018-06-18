<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2014/7/30
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>测试</title>
    <!--框架必需start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/language/cn.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/framework.js"></script>
    <link href="<%=request.getContextPath()%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath()%>/"/>
    <link rel="stylesheet" type="text/css" id="customSkin"/>
    <!--框架必需end-->

    <!-- 图片压缩 -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/thumb/binaryajax.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/thumb/exif.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/thumb/jquery.make-thumb.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/thumb/megapix-image.js"></script>
    <!-- /图片压缩 -->

    <!--单图边框start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/pic/imgFrame.js"></script>
    <!--单图边框end-->

    <!-- 异步上传end -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/js/ajaxfileupload.js"></script>
    <!-- 异步上传end -->

    <!--图片弹窗start-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide-with-gallery.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/libs/thirdparty/highslide/highslide.css" />
    <!--图片弹窗end-->

    <style>
        .boxgrid{
            width: 200px;
            height: 122px;
            margin:10px;
            float:left;
            background:#161613;
            border: solid 2px #8399AF;
            overflow: hidden;
            position: relative;
        }

        .upload {
            width: 83px;
            height: 34px;
            z-index: 9;
            opacity: 0;
        }

        .fake-file {
            width: 82px;
            height: 34px;
            line-height: 36px;
            z-index: 2;
            margin-left: -80px;
            font-size: 18px;
            -webkit-box-shadow: inset 0 1px 1px 0 #fff, 0px 1px 1px 0 #FCFCFC;
            box-shadow: inset 0 1px 1px 0 #fff, 0px 1px 1px 0 #FCFCFC;
            border: solid 1px #95E4F3;
            background: #f5f5f5;
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f5f5f5), color-stop(100%, #EBEBEB));
            background: -webkit-linear-gradient(top, #DFF8F7 0, #A0F0F3 100%);
            border-radius: 3px;
            -webkit-border-radius: 3px
        }
    </style>

</head>

<body>

<div id="scrollContent">
    <form id="myFormId" action="<%=request.getContextPath()%>/bag/testUpload" enctype="multipart/form-data" method="post">
        <fieldset>
            <legend>测试上传</legend>
           <table class="tableStyle" formMode="transparent" footer="normal">

                    <tr>
                    <td>上传照片：</td>
                    <td>
                        <div>
                            <input id="j-file" keepdefaultstyle="true" class="upload" name="file" type="file"/>
                            <span class="fake-file" data-ac="active">拍照上传</span>
                        </div>
                        <input onclick="sub()" type="button" value="提交？"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="horsePicture_div" align="left"></div>
                    </td>
                </tr>

            </table>
        </fieldset>
        <div class="height_15"></div>
        <div id="imgDiv" align="left"></div>
    </form>
</div>
<script type="text/javascript">
var fixedObj = 40;

function customHeightSet(contentHeight) {
    $("#scrollContent").height(contentHeight - fixedObj);
}

function initComplete() {
    //表单提交
    $('#ok').click(function () {
        //判断表单的客户端验证是否通过
        var valid = $('#myFormId').validationEngine({returnIsValid: true});
        if (valid) {
            //此处进行ajax后台数据处理
            $.post('<%=request.getContextPath()%>/horse/',$("#myFormId").serialize(),function(result){
                if(result=='1'){
                    top.Dialog.alert("操作成功！",function(){
                        closeWin();
                    });
                }else{
                    top.Dialog.alert("操作失败，请重新操作！");
                }
            },"json");
        }
        //阻止表单默认提交事件
        return false;
    });
}


function imgRemarkInit(){
    //标题特效
    $('.framegrid.nocaption').each(function(){
        $(".framegrid_cover", this).css({
            top:"128px",
            height:"0px"
        })
        $(".framegrid_title", this).hide()
        $(".framegrid_con", this).hide()
    })
    $('.framegrid.nocaption').hover(function(){
        $(".framegrid_cover", this).stop().animate({top:'68px',height:'60px'},{queue:false,duration:160});
        $(".framegrid_title", this).show()
        $(".framegrid_con", this).show()
    }, function() {
        $(".framegrid_cover", this).stop().animate({top:'125px',height:'0px'},{queue:false,duration:160});
        $(".framegrid_title", this).hide()
        $(".framegrid_con", this).hide()
    });
}

</script>

<script type="text/javascript">
    function sub(){
        var $form = $('#myFormId');
        $form.submit();
    }
    var picNum = 0;
    $(function() {
        var $form = $('#myFormId');
        var $file = $('#j-file');
        // thumb

        $file.makeThumb({
            width: 1324,
            height: 1324,
            //mark: {padding: 5, src: 'mark.png', width: 30, height: 30},
            success: function(dataURL, tSize, file, sSize, fEvt) {

                picNum++;
                // 可以得到图片名, 高度等信息, 用来做一些判断, 比如图片大小是否符合要求等..
                // console.log(dataURL, tSize, file, sSize, fEvt);
                // console.log(fEvt.target, file.name, sSize, sSize.width, sSize.height);
                // console.log(file.name, sSize.width +'->'+ tSize.width, sSize.height +'->'+ tSize.height);
//                var thumb = new Image();
//                thumb.src = dataURL;
                // try{}catch(err){console.log(err);}
                // var title =  file.name +', '+ sSize.width +'->'+ tSize.width +', '+ sSize.height +'->'+ tSize.height;
//                var title = file.name;
//                var $div = thumb;
//                $('.height_15').before($div);
                // console.log(dataURL);
                // post data
                var $up = $('<input id="baseFile_xxx_'+picNum+'" type="hidden" name="baseFile" />');
                $up.insertAfter($file).val(dataURL);
                // $file.remove();
                // console.log($form.serialize());
//                $form.submit();


                var newDiv=document.createElement("div");
                newDiv.style.float="left";
//                newDiv.style.width="200px";
//                newDiv.style.marginRight="15px";
                newDiv.id="xxx_"+picNum;
                <%--var str = '<div>'--%>
                <%--+'<img width="200px" height="122px" src="' + '<%=request.getContextPath()%>' + data.uploadFile.filePath + '" />'--%>
                <%--+'</div>'--%>

                var str = '<div class="framegrid nocaption">'
                                + '<a href="' + dataURL + '" class="highslide" onclick="return hs.expand(this)">'
                                + '<div class="boxgrid captionfull"><img  width="200px" height="122px" src="' + dataURL + '"/></div>'
//                                + '<div class="framegrid_cover">'
//                            + '<div class="framegrid_title">图片标题</div>'
//                                + '<div class="framegrid_con">'+(data.uploadFile.remark==null?'':data.uploadFile.remark)+'</div>'
//                                + '</div>'
                                + '</a>'
                                + '</div>'
                                +'<div style="margin-left:10px; margin-top: 10px;"><input type="button" onclick="deleteFile(\''+newDiv.id+'\');" value="删除"></div>'
                        ;
                newDiv.innerHTML=str;
                document.getElementById("imgDiv").appendChild(newDiv);
//                imgRemarkInit();
            }
        });
        // $file.change(function(){alert(111)});
        // test
        /*$file.change(function(){
         $form.submit();
         });*/

    });
    function deleteFile(divId){
                 $('#baseFile_'+divId).remove();
                var my = document.getElementById(divId);
                if (my != null) {
                    my.parentNode.removeChild(my);
                }

    }
    function initComplete() {
        //根据check设置值

        //图片弹窗
        hs.graphicsDir = '<%=request.getContextPath()%>/libs/thirdparty/highslide/graphics/';
        hs.align = 'center';
        hs.transitions = ['expand', 'crossfade'];
        hs.outlineType = 'rounded-white';
        hs.fadeInOut = true;

        hs.addSlideshow({
            interval: 5000,
            repeat: false,
            useControls: false,
            fixedControls: 'fit',
            overlayOptions: {
                opacity: .75,
                position: 'bottom center',
                hideOnMouseOut: true
            }
        });
    }

</script>
</body>
</html>