<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
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
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
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
			<%
				File uploadFolder = new File("C:/dev/workspace/jsp_prj/WebContent/upload");
				File[] listFile = uploadFolder.listFiles();
			%>
			<a href="upload_form.jsp">업로드</a>
			<table border="1">
				<tr>
					<th width="60">번호</th>
					<th width="350">파일명</th>
					<th width="150">업로드 일시</th>
					<th width="120">크기(byte)</th>
				</tr>
				<%
					if (listFile.length != 0) {
						File temp = null;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
						for (int i = 0; i < listFile.length; i++) {
							temp = listFile[i];
				%>
				<tr>
					<td><%=i + 1%></td>
					<td>
						<!-- 
							IE에서는 한글파일명을 link로 전송할 때에는 인코딩 처리를 해주어야 값이 올바르게 전송된다.
							단, <form>으로 한글을 넘길 때에는 브라우저에서 인코딩을 처리해 주기 때문에 개발자가 따로 처리하지 않아도 된다.
						-->
						<a href="download.jsp?file_name=<%=URLEncoder.encode(temp.getName(), "UTF-8")%>"> <%=temp.getName()%>
						</a>
					</td>
					<td><%=sdf.format(new Date(temp.lastModified()))%></td>
					<td><%=temp.length()%></td>
				</tr>
				<%
					} // end for
					} else {
						out.println("<tr><td colspan='4' align='center'>업로드된 파일이 존재하지 않습니다.</td></tr>");
					} // end else
				%>
			</table>

		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

