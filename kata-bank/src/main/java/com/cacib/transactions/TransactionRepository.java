package com.cacib.transactions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author romdhani
 *
 */
public class TransactionRepository {
	// once created we cannot change transaction_date

	public final String localDate;
	private List<Transaction> inMemoryTransactions = new ArrayList<>();

	public TransactionRepository(String localDate) {
		this.localDate = localDate;
	}

	/**
	 * @return transaction balance
	 */
	public int getCurrentBalance() {
		return getAllTransactions().stream().mapToInt(Transaction -> Transaction.amount()).sum();
	}

	/**
	 * param amount create a deposit transaction
	 */
	public void saveDeposit(int amount) {

		Transaction toDepositTransaction = new Transaction(
				LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), amount,
				getCurrentBalance() + amount);
		inMemoryTransactions.add(toDepositTransaction);
	}

	/**
	 * param amount create a withdraw transaction
	 */

	public void saveWithdraw(int amount) {
		// ! amount should be negatif.
		Transaction toWithdrawTransaction = new Transaction(
				LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), -amount,
				getCurrentBalance() - amount);
		inMemoryTransactions.add(toWithdrawTransaction);
	}

	/**
	 * @return get Alltransaction
	 */
	public List<Transaction> getAllTransactions() {
		return inMemoryTransactions;
	}
}
