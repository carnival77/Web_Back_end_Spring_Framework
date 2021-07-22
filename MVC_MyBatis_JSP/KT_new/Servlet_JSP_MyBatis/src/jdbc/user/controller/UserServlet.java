package jdbc.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.user.dao.UserDAOMyBatis;
import jdbc.user.vo.UserVO;

/**
 * Servlet implementation class UserServelt
 */
//@WebServlet("/controller")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOMyBatis dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserServlet doGet() " + request.getMethod());
		// doGet �޼ҵ�� ������ ���ΰ�ħ �� ������ ��ȭ�� ��û�� ������ ȣ���.

		// response(����) �����Ϳ� ���� content type ����, �ѱ����ڵ�
//		response.setContentType("text/html;charset=utf-8");
		// Ŭ���̾�Ʈ���� ������ html�� ����� �� �ִ� ��Ʈ�� ����
//		PrintWriter out  = response.getWriter();
//		out.println("<h1>Hello ����</h1>");
//		Date date = new Date();
//		out.println("<h3>���� �ð��� "+date+"</h3>");
//		out.close();

		// Request(��û) ������ ���ڵ�
		request.setCharacterEncoding("UTF-8");

		// 1. Query String ���ڿ� ����
		String cmd = request.getParameter("cmd");
		String jspPageName = "";
		if (cmd.equals("userList")) {
			jspPageName = userList(request, response);
		} else if (cmd.equals("userDetail")) {
			jspPageName = userDetail(request, response);
		} else if (cmd.equals("userInsertForm")) {
			jspPageName = "/userInsert.jsp";
		} else if (cmd.equals("userInsert")) {
			jspPageName = userInsert(request, response);
		}

		// 3. RequestDispatcher�� forward() �޼��带 ȣ���ؼ� �ʿ��� jsp�� �������Ѵ�.
		RequestDispatcher rd = request.getRequestDispatcher(jspPageName);
		rd.forward(request, response);

//		userList(request, response);

		// // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private String userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. DAO�� �޼��� ȣ��
		List<UserVO> users = dao.getUsers();
		// 2. List ��ü�� Request ��ü�� �����Ѵ�.
		request.setAttribute("users", users);

		return "/userList.jsp";
	}

	private String userDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Query String ����
		String userid = request.getParameter("userid");
		// 1. DAO�� �޼��� ȣ��
		UserVO user = dao.getUser(userid);
		// 2. List ��ü�� Request ��ü�� �����Ѵ�.
		request.setAttribute("userOne", user);

		return "/userDetail.jsp";
	}

	private String userInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. form data �����ؼ� UserVO ����
		UserVO user = new UserVO(request.getParameter("userid"), request.getParameter("name"),
				request.getParameter("gender"), request.getParameter("city"));

		// 2. UserDAO �� ȣ��
		int cnt = dao.insertUser(user);
		if (cnt == 1) {
			return userList(request, response);
		} else {
			return "";
		}

//		return "";
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("UserServlet init()");
		dao = new UserDAOMyBatis();
		// init �޼ҵ�� ������ ���۵� �� �ѹ���
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserServlet doPost()" + request.getMethod());

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
