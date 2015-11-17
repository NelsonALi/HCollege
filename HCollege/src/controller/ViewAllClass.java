package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Classes;
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
		String viewClassFilter = (String) request.getParameter("viewclassfilter");		
		ArrayList<Classes> postList = ClassesDB.selectAll();
		request.setAttribute("classList", postList);
		getServletContext().getRequestDispatcher("/ViewCurrentClasses.jsp").forward(request, response);		
    }
}
