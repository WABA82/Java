<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info=""%>


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
<!-- summernote 관련 library 시작. -->

<!-- include libraries(jQuery, bootstrap) -->
<link href="../common/summernote/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="../common/summernote/bootstrap.js"></script>
<!-- include summernote css/js -->
<link href="../common/summernote/summernote-lite.css" rel="stylesheet">
<script src="../common/summernote/summernote-lite.js"></script>
<!-- include summernote-ko-KR -->
<script src="../common/summernote/lang/summernote-ko-KR.js"></script>
<!-- 사용 -->
<script type="text/javascript">
	$(function() {
		$('#summernote').summernote({
			placeholder : '서머노트 우왕굳',
			tabsize : 2,
			height : 150,
			width : 730,
			lang : 'ko-KR' // default: 'en-US'
		});
	}); // ready
</script>

<!-- summernote 관련 library 끝. -->
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			$("form").submit();
		});// click
	});//ready
</script>


</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
		</div>

		<div id="container">
			<form method="post" action="summernote_process.jsp">
				<label>작성자</label> <input type="text" name="name" class="inputBox" />
				<br>
				<label>제목</label> <input type="text" name="subject" class="inputBox" />
				<br>
				<label>내용</label>
				<textarea id="summernote" name="contents"></textarea>
				<br>
				<input type="button" value="글쓰기" class="btn" id="btn">
			</form>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

