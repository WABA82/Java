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
		$("#group").change(function() {
				var name = $("#group").val();

				if (name != "none") {
				var queryString = "name=" + encodeURI(name);
				$.ajax({
					url : "html_result.jsp",
					type : "get",
					data : queryString,
					dataType : "html",
					error : function(xhr) {
						$("#memberView").html("<img src='../common/images/img.png'/>");
						for (var i = 0; i < 4; i++) {
							$("#memberView").fadeOut(1000).fadeIn(2000);
						}// end for
					}, // error

					success : function(html_data) {
						var temp = html_data.replace("김건하","김건하 CEO");
						$("#memberView").html(html_data);
					}// success

				})// ajax
			}// end if
		}); // change
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
				<select id="group">
					<option value="none">조 선택</option>
					<option value="이봉현">1조</option>
					<option value="박영민">2조</option>
					<option value="오영근">3조</option>
					<option value="김건하">조기취업</option>
				</select>
			</div>
			<div id="memberView"></div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

