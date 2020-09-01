package com.cacib.account;

import com.cacib.transaction.TransactionRepository;

public class AccountManager {
	private TransactionRepository transactionRepository;
	
	  public AccountManager(TransactionRepository transactionRepository) {
		  this.transactionRepository = transactionRepository;
	}

	public void deposit(int  amount) {
		 
		transactionRepository.saveDeposit(amount);
	     
	    }

	    public void withdraw(int  amount) {
	    	
	    }

	    public void printAccount() {
	    	throw new UnsupportedOperationException(); 
	    }

}
