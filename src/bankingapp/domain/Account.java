package bankingapp.domain;

public class Account {
	private int accountNumber;
	private String name;
	protected double balance;
	private static int AUTO_INCREMENT = 1;
	
	public Account(String name, double balance){
		this.accountNumber = AUTO_INCREMENT++;
		this.name = name;
		this.balance = balance;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public String getName(){
		return name;
	}
	
	public void Deposit(double amount){
		balance += amount;
	}
	
	public void Withdraw(double amount){}
	
	public double getBalance (){
		return balance;
	}
	
}
