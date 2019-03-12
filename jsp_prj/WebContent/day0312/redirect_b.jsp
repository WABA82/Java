<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="redirect의 연습."%>
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
			비정상적인 요청이 있을 때 보여질 페이지
			<br>
			<a href="redirect_a.jsp?name=jungyun&age=20">redirect_a 요청</a>
			<div>
				<!-- 
					* forward 이동 방식과 다르게 이동한 페이지에서 파라미터 값을 사용할 수 없다. 
					* redirect 이동 방식 : 비정상적인 요청이 있을 때 제공될 페이지이므로 이전 페이지의 값들을 유지하여 사용하지 않는다.
				-->
				파라미터 이름 : <%=request.getParameter("name")%>
				파라미터 나이 : <%=request.getParameter("age")%>
			</div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

