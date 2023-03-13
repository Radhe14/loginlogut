import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
		if(DBOperations.register(email, password))
		{
			req.getRequestDispatcher("link.html").include(req, resp);
			pw.print("<br><br><br><br><h1>Registration Successful</h1>");
		}
		else
		{
			req.getRequestDispatcher("link.html").include(req, resp);
			pw.print("<br><br><br><br><h1>Registration Failed</h1>");
			req.getRequestDispatcher("register.html").include(req, resp);
		}
	}
}
