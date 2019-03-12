<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="업무처리페이지(forward_a.jsp)에서 처리한 결과를 받아 화면을 구성하는 일 만합니다."%>

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
				//이전 페이지에서 처리된 결과 받기.
				String[] member = (String[]) request.getAttribute("group2");

				// member에 들어오는 값이 없을 때.
				if (member == null) {
					//redirect는 아래의 코드를 실행한다.
					response.sendRedirect("forward_a.jsp");
					return;
				} // end if
			%>

			<table border="1">
				<tr>
					<th width="100">이름</th>
				</tr>
				<%
					for (int i = 0; i < member.length; i++) {
				%>
				<tr>
					<td><%=member[i]%></td>
				</tr>
				<%
					} // end for
				%>
			</table>
	
			<a href="forward_a.jsp?name=jungyun&age=30">Parameter</a>
			<br>
			<!-- forward로 이동한 페이지에서 이전페이지의 Parameter를 사용할 수 있다. -->
			이름 : <%= request.getParameter("name") %>
			<br>
			나이 : <%= request.getParameter("age") %>
			<br>
	
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

