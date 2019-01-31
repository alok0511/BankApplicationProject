package com.capgemini.beans;

public class InsufficientOpeningBalanceException extends Exception {
	
	public InsufficientOpeningBalanceException(){
		super();
	}
	
	public InsufficientOpeningBalanceException(String message){
		super(message);
	}
	

	@Override
	public String toString() {
		return "InsufficientOpeningBalanceException";
	}
	
	
}
