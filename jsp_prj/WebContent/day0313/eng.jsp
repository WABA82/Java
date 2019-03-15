<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				//HTML Form Controll에서 입력된 값.
				String name = request.getParameter("name");
				String age = request.getParameter("age");
				String addr = request.getParameter("address");

				//<jsp:param>으로 생성된 값.
				String lang = request.getParameter("lang");
				String date = request.getParameter("date");
			%>
			<strong>Hello? This is English page</strong>
			<br>
			<strong>Values are under contents</strong>
			<br>
			<ul>
				<li>Name : <strong><%=name%></strong></li>
				<li>Age : <strong><%=age%></strong></li>
				<li>Address : <strong><%=addr%></strong></li>
				<li>Language : <strong><%=lang%></strong></li>
				<li>Access Time : <strong><%=date%></strong></li>
				<li>Locations : <select>
						<%
							String[] loc = (String[]) request.getAttribute("loc");

							for (int i = 0; i < loc.length; i++) {
						%>
						<option value="<%=loc[i]%>"><%=loc[i]%></option>
						<%
							} // end for
						%>
					</select>
				</li>
			</ul>
			<br>
			<a href="forward_a.jsp">입력폼으로 이동</a>

		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

