package com.capgemini.beans;

public class InvalidAccountNumberException extends Exception {

	public InvalidAccountNumberException(){
		super();
	}
	
	public InvalidAccountNumberException(String message){
		super(message);
	}
	@Override
	public String toString() {
		return "InvalidAccountNumberException";
	}
	
	
}
