<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<style>
	*{margin: 0; padding: 0; box-sizing: border-box; text-decoration: none; list-style: none;}
	
	p {margin: 30px 0; text-align: center;}
	
	a {background-color: lightgray; color: black; padding: 0 20px;}
</style>
<% if (request.getAttribute("exception") == null)  {%>
<title>회원 수정 성공</title>
<%} else { %>
<title>회원 수정 실패</title>
<%} %>
</head>
<body>
	<% if (request.getAttribute("exception") == null)  {%>
	<p>수정되었습니다.</p>
	<%} else { %>
	<p>수정할 수 없습니다. 해당 ID가 존재하지 않습니다.</p>
	<%} %>
	<p><a href='<%=request.getContextPath() + "/list"%>'>리스트 보기</a></p>
</body>
</html>