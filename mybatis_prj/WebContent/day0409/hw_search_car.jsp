<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisHwService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String country = request.getParameter("country_select");

	MyBatisHwService mbhs = new MyBatisHwService();

	if (country != null) {
		List<String> list = mbhs.carMakerList();
		pageContext.setAttribute("makerList", list);
	} //end if
%>

<script type="text/javascript">
	$(function() {
		$("#frm").change(function() {
			$("#frm").submit();
		});// 
	});// ready
</script>

<form id="frm" name="frm" action="main.jsp">
	<input type="hidden" name="page" value="day0409/hw_search_car" />
	<label>제조국</label>
	<select id="country_select" name="country_select">
		<option value="국산">국산</option>
		<option value="수입">수입</option>
	</select>

	<label>제조사</label>
	<select name="maker">
		<c:forEach var="maker" items="${ makerList }">
			<option>${ maker }</option>
		</c:forEach>
	</select>

	<label>모델명</label>
	<select name="model">
		<option>-모델명-</option>
	</select>
	<input type="submit" value="조회">
</form>

