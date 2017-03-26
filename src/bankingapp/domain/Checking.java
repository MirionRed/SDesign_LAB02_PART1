package bankingapp.domain;

public class Checking extends Account{
	public Checking(String name, double balance){
		super(name, balance);
	}
	
	public void Withdraw(double amount){
		balance -= amount*1.05;
	}
}
