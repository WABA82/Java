<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = "김정윤";
	int age = 30;

	JSONObject jo = new JSONObject();

	jo.put("name", name);
	jo.put("age", age);

	out.println(jo.toJSONString());
%>

<!-- json사용 -->
<%-- {"name" : "<%=name%>", "age":<%=age%>} --%>
