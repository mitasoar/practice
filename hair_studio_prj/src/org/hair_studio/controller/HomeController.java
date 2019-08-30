package org.hair_studio.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hair_studio.dao.StudioDAO;
import org.hair_studio.model.Member;

@WebServlet("/studio/*")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String cmd = uri[uri.length - 1];

		if (cmd.equals("designer")) {
			request.getRequestDispatcher("/WEB-INF/designers.jsp").forward(request, response);
		} else if (cmd.equals("add")) {
			request.getRequestDispatcher("/WEB-INF/addMember.jsp").forward(request, response);
		} else if (cmd.equals("login")) {
			if (request.getSession().getAttribute("user") != null) {
				request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
			} else {
				timeToDB();
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		} else if (cmd.equals("logout")) {
			logoutMember(request, response);
		} else if (cmd.equals("reservation")) {
			if (request.getSession().getAttribute("user") != null) {
				request.getRequestDispatcher("/WEB-INF/reservation.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		} else if (cmd.equals("booking")) {
			if (request.getSession().getAttribute("user") != null) {
				request.getRequestDispatcher("/WEB-INF/bookingD.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		} else if (cmd.equals("check")) {
			if (request.getSession().getAttribute("user") != null) {
				request.getRequestDispatcher("/WEB-INF/check.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		} else if (cmd.equals("update")) {
			if (request.getSession().getAttribute("user") != null) {
				infoMember(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		} else if (cmd.equals("delete")) {
			if (request.getSession().getAttribute("user") != null) {
				deleteMember(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
		} else if (cmd.equals("list")) {
			request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String cmd = uri[uri.length - 1];

		if (cmd.equals("add")) {
			procAddMember(request, response);
		} else if (cmd.equals("login")) {
			loginMember(request, response);
		} else if (cmd.equals("bookingD")) {
			request.getRequestDispatcher("/WEB-INF/bookingT.jsp").forward(request, response);
		} else if (cmd.equals("bookingT")) {
			procAddSchedule(request, response);
		} else if (cmd.equals("update")) {
			updateMember(request, response);
		} else if (cmd.equals("cancel")) {
			cancelSchedule(request, response);
		}
	}

	private void timeToDB() {

		StudioDAO dao = new StudioDAO();

		dao.timeToDB(new Date().toString());

	}

	private void cancelSchedule(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudioDAO dao = new StudioDAO();

		String can = request.getParameter(request.getParameter("cancel"));

		if (dao.cancelSchedule(can)) {
			request.getRequestDispatcher("/WEB-INF/check.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/server_error.jsp").forward(request, response);
		}
	}

	private void deleteMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = ((String) request.getSession().getAttribute("user")).split("-")[1];

		StudioDAO dao = new StudioDAO();

		if (dao.deleteMember(id)) {
			request.getSession().invalidate();
			request.getRequestDispatcher("/WEB-INF/delete_success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/server_error.jsp").forward(request, response);
		}

	}

	private void updateMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member m = new Member();
		m.setName(request.getParameter("name"));
		m.setId(request.getParameter("id"));
		m.setPw(request.getParameter("pw"));
		m.setNum(request.getParameter("num"));
		String pw = request.getParameter("pw2");

		StudioDAO dao = new StudioDAO();

		if (m.getPw().equals(pw)) {
			if (dao.updateMember(m)) {
				request.getRequestDispatcher("/WEB-INF/update_success.jsp").forward(request, response);
			} else {
				m.setPw(null);
				request.setAttribute("member", m);
				request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorCode", "pwDup");
			m.setPw(null);
			request.setAttribute("member", m);
			request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
		}

	}

	private void infoMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudioDAO dao = new StudioDAO();
		String id = ((String) request.getSession().getAttribute("user")).split("-")[1];
		Member m = dao.infoMember(id);
		request.setAttribute("member", m);

		request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
	}

	private void procAddSchedule(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudioDAO dao = new StudioDAO();
		String id = ((String) request.getSession().getAttribute("user")).split("-")[1];
		String time = request.getParameter("time");

		if (dao.addSchedule(time, id)) {
			if (dao.addBooking(id, time)) {
				request.getRequestDispatcher("/WEB-INF/reservation_success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/server_error.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/server_error.jsp").forward(request, response);
		}

	}

	private void logoutMember(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getSession().invalidate();

		request.getRequestDispatcher("/WEB-INF/logout_success.jsp").forward(request, response);

//		response.sendRedirect(request.getContextPath() + "/studio/");
	}

	private void loginMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudioDAO dao = new StudioDAO();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if (dao.login(id, pw)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", "guest-" + id);

			request.getRequestDispatcher("/WEB-INF/login_success.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath() + "/studio/");
		} else {
			request.setAttribute("error", "로그인이 실패하였습니다. 다시 로그인 하세요");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	private void procAddMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member m = new Member();

		m.setName(request.getParameter("name"));
		m.setId(request.getParameter("id"));
		m.setPw(request.getParameter("pw"));
		m.setNum(request.getParameter("num"));

		String pw = request.getParameter("pw2");

		StudioDAO dao = new StudioDAO();

		if (m.getPw().equals(pw)) {
			if (dao.addMember(m)) {
				if (dao.login(m.getId(), m.getPw())) {
					HttpSession session = request.getSession();
					session.setAttribute("user", "guest-" + m.getId());
				}
				request.getRequestDispatcher("/WEB-INF/add_success.jsp").forward(request, response);
			} else {
				request.setAttribute("errorCode", "idDup");
				m.setPw(null);
				request.setAttribute("member", m);
				request.getRequestDispatcher("/WEB-INF/addMember.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorCode", "pwDup");
			m.setPw(null);
			request.setAttribute("member", m);
			request.getRequestDispatcher("/WEB-INF/addMember.jsp").forward(request, response);
		}
	}

}
