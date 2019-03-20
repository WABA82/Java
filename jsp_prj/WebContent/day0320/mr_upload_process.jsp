<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="MultipartRequest사용 파일 업로드 처리."%>
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
				// 1. 객체 생성 - 파일 업로드 자동 실행.
				int maxSize = 1024 * 1024 * 10;// 최대 10mb이하의 파일까지 업로드 가능.
				File repository = new File("C:/dev/workspace/jsp_prj/WebContent/upload");
				MultipartRequest mr = new MultipartRequest(request, repository.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());

				// 2. 파라미터 처리.
				String name = mr.getParameter("uploader");
				String age = mr.getParameter("age");

				// DefaultFileRenamePolicy에 의해 변경된 이름이 될수도 있음.
				String fileName = mr.getFilesystemName("upfile");

				// 4.원본 파일명 받기.
				String originalFileName = mr.getOriginalFileName("upfile");
			%>
			<div>
				<strong>파일업로드성공</strong>
				<ul>
					<li>업로더 : <%=name%></li>
					<li>연령대 : <%=age%></li>
					<li>업로드 된 파일명 : <%=fileName%></li>
					<li>원본 파일명 : <%=originalFileName%></li>
					<li><a href="mr_upload_form.jsp">업로드 창으로</a></li>
					<li><a href="../day0319/file_list.jsp">파일리스트 보기</a></li>
				</ul>
			</div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

