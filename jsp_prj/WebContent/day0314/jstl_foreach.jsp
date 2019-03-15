<%@page import="day0313.TestVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="반복문 forEach의 사용"%>
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
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
		</div>

		<div id="container">
			<select>
				<!-- 증가하는 값을 반복시킬때. -->
				<c:forEach var="i" begin="1" end="100" step="1">
					<option value="${ i }"><c:out value="${ i }" /></option>
				</c:forEach>
			</select>

			<div>
				<%
					String[] movie = { "시네마 천국", "주토피아", "코어", "7인의 사무라이", "트루먼 쇼", "인셉션" };
					pageContext.setAttribute("movie", movie);
				%>
				<ul>
					<c:forEach var="movie" items="${ movie }">
						<c:set var="i" value="${ i+1 }" />
						<li>${ i }.${ movie }</li>
					</c:forEach>

					<%
						List<String> list = new ArrayList<String>();
						list.add("Java SE");
						list.add("Java EE");
						list.add("DBMS");
						list.add("HTML");
						pageContext.setAttribute("list", list);
					%>

					<ul>
						<c:forEach var="subject" items="${ list }">
							<li><c:out value="${ subject }"></c:out></li>
						</c:forEach>
					</ul>
					<%
						//list가 제네릭으로 VO를 가지는 경우의 사용.
						//forEach안에서 변수명.getter명.
						List<TestVO> voList = new ArrayList<TestVO>();
						voList.add(new TestVO("정윤", 30));
						voList.add(new TestVO("희철", 30));
						voList.add(new TestVO("재찬", 26));
						voList.add(new TestVO("택성", 28));

						pageContext.setAttribute("vl", voList);
					%>
				</ul>

				<table border="1">
					<thead>
						<tr>
							<th width="50">이름</th>
							<th width="100">이름</th>
							<th width="50">나이</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="data" items="${ vl }">
							<c:set var="cnt" value="${ cnt + 1 }"></c:set>
							<tr>
								<td>
									<c:out value="${ cnt }" />
								</td>
								<td>
									<c:out value="${ data.firstName }" />
								</td>
								<td>
									<c:out value="${ data.age }" />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

