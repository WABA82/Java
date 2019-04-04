<%@page import="kr.co.sist.exam.domain.DeptInfo"%>
<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MyBatisService mbs = new MyBatisService();

	DeptInfo di = mbs.deptInfo();
%>
10번 부서
<br>
부서명 : <strong><%=di.getDname()%></strong>
<br>
위치 : <strong><%=di.getLoc()%></strong>