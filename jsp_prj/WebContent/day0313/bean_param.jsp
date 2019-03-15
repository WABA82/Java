<%@page import="com.sun.org.apache.bcel.internal.generic.LNEG"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="Web parameter를 useBean action tag로 처리하는 방법."%>
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
			<!-- HTML Form Control의 값 받기 -->
			<%
				request.setCharacterEncoding("UTF-8");
			%>
			<!-- 1. bean 생성 -->
			<jsp:useBean id="bp_vo" class="day0313.BeanParamVO" scope="page" />
			<!-- 2. setter 메서드를 호출하여 값을 저장 -->
			<jsp:setProperty property="*" name="bp_vo" />

			<table>
				<tr>
					<td colspan="2">입력 하신 정보는 아래와 같습니다.</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><jsp:getProperty property="id" name="bp_vo" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><jsp:getProperty property="name" name="bp_vo" /></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<!-- 숫자로 변환되어 저장된 값 -->
						<jsp:getProperty property="b_year" name="bp_vo" />
						-
						<jsp:getProperty property="b_month" name="bp_vo" />
						-
						<jsp:getProperty property="b_day" name="bp_vo" />
						(만
						<%=2019 - bp_vo.getB_year()%>세)
					</td>
				</tr>
				<tr>
					<td>관심 언어</td>
					<td>
						<jsp:getProperty property="interestlang" name="bp_vo" />

						<%
							String[] lang = bp_vo.getInterestlang();
							if (lang != null) {
								for (int i = 0; i < lang.length; i++) {
									out.print(lang[i]);
									out.println("");
								} // end for
							} else {
								out.println("관심 언어 없음");
							} // end else
						%>
					</td>
				</tr>
			</table>

		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

