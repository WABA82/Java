<%@page import="java.io.IOException"%>
<%@page import="kr.co.sist.diary.vo.DiaryDetailVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="java.sql.SQLException"%>
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

<!-- CDN : jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

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
			<div id="readFrm">
				<%
					DiaryDAO d_dao = DiaryDAO.getInstance();
					try {
						int num = Integer.parseInt(request.getParameter("num"));
						DiaryDetailVO dd_vo = d_dao.selectDetailEvent(num);
						if (dd_vo == null) {
							throw new NullPointerException();
						} // end if
				%>
				<form action="list.jsp" method="post" name="readFrm">
					<input type="hidden" name="pageFlag"> <input type="hidden" name="num" value="${ param.num }"> <input type="hidden" name="param_year" value="${ param.param_year }"> <input type="hidden" name="param_month" value="${ param.param_month }">
					<table id="readTab">

						<tr>
							<th colspan="2" style="text-align: center;">
								<span style="font-size: 20px">이벤트 읽기.</span> <span style="float: right; padding-right: 7px"> <a href="#void" id="btnCloseFrm"> <img src="images/btn_close.png">
								</a>
								</span>
							</th>
						</tr>

						<tr>
							<td style="width: 80px;">제목</td>
							<td style="width: 400px;">
								<div id="subject">
									<strong><%=dd_vo.getSubject()%></strong>
								</div>
							</td>
						</tr>

						<tr>
							<td style="width: 80px;">내용</td>
							<td style="width: 400px;">
								<%=dd_vo.getContents()%>
							</td>
						</tr>

						<tr>
							<td style="width: 80px;">작성자</td>
							<td style="width: 400px;">
								<div id="writer">
									<strong><%=dd_vo.getWriter()%></strong>
								</div>
							</td>
						</tr>

						<tr>
							<td style="width: 80px;">비밀번호</td>
							<td style="width: 400px;">
								<input type="password" name="pass" id="pass" class="inputBox" style="width: 200px;">
							</td>
						</tr>

						<tr>
							<td style="width: 80px;">작성일</td>
							<td style="width: 400px;">
								<div id="w_date"><%=dd_vo.getW_date()%></div>
							</td>
						</tr>

						<tr>
							<td style="width: 80px;">작성IP</td>
							<td style="width: 400px;">
								<div id="ip"><%=dd_vo.getIp()%></div>
								(<%=request.getRemoteAddr()%>)
							</td>
						</tr>

						<tr>
							<td colspan="2" align="center">
								<a href="#void" onclick="history.back()">리스트</a>
							</td>
						</tr>
					</table>

				</form>
				<%
					} catch (IOException ioe) {
				%>
				글의 내용을 읽어들이지 못했습니다.
				<%
					} catch (NumberFormatException ne) {
				%>
				유효하지 않은 파라미터가 입력되었습니다.
				<%
					} catch (NullPointerException nfe) {
				%>
				해당글을 찾을 수 없습니다.
				<br>
				<%
					} catch (SQLException se) {
						se.printStackTrace();
				%>
				<img alt="" src="construction.jpg" title="죄송합니다. 정보를 가져오는 도중 문제가 발생했습니다.">
				<%
					} // end catch
				%>
			</div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

