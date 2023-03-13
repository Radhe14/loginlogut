import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UserHome")
public class UserHome extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("link.html").include(req, resp);
//		System.out.println(req.getCookies()[0]);
		if(req.getCookies()!=null)
		{		
		pw.print("<br><br><br><br><h1>Hello "+email+"</h1>");
		}
		else
		{
			pw.print("<br><br><br><br><h1>Please Login to access the page</h1>");
		}
	}
}

