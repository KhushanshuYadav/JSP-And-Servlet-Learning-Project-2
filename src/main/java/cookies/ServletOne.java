package cookies;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

/**
 * Servlet implementation class ServletOne
 */


//1.Below servlet will send response + cookies to client i.e  creates and send cookies to client

//2. Below servlet will create HTTP session object for state management
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
		Integer userPhNo=1234567890;
		String userEmailAdd="xyz@gmail.com";
		
		
		
		//COOKIE CREATION
		
		//creating cookie named "cookie"
		
		//a cookie can store a single value only
		Cookie cookie=new Cookie("userName",userName);  //name of cookie,value of cookie both must be string
		
		cookie.setMaxAge(10*60);  //takes expiring time in seconds
		
		response.addCookie(cookie); //adds cookie to response
		
		
		//SESSION CREATION
		//session objects are created and managed by server container so all servlets have access to it
		
		HttpSession session=request.getSession(); //Returns the current session associated with this request, or if the request does not have a session, creates one
		
		//session stores information in key(String)-value(Object) pair i.e binds value Object to session with name as key
		session.setAttribute("userId", userId);
		session.setAttribute("userPhNo", userPhNo);
		session.setAttribute("userEmailAdd", userEmailAdd);
		
		session.setMaxInactiveInterval(10*60); //terminates or invalidates session if no communication between client and server till specified seconds
		
		response.getWriter().println("<h1>Cookie and Session created<h1>");
		
		
		//getting servlet context
		ServletContext servletcontext=getServletContext();
		
		//Extracting initialization parameters from ServletConfig
		Enumeration<String> pNames=servletcontext.getInitParameterNames();
		
		while (pNames.hasMoreElements()) {
			
		    String pName = pNames.nextElement();
		    String pValue=servletcontext.getInitParameter(pName);
		    
		    response.getWriter().println("<h1>Parameter name: "+pName+" Parameter value: "+pValue+"<h1>");
		    
		}
		
		//setting attributes into servlet context as key(String)-value(Object)
		servletcontext.setAttribute("msg from servlet one","Hello Servlet Two");
		
		
		
		
		
		
	}

}
