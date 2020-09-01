package feature;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cacib.account.AccountManager;
import com.cacib.transaction.TransactionRepository;
@RunWith(MockitoJUnitRunner.class)
public class AccountManagerTest {
	@Mock TransactionRepository transactionRepository;
	private AccountManager account ;
	@Before
	public void initialise() {
		account= new AccountManager(transactionRepository);
	}
	@Test
	public void depositTransaction(){
		account.deposit(500);
		verify(transactionRepository).saveDeposit(500);
	}

}
