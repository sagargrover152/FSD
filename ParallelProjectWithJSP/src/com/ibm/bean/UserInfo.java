package com.ibm.bean;

public class UserInfo {
	String name;
	String pass;
	String addr;
	long num;
	long amnt;
	
	
	public UserInfo(long num, String pass, String name, String addr, long amnt) {
		this.name = name;
		this.pass = pass;
		this.addr = addr;
		this.num = num;
		this.amnt = amnt;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	public long getNum() {
		return num;
	}
	public long getAmnt() {
		return amnt;
	}
	public String getPass() {
		// TODO Auto-generated method stub
		return pass;
	}
}
