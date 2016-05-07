<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>jump</title>
	<link href="css/404.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript">
            $(function() {
                var h = $(window).height();
                $('body').height(h);
                $('.mianBox').height(h);
                centerWindow(".tipInfo");
            });

            //2.将盒子方法放入这个方，方便法统一调用
            function centerWindow(a) {
                center(a);
                //自适应窗口
                $(window).bind('scroll resize',
                        function() {
                            center(a);
                        });
            }

            //1.居中方法，传入需要居中的标签
            function center(a) {
                var wWidth = $(window).width();
                var wHeight = $(window).height();
                var boxWidth = $(a).width();
                var boxHeight = $(a).height();
                var scrollTop = $(window).scrollTop();
                var scrollLeft = $(window).scrollLeft();
                var top = scrollTop + (wHeight - boxHeight) / 2;
                var left = scrollLeft + (wWidth - boxWidth) / 2;
                $(a).css({
                    "top": top,
                    "left": left
                });
            }
        </script>
</head>
<body>
	<% String url = new String("question.jsp");%>
	<div class="mianBox">
		<img src="images/yun0.png" class="yun yun0" />
        <img src="images/yun1.png" class="yun yun1" />
        <img src="images/yun2.png" class="yun yun2" />
        <img src="images/bird.png" class="bird" />
        <img src="images/san.png" class="san" />
        <div class="tipInfo">
                <div class="in">
                    <div class="textThis">
                        <h2>请等待</h2>
                        <p><span>页面自动<a id="href" href=<%=url %>>跳转</a></span><span>等待<b id="wait">5</b>秒</span></p>
                        <script type="text/javascript">                            (function() {
                                var wait = document.getElementById('wait'), href = document.getElementById('href').href;
                                var interval = setInterval(function() {
                                    var time = --wait.innerHTML;
                                    if (time <= 0) {
                                        location.href = href;
                                        clearInterval(interval);
                                    }
                                    ;
                                }, 1000);
                            })();
                        </script>
                    </div>
                </div>
            </div>
   </div>
</body>
</html>