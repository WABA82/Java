<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css">
<style type="text/css">
#wrap {
	margin: 0px auto;
	width: 800px;
	height: 860px;
}

#header {
	width: 800px;
	height: 140px;
	background: #e5c3ef
		url("http://localhost:8080/jsp_prj/common/images/header_bg.png");
	position: relative;
}

#headerTitle {
	font-family: HY견고딕;
	font-size: 30px;
	font-weight: bold;
	text-align: center;
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			if ($("#uploader").val() == "") {
				$("#uploader").focus();
				return;
			}// end if

			if ($("#upfile").val() == "") {
				alert("업로드할 파일을 선택해 주세요.")
				return;
			}// end if

			// 확장자가 jsp,java,class,xml은  업로드하지 못하도록 막는다. -- 아직 완성 못함.
			/* 방법1 */
			var ext = [ "jsp", "java", "class", "xml" ]
			var flag = false;
			//var fileName = $("#upfile").val();
			//var inputExt = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
			var fileName = $("#upfile").val().split(".");
			var inputExt = fileName[fileName.length - 1].toLowerCase();
			for (var i = 0; i < ext.length; i++) {
				if (ext[i] == inputExt) {
					flag = true;
				}// end if
			}// end for

			if (flag) {
				alert("업로드 할수 없는 파일 형식입니다.");
			}// end if

			/* 방법2 */
			//var tempfile = ($("#upfile").val().substr($("#upfile").val().lastIndexOf(".")+1)).toLowerCase();
			//if (tempfile == "jsp" || tempfile == "java" || tempfile == "class" || tempfile == "xml") {
			//	alert("업로드 할수 없는 파일 형식입니다.");
			//	return;
			//}// end if
			$("#uploadFrm").submit();
		});//click
	});//ready
</script>
</head>

<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
		</div>

		<div id="container">

			<!-- HTML 폼 기반의 파일업로드
				1. enctype = "multipart/form-data"
				2. method = "post"
			-->
			<form action="upload_process.jsp" id="uploadFrm" method="post" enctype="multipart/form-data">
				<label>이름</label> <input type="text" name="uploader" class="inputBox" id="uploader" />
				<br>
				<label>나이</label>
				<select name="age" id="age">
					<c:forEach var="i" begin="10" end="80" step="10">
						<option value="${ i }">
							<c:out value="${ i }" />대
						</option>
					</c:forEach>
				</select>
				<br>
				<label>파일</label><input type="file" name="upfile" id="upfile" class="inputBox" style="width: 200px;">
				<br>
				<input type="button" value="업로드" class="btn" id="btn">
			</form>
			<%-- <%= // System.getenv(); System.getProperties() %> --%>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>