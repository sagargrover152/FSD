package com.cg.eis.exception;

public class EmployeeException extends RuntimeException{

	String emploeeException(){

		return "Employee Salary is less than 30000";
	}
}