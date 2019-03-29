<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<script type="text/javascript">
	$(function() {
		$("#btn").click(
				function() {

					var name = $("#name").val();
					// chrome은 URL을 자동 처리, IE는 처리하지 않는다.
					// encodeURI 함수를 사용하여 처리해준다.
					var queryString = "name=" + encodeURI(name);

					$.ajax({
						url : "text_result.jsp",
						type : "GET",
						data : queryString,
						dataType : "TEXT",
						error : function(xhr) {
							//xhr - XMLHtttpRequest : error의 이유를 확인가능.
							//200 - 서버가 정상 실행되어 응답 성공하였으나, 응답의 형태가 처리 가능한 데이터가 아닐 때.
							alert("에러코드  : " + xhr.status + ", 에러메세지 : "
									+ xhr.statusText);

						},// 에러

						// 서버에서 응답된 데이터를 받아 처리한다.
						success : function(text_data) {
							var output = "<strong>" + name
									+ "</strong> 조장의 조원 <ul>";

							var data = text_data.split(",");

							for (var i = 0; i < data.length; i++) {
								output += "<li>" + data[i] + "</li>";
							}// end for
							output += "</ul>";

							$("#memberView").html(output);

						}// 성공.

					});// ajax

				});// click
	}); //ready
</script>

</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
			<div style="padding-top: 100px;">
				<c:import url="../common/jsp/main_menu.jsp" />
			</div>
		</div>

		<div id="container">
			<div>
				조장 : <input type="text" id="name" class="inputBox">
				<br>
				<input type="button" value="입력" class="btn" id="btn">
			</div>
			<div id="memberView"></div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

