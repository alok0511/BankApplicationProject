package com.capgemini.view;

import com.capgemini.beans.Account;
import com.capgemini.beans.InvalidAccountNumberException;
import com.capgemini.beans.InsufficientBalanceException;
import com.capgemini.beans.InsufficientOpeningBalanceException;
import com.capgemini.service.ICICIBank;

public class Client {

	public static void main(String[] args) throws InsufficientOpeningBalanceException,InvalidAccountNumberException,InsufficientBalanceException {
		ICICIBank bank = new ICICIBank();
		
		try{
			System.out.println(bank.createAccount(101, 2000));
			System.out.println(bank.createAccount(102, 3000));
			}
			catch(InsufficientOpeningBalanceException ioe){
				System.out.println(ioe.getMessage());	
			}
				try{
					System.out.println("Remaining Balance in your Account = "+bank.withdrawAmount(101, 1000));
					System.out.println(bank.fundTransfer(101,102,2000));
					try{
						System.out.println("Remaining Balance in your Account = "+bank.depositAmount(103, 2000));
					}
					catch(InvalidAccountNumberException iae)
					{
						System.out.println(iae.getMessage() );
					}
	
				}
				catch(InsufficientBalanceException ibe){
					System.out.println(ibe.getMessage());
		}
	
		

	}

}
