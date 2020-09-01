package com.cacib.account;

import com.cacib.transactions.TransactionRepository;

public class AccountManager {
	// The account manager delegate the responsablity to the transactionRepositoy
	private TransactionRepository transactionRepository;
	
	  public AccountManager(TransactionRepository transactionRepository) {
		  this.transactionRepository = transactionRepository;
	}

	public void deposit(int  amount) {
		 
		transactionRepository.saveDeposit(amount);
	     
	    }

	    public void withdraw(int  amount) {
	    	transactionRepository.saveWithdraw(amount);
	    }

	    public void printAccount() {
	    	throw new UnsupportedOperationException(); 
	    }

}
