package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.StudentDB;
import customTools.UserDB;
import model.Huser;
import model.Hstudent;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		String name = (String) request.getParameter("loginname");
		String email = (String) request.getParameter("email");
		String admin = (String) request.getParameter("rolefilter");
		String pwd = (String) request.getParameter("password");
		Huser user = new Huser();
		Hstudent aStudent = new Hstudent();
		String userType = "";
		if (admin.equals("Student")) userType = "1";
		if (admin.equals("Instructor")) userType = "2";
		if (admin.equals("Advisor")) userType = "3";
		if (admin.equals("Administrator")) userType = "4";
		user.setNetid(name);
//		user.setEmail(email);
		user.setUserpwd(pwd);
		user.setUsertype(new BigDecimal(userType));
		UserDB.insert(user);
		switch (userType) {
		case "1":
			aStudent.setStudentname(name);
			StudentDB.insert(aStudent);;
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;
		}
		session.setAttribute("loginname", name);
		String message = "Welcome " + name +", you have loggedin successfully.";
		request.setAttribute("Message", message);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
