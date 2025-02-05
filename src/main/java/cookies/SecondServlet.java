package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SecondServlet
 */

//Below servlet is for testing purpose it receives request from client and tries to extract cookies
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter writer=response.getWriter();
        Boolean flag=false;
		Cookie[] cookiesArray=request.getCookies();  //returns array of cookies
        
        if(cookiesArray!=null) {
        	
        	for(Cookie cookie:cookiesArray) {
        		
        		String cookieName=cookie.getName();
        		
        		if(cookieName.equals("userName")) {
        			
        			System.out.println("Cookie named "+cookieName+" extracted with value as "+cookie.getValue());
        			
        			writer.println("Cookie named "+cookieName+" extracted with value as "+cookie.getValue());
        			
        			flag=true;
        		}
        	}
        	
        }
        
        if(!flag) writer.println("No cookie found");
		
		
	}

}
