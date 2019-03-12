<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" info="Session 내장 객체 사용."%>
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
			<%!private Map<String, String> logmap = new HashMap<String, String>();
	{//instance 영역 : 클래스가 실행 될 때 자동 호출 되며, 한번만 실행 된다.
		logmap.put("gong", "공선의");
		logmap.put("lee", "이재찬");
		logmap.put("kim", "김희철");
	}
	//이름이 없으므로 개발자가 직접 호출 할 수 없다.%>
			<%
				String id = request.getParameter("id");
				String pass = request.getParameter("pass");

				if (logmap.containsKey(id) && "1234".equals(pass)) {
					//로그인 성공.
					//세션의 값 설정.
					session.setAttribute("user_id", id);
					session.setAttribute("user_name", logmap.get(id));

					// 세션의 생존시간 설정.
					session.setMaxInactiveInterval(60 * 1);

					// Servlet이나 JSP에서 Console로 출력할 때 log method 사용.
					String name = (String) session.getAttribute("user_name");
			%>
			로그인 성공
			<br />
			<a href="use_session_c.jsp">로그아웃</a>
			<br>
			<%=name%>님이 로그인
			<br>
			<a href="job_a.jsp">작업페이지</a>
			<%
				} else { //로그인 실패.
			%>
			아이디나 비밀번호를 확인해 주세요.
			<br>
			<a href="use_session.html">로그인</a>
			<%
				} // end else
			%>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

