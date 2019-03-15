<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="jsp:useBean의 scope에 대한 연습"%>
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
			<!-- 
				page-기본설정 : 요청할 때마다 객체 생성되며, 생성된 객체는 현재 페이지에서만 사용.			
				request : 요청할 때마다 객체 생성되며, 생성된 객체는 현재 페이지와 forward로 이동한 페이지에서 사용.
				session : 접속자 마다 객체가 생성되며, 생성된 객체는 모든 jsp에서 사용할 수 있다. 단, 접속을 종료하면 사라진다.
				application : 최초 접속자에 의해 하나의 객체가 생성되고 생성된 객체는 모든 jsp에서 모든 접속자가 사용(공용으로 사용) WAS가 종료 되면 사라진다.
			-->
			<jsp:useBean id="c_vo" class="day0313.CounterVO" scope="application" />
			<jsp:setProperty property="cnt" name="c_vo" value="1" />
			안녕하세요?
			<br>
			이 페이지의 [<strong><jsp:getProperty property="cnt" name="c_vo" /></strong>]번째 방문자 입니다.
			<div>
				<%
					String str_Cnt = String.valueOf(c_vo.getCnt());
					for (int i = 0; i < str_Cnt.length(); i++) {
				%>
				<img src="images/num_<%=str_Cnt.substring(i, i + 1)%>.png">
				<%
					} // end for
				%>
			</div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

