package feature;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


//import org.mockito.junit.MockitoJUnitRunner;

import com.cacib.account.AccountManager;
import com.cacib.bankkata.Printer;


@RunWith(MockitoJUnitRunner.class)
public class PrintOperationFeature {
	@Mock Printer printer;
	private AccountManager account;
	@Before
	public void initialise() {
		account= new AccountManager();
	}
	  @Test
	public void print_Opeation_History(){
		  account.deposit(500);
		  account.withdraw(100);
		  account.deposit(50);
		  account.printAccount();
		  verify(printer).printOperation("DATE | AMOUNT | BALANCE");
	      verify(printer).printOperation("10/09/2020 | 50.00 | 1400.00");
	      verify(printer).printOperation("02/09/2020 | -100.00 | 900.00");
	      verify(printer).printOperation("01/09/2020 | 500.00 | 1000.00");
		
	}

}
