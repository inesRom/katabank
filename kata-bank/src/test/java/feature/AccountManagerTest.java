package feature;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cacib.account.AccountManager;
import com.cacib.operation.OperationManager;
import com.cacib.transactions.Transaction;
import com.cacib.transactions.TransactionRepository;
import static org.mockito.BDDMockito.*;
@RunWith(MockitoJUnitRunner.class)
public class AccountManagerTest {
	
	@Mock TransactionRepository transactionRepository;
	private AccountManager account ;
	@Mock OperationManager operationPrinter;
	@Before
	public void initialise() {
		account= new AccountManager(transactionRepository,operationPrinter);
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
		List<Transaction> transactions= Arrays.asList(new Transaction("02/09/2020",500));
		given(transactionRepository.getAllTransactions()).willReturn(transactions);
		//when i call printAccount methode from account , I expect transactionRepository method 
		//(alltransaction()) to return a list of transactions
		account.printAccount();
		// Verify operationPrinter class was cold with transactions that came from the repository
		verify(operationPrinter).show(transactions);
	}
}
