package bankingDAO;

import banking.domain.Account;
import banking.domain.Bank;
import banking.domain.Customer;
import java.io.RandomAccessFile;
import java.io.IOException;

public class CustomerDAO {
    Customer customer;
    Account  account;
private RandomAccessFile raf;

//write a record at the end of the file;
public  void writeCusomer() {
	try {
		raf.seek(raf.length());
		FixedLengthStringIO.writeFixedLengthString(jtfFirstName.getText(), FIRSTNAME_SIZE, RAF);
	}
	catch(IOException ex) {
		ex.printStackTrace();
	}
	//因为题目说明了暂时不考虑ACCOUNTS，所以下面两行可以省去
	/*customer=Bank.getCustomer(0);
	customer.addAccount(add_acct);*/
	
}
public boolean deleteCustomer(int index) {
	
	return true;
}
public boolean queryCustomer() {
	return true;
}
}
