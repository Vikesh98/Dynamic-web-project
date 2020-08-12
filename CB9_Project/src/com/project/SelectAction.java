package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SelectAction")
public class SelectAction extends HttpServlet {
	
  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String action=request.getParameter("action");
		
//  To check for the action to be performed and invoke that page
	if("Student".equals(action))
	{
		RequestDispatcher rd=request.getRequestDispatcher("Student.html");
		rd.include(request, response);
		
	}
	else if("Administrator".equals(action))
	{
		RequestDispatcher rd=request.getRequestDispatcher("Administrator.html");
		rd.include(request, response);
	}
	}


}
