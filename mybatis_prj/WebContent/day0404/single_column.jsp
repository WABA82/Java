<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MyBatisService mbs = new MyBatisService();

	String dname = mbs.deptName();
%>
10번 부서는
<strong><%=dname%></strong>
