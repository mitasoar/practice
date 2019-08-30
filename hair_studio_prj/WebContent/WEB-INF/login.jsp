<%@page import="org.hair_studio.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>로그인</title>

<%@ include file="/WEB-INF/common/begin.jspf"%>

<div>
	<h1>로그인</h1>
	<%
		String error = String.valueOf(request.getAttribute("error"));
	%>
	<p><%= error = error.equals("null") ? "" : error%></p>
	<form action='<%=request.getContextPath() + "/studio/login"%>'
		method='post'>
		<table>
			<tr>
				<td>아이디:</td>
				<td><input type='text' name='id' required></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type='password' name='pw' required></td>
			</tr>
		</table>
		<center>
			<button type='submit' value="로그인">로그인</button>
		</center>
	</form>
</div>

<%@ include file="/WEB-INF/common/end.jspf"%>