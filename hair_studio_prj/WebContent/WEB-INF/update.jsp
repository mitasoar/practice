<%@page import="org.hair_studio.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>회원정보수정</title>

<%@ include file="/WEB-INF/common/begin.jspf"%>

<%
	String errorCode = (String) request.getAttribute("errorCode");

	String name = "";
	String id = "";
	String num = "";

	Member m = (Member) request.getAttribute("member");

	if (m != null) {
		name = m.getName() == null ? "" : m.getName();
		id = m.getId() == null ? "" : m.getId();
		num = m.getNum() == null ? "" : m.getNum();
	}
%>

<div>
	<h1>회원정보수정</h1>
	<%
		if (errorCode != null && errorCode.equals("pwDup")) {
	%>
	<div class='error'>
		<p>비밀번호가 일치하지 않습니다. 다시 입력해주세요</p>
	</div>
	<%
		}
	%>
	<form action='<%=request.getContextPath() + "/studio/update"%>'
		method='post'>
		<table>
			<tr>
				<td>이름(*):</td>
				<td><input type='text' name='name' value='<%=name%>' required></td>
			</tr>
			<tr>
				<td>아이디(*):</td>
				<td><input type='text' name='id' value='<%=id%>' readonly></td>
				<!-- <td><button id='check' name='check'>중복확인</button></td> -->
			</tr>
			<tr>
				<td>비밀번호(*):</td>
				<td><input type='password' name='pw' required></td>
			</tr>
			<tr>
				<td>비밀번호확인(*):</td>
				<td><input type='password' name='pw2' required></td>
			</tr>
			<tr>
				<td>전화번호:</td>
				<td><input type='text' name='num' value='<%=num%>'></td>
			</tr>
		</table>
		<center>
			<button>
				<a href='<%=request.getContextPath() + "/studio/delete"%>'>회원탈퇴</a>
			</button>
			<button type='submit' value="수정">수정</button>
			<button type='reset' value="초기화">초기화</button>
		</center>
	</form>
</div>

<%@ include file="/WEB-INF/common/end.jspf"%>