package com.cacib.transactions;

public class Transaction {
	private final String date;
	private final int amount;
	private final int balance;

	public Transaction(String date, int amount, int balance) {
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}

	public int amount() {
		return amount;
	}

	// Transaction is a combination of an amount and date
	// Generate equals and hash code to compare to transactions
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + balance;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount != other.amount)
			return false;
		if (balance != other.balance)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

}
