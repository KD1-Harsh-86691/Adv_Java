package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/details")
public class ProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);	
	}

	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String qualification = req.getParameter("qualification");
		String college = req.getParameter("college");
		String birth = req.getParameter("birth");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Info</title>");
		out.println("</head>");
		out.println("<body bgcolor='pink'>");
		out.println("<h3>Profile Servlet</h3>");
		out.printf("<h3>First Name: %s</h3>", firstname);
		out.printf("<h3>Last Name: %s</h3>", lastname);
		out.printf("<h3>Qualification: %s</h3>", qualification);
		out.printf("<h3>College Name: %s</h3>", college);
		out.printf("<h3>Birth Date: %s</h3>", birth);
		out.println("</body>");
		out.println("</html>");

	}
}


