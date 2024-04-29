package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BankServer
 */
//@WebServlet ("/BankServer")
public class BankServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//getting the object of ServletConfig
		ServletConfig config=getServletConfig();
		
		String pinCode=config.getInitParameter("pin");
		String adminName=config.getInitParameter("server-admin");
		PrintWriter out =response.getWriter();
		String servletName=config.getServletName();
		
		//String contextPath=config.getServletContext().getContextPath();
		ServletContext context=config.getServletContext();
		String contextPath =context.getContextPath();
		
		out.println("pin for server is"+" "+pinCode);
		out.println("admin name"+" "+adminName);
		out.println("servlet name info"+" "+servletName);
		out.println("servlet path info"+" "+contextPath);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
