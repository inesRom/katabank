package feature;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;



import com.cacib.account.AccountManager;
import com.cacib.operation.OperationEditor;
import com.cacib.transactions.TransactionRepository;
import com.cacib.util.Editor;

// Acceptence test : use the real  collaborator dont mock anything


@RunWith(MockitoJUnitRunner.class)
public class PrintOperationFeature {
	@Mock Editor editor;
	private AccountManager account;
	private String localDate;
	@Before
	public void initialise() {
		TransactionRepository transactionRepository = new TransactionRepository(localDate);
		OperationEditor operationEditor = new OperationEditor(editor);
		account= new AccountManager(transactionRepository, operationEditor);
	}
	  @Test
	public void print_Opeation_History(){
		  account.deposit(500);
		  account.withdraw(100);
		  account.deposit(50);
		  account.editAccount();
		  // verify sideEffects 
		  verify(editor).editOperation("DATE | AMOUNT | BALANCE");
	      verify(editor).editOperation("10/09/2020 | 50.00 | 1400.00");
	      verify(editor).editOperation("02/09/2020 | -100.00 | 900.00");
	      verify(editor).editOperation("01/09/2020 | 500.00 | 1000.00");
	      verify(editor).editOperation("01/09/2020 | 500.00 | 1000.00");
	}

}
