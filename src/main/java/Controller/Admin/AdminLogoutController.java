package Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogoutController
 */
@WebServlet("/AdminLogoutController")
public class AdminLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
			session.removeAttribute("admin_username");
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/login.jsp");
	    	dispatcher.forward(request, response);
	}


}
