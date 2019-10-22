package com.ibm.service;

import java.util.ArrayList;

import com.ibm.bean.Credentials;
import com.ibm.bean.Transactions;
import com.ibm.dao.DatabaseClass;

public class ServiceClass implements ServiceInterface {
	DatabaseClass dbc = new DatabaseClass();
	public Boolean validateMobNum(long mobnum) {
		if(mobnum!=0)
		{
			return dbc.validateNum(mobnum);
		}
		return false;
	}

	public void insertData(Credentials cred) {
		// TODO Auto-generated method stub
		String name = cred.getName();
		String addr = cred.getAddr();
		long num = cred.getNum();
		long amnt = cred.getAmnt();
		String pass = cred.getPass();
		dbc.inserDatadb(name,addr,num,amnt,pass);
	}

	public boolean validatePass(long mobnum, String pass) {
		// TODO Auto-generated method stub
		return dbc.validatePassword(mobnum,pass);
		
	}

	public int checkBalance(long mobnum) {
		return dbc.checkBal(mobnum);
	}

	public int addBalance(long mobnum, int addamnt) {
		// TODO Auto-generated method stub
		return dbc.addBal(mobnum,addamnt);
	}

	public Boolean withBalance(long mobnum, int withamnt) {
		// TODO Auto-generated method stub
		return dbc.withBal(mobnum,withamnt);
	}

	public boolean updateBalance(long mobnum, long mob, int amnt) {
		// TODO Auto-generated method stub
		return dbc.updateBal(mobnum,mob,amnt);
	}

	public void transactCred(long mobnum, int addamnt) {
		// TODO Auto-generated method stub
		dbc.transactCredit(mobnum,addamnt);
		
	}

	public void transactDeb(long mobnum, int withamnt) {
		// TODO Auto-generated method stub
		dbc.transactDebit(mobnum,withamnt);
	}

	public ArrayList<Transactions> state(long mobnum){
		return dbc.statement(mobnum);
	}
}
