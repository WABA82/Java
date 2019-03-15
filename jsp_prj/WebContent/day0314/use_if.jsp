<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="JSTL의 if문"%>
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
			<a href="#void">공지 사항 읽기</a>
			<c:if test="${ param.user_role eq 'admin' }">
				<a href="#void">공지 사항 쓰기</a>
				<a href="#void">공지 사항 수정</a>
				<a href="#void">공지 사항 삭제</a>
			</c:if>
			<div>
				<a href="use_if.jsp?user_role=user">일반 사용자</a> <a href="use_if.jsp?user_role=admin">관리자</a>
			</div>

			<form action="use_if.jsp">
				<label>이름</label> : <input type="text" name="name" class="inputBox" /> <input type="submit" value="입력" class="btn" />
			</form>
			<div>
				위의 From Control에서 입력된 이름을 출력 하는데 이름이 '이재찬'이라면 흘러가도록 만들어 보세요.JSTL
				<%-- <c:if test="${ param.name == '이재찬'}">
					<marquee>
				</c:if>
				<c:if test="${ param.name == '이재찬'}">
					<c:out value="${ param.name }" />
					</marquee>
				</c:if> --%>
				<c:if test="${ param.name == '이재찬'}">
					<marquee>
					<c:out value="${ param.name }" />
					</marquee>
				</c:if>
			</div>

		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

