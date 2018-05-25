package selfCase;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("SecondServlet");
		rd.forward(request, response);
		
		
		/*HttpSession session = request.getSession();
		
		String str = request.getParameter("t1");
		String str2 = request.getParameter("t2");
		session.setAttribute("t1", str);
		session.setAttribute("t2", str2);
		
		String str = request.getParameter("t1");
		String str2 = request.getParameter("t2");
		
		Cookie cookie = new Cookie("t1",str);
		Cookie cookie2 = new Cookie("t2",str2);
		
		response.addCookie(cookie);
		response.addCookie(cookie2);


		

		response.sendRedirect("SecondServlet");*/
		
	}



}
