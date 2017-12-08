package banking.domain;

public class CheckingAccount extends Account{
private double overdraftProtection;
public CheckingAccount(double balance){
	super(balance);
}
public CheckingAccount(double balance,double protect){
	super(balance);
	this.overdraftProtection=protect;
}
/*pass the balance parameter to the parent constructor by calling super(balance) and set the overdraftProtection attribute.*/
public void withdraw(double amt)throws OverdraftException{
	if (this.balance>=amt){
		this.balance-=amt;
	}
	else if(overdraftProtection==0){
		throw new OverdraftException("No overdraft protection",amt-this.balance);
	}
	else if(overdraftProtection>0&&(amt-this.balance)<=overdraftProtection){
		overdraftProtection-=(amt-this.balance);
		this.balance=0;
	}
	else {
		throw new OverdraftException("Insufficient funds for overdraft protection",amt-this.balance);//不确定deficit是不是这个表示。
}
/*it perform the following check: if the current balance is adequate to cover the amount to withdraw, then proceed as usual. If not and if there is overdraft protection, then attempt to cover the difference (balance - amount) by value of the overdraftProtection. If the amount needed to cover the overdraft is greater than the current level of protection, then the whole transaction must fail with the checking balance unaffected.*/
}
public double getOverdraftProtection(){
	return overdraftProtection;
}
}
