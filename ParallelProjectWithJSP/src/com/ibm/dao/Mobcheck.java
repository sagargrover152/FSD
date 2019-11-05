package com.ibm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mobcheck")
public class Mobcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
		if(dbCon!=null)
		{
			String fetchQry = "select id from user_details where num = ?";

			try {
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setLong(1,Long.parseLong(request.getParameter("mob")));
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
				{
					response.getWriter().print("Already registered");
					request.getRequestDispatcher("login.jsp").include(request, response);
				}
				else
				{
					response.getWriter().print("hello " + request.getParameter("mob"));
					request.getRequestDispatcher("register.jsp").include(request, response);
				}
			}
			catch (SQLException e) {
				System.out.println("Issue while creating the statement : " + e);
			}
		}
	}

}
