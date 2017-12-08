package banking.domain;
import java.util.*;

public class Customer implements  Comparable<Customer>{
private String firstName;
private String lastName;
private Account acct;
private ArrayList<Account> acct_multiplicity=new ArrayList<Account>();
public Customer(String f,String l){
	this.firstName=f;
	this.lastName=l;
}
public String getFirstName(){
	return this.firstName;
}
public String getLastName(){
	return this.lastName;
}
public Account getAccount(){
	return acct;
}
public void setAccount(Account acct){
	this.acct=acct;
}
/*the public methods: addAccount(Account), getAccount(int), and getNumOfAccounts()*/
public void addAccount(Account add_acct){
	acct_multiplicity.add(add_acct);
}
public Account getAccount(int index){
	return acct_multiplicity.get(index);
}
public int getNumOfAccounts(){
	return acct_multiplicity.size();
}

//实现Comparable接口比较两个不同的Customer的firstname和lastname(先比较lastname)
public int compareTo(Customer other){
	if(other.lastName.compareTo(this.lastName)!=0)return other.lastName.compareTo(this.lastName);
	//利用String 的compareTo方法。这里注意要用other的对应lastName和firstName的compareTo来比较，不然如果用this.lastName.compareTo方法会使得编译时报NullpointerException错误。
	else return other.firstName.compareTo(this.firstName);
}
}

