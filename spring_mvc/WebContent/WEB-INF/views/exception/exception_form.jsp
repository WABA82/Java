<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="Controller에서 HttpServletRequest를 사용하여 전달된 값을 처리하는 Page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSS 디자인 틀</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.135/common/css/main_v20190130.css">
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
		url("http://211.63.89.135/common/images/header_bg.png");
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
			
			<!-- Runtime Exception -->
			<form action="number_format.do" method="get">
				<label>나이</label> 
				<input type="text" name="age" class="inputBox">
				<input type="submit" value="전송" class="btn">
				<br>
				문자열을 입력하면 NumberFormatException이 발생하고 처리하는 페이지로 이동합니다.
			</form>
		
			<br>
			-----------------------------------------------------------------
			<br>
			
			<!-- Compile Exception -->
			<form action="class_not_found.do" method="get">
				<input type="submit" value="ClassNotFoudException이 발생(랜덤으로 발생)하는 페이지로 이동" class="btn">
			</form>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

