package com.ibm.dao;

import java.security.DrbgParameters.Reseed;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ibm.bean.Credentials;
import com.ibm.bean.Transactions;
import com.mysql.jdbc.PreparedStatement;


public class DatabaseClass {
	
	public Connection createConnection() {
		Connection dbCon = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			dbCon = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Wallet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dbCon;
		
	}
	public Boolean validateNum(long mobnum) {

			Connection dbCon = new DatabaseClass().createConnection();
			if (dbCon != null) {
				return new DatabaseClass().fetchNum(dbCon, mobnum);
			} 
			
		return false;
	}

	private Boolean fetchNum(Connection dbCon, long mobnum) {
		// TODO Auto-generated method stub
		String fetchQry = "select id from user_details where num = ?";

		try {
			java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setLong(1,mobnum);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Issue while creating the statement : " + e);
		}
		return false;
	}


	public void inserDatadb(String name, String addr, long num, long amnt, String pass) {
		// TODO Auto-generated method stub
		Connection dbCon = new DatabaseClass().createConnection();
		String fetchQry = "insert into user_details (name,city,num,balance,pass) values(?,?,?,?,?)";

		try {
			java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setString(1,name);
			pstmt.setString(2,addr);
			pstmt.setLong(3,num);
			pstmt.setLong(4,amnt);
			pstmt.setString(5, pass);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Issue while creating the statement : " + e);
		}
	}
	public boolean validatePassword(long mobnum, String pass) {
		// TODO Auto-generated method stub
		
		Connection dbCon = new DatabaseClass().createConnection();
		if (dbCon != null) {
			String fetchQry = "select pass from user_details where num = ?";

			try {
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setLong(1,mobnum);
				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {
					if(rs.getString("pass").equals(pass))
						return true;
					else
						return false;
				}
			} catch (SQLException e) {
				System.out.println("Issue while creating the statement : " + e);
			}
		}
		return false;
	}
	public int checkBal(long mobnum) {
		// TODO Auto-generated method stub
		
		Connection dbCon = new DatabaseClass().createConnection();
		if (dbCon != null) {
			String fetchQry = "select balance from user_details where num = ?";

			try {
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setLong(1,mobnum);
				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {
					return rs.getInt("balance");
				}	
			} catch (SQLException e) {
				System.out.println("Issue while creating the statement : " + e);
			}
		}
		return 0;
	}
	public int addBal(long mobnum, int addamnt) {
		// TODO Auto-generated method stub
		int nbal = 0;
		Connection dbCon = new DatabaseClass().createConnection();
		if (dbCon != null) {
			String fetchQry = "select balance from user_details where num = ?";

			try {
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setLong(1,mobnum);
				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {
					nbal = rs.getInt("balance")+addamnt;
					fetchQry = "update user_details set balance = ? where num = ?";
					pstmt = dbCon.prepareStatement(fetchQry);
					pstmt.setInt(1, nbal);
					pstmt.setLong(2,mobnum);
					pstmt.executeUpdate();
				}	
			} catch (SQLException e) {
				System.out.println("Issue while creating the statement : " + e);
			}
		}
		return nbal;
	}
	public Boolean withBal(long mobnum, int withamnt) {
		// TODO Auto-generated method stub
		int nbal = 0;
		Connection dbCon = new DatabaseClass().createConnection();
		if (dbCon != null) {
			String fetchQry = "select balance from user_details where num = ?";

			try {
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setLong(1,mobnum);
				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {
					if(rs.getInt("balance")<withamnt) {
						return false;
					}
					else {
						nbal = rs.getInt("balance")-withamnt;
						fetchQry = "update user_details set balance = ? where num = ?";
						pstmt = dbCon.prepareStatement(fetchQry);
						pstmt.setInt(1, nbal);
						pstmt.setLong(2,mobnum);
						pstmt.executeUpdate();
						return true;
					}
				}	
			} catch (SQLException e) {
				System.out.println("Issue while creating the statement : " + e);
			}
		}
		return false;
	}
	public boolean updateBal(long mobnum, long mob, int amnt) {
		// TODO Auto-generated method stub
		int nbal = 0;
		Connection dbCon = new DatabaseClass().createConnection();
		if (dbCon != null) {
			String fetchQry = "select balance from user_details where num = ?";

			try {
				java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setLong(1,mobnum);
				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {
						nbal = rs.getInt("balance")-amnt;
						fetchQry = "update user_details set balance = ? where num = ?";
						pstmt = dbCon.prepareStatement(fetchQry);
						pstmt.setInt(1, nbal);
						pstmt.setLong(2,mobnum);
						pstmt.executeUpdate();
					}
				fetchQry = "select balance from user_details where num = ?";
				pstmt = dbCon.prepareStatement(fetchQry);
				pstmt.setLong(1,mob);
				rs = pstmt.executeQuery();

				if(rs.next()) {
						nbal = rs.getInt("balance")+amnt;
						fetchQry = "update user_details set balance = ? where num = ?";
						pstmt = dbCon.prepareStatement(fetchQry);
						pstmt.setInt(1, nbal);
						pstmt.setLong(2,mob);
						pstmt.executeUpdate();
						return true;
					}	
			} catch (SQLException e) {
				System.out.println("Issue while creating the statement : " + e);
			}
		}
		return false;
	}
	public void transactCredit(long mobnum, int addamnt) {
		// TODO Auto-generated method stub
		Connection dbCon = new DatabaseClass().createConnection();
		String fetchQry1 = "select balance from user_details where num = ?";
		String fetchQry = "insert into transactions (number,credited,balance) values(?,?,?)";
		try {
			int bal=0;
			java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
			java.sql.PreparedStatement pstmt1 = dbCon.prepareStatement(fetchQry1);
			pstmt1.setLong(1, mobnum);
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next())
				bal = rs.getInt("balance");
			pstmt.setLong(1,mobnum);
			pstmt.setInt(2,addamnt);
			pstmt.setInt(3, bal);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void transactDebit(long mobnum, int withamnt) {
		// TODO Auto-generated method stub
		Connection dbCon = new DatabaseClass().createConnection();
		String fetchQry1 = "select balance from user_details where num = ?";
		String fetchQry = "insert into transactions (number,debited,balance) values(?,?,?)";
		try {
			int bal=0;
			java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
			java.sql.PreparedStatement pstmt1 = dbCon.prepareStatement(fetchQry1);
			pstmt1.setLong(1, mobnum);
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next())
				bal = rs.getInt("balance");
			pstmt.setLong(1,mobnum);
			pstmt.setInt(2,withamnt);
			pstmt.setInt(3, bal);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}
	
	public ArrayList<Transactions> statement(long mobnum) {
		Connection dbCon = new DatabaseClass().createConnection();
		Transactions trans = null;
		ArrayList<Transactions> arr = new ArrayList<>();
		String fetchQry = "select * from transactions where number = ?";
		try {
			java.sql.PreparedStatement pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setLong(1, mobnum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				trans = new Transactions();
				trans.setNumber(rs.getLong("Number"));
				trans.setCredited(rs.getInt("credited"));
				trans.setDebited(rs.getInt("debited"));
				trans.setBalance(rs.getInt("balance"));
				trans.setTime(rs.getString("time"));
				arr.add(trans);
			}
			return arr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
}

