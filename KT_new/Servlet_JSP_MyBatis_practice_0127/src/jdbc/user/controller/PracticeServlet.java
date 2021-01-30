package jdbc.user.controller;

import java.io.IOException;
import java.util.Calendar;
//import java.util.Date;
import java.util.List;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.user.dao.User_2DaoMyBatis;
import jdbc.user.vo.User_2VO;

/**
 * Servlet implementation class PraticeServlet
 */
//@WebServlet("/PraticeServlet")
public class PracticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User_2DaoMyBatis dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PracticeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new User_2DaoMyBatis();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String page = request.getParameter("page");
		String jspPangeName = "";
		if (page.equals("userList")) {
			jspPangeName = userList(request, response);
		} else if (page.equals("userDetail")) {
			jspPangeName = userDetail(request, response);
		} else if (page.equals("userInsertForm")) {
			jspPangeName = "/userInsert.jsp";
		} else if (page.equals("userInsert")) {
			jspPangeName = userInsert(request, response);
		}

		RequestDispatcher rd = request.getRequestDispatcher(jspPangeName);
		rd.forward(request, response);

	}

	private String userInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		User_2VO user = new User_2VO(request.getParameter("userid"), request.getParameter("name"),
				request.getParameter("gender"), request.getParameter("city"), (java.sql.Date) date);

		int cnt = dao.insertUser(user);
		if (cnt == 1) {
			return userList(request, response);
		} else {
			return "";
		}

//		return "/userInsert.jsp";
	}

	private String userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User_2VO> users = dao.getUserList();

		request.setAttribute("users", users);

		return "/userList.jsp";
	}

	private String userDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User_2VO user = dao.getUser(username);

		request.setAttribute("userOne", user);

		return "/userDetail.jsp";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
