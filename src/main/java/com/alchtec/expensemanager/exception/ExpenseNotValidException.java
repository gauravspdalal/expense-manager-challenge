package com.alchtec.expensemanager.exception;

/**
 * Exception class to represent scenarios when an invalid expense entry is submitted 
 * to the rest.
 * @author dalalgau
 *
 */
@SuppressWarnings("serial")
public class ExpenseNotValidException extends Exception {
	public ExpenseNotValidException(Exception e){
		super(e);
	}
	
	public ExpenseNotValidException(String message){
		super(message);
	}
}
