package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.CourseDB;
import model.Course;

/**
 * Servlet implementation class ViewAllCourse
 */
@WebServlet("/ViewAllCourse")
public class ViewAllCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCourse() {
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
		String viewCourseFilter = (String) request.getParameter("viewcoursefilter");		
		ArrayList<Course> postList = CourseDB.selectAll();
		request.setAttribute("courseList", postList);
		getServletContext().getRequestDispatcher("/DisplayAllCourse.jsp").forward(request, response);		
        }
}
