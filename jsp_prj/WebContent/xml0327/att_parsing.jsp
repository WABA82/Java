<%@page import="day0327.AttVO"%>
<%@page import="java.util.List"%>
<%@page import="day0327.AttParsing"%>
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
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			$("[name = 'frm']").submit();
		});// click
	}); //ready
</script>

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
			<div>
				<form name="frm" method="get" action="att_parsing.jsp">
					<select id="lastName" name="lastName">
						<option value="김">김씨</option>
						<option value="이">이씨</option>
						<option value="박">박씨</option>
						<option value="최">최씨</option>
						<option value="정">정씨</option>
						<option value="노">노씨</option>
					</select>
					<input type="button" value="조회" id="btn" class="btn">
				</form>
			</div>


			<c:if test="${ not empty param.lastName }">
				<div>
					<div>선택하신 "${ param.lastName }"으로 조회한 결과 입니다.</div>
					<div>
						<%
							String lastName = request.getParameter("lastName");

								AttParsing ap = new AttParsing();
								List<AttVO> list = ap.personData(lastName);

								pageContext.setAttribute("personList", list);
						%>
						<table border="1">
							<tr>
								<th width="100">이름</th>
								<th width="400">주소</th>
							</tr>
							<c:if test="${ empty personList }">
								<tr>
									<td colspan="2" align="center">검색 결과가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<c:forEach var="data" items="${ personList }">
								<tr>
									<td>
										<c:out value="${ data.lastName }" />
										<c:out value="${ data.firstName }" />
									</td>
									<td>${ data.address }(${ data.city },${ data.zipcode })</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</c:if>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

