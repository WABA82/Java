<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="EL에서 제공하는 변수관련 태그 사용."%>

<!-- JSTL을 사용하려면 지시자 선언을 해야한다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
				int month = 3;
				pageContext.setAttribute("month", month);
			%>
			<!-- 변수의 선언 -->
			<c:set var="i" value="14" />
			<c:set var="mon" value="<%=month%>" />
			<c:set var="name" value="김희철" />

			<!-- 출력 - 취약점을 보완하기 위해  c:out안에 EL을 사용한다.-->
			i = <c:out value="${ i+1 }" />
			<br>
			<strong><c:out value="${ name }" /></strong>
			pageScope 사용 : <c:out value="${ month }" /> ( <c:out value="${ pageScope.month }" /> )
			<br>
			&lt;c:set&gt;사용 : <c:out value="${ mon }" />
			<!-- 변수의 삭제 : 삭제된 변수는 아무것도 출력되지 않는다. -->
			<c:remove var="i"/>
			<c:remove var="name"/>
			<br>
			변수 삭제후 출력<br>
			i = <c:out value="${ i }"/>
			<br>
			name = <c:out value="${ name }"/>
			<br>
			mon = <c:out value="${ mon }"/>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

