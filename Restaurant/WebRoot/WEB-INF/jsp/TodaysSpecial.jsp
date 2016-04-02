<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- TemplateBeginEditable name="doctitle" -->
<title>Today's Special</title>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" -->
<!-- TemplateEndEditable -->
<style type="text/css">
#apDiv1 {
	position:absolute;
	left:40px;
	top:23px;
	width:1251px;
	height:862px;
	z-index:1;
	background-image: url(${pageContext.request.contextPath }/img/bgr.jpg);
	background-repeat: repeat-y;
}
#apDiv2 {
	position:absolute;
	left:97px;
	top:25px;
	width:211px;
	height:153px;
	z-index:2;
}
#apDiv3 {
	position:absolute;
	left:322px;
	top:20px;
	width:672px;
	height:158px;
	z-index:3;
	border: 5px solid #999;
}
#apDiv4 {
	position:absolute;
	left:102px;
	top:179px;
	width:166px;
	height:419px;
	z-index:4;
	background-image: url(${pageContext.request.contextPath }/img/btnBg1.jpg);
	background-repeat: repeat-y;
}
#apDiv5 {
	position:absolute;
	left:267px;
	top:180px;
	width:22px;
	height:592px;
	z-index:5;
	border-right-color: #D6D6D6;
	border-left-color: #999;
	background-image: url(${pageContext.request.contextPath }/img/z2.jpg);
	background-repeat: repeat;
}
#apDiv6 {
	position:absolute;
	left:87px;
	top:774px;
	width:1100px;
	height:6px;
	z-index:6;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #CCC;
}
#apDiv7 p #dnn_dnnLINKS_lblLinks a {
	font-size: 14px;
	font-style: oblique;
	color: #333;
	text-decoration: none;
}
#apDiv7 {
	position:absolute;
	left:90px;
	top:785px;
	width:1101px;
	height:80px;
	z-index:7;
	background-color: #D6D6D6;
	text-align: center;
	font-family: "Times New Roman", Times, serif;
	font-size: 14px;
	font-style: oblique;
	color: #333;
	line-height: 8px;
}
#apDiv8 {
	position:absolute;
	left:334px;
	top:222px;
	width:170px;
	height:472px;
	z-index:8;
}
#apDiv9 {
	position:absolute;
	left:326px;
	top:194px;
	width:690px;
	height:21px;
	z-index:9;
	background-color: #CCC;
	font-size: 14px;
	font-style: oblique;
	color: #8f8c47;
	background-image: url(${pageContext.request.contextPath }/img/m1.jpg);
	background-repeat: repeat;
}
#apDiv4 a {
	margin-top: 25px;
	line-height: 15px;
	padding-top: 20px;
}
#apDiv4 img {
	margin-top: 14px;
}
#apDiv10 {
	position:absolute;
	left:102px;
	top:604px;
	width:169px;
	height:170px;
	z-index:10;
}
#apDiv11 {
	position:absolute;
	left:332px;
	top:723px;
	width:854px;
	height:57px;
	z-index:11;
	background-image: url(${pageContext.request.contextPath }/img/btnBg1.jpg);
	background-repeat: repeat;
	text-align: center;
}
#apDiv11 img {
	margin-right: 30px;
	margin-top: 5px;
}
#apDiv12 {
	position:absolute;
	left:101px;
	top:597px;
	width:166px;
	height:9px;
	z-index:12;
	background-color: #CCC;
}
#apDiv13 {
	position:absolute;
	left:510px;
	top:220px;
	width:12px;
	height:500px;
	z-index:13;
	background-image: url(${pageContext.request.contextPath }/img/z2.jpg);
	background-repeat: repeat-y;
}
#apDiv14 {
	position:absolute;
	left:547px;
	top:219px;
	width:460px;
	height:31px;
	z-index:14;
	background-image: url(${pageContext.request.contextPath }/img/c2.jpg);
	background-repeat: repeat-x;
}
#apDiv15 {
	position:absolute;
	left:547px;
	top:225px;
	width:461px;
	height:492px;
	z-index:15;
}
</style>
<script type="text/javascript">
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
<link href="${pageContext.request.contextPath }/s.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#apDiv16 {
	position:absolute;
	left:40px;
	top:1px;
	width:1250px;
	height:23px;
	z-index:16;
	background-color: #bdac90;
	background-image: url(${pageContext.request.contextPath }/img/topBackground.jpg);
}
#apDiv17 {
	position:absolute;
	left:1033px;
	top:1px;
	width:60px;
	height:23px;
	z-index:17;
	background-image: url(${pageContext.request.contextPath }/img/Registerbtn.jpg);
}
#apDiv18 {
	position:absolute;
	left:1102px;
	top:1px;
	width:60px;
	height:23px;
	z-index:18;
}

#apDiv19 {
	position:absolute;
	left:1021px;
	top:1px;
	width:147px;
	height:23px;
	z-index:19;
	font-size: 14px;
	text-align: left;
	vertical-align: middle;
}
#apDiv20 {
	position:absolute;
	left:1183px;
	top:1px;
	width:60px;
	height:23px;
	z-index:20;
}


.welcome {
	font-size: 16px;
	color: #8f8c47;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	vertical-align: middle;
	text-decoration: underline;
}
</style>

</head>

<body onload="MM_preloadImages('${pageContext.request.contextPath }/img/btnHomeChange.jpg','${pageContext.request.contextPath }/img/btnTodaySpecailChange.jpg','${pageContext.request.contextPath }/img/btnmenuChange.jpg','${pageContext.request.contextPath }/img/btnReservationChange.jpg','${pageContext.request.contextPath }/img/btnWeddingChange.jpg','${pageContext.request.contextPath }/img/btnAboutUsChange.jpg','${pageContext.request.contextPath }/img/btnLocationChange.jpg','file:///C|/Users/Administrator/Desktop/Li JingTian 1135260865/img/RegisterChangedbtn.jpg','file:///C|/Users/Administrator/Desktop/Li JingTian 1135260865/img/LoginChangedbtn.jpg')">
<div id="apDiv1"></div>
<div id="apDiv2"><img src="${pageContext.request.contextPath }/img/logo.jpg" width="220" height="153" /></div>
<div id="apDiv3"><img src="${pageContext.request.contextPath }/img/header.jpg" width="675" height="163" border="0" usemap="#Map" />
  <map name="Map" id="Map">
    <area shape="rect" coords="41,20,152,133" href="${pageContext.request.contextPath }/AboutUs.html" />
    <area shape="circle" coords="287,77,57" href="${pageContext.request.contextPath }/Menu.html" />
    <area shape="poly" coords="450,41,435,97,467,121,541,125,564,79,560,40,504,19" href="${pageContext.request.contextPath }/Today's Special.html" />
  </map>
</div>
<div class="left" id="apDiv4"><img src="${pageContext.request.contextPath }/img/btnBg1.jpg" width="164" height="37" /><a href="${pageContext.request.contextPath }/index.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image6','','${pageContext.request.contextPath }/img/btnHomeChange.jpg',1)"><img src="${pageContext.request.contextPath }/img/button.jpg" name="Image6" width="164" height="27" border="0" id="Image6" /></a><a href="${pageContext.request.contextPath }/servlet/TodaysSpecialUIServlet" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image7','','${pageContext.request.contextPath }/img/btnTodaySpecailChange.jpg',1)"><img src="${pageContext.request.contextPath }/img/btnTodaySpecail.jpg" name="Image7" width="164" height="27" border="0" id="Image7" /></a><a href="${pageContext.request.contextPath }/servlet/MenuUIServlet" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image8','','${pageContext.request.contextPath }/img/btnmenuChange.jpg',1)"><img src="${pageContext.request.contextPath }/img/menu.jpg" name="Image8" width="164" height="27" border="0" id="Image8" /></a><a href="${pageContext.request.contextPath }/servlet/ReservationUIServlet" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image9','','${pageContext.request.contextPath }/img/btnReservationChange.jpg',1)"><img src="${pageContext.request.contextPath }/img/btnReservation.jpg" name="Image9" width="164" height="27" border="0" id="Image9" /></a><a href="${pageContext.request.contextPath }/servlet/WeddingUIServlet" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image10','','${pageContext.request.contextPath }/img/btnWeddingChange.jpg',1)"><img src="${pageContext.request.contextPath }/img/btnWedding.jpg" name="Image10" width="164" height="27" border="0" id="Image10" /></a><a href="${pageContext.request.contextPath }/servlet/AboutUsUIServlet" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image11','','${pageContext.request.contextPath }/img/btnAboutUsChange.jpg',1)"><img src="${pageContext.request.contextPath }/img/btnAboutUs.jpg" name="Image11" width="164" height="27" border="0" id="Image11" /></a><a href="${pageContext.request.contextPath }/servlet/LocationUIServlet" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image12','','${pageContext.request.contextPath }/img/btnLocationChange.jpg',1)"><img src="${pageContext.request.contextPath }/img/btnLocation.jpg" name="Image12" width="164" height="27" border="0" id="Image12" /><img src="${pageContext.request.contextPath }/img/m1.jpg" width="164" height="27" /></a></div>
<div class="fuilLeft" id="apDiv5"></div>
<div id="apDiv6"></div>
<div id="apDiv7">
  <p><span id="dnn_dnnLINKS_lblLinks"><a href="${pageContext.request.contextPath }/index.jsp">Home</a>| <a href="${pageContext.request.contextPath }/servlet/TodaysSpecialUIServlet">Today's Special</a> | <a href="${pageContext.request.contextPath }/servlet/MenuUIServlet">Menu</a> | <a href="${pageContext.request.contextPath }/servlet/ReservationUIServlet">Reservation</a> | <a href="${pageContext.request.contextPath }/servlet/WeddingUIServlet">Weddings</a> |<a href="${pageContext.request.contextPath }/servlet/AboutUsUIServlet">About Us</a> | <a href="${pageContext.request.contextPath }/servlet/LocationUIServlet">Location</a></span></p>
  <p><span id="dnn_dnnCOPYRIGHT_lblCopyright">Copyright | 03, 23, 2015 by Li JingTian</span>  1135260865</p>
  <p>&nbsp;</p>
</div>
<div id="apDiv8">
  <embed src="${pageContext.request.contextPath }/swf/indexFlv.swf" width="170" height="500"></embed>
</div>
<div class="titleBg" id="apDiv9">Welcome to seafood restaurant to have a great experience!</div>
<div id="apDiv10"><img src="${pageContext.request.contextPath }/img/SeafoodPlatter1.jpg" width="164" height="170" /></div>
<div id="apDiv11"><img src="${pageContext.request.contextPath }/img/REGALogo100.jpg" width="65" height="48" /><img src="${pageContext.request.contextPath }/img/fournologo100.jpg" width="120" height="48" /><img src="${pageContext.request.contextPath }/img/Atlantis-Logo100.jpg" width="120" height="48" /></div>
<div id="apDiv12"></div>
<div class="fuilLeft" id="apDiv13"></div>
<div id="apDiv15"><!-- TemplateBeginEditable name="EditRegion4" -->


    <div id="title2">
    <div id="ee"><img src="${pageContext.request.contextPath }/img/c1.jpg" width="18" height="31" /><span class="titleTxt">Today's Special</span></div>
    <div class="split" id="text3">
      <p>Grilled Whole Baby Snapper: </p>
      <p>Featuring the freshest of seafood, Lugarno Seafood Restaurant has gained a   reputation for delivering excellence, with an international cuisine tailored to   take advantage of the best of the seasons. <br />
        <br />
        Our long standing   relationship with the Sydney fish markets ensures we gain the best of the catch   for our guests. We pursue quality ingredients with a passion, and focus on the   importance of preparation. <br />
        <br />
        It's all about the food...</p>
    </div>
    <div class="centerContent" id="image"><img src="${pageContext.request.contextPath }/img/RTEmagicC_f28e9a58cf_jpg.jpg" width="290" height="145" /></div>
  </div>


<!-- TemplateEndEditable --></div>
<div id="apDiv16"><img src="${pageContext.request.contextPath }/img/topBackground.jpg" width="1250" height="24"/></div>


 <%-- jstl won't show in the code page of the browser --%>
  	<c:if test="${user==null }">
		<div id="apDiv17"><a href="${pageContext.request.contextPath }/servlet/RegisterUIServlet" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image17','','${pageContext.request.contextPath }/img/RegisterChangedbtn.jpg',1)"><img src="${pageContext.request.contextPath }/img/Registerbtn.jpg" name="Image17" width="60" height="23" border="0" id="Image17" /></a></div>
		<div id="apDiv18"><a href="${pageContext.request.contextPath }/servlet/LoginUIServlet" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image18','','${pageContext.request.contextPath }/img/LoginChangedbtn.jpg',1)"><img src="${pageContext.request.contextPath }/img/Loginbtn.jpg" name="Image18" width="60" height="23" border="0" id="Image18" /></a></div>
	</c:if>
	
	 <c:if test="${user!=null }">	 	
	 	<div id="apDiv19"><span class="welcome">Welcome: ${user.username }</span></div>
		<div id="apDiv20"><a href="${pageContext.request.contextPath }/servlet/LogoutServlet" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image19','','${pageContext.request.contextPath }/img/LogoutChangedbtn.jpg',1)"><img src="${pageContext.request.contextPath }/img/Logoutbtn.jpg" name="Image19" width="60" height="23" border="0" id="Image19" /></a></div>
	 </c:if>
</body>
</html>
