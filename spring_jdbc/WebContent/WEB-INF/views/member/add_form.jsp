<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSS 디자인 틀</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_jdbc/common/css/main_v20190130.css">
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
		url("http://localhost:8080/spring_jdbc/common/images/header_bg.png");
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

		$("#upfile").change(function() {

			var upfile = $("#upfile").val();

			if (upfile == "") {
				alert("이미지를 선책해 주세요.");
			}// end if
			readImgFile(this);

			// 클라이언트의 파일은 보안 이슈로 인해 직접 접근하여 미리보기를 할 수 없다.
			/*
			var img = $("#img");
			img.src = upfile;
			alert(img.src);
			 */

		}); // click	

	}); //ready

	function readImgFile(input) {
		// iuput type 파일의 첫 째 파일 이라면.
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#img').attr('src', e.target.result);
			}//function
			reader.readAsDataURL(input.files[0]);
		}//end if
	}//readURL
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
			<!-- 파일업로드의 요청방식은 POST만 사용할 수 있다. -->
			<form action="add_member_process.do" method="post" enctype="multipart/form-data">
				<table border="1">
					<tr>
						<th colspan="3">
							<h2>회원정 보 추가</h2>
						</th>
					</tr>
					<tr>
						<td width="100">이미지</td>
						<td width="100">이름</td>
						<td width="100">
							<input type="text" name="name" class="inputBox" />
						</td>
					</tr>
					<tr>
						<td rowspan="5">
							<img id="img" src="common/images/default.png" style="width: 100px; height: 100px;" />
							<br>
							<input id="upfile" name="upfile" type="file" class="inputBox" />
						</td>
					</tr>
					<tr>
						<td>지역</td>
						<td>
							<input type="text" name="loc" class="inputBox">
						</td>
					</tr>
					<tr>
						<td>출신학교</td>
						<td>
							<select name="high_school">
								<option value="오지고">오지고</option>
								<option value="지리고">지리고</option>
								<option value="렛잇고">렛잇고</option>
								<option value="맛보고">맛보고</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="입력" class="btn">
						</td>
					</tr>
				</table>
			</form>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

