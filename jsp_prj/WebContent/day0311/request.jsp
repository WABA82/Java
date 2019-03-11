<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<ul>
				<li><strong>접속 URL</strong> : <%=request.getRequestURL()%></li>
				<li><strong>요청 Protocol</strong> : <%=request.getProtocol()%></li>
				<li><strong>요청 서버명</strong> : <%=request.getServerName()%></li>
				<li><strong>요청 서버 Port</strong> : <%=request.getServerPort()%></li>
				<li><strong>요청 URI</strong> : <%=request.getRequestURI()%></li>
				<li><strong>요청 서블릿 Path</strong> : <%=request.getServletPath()%></li>
				<li><a href="request.jsp?name=jinkyung&addr=gangseogu&age=30">JSP QueryString 요청</a></li>
				<li><strong>QueryString</strong> : <%=request.getQueryString()%></li>
				<li><strong>요청 Parameter</strong> : <%=request.getParameter("name")%></li>
				<li><strong>요청 방식</strong> : <%=request.getMethod()%></li>
				<li><strong>접속자의 IP</strong> : <%=request.getRemoteAddr()%></li>
				<li><strong>접속자의 Port</strong> : <%=request.getRemotePort()%></li>
			</ul>

		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

