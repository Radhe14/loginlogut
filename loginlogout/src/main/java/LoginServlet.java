import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
		if(DBOperations.login(email, password))
		{
			Cookie ck = new Cookie("name", email);
			resp.addCookie(ck);
			req.getRequestDispatcher("UserHome").forward(req, resp);
			
		}
		else
		{
			req.getRequestDispatcher("link.html").include(req, resp);
			pw.print("<br><br><br><br><h1>Login Failed</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
}
