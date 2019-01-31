package com.capgemini.service;

import java.util.LinkedList;

import com.capgemini.beans.Account;
import com.capgemini.beans.InvalidAccountNumberException;
import com.capgemini.beans.InsufficientBalanceException;
import com.capgemini.beans.InsufficientOpeningBalanceException;

public class ICICIBank {

	LinkedList<Account> accounts=new LinkedList<>();
	
	
	public String createAccount(int accountNumber,int amount)throws InsufficientOpeningBalanceException
	{
		if(amount >=500){
		Account acc = new Account(accountNumber, amount);
		
		accounts.add(acc);
		
		return "account created successfully";
		}
		throw new InsufficientOpeningBalanceException("You must atleast 500 as a minimum balance to open an account");
	}
	
	private Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		
		for(Account acc : accounts)
		{
			if(acc.getAccountNumber()==accountNumber)
			{
				return acc;
			}
		}
		throw new InvalidAccountNumberException("You have entered Invalid Account Number");
		
	}
	
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account acc = searchAccount(accountNumber);
		
		if((acc.getAmount() - amount)>=0)
		{
			acc.setAmount(acc.getAmount() - amount);
			return acc.getAmount();
		}
		
		throw new InsufficientBalanceException("Insufficient Balance in your Account");
	}
	
	public int depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException
	{
		Account acc = searchAccount(accountNumber);
		acc.setAmount(acc.getAmount() + amount);
		return acc.getAmount();
	}
	
	public String fundTransfer(int accountNumber,int accountNumber2,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account acc = searchAccount(accountNumber);
		Account acc1 = searchAccount(accountNumber2);
		if((acc.getAmount() - amount) >= 0){
			acc.setAmount(acc.getAmount() - amount);
			acc1.setAmount(acc1.getAmount() + amount);
			return "First Person Balance : " + acc.getAmount() + "\nSecond Person Balance : " + acc1.getAmount();
		}
		throw new InsufficientBalanceException("Insufficient Balance in your Account");
	}
	
	
}


