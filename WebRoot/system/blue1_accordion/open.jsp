<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="../../libs/js/jquery-1.7.2.min.js"></script>
    <script src="../../libs/js/jquery.touchwipe.1.1.1.js"></script>
    <script src="../../libs/js/jquery.cycle.all.min.js"></script>
    <script>
    </script>
    <style>
        a{ cursor:pointer; text-decoration:none; color:#000;}
        ul{ list-style-type:none; padding-top:30px;}
        li{ width:200px;float:left; padding-bottom:10px; }
        #open_bg{ width:1389px; height:640px;background: #9ec2e3 url("../../system/blue1_accordion/skin/bgbg.jpg") no-repeat;margin: 0 auto; }
        #imagegallery { width:900px; margin:0 auto; height:510px;}
        .boxIcon{width:900px;margin:0 auto;text-align:center;}
        .boxIcon img{ width:80px;}
        #nav{ width:100px; margin:0 auto; overflow:hidden;}
        #nav a{
            width:15px;
            height:15px;
            display:block;
            margin-left:25px;
        }
        #nav a.cur_a{
            background:#7ebce7;
        }
        #nav a.cur{
            background:#bfc0c1;
        }
        #prev {
            float:left;
        }
        #next {
            float:left;
        }
    </style>
    <script>

        function customHeightSet(contentHeight){
            $("#open_bg").height(contentHeight);
        }


        $.post("<%=request.getContextPath()%>/user/queryMainMenu",
            function(data){
                var mm="";
                    $.each(data,function(i,item){
                        mm+=("<li><a onclick=\"window.location.href='"+item.url+"'\"><img src=\""+item.icon+"\"/><h4>"+item.name+"</h4></a></li>");
                    });
                $("#boxIcon").html(mm);
            }, "json");
    </script>

</head>
<body style="overflow-x: hidden;overflow-y: hidden;">
<div id="open_bg">
    <div id="imagegallery">
        <ul class="boxIcon" id="boxIcon">
            
        </ul>
    </div>
</div>
</body>
</html>