package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletOne
 */


//below servlet will send response + cookies to client;
//Below servlet creates and send cookies to client
@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Assume we got some data by processing
		
		String userName="JohnDoe";
		
		String userId="123456";
		
		//creating cookie named "Cookie"
		
		//a cookie can store a single value only
		Cookie cookie=new Cookie("userName",userName);  //name of cookie,value of cookie
		
		cookie.setMaxAge(10*60);  //takes expiring time in seconds
		
		response.addCookie(cookie); //adds cookie to response
	}

}
