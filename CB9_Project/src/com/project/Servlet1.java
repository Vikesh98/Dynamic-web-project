package com.project;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {

  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		
//		 Check for Login if valid Continue to Login 	
		if(Login.validate(name,password))
		{
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeLog.html");
			rd.forward(request, response);
		}
		else 
		{
			out.print("<h2>Please Enter valid user name and password</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("Administrator.html");
			rd.include(request, response);
		}
		out.close();
	}

}