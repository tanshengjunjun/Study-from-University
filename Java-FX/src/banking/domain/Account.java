package banking.domain;

public class Account{
	protected double balance;//private��Ϊ��protected
	public Account(double b){
		this.balance=b;
	}
	public double getBalance(){
		return this.balance;
	}
	public boolean deposit(double amt){
		this.balance+=amt;
		return true;
	}
	public void withdraw (double amt) throws OverdraftException{
		try {
			if(amt<=this.balance){
				this.balance-=amt;
			}
			else{//抛出异常
				throw new OverdraftException("Insufficient funds",amt-this.balance);
			}
		}
		catch(OverdraftException ex){
			ex.printStackTrace();//在控制台上打印Throwable对象以及它的调用栈的跟踪信息
		}

	}
}
