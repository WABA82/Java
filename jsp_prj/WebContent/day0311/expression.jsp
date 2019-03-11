<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div id="header" >
		<div id="headerTitle">SIST Class4</div>
	</div>
	
	<div id="container">
	
		<%
			// scriptlet
			String name = "김정윤";
			String addr = "서울시 강남구 역삼동";
		%>
		
		<ul>
			<li>이름 : <%= name %></li>
			<li>주소 : <%= addr %></li>
		</ul>
		<br>
		<!-- Expression에서는 값을 하나만 출력 할 수 있다. -->
		<%-- <%= name, addr %> --%>
		<!-- Expression에서는 ;을 사용할 수 없다. -->
		<%-- <%= name; %> --%>

			
	</div>
	
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4 </div>
	</div>
</div>

</body>
</html>

