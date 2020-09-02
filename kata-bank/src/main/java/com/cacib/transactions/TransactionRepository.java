package com.cacib.transactions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
	// once created  we cannot change transaction_date

	public  final String localDate ;
    private List<Transaction> inMemoryTransactions = new ArrayList<>();
	public TransactionRepository(String localDate) {
		this.localDate = localDate;
	}

	public void saveDeposit(int amount) {
		Transaction toDepositTransaction = new Transaction(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),amount);
		inMemoryTransactions.add(toDepositTransaction);
	}

	public void saveWithdraw(int amount) {
		throw new UnsupportedOperationException();	
		}
	public List<Transaction> getAllTransactions(){
	return inMemoryTransactions;
	}
	}

