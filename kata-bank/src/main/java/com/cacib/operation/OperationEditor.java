package com.cacib.operation;

import java.util.List;

import com.cacib.transactions.Transaction;
import com.cacib.util.Editor;

/**
 * @author romdhani
 *
 */
/**
 * @author 33769
 *
 */
public class OperationEditor {
	private Editor editor;
	public static final String HEADER = "DATE|AMOUNT|BALABCE";

	public OperationEditor(Editor editor) {
		this.editor = editor;
	}

	/**
	 * @param myAccountLine use editor to edit transaction lines
	 */
	public void editOperationLine(String myAccountLine) {
		editor.editOperation(myAccountLine);
	}

	/**
	 * print transactions Header
	 */
	public void printHeader() {
		editOperationLine(HEADER);
	}

	/**
	 * @param transactionList edit transaction lines
	 */
	public void edit(List<Transaction> transactionList) {
		printHeader();
		transactionList.forEach(System.out::println);

	}
}
