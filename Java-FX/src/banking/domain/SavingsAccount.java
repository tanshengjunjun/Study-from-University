package banking.domain;

public class SavingsAccount extends Account{
private double interestRate;
public SavingsAccount(double balance,double interest_rate){
	super(balance);
	this.interestRate=interest_rate;
}
/*pass the balance parameter to the parent constructor by calling super(balance).*/
public double getInterestRate(){
	return interestRate;
}
}
