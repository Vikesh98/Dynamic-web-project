package com.project;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DataRetrieve")
public class DataRetrieve extends HttpServlet {
	
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();

          

          
		try
		{  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1998"); 
				con.setAutoCommit(false);
//				table name  StudentDetails         
			
				PreparedStatement ps=con.prepareStatement("select * from StudentDetails");  	
				ResultSet rs=ps.executeQuery();  
				
// 				Checking for records in database 
//				int NoOfRecords=rs.getRow();
//				System.out.println(NoOfRecords);
				//if records are present in DB then get records
//				if(NoOfRecords!=0) 
//				{
				out.print("<table width=50% border=1 cellspacing=0px>");  
				out.print("<caption><h1>Result:</h1></caption>");  
				  
				
				              
				
				ResultSetMetaData rsmd=rs.getMetaData();  
				int total=rsmd.getColumnCount();  
				out.print("<tr>");  
				for(int i=1;i<=total;i++)  
				{  
				out.print("<th bgcolor=cyan>"+rsmd.getColumnName(i)+"</th>");  
				}  
				  
				out.print("</tr>");  
				             
				 
		  
					while(rs.next())  
					{  
					out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"
					+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getInt(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td></tr>");  
					                  
					}  
		  
					out.print("</table>");  
					con.commit();
					RequestDispatcher rd=request.getRequestDispatcher("Logout.html");
					rd.include(request, response);
//				}
//				else {
//					out.print("<h2>No records Present in the DataBase.</h2>");
//					RequestDispatcher rd=request.getRequestDispatcher("Logout.html");
//					rd.include(request, response);
//				}
					              
			}
		

			catch (Exception e) 
			{
				e.printStackTrace();
				
			}  
			          
			finally
			{
				out.close();
			}  
  
}  
	
		
		
}


