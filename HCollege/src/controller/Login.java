package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		request.removeAttribute("Message");
		String userid = (String) session.getAttribute("loginname");

		String message = "";
		boolean isRegistered = false;
		if (userid == null) { // user has not logged in yet
			userid = request.getParameter("loginname");
			isRegistered = UserDB.huserExist(userid);
			if (isRegistered) { // user is a member
				session.setAttribute("loginname", userid);
				// check if an admin
				if (UserDB.isAdmin(userid)) {
					session.setAttribute("anAdmin", "true");
				}
				message = "Welcome " + userid +", you have loggedin successfully.";
				request.setAttribute("Message", message);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				message = " You are not a memeber yet, please register first.";
				request.setAttribute("Message", message);
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			}
		} else {
			message = "You have logged in already. Do something else.";
			request.setAttribute("Message", message);
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
