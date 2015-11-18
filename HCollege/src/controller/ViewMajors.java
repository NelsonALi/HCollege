package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hmajor;
import customTools.MajorDB;

/**
 * Servlet implementation class ViewAllClass
 */
@WebServlet("/ViewMajors")
public class ViewMajors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMajors() {
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
		ArrayList<Hmajor> postList = new ArrayList<Hmajor>();
		String classFilter = (String) request.getParameter("classfilter");
		String viewClassFilter = (String) request.getParameter("viewclassfilter");	
		if (viewClassFilter.equals("All")) {
			postList = MajorDB.selectAll();
		} else if (viewClassFilter.equals("departname")) {
			postList = MajorDB.majorByDept(classFilter);
		}

		request.setAttribute("majorList", postList);
		getServletContext().getRequestDispatcher("/ViewMajors.jsp").forward(request, response);		
    }
}

