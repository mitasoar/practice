<%@page import="org.hair_studio.model.Booking"%>
<%@page import="org.hair_studio.dao.StudioDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>예약 확인</title>

<%@ include file="/WEB-INF/common/begin.jspf"%>

<%
	StudioDAO dao = new StudioDAO();

	String user = (String) request.getSession().getAttribute("user");

	Booking[] bookings = dao.getBookings(user.split("-")[1]);
%>
<%
	if (bookings == null) {
%>
<h1><%=user.split("-")[1] + " 님의 오늘 예약은 없습니다"%></h1>
<%
	} else {
%>
<h1><%=user.split("-")[1] + " 님의 오늘 예약현황 입니다"%></h1>
<form action='<%=request.getContextPath() + "/studio/cancel"%>' method='post'>
	<table border=5>
		<tr>
			<th>예약 디자이너</th>
			<th>예약 시간</th>
			<th>예약 취소</th>
		</tr>
		<%
			for (int i = 0; i < bookings.length; i++) {
		%>
		<tr>
			<td><%=bookings[i].getdName() + " 디자이너"%></td>
			<td><%=bookings[i].getTime()%></td>
			<input type="hidden" name=<%=i%>
				value=<%=bookings[i].getdName() + "-" + bookings[i].getPart()%>>
			<td><button type="submit" name="cancel" value=<%=i%>>취소</button></td>
		</tr>
		<%
			}
		%>
	</table>
</form>
<%
	}
%>
<%@ include file="/WEB-INF/common/end.jspf"%>