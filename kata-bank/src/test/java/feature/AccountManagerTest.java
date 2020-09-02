package feature;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cacib.account.AccountManager;
import com.cacib.operation.OperationEditor;
import com.cacib.transactions.Transaction;
import com.cacib.transactions.TransactionRepository;
import static org.mockito.BDDMockito.*;
@RunWith(MockitoJUnitRunner.class)
public class AccountManagerTest {
	public static final String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	@Mock TransactionRepository transactionRepository;
	private AccountManager account ;
	@Mock OperationEditor operationEditor;
	@Before
	public void initialise() {
		account= new AccountManager(transactionRepository,operationEditor);
	}
	@Test
	public void depositTransaction(){
		account.deposit(500);
		verify(transactionRepository).saveDeposit(500);
	}
	@Test
	public void withdrawTransaction(){
		account.withdraw(500);
		verify(transactionRepository).saveWithdraw(500);
	}
	@Test
	public void checkOperations() {
		List<Transaction> transactions= Arrays.asList(new Transaction(localDate,500,1000));
		given(transactionRepository.getAllTransactions()).willReturn(transactions);
		//when i call printAccount methode from account , I expect transactionRepository method 
		//(alltransaction()) to return a list of transactions
		account.editAccount();
		// Verify operationPrinter class was cold with transactions that came from the repository
		verify(operationEditor).edit(transactions);
	}
}
