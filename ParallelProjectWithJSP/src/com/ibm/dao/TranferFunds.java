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


@WebServlet("/transferfunds")
public class TranferFunds extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int nbal=0;
		Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
		if(dbCon!=null)
		{
			String fetchQry = "select balance from user_details where num = ?";

		try {
			java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setLong(1,Long.parseLong((String) request.getSession().getAttribute("mob")));
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
					nbal = rs.getInt("balance")-Integer.parseInt(request.getParameter("amnt"));
					fetchQry = "update user_details set balance = ? where num = ?";
					pstmt = dbCon.prepareStatement(fetchQry);
					pstmt.setInt(1, nbal);
					pstmt.setLong(2,Long.parseLong((String) request.getSession().getAttribute("mob")));
					pstmt.executeUpdate();
				}
			fetchQry = "select balance from user_details where num = ?";
			pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setLong(1,Long.parseLong((String) request.getParameter("othermob")));
			rs = pstmt.executeQuery();

			if(rs.next()) {
					nbal = rs.getInt("balance")+Integer.parseInt(request.getParameter("amnt"));
					fetchQry = "update user_details set balance = ? where num = ?";
					pstmt = dbCon.prepareStatement(fetchQry);
					pstmt.setInt(1, nbal);
					pstmt.setLong(2,Long.parseLong((String) request.getParameter("othermob")));
					pstmt.executeUpdate();
				}	
			response.getWriter().print("Money Send Succesfully");
			request.getRequestDispatcher("mainMenu.jsp").include(request, response);
		} catch (SQLException e) {
			System.out.println("Issue while creating the statement : " + e);
		}
	}
	}
}
