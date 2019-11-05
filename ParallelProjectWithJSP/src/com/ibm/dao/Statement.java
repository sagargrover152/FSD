package com.ibm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.Transactions;


@WebServlet("/statement")
public class Statement extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Connection dbCon = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		dbCon = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/wallet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dbCon!=null) {
			String fetchQry = "select * from transactions where number = ?";
			try {
				Transactions trans = null;
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setLong(1, Long.parseLong((String) request.getSession().getAttribute("mob")));
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					trans = new Transactions();
					trans.setNumber(rs.getLong("Number"));
					trans.setCredited(rs.getInt("credited"));
					trans.setDebited(rs.getInt("debited"));
					trans.setBalance(rs.getInt("balance"));
					trans.setTime(rs.getString("time"));
					response.getWriter().println(trans.getNumber() + "\t" + trans.getCredited() + "\t" + trans.getDebited() + "\t" + trans.getBalance() + "\t" + trans.getTime()+"<br>");
				}
				request.getRequestDispatcher("mainMenu.jsp").include(request, response);
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
	}
	}

}
