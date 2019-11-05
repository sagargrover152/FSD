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

@WebServlet("/ValidateNum")
public class ValidateNum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
		if(dbCon!=null)
		{
			String fetchQry = "select id from user_details where num = ?";

			try {
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setLong(1,Long.parseLong(request.getParameter("othermob").toString()));
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
				{
					request.getRequestDispatcher("TransferFunds.jsp").include(request, response);
				}
				else
				{
					response.getWriter().print("Mobile Number DoesNot Exist...");
					request.getRequestDispatcher("mainMenu.jsp").include(request, response);
				}
			}
			catch (SQLException e) {
				System.out.println("Issue while creating the statement : " + e);
			}
	}

	}
}
