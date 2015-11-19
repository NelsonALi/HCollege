package controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.ClassesDB;
import customTools.EnrollmentDB;
import customTools.StudentDB;
import model.Hclass;
import model.Henrollment;
import model.Hstudent;

/**
 * Servlet implementation class Enroll
 */
@WebServlet("/Enroll")
public class Enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enroll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Hclass aClass = new Hclass();
		Hstudent aStudent = new Hstudent();
		Henrollment anEnroll = new Henrollment();
		int enrollCount = 0;
        HttpSession session = request.getSession(true);
        String userid = (String) session.getAttribute("loginname");
		request.removeAttribute("Message");
		if (userid == null || userid == "") {
			request.setAttribute("Message", "You need to login/register first in order to enroll in a class.");
			getServletContext().getRequestDispatcher("/login.jsp").forward(
					request, response);       	
        } else {     	
			String pId = request.getParameter("classId"); 
			aClass = ClassesDB.getClassById(pId);
			enrollCount = aClass.getEnrollmenthold().intValueExact();
			int classMax = aClass.getHclassroom().getMaxcapacity().intValueExact();
			if (enrollCount >= classMax) {
				request.setAttribute("Message", "Class is full. Please choose other class to enroll.");
	        	getServletContext().getRequestDispatcher("/EnrollClassList").forward(request, response);					
			} else {
				aStudent = StudentDB.getStudentByName(userid);
				aClass.setEnrollmenthold(new BigDecimal(enrollCount+1));
				ClassesDB.update(aClass);
				anEnroll.setHclass(aClass);
				anEnroll.setHstudent(aStudent);
				EnrollmentDB.insert(anEnroll);
//				request.setAttribute("Message", "You have successfully enrolled in the following class:");
				request.setAttribute("theclass",aClass);
				getServletContext().getRequestDispatcher("/EnrollConfirmation.jsp").forward(request, response);	
			}
        }
	}
}
