<%@page import="java.util.Date"%>
<%@page import="org.hair_studio.model.Designer"%>
<%@page import="org.hair_studio.dao.StudioDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>예약하기</title>

<%@ include file="/WEB-INF/common/begin.jspf"%>

<%
	StudioDAO dao = new StudioDAO();

	Designer[] designers = dao.getDesigners();
%>

<div>
	<h1>예약하기 - 시간</h1>
	<form action='<%=request.getContextPath() + "/studio/bookingT"%>'
		method='post'>
		<table>
			<tr>
				<td>예약 시간 => </td>
				<td><select name='time'>
						<% if (true) {
							Designer d = dao.getDesigner(request.getParameter("designer"));
							if (d.getPart1() == null) {
						%>
						<option value=<%= d.getName() + "-part_time1-10:00~10:30" %>>10:00 ~ 10:30</option>
						<%
							}
							if (d.getPart2() == null) {
						%>
						<option value=<%= d.getName() + "-part_time2-10:30~11:00" %>>10:30 ~ 11:00</option>
						<%
							}
							if (d.getPart3() == null) {
						%>
						<option value=<%= d.getName() + "-part_time3-11:00~11:30" %>>11:00 ~ 11:30</option>
						<%
							}
							if (d.getPart4() == null) {
						%>
						<option value=<%= d.getName() + "-part_time4-11:30~12:00" %>>11:30 ~ 12:00</option>
						<%
							}
							if (d.getPart5() == null) {
						%>
						<option value=<%= d.getName() + "-part_time5-13:00~13:30" %>>13:00 ~ 13:30</option>
						<%
							}
							if (d.getPart6() == null) {
						%>
						<option value=<%= d.getName() + "-part_time6-13:30~14:00" %>>13:30 ~ 14:00</option>
						<%
							}
							if (d.getPart7() == null) {
						%>
						<option value=<%= d.getName() + "-part_time7-14:00~14:30" %>>14:00 ~ 14:30</option>
						<%
							}
							if (d.getPart8() == null) {
						%>
						<option value=<%= d.getName() + "-part_time8-14:30~15:00" %>>14:30 ~ 15:00</option>
						<%
							}
							if (d.getPart9() == null) {
						%>
						<option value=<%= d.getName() + "-part_time9-15:00~15:30" %>>15:00 ~ 15:30</option>
						<%
							}
							if (d.getPart10() == null) {
						%>
						<option value=<%= d.getName() + "-part_time10-15:30~16:00" %>>15:30 ~ 16:00</option>
						<%
							}
							if (d.getPart11() == null) {
						%>
						<option value=<%= d.getName() + "-part_time11-16:00~16:30" %>>16:00 ~ 16:30</option>
						<%
							}
							if (d.getPart12() == null) {
						%>
						<option value=<%= d.getName() + "-part_time12-16:30~17:00" %>>16:30 ~ 17:00</option>
						<%
							}
							if (d.getPart13() == null) {
						%>
						<option value=<%= d.getName() + "-part_time13-17:00~17:30" %>>17:00 ~ 17:30</option>
						<%
							}
							if (d.getPart14() == null) {
						%>
						<option value=<%= d.getName() + "-part_time14-17:30~18:00" %>>17:30 ~ 18:00</option>
						<%
							}
							if (d.getPart15() == null) {
						%>
						<option value=<%= d.getName() + "-part_time15-18:00~18:30" %>>18:00 ~ 18:30</option>
						<%
							}
							if (d.getPart16() == null) {
						%>
						<option value=<%= d.getName() + "-part_time16-18:30~19:00" %>>18:30 ~ 19:00</option>
						<%
							}
						}
						%>
						<input type='submit' value="예약신청">
				</select></td>
			</tr>
		</table>
	</form>
</div>

<h1><%="예약 목록 (" + new Date() + ")"%></h1>

<table border=5>
	<tr>
		<th>디자이너 / 시간</th>
		<th>10:00 ~ 10:30</th>
		<th>10:30 ~ 11:00</th>
		<th>11:00 ~ 11:30</th>
		<th>11:30 ~ 12:00</th>
		<th>13:00 ~ 13:30</th>
		<th>13:30 ~ 14:00</th>
		<th>14:00 ~ 14:30</th>
		<th>14:30 ~ 15:00</th>
		<th>15:00 ~ 15:30</th>
		<th>15:30 ~ 16:00</th>
		<th>16:00 ~ 16:30</th>
		<th>16:30 ~ 17:00</th>
		<th>17:00 ~ 17:30</th>
		<th>17:30 ~ 18:00</th>
		<th>18:00 ~ 18:30</th>
		<th>18:30 ~ 19:00</th>
	</tr>
	<%
		for (Designer d : designers) {
	%>
	<tr>
		<th><%=d.getName() + " 디자이너"%></th>
		<td><%=d.getPart1() == null ? "" : d.getPart1()%></td>
		<td><%=d.getPart2() == null ? "" : d.getPart2()%></td>
		<td><%=d.getPart3() == null ? "" : d.getPart3()%></td>
		<td><%=d.getPart4() == null ? "" : d.getPart4()%></td>
		<td><%=d.getPart5() == null ? "" : d.getPart5()%></td>
		<td><%=d.getPart6() == null ? "" : d.getPart6()%></td>
		<td><%=d.getPart7() == null ? "" : d.getPart7()%></td>
		<td><%=d.getPart8() == null ? "" : d.getPart8()%></td>
		<td><%=d.getPart9() == null ? "" : d.getPart9()%></td>
		<td><%=d.getPart10() == null ? "" : d.getPart10()%></td>
		<td><%=d.getPart11() == null ? "" : d.getPart11()%></td>
		<td><%=d.getPart12() == null ? "" : d.getPart12()%></td>
		<td><%=d.getPart13() == null ? "" : d.getPart13()%></td>
		<td><%=d.getPart14() == null ? "" : d.getPart14()%></td>
		<td><%=d.getPart15() == null ? "" : d.getPart15()%></td>
		<td><%=d.getPart16() == null ? "" : d.getPart16()%></td>
	</tr>
	<%
		}
	%>
</table>

<%@ include file="/WEB-INF/common/end.jspf"%>