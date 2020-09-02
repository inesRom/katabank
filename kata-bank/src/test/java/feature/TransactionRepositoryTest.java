package feature;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.runners.MockitoJUnitRunner;

import com.cacib.transactions.Transaction;
import com.cacib.transactions.TransactionRepository;


@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
	private  TransactionRepository transactionRepository;

	public static final String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


	@Before
	public void initialise() {
		transactionRepository= new TransactionRepository(localDate);
	}
	@Test
	public void createDepositTransaction() {
		// if i create a transaction , i ill a get an list of  transactions of one item
		// with the today date	
		transactionRepository.saveDeposit(500);
		List<Transaction> transactions = transactionRepository.getAllTransactions();
		assertThat(transactions.size(),is(1));
		assertThat(transactions.get(0),is(new Transaction(localDate,500)));
		
	}
	@Test
	public void createWithdrawTransaction() {
		// if i create a transaction , i ill a get an list of  transactions of one item
		// with the today date
		transactionRepository.saveWithdraw(500);
		List<Transaction> transactions = transactionRepository.getAllTransactions();
		assertThat(transactions.size(),is(1));
		assertThat(transactions.get(0),is(new Transaction(localDate,-500)));
		
	}


}
