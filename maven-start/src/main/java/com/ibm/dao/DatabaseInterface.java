package com.ibm.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.ibm.bean.Transactions;

public interface DatabaseInterface {

	public Connection createConnection();
	public Boolean validateNum(long mobnum);
	public void inserDatadb(String name, String addr, long num, long amnt, String pass);
	public boolean validatePassword(long mobnum, String pass);
	public int checkBal(long mobnum);
	public int addBal(long mobnum, int addamnt);
	public Boolean withBal(long mobnum, int withamnt);
	public boolean updateBal(long mobnum, long mob, int amnt);
	public void transactCredit(long mobnum, int addamnt);
	public void transactDebit(long mobnum, int withamnt);
	public ArrayList<Transactions> statement(long mobnum);
}
