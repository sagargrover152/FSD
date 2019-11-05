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

@WebServlet("/addmoney")
public class AddMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
		if(dbCon!=null)
		{

			String fetchQry3 = "select balance from user_details where num = ?";

			try {
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry3);
				pstmt.setLong(1,Long.parseLong((String) request.getSession().getAttribute("mob")));
				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {
					int nbal = rs.getInt("balance")+Integer.parseInt(request.getParameter("amnt"));
					fetchQry3 = "update user_details set balance = ? where num = ?";
					pstmt = dbCon.prepareStatement(fetchQry3);
					pstmt.setInt(1, nbal);
					pstmt.setLong(2,Long.parseLong((String) request.getSession().getAttribute("mob")));
					pstmt.executeUpdate();
					response.getWriter().print("Money Added Successfuly");
					request.getRequestDispatcher("mainMenu.jsp").include(request, response);
				}	
			} catch (SQLException e) {
				System.out.println("Issue while creating the statement : " + e);
			}
			
			String fetchQry1 = "select balance from user_details where num = ?";
			String fetchQry = "insert into transactions (number,credited,balance) values(?,?,?)";
			try {
				int bal=0;
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				java.sql.PreparedStatement pstmt1 = dbCon.prepareStatement(fetchQry1);
				pstmt1.setLong(1, Long.parseLong((String) request.getSession().getAttribute("mob")));
				ResultSet rs = pstmt1.executeQuery();
				if(rs.next())
					bal = rs.getInt("balance");
				pstmt.setLong(1,Long.parseLong((String) request.getSession().getAttribute("mob")));
				pstmt.setInt(2,Integer.parseInt(request.getParameter("amnt")));
				pstmt.setInt(3, bal);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
