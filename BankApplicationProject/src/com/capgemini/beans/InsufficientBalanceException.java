package com.capgemini.beans;

public class InsufficientBalanceException extends Exception {
	
	public InsufficientBalanceException(){
		super();
	}
	
	public InsufficientBalanceException(String message){
		super(message);
	}

	@Override
	public String toString() {
		return "InsufficientBalanceException";
	}
	
	
	

}
