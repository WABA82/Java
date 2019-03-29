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
		$(".btn").click(function() {
			var name = $("[name='name']:checked").val();
			var queryString = "name=" + encodeURI(name);
			$.ajax({
				url : "xml_result.jsp",

				type : "get",

				data : queryString,

				dataType : "xml",

				error : function(xhr) {
					alert(xhr.status);
				},// error

				success : function(xml_data) {
					alert(xml_data);
					/* 값은 나오난 잘못된 parsing alert($(xml_data).find("name").text()) */
					var nameNodes = $(xml_data).find("name");
					var output="";
					$.each(nameNodes, function(idx, nameNode) {
						/* alert($(this).text()); */
						output += "<input type='checkbox' name='name' value='" + $(this).text()+"'>'" + $(this).text() + "<br/>";
					}); // end each 
					$("#memberView").html(output);
				}// success
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
				<input type="radio" name="name" value="이봉현" checked="checked" />1조
				<br>
				<input type="radio" name="name" value="박영민" />2조
				<br>
				<input type="radio" name="name" value="오영근" />3조
				<br>
				<input type="radio" name="name" value="김건하" />조기취업
				<br>
				<input type="button" class="btn" value="조회" />

			</div>
			<div id="memberView"></div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

