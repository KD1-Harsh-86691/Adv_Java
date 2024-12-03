package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		responseResult(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		responseResult(req, resp);
	}

	protected void responseResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String firstName=req.getParameter("fname");
		String lastName=req.getParameter("lname");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		String date = req.getParameter("date");
		Date d= Date.valueOf(date);
		int status=0;
		String role=req.getParameter("role");
		User u = new User(0, firstName, lastName, email, password, d, status, role);
		try (UserDao userDao = new UserDaoImpl()) {
			int count = userDao.save(u);
			if (count==1) {
				resp.sendRedirect("index.html");
			} else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Registration Fail</h2>");
				out.println("<p><a href='newuser.html'>Register Again</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
}
