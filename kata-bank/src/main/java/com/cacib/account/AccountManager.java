package com.cacib.account;

import com.cacib.operation.OperationEditor;
import com.cacib.transactions.TransactionRepository;

/**
 * @author romdhani
 * 
 *
 */
public class AccountManager {
	// The account manager delegate the responsablity to the transactionRepositoy
	private TransactionRepository transactionRepository;
	private OperationEditor operationEditor;

	public AccountManager(TransactionRepository transactionRepository, OperationEditor operationEditor) {
		this.transactionRepository = transactionRepository;
		this.operationEditor = operationEditor;
	}

	/**
	 * @param amount call repository to add deposit transaction
	 */
	public void deposit(int amount) {

		transactionRepository.saveDeposit(amount);

	}

	/**
	 * @param amount call repository to add withdraw transaction
	 */
	public void withdraw(int amount) {
		transactionRepository.saveWithdraw(amount);
	}

	/**
	 *
	 * call editor to print all transactions
	 */
	public void editAccount() {

		operationEditor.edit(transactionRepository.getAllTransactions());
	}

}
