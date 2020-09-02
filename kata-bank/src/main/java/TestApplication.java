import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cacib.account.AccountManager;
import com.cacib.operation.OperationEditor;
import com.cacib.transactions.TransactionRepository;
import com.cacib.util.Editor;

public class TestApplication {

	public static void main(String[] args) {
		
		String transactionDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		TransactionRepository transactions = new TransactionRepository(transactionDate);
		Editor editor = new Editor();
		OperationEditor operationEditor = new OperationEditor(editor);
		AccountManager account = new AccountManager(transactions, operationEditor);

		account.deposit(1000);
		account.withdraw(300);
		account.withdraw(50);
		account.deposit(500);

		account.editAccount();

	}

}
