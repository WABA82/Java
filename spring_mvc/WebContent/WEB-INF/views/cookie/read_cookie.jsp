<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSS 디자인 틀</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc/common/css/main_v20190130.css">
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
		url("http://localhost:8080/spring_mvc/common/images/header_bg.png");
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
	min-height: 600px;
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

<!-- CDN : jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- 자바스크립트 작성. -->
<script type="text/javascript">
	$(function() {
		<c:if test="${ cookieFlag }">
			alert("${ msg }");
		</c:if>
	}); //ready
</script>
<!-- 자바스크립트 작성. -->

</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
			<div style="padding-top: 100px;">
				<c:import url="/common/jsp/main_menu.jsp" />
			</div>
		</div>

		<div id="container">
			<div>
				<strong>Model에 들어있는 쿠키들 읽기</strong>
				<br>

				<c:if test="${ empty requestScope.rCookie }">
					쿠키가 존재 하지 않습니다. - <a href="add_cookie.do">[ 쿠키심기 ]</a>
					<br>
				</c:if>

				<%-- <c:forEach var="cookie" items="${ rCookie }">
					쿠키명 : <c:out value="${ cookie.name }" />
					<br>
					쿠키값 : <c:out value="${ cookie.value }" />
					<br>
				</c:forEach> --%>
				<%
					Cookie[] t = (Cookie[]) request.getAttribute("rCookie");
					if (t != null) {
						for (Cookie tt : t) {
							out.println(tt.getName() + " " + tt.getValue() + "<br>");
						}
					}
				%>

				<c:if test="${ not empty requestScope.rCookie }">
					<strong>쿠키 값</strong>
					<br>
					<c:out value="${ requestScope.name }" escapeXml="false" />
					<br>
					태어난 해
					<c:out value="${ requestScope.birth }" escapeXml="false" />

					쿠키가 존재 합니다. - <a href="remove_cookie.do">[ 쿠키삭제 ]</a>
					<br>
				</c:if>

			</div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

