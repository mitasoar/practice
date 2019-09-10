package org.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shop.dao.MemberDAO;
import org.shop.model.Member;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] uri = request.getRequestURI().split("/");
		String cmd = uri[uri.length - 1];

		if (cmd.equals("list")) {
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} else if (cmd.equals("insert")) {
			request.getRequestDispatcher("insertForm.jsp").forward(request, response);
		} else if (cmd.equals("delete")) {
			request.getRequestDispatcher("deleteForm.jsp").forward(request, response);
		} else if (cmd.equals("update")) {
			request.getRequestDispatcher("updateForm.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String cmd = uri[uri.length - 1];

		if (cmd.equals("insert")) {
			insertMember(request, response);
		} else if (cmd.equals("delete")) {
			deleteMember(request, response);
		} else if (cmd.equals("update")) {
			updateMember(request, response);
		}
	}

	private void updateMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Member m = new Member();

			m.setId(Integer.parseInt(request.getParameter("id")));
			m.setName(request.getParameter("name"));
			m.setPhone(request.getParameter("phone"));
			m.setAddress(request.getParameter("address"));

			if (MemberDAO.getInstance().updateMember(m)) {
				request.getRequestDispatcher("update.jsp").forward(request, response);
			} else {
				request.setAttribute("exception", "error");
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("exception", "error");
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}

	}

	private void deleteMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if (MemberDAO.getInstance().deleteMember(Integer.parseInt(request.getParameter("id")))) {
				request.getRequestDispatcher("delete.jsp").forward(request, response);
			} else {
				request.setAttribute("exception", "error");
				request.getRequestDispatcher("delete.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("exception", "error");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		}

	}

	private void insertMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			Member m = new Member();
			
			m.setName(request.getParameter("name"));
			m.setPhone(request.getParameter("phone"));
			m.setAddress(request.getParameter("address"));
			if (MemberDAO.getInstance().addMember(m)) {
				request.getRequestDispatcher("insert.jsp").forward(request, response);
			} else {
				request.setAttribute("exception", "error");
				request.getRequestDispatcher("insert.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("exception", "error");
			request.getRequestDispatcher("insert.jsp").forward(request, response);
		}

	}

}
