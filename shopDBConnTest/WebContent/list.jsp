<%@page import="org.shop.model.Member"%>
<%@page import="org.shop.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<style>
	*{margin: 0; padding: 0; box-sizing: border-box; text-decoration: none; list-style: none;}
	
	.screen_out {display: none;}
	
	#wrap {width: 50%; margin: 100px auto;}
	
	p {margin: 30px 0; text-align: right;}
	
	a {border: 1px solid black; background-color: lightgray; color: black; padding: 10px;}
	
	table {margin: auto; width: 100%; border-collapse: collapse; text-align: left;}
	
	td, th {border: 1px solid black; width: 25%; padding-left: 5px;}
</style>
<title>회원 목록 페이지</title>
</head>
<% 
	Member[] members = MemberDAO.getInstance().listMembers();
%>
<body>
	<div id="wrap">
	<h1 class="screen_out">회원 목록</h1>
		<p>
			<a href='<%=request.getContextPath() + "/list"%>'>회원조회</a>
			<a href='<%=request.getContextPath() + "/insert"%>'>회원추가</a>
			<a href='<%=request.getContextPath() + "/delete"%>'>회원삭제</a>
			<a href='<%=request.getContextPath() + "/update"%>'>회원수정</a>
		</p>
		<table>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<% if (members != null) {
				for (Member m : members) { %>
			<tr>
				<td><%=m.getId()%></td>
				<td><%=m.getName()%></td>
				<td><%=m.getPhone()%></td>
				<td><%=m.getAddress()%></td>
			</tr>
			<% }
				}%>
		</table>
	</div>
</body>
</html>