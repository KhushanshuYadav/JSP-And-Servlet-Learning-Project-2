package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SecondServlet
 */

//Below servlet is for testing purpose 
//it receives request from client and tries to extract cookies
//it also have access to session object 
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		
		//extracting cookie from request and processing
		
		
        Boolean flag=false;
		Cookie[] cookiesArray=request.getCookies();  //returns array of cookies
        
        if(cookiesArray!=null) {
        	
        	for(Cookie cookie:cookiesArray) {
        		
        		String cookieName=cookie.getName();
        		
        		if(cookieName.equals("userName") ||cookieName.equals("JSESSIONID") ) {
        			
        			System.out.println("<h1>Cookie named "+cookieName+" extracted with value as "+cookie.getValue()+"</h1>");
        			
        			writer.println("<h1>Cookie named "+cookieName+" extracted with value as "+cookie.getValue()+"</h1>");
        			
        			flag=true;
        		}
        	}
        	
        }
        
        if(!flag) writer.println("<h1>No cookie found</h1>");
        
        //extracting attributes from session i.e processing
        
        HttpSession session=request.getSession();
		
        Integer userPhNo=(Integer) session.getAttribute("userPhNo");  //returns value which is of type object
        
        writer.println("<h1>Session data:  "+userPhNo+"</h1>");
	}

}
