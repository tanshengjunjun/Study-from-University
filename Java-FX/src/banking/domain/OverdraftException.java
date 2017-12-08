package banking.domain;

public class OverdraftException extends Exception{
	private static final long serialVersionUID=1;
	private double deficit;
	public  OverdraftException(String message,double deficit){
		super(message);
		this.deficit=deficit;
	}
	public double getDeficit(){
		return this.deficit;
	}
}
