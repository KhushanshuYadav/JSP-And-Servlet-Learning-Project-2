package com.khushanshu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FeedbackHandler
 */
@WebServlet("/feedback")
public class FeedbackHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//parameter extraction
		String name =request.getParameter("name");
		System.out.println(name); 
		
		//sending response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("Response");
		
		
		
	}

}
