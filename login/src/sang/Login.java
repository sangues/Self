package sang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String username= request.getParameter("uname");
	String password= request.getParameter("pass");
	
	HttpSession session = request.getSession();
	session.setAttribute("username", username);
	
	LoginDao loginDao = new LoginDao();
	
	if(loginDao.check(username, password))
	{
		response.sendRedirect("welcome.jsp");
	}
	else {
	request.setAttribute("Error","Sorry! Username or Password Error. plz Enter Correct Detail");
	session.setAttribute("Loginmsg","plz sign in first");
	response.sendRedirect("Register.jsp");
	}
	}

}
