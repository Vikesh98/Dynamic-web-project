package com.project;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DataSubmit")
public class DataSubmit extends HttpServlet 
{

	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
	

		String gender=request.getParameter("gender");
	

		String mobileno=request.getParameter("mobileno");
//		long mobileno =Integer.parseInt(request.getParameter("mobileno"));

		String email=request.getParameter("mail");
	

		String qualification =request.getParameter("qualification");
		

		String branch=request.getParameter("branch");
		

		int yop=Integer.parseInt(request.getParameter("year"));
		

		String dob=request.getParameter("dob");

		String college=request.getParameter("college");

	
		
		try 
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1998");  
			//con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into studentdetails values(?,?,?,?,?,?,?,?,?)");  	
			ps.setString(1,uname);
			ps.setString(2,gender);
			ps.setString(3,mobileno);			
			ps.setString(4,email);
			ps.setString(5,qualification);
			ps.setString(6,branch);
			ps.setInt(7,yop);
			ps.setString(8,dob);
			ps.setString(9,college);
			
			ps.executeUpdate();
			
			//con.commit();
			con.close();
			out.print("<h2>ThankYou Your Data Has been Sucessfully Submitted</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("ReturnHome.html");
			rd.include(request, response);
			
		}
		catch(SQLException e)
		{
			out.print("<h2>User with the Entered Name Already Exists In The Database.Try using another UserName.</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("Student.html");
			rd.include(request,response);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

}
}