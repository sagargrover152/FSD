package com.ibm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.UserInfo;


@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
		if(dbCon!=null)
		{
			String fetchQry = "insert into user_details (name,city,num,balance,pass) values(?,?,?,?,?)";
			try {
				UserInfo user = (UserInfo)request.getAttribute("user");
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setString(1,user.getName());
				pstmt.setString(2,user.getAddr());
				pstmt.setLong(3,user.getNum());
				pstmt.setLong(4,user.getAmnt());
				pstmt.setString(5,user.getPass());
				pstmt.executeUpdate();
				String fetchQry2 = "insert into transactions (number,credited,balance) values(?,?,?)";
				java.sql.PreparedStatement pstmt2 = dbCon.prepareStatement(fetchQry2);
				pstmt2.setLong(1,Long.parseLong((String) request.getSession().getAttribute("mob")));
				pstmt2.setLong(2,user.getAmnt());
				pstmt2.setLong(3, user.getAmnt());
				pstmt2.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Issue while creating the statement : " + e);
			}
				
			response.getWriter().print("User Registered....please login to continue");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		
	}

}
