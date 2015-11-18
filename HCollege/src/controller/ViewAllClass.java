package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hclass;
import customTools.ClassesDB;

/**
 * Servlet implementation class ViewAllClass
 */
@WebServlet("/ViewAllClass")
public class ViewAllClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllClass() {
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
		ArrayList<Hclass> postList = new ArrayList<Hclass>();
		String classFilter = (String) request.getParameter("classfilter");
		String viewClassFilter = (String) request.getParameter("viewclassfilter");	
		if (viewClassFilter.equals("All")) {
			postList = ClassesDB.selectAll();
		} else if (viewClassFilter.equals("subjectcode")) {
			postList = ClassesDB.classesBySuject(classFilter);
		} else if (viewClassFilter.equals("departname")) {
			postList = ClassesDB.classesByDept(classFilter);
		} else if (viewClassFilter.equals("instructorname")) {
			postList = ClassesDB.classesByInstructor(classFilter);
		} else if (viewClassFilter.equals("classtime")) {
			postList = ClassesDB.classesByTime(classFilter);
		}

		request.setAttribute("classList", postList);
		getServletContext().getRequestDispatcher("/ViewCurrentClasses.jsp").forward(request, response);		
    }

}
