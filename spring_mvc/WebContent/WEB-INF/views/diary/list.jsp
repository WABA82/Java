<%@page import="kr.co.sist.vo.DiaryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSS 디자인 틀</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc/common/css/main_v20190130.css">
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
		url("http://localhost:8080/spring_mvc/common/images/header_bg.png");
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

/* 다이어리 CSS */
#diary {
	margin-top: 20px;
}

#diaryHeader {
	font-size: 19px;
	font-weight: bold;
	text-align: center;
	height: 40px;
}

#diaryContents {
	height: 400px;
}

#diaryIndexList {
	height: 30px;
	text-align: center;
}

#diarySearch {
	height: 30px;
	text-align: center;
}

#listTab {
	border-top: 2px solid #3c4790;
	border-spacing: 0px;
}

#numTitle {
	width: 50px;
	height: 25px;
	background-color: #f3f3f3;
}

#subjectTitle {
	width: 350px;
	height: 25px;
	background-color: #f3f3f3;
}

#writerTitle {
	width: 120px;
	height: 25px;
	background-color: #f3f3f3;
}

#evtDayTitle {
	width: 150px;
	height: 25px;
	background-color: #f3f3f3;
}

#wriDayTitle {
	width: 150px;
	height: 25px;
	background-color: #f3f3f3;
}

th, td {
	border-bottom: 1px solid #eeeeee
}

td {
	height: 24px;
}

tr:hover {
	background-color: #f3f3f3;
}

.center {
	text-align: center;
}
</style>

<!-- CDN : jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- 자바스크립트 작성. -->
<script type="text/javascript">
	$(function() {
	}); //ready
</script>
<!-- 자바스크립트 작성. -->

</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
			<div style="padding-top: 100px;">
				<c:import url="/common/jsp/main_menu.jsp" />
			</div>
		</div>

		<div id="container">
			<div>
				<div id="diary">
					<div id="diaryHeader">
						<span style="float: left;"><a href="list.jsp"><img alt="" src="images/btn_all.png"></a></span> 이벤트 리스트
					</div>
					<div id="diaryContents" style="height: 400px">
						<table id="listTab">
							<tr>
								<th id="numTitle">번호</th>
								<th id="subjectTitle">이벤트 제목</th>
								<th id="writerTitle">작성자</th>
								<th id="evtDayTitle">이벤트 일자</th>
								<th id="wriDayTitle">작성일자</th>
							</tr>

							<c:if test="${ not empty e }">
								<tr>
									<td colspan="5">서비스가 원활하지 못한점 죄송합니다.</td>
								</tr>
							</c:if>

							<c:if test="${empty list}">
								<tr>
									<td colspan="5">
										이벤트가 존재하지 않습니다.
										<br>
										<a href="diary.jsp">이벤트 작성</a>
									</td>
								</tr>
							</c:if>

							<c:forEach var="data" items="${ diaryList }">
								<c:set var="i" value="${ i+1 }" />
								<tr>
									<td>
										<c:out value="${ (param.currentPage-1)*pageScale+i }" />
									</td>
									<td>
										<a href="bbs_read.do?num=${ data.num }"><c:out value="${ data.subject }" /></a>
									</td>
									<td>
										<c:out value="${ data.writer }" />
									</td>
									<td>
										<c:out value="${ data.e_year }-${ data.e_month }-${ data.e_day }" />
									</td>
									<td>
										<c:out value="${ data.w_date  }" />
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>

					<div id="diaryIndexList">
						<!-- escapeXml="false" c:out으로 태그를 출력할 때. -->
						<c:out value="${indexList}" escapeXml="false" />
					</div>
				</div>
			</div>
			<div id="view"></div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

