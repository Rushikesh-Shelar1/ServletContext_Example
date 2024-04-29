package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet ("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//setting content type or response type
		
		response.setContentType("text/html");
		//creating object of PrintWriter
		PrintWriter out =response.getWriter();
		//getting object of ServletContext
		ServletContext context=getServletContext();
		//reading input from web.xml file(context-param)
		String adminNamexmlFile=context.getInitParameter("userName");
		String adminPassordxmlFile=context.getInitParameter("userPassword");
		
		//reading input from Html file
		String adminNamefromhtml=request.getParameter("t1");
		String adminPassordfromhtml=request.getParameter("t2");
		
		//comparing both input using conditional statement
		if(adminNamexmlFile.equals(adminNamefromhtml)&& adminPassordxmlFile.equals(adminPassordfromhtml)) {
			out.println("Welcome"+" "+adminNamexmlFile);
			out.println("your server info is "+" "+context.getServerInfo());
			List<String> list=new ArrayList();
			list.add("java course in 2000.00");
			list.add("python course in 3000.00");
			list.add("sql in 1000.00");
			//binding global object with servletContext
			context.setAttribute("courseInfo", list);
			RequestDispatcher rd=request.getRequestDispatcher("getCourses.html");
			rd.include(request, response);
		}
		
		
		
		
	}

}
