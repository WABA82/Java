<%@page import="kr.co.sist.exam.domain.Car"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MyBatisService1 mbs1 = new MyBatisService1();
	List<Car> carList = mbs1.joinSubquery();
	pageContext.setAttribute("carList", carList);
%>
<table style="border-top: 2px solid #333; border-bottom: 1px solid #333;">
	<tr>
		<th width="80">이미지</th>
		<th width="400">차량정보</th>
		<th width="150">등록일</th>
	</tr>

	<!-- list의 값이 비었을 때. -->
	<c:if test="${ empty carList }">
		<tr>
			<td colspan="3" style="text-align: center;">등록된 차량이 존재하지 않습니다.</td>
		</tr>
	</c:if>

	<c:forEach var="car" items="${ carList }">
		<tr>
			<td>
				<img alt="" src="http://localhost:8080/mybatis_prj/day0409/images/${ car.img }" style="width: 80px; height: 60px;">
			</td>
			<td>
				<div>
					<c:out value="${ car.maker }" />
					<c:out value="${ car.model }" />
				</div>

				<div>
					<c:out value="${ car.carYear }" />
					년식
					<c:out value="${ car.price }" />
				</div>
				<div>
					<c:out value="${ car.carOption }" />
				</div>
			</td>
			<td>
				<c:out value="${ car.hiredate }" />
			</td>
		</tr>
	</c:forEach>
</table>