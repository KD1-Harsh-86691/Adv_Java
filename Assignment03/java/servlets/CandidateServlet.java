package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/candidateregister")
public class CandidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("candidatename");
        String party = req.getParameter("candidateparty");
        String votes = req.getParameter("votes");

        // Setup response content type
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kdacdb", "root", "manager");

            String sql = "INSERT INTO candidates (name, party, votes) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, party);
            stmt.setString(3, votes);

            int result = stmt.executeUpdate();

            if (result > 0) {
                out.println("<h2>Registration Successful!</h2>");
                out.println("<p>Candidate have been successfully saved.</p>");
            } else {
                out.println("<h2>Candidate Registration Failed!</h2>");
                out.println("<p>There was an error saving your details. Please try again.</p>");
            }

            // Close the resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            // Handle any exceptions (e.g., database connection issues)
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        } finally {
            out.close();
        }
	}
	
	
}
