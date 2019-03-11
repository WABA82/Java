<!-- 지시자 하나에 여러 속성 사용하는 경우 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="Page Directive 연습"%>
<%@ page buffer="8kb" autoFlush="true"%>
<%@ page isThreadSafe="true"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Random"%>
<%@ page import="java.lang.Exception"%>
<%@ page isELIgnored="false"%>
<%@ page errorPage="page_directive1.jsp"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSS 디자인 틀</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css">
<style type="text/css">
#wrap {
	margin: 0px auto; /* 가운데 정렬  */
	width: 800px;
	height: 860px;
	/* background-color: #ff0000; */
}

#header {
	width: 800px;
	height: 140px;
	background: #e5c3ef
		url("http://localhost:8080/jsp_prj/common/images/header_bg.png");
	position: relative;
}

#headerTitle {
	font-family: HY견고딕, 고딕;
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	/* 위치 조정 */
	position: absolute;
	top: 30px;
	left: 290px;
}

#container {
	width: 800px;
	height: 600px;
	background-color: #3cff15;
}

#footer {
	width: 800px;
	height: 120px;
	background-color: #3ceff8;
}

#footerTitle {
	float: right;
	font-size: 15px;
	padding-top: 20px;
	padding-right: 20px;
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
		</div>
		<div id="container">
			<%
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String date = sdf.format(new Date());

				int year = Calendar.getInstance().get(Calendar.YEAR);

				if (new Random().nextBoolean()) {
					throw new Exception("예외 강제 발생!!");
				} // end if

				session.setAttribute("name", "정택성");
			%>
			<%=date%>,
			<%=year%>
			<div>
				<strong>EL(Expression Language)</strong>
				<br>
				3 +11 = ${3+11}
				<br>
				web parameter : ${ param.name }
				<br>
				<a href="page_directive.jsp?name=heechul">요청</a>
			</div>
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>
</body>
</html>
