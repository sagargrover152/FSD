package com.ibm.bean;

public class Credentials {
	String name;
	String pass;
	String addr;
	long num;
	long amnt;
	
	
	public Credentials(long num, String pass, String name, String addr, long amnt) {
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
