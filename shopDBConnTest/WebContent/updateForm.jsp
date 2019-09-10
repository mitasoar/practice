<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<style>
	*{margin: 0; padding: 0; box-sizing: border-box; text-decoration: none; list-style: none;}
	
	.screen_out {display: none;}
	
	#wrap {width: 50%; margin: 100px auto; text-align: center;}
	
	p {margin: 30px 0; text-align: right;}
	
	a {border: 1px solid black; background-color: lightgray; color: black; padding: 10px;}
	
	table {margin: auto; width: 50%; border-collapse: collapse; text-align: left;}
	
	th {border: 1px solid black; width: 25%; padding-left: 5px;}
	
	td {border: 1px solid black; width: 25%; padding: 0; overflow: hidden;}
	
	input {width: 100%; border: 0;}
	
	button {padding: 5px 20px; margin-top: 20px;}
</style>
<title>회원 수정 페이지</title>
</head>
<body>
	<div id="wrap">
	<h1 class="screen_out">회원 수정</h1>
		<p>
			<a href='<%=request.getContextPath() + "/list"%>'>회원조회</a>
			<a href='<%=request.getContextPath() + "/insert"%>'>회원추가</a>
			<a href='<%=request.getContextPath() + "/delete"%>'>회원삭제</a>
			<a href='<%=request.getContextPath() + "/update"%>'>회원수정</a>
		</p>
		<form action='<%=request.getContextPath() + "/update"%>' method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" required></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" required></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
		</form>
	</div>
</body>
</html>