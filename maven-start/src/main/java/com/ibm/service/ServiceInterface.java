package com.ibm.service;

import java.util.ArrayList;

import com.ibm.bean.Credentials;
import com.ibm.bean.Transactions;

public interface ServiceInterface {
	public Boolean validateMobNum(long mobnum);
	public void insertData(Credentials cred);
	public boolean validatePass(long mobnum, String pass);
	public int checkBalance(long mobnum);
	public int addBalance(long mobnum, int addamnt);
	public Boolean withBalance(long mobnum, int withamnt);
	public boolean updateBalance(long mobnum, long mob, int amnt);
	public void transactCred(long mobnum, int addamnt);
	public void transactDeb(long mobnum, int withamnt);
	public ArrayList<Transactions> state(long mobnum);
}
