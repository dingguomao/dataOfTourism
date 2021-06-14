<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>index</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="css/comon0.css">
</head>
	<script>
	$(window).load(function(){  
             $(".loading").fadeOut()
            })  
			
/****/
$(document).ready(function(){
	var whei=$(window).width()
	$("html").css({fontSize:whei/20})
	$(window).resize(function(){
		var whei=$(window).width()
	 $("html").css({fontSize:whei/20})
});
	});
	</script>
	<script type="text/javascript" src="js/echarts.min.js"></script> 
	<script language="JavaScript" src="js/js.js"></script> 
<body>
<div class="canvas" style="opacity: .2">
	<iframe frameborder="0" src="js/index.html" style="width: 100%; height: 100%"></iframe>
	</div>
<div class="loading">
  <div class="loadbox"> <img src="picture/loading.gif"> 页面加载中... </div>
</div>
<div class="head">
  <h1>景点数据可视化</h1>
  <div class="weather"><!--<img src="picture/weather.png"><span>多云转小雨</span>--><span id="showTime"></span></div>
	
	<script>
var t = null;
    t = setTimeout(time,1000);//開始运行
    function time()
    {
       clearTimeout(t);//清除定时器
       dt = new Date();
		var y=dt.getFullYear();
		var mt=dt.getMonth()+1;
		var day=dt.getDate();
       var h=dt.getHours();//获取时
       var m=dt.getMinutes();//获取分
       var s=dt.getSeconds();//获取秒
       document.getElementById("showTime").innerHTML = y+"年"+mt+"月"+day+"-"+h+"时"+m+"分"+s+"秒";
       t = setTimeout(time,1000); //设定定时器，循环运行     
    } 

</script>
	
	
</div>
<div class="mainbox">
  <ul class="clearfix">
    <li>
      <div class="boxall" style="height: 3.2rem">
        <div class="alltitle">入境人数（万人次）</div>
        <div class="allnav" id="echart1"></div>
        <div class="boxfoot"></div>
      </div>
      <div class="boxall" style="height: 3.2rem">
        <div class="alltitle">国内游客(万人次)</div>
        <div class="allnav" id="echart2"></div>
        <div class="boxfoot"></div>
      </div>
      <div class="boxall" style="height: 3.2rem">
        <div style="height:100%; width: 100%;">
		  	<div class="sy" id="fb1"></div>
				<div class="sy" id="fb2"></div>
				<div class="sy" id="fb3"></div>
		  </div>
        <div class="boxfoot">
			
		  </div>
      </div>
    </li>
    <li>
      <div class="bar">
        <div class="barbox">
          <ul class="clearfix">
            <li class="pulll_left counter">57250.92</li>
            <li class="pulll_left counter">51278.29</li>
          </ul>
        </div>
        <div class="barbox2">
          <ul class="clearfix">
            <li class="pulll_left">2019年总消费情况(亿元) </li>
            <li class="pulll_left">2018年总消费情况(亿元)</li>
          </ul>
        </div>
      </div>
      <div class="map">
        <div class="map1"><img src="picture/lbx.png"></div>
        <div class="map2"><img src="picture/jt.png"></div>
        <div class="map3"><img src="picture/map.png"></div>
        <div class="map4" id="map_1"></div>
      </div>
    </li>
    <li>
        <div class="boxall" style="height:9.9rem">
        <div class="alltitle"  id="abstract">
          <h2>景点推荐排行</h2>
          <br/>
          <p>&nbspTop1:&nbsp故宫</p><br>
          <p>&nbspTop2:&nbsp九寨沟</p><br>
          <p>&nbspTop3:&nbsp丽江</p><br>
          <p>&nbspTop4:&nbsp西湖</p><br>
          <p>&nbspTop5:&nbsp泰山</p><br>
          <p>&nbspTop6:&nbsp八达岭</p><br>
          <p>&nbspTop7:&nbsp天安门</p><br>
          <p>&nbspTop8:&nbsp黄山</p><br>
          <p>&nbspTop9:&nbsp颐和园</p><br>
          <p>&nbspTop10:&nbsp明珠塔</p>
          
        </div>
        <div id="tianqi">
          
        </div>
        
        
        <div class="boxfoot"></div>
      </div>
      
    </li>
  </ul>
</div>
<div class="back"></div>


<script type="text/javascript" src="js/china.js"></script> 
<script type="text/javascript" src="js/area_echarts.js"></script> 
</body>
</html>
