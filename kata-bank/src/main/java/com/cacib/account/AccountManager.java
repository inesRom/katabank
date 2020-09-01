package com.cacib.account;

import com.cacib.operation.OperationManager;
import com.cacib.transactions.TransactionRepository;

public class AccountManager {
	// The account manager delegate the responsablity to the transactionRepositoy
	private TransactionRepository transactionRepository;
	private OperationManager operationManager ;
	
	  public AccountManager(TransactionRepository transactionRepository, OperationManager operationManager) {
		  this.transactionRepository = transactionRepository;
		  this.operationManager =operationManager;
	}

	public void deposit(int  amount) {
		 
		transactionRepository.saveDeposit(amount);
	     
	    }

	    public void withdraw(int  amount) {
	    	transactionRepository.saveWithdraw(amount);
	    }

	    public void printAccount() {
	    	operationManager.show(transactionRepository.getAllTransactions());
	    }

}
