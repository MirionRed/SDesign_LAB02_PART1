
public class Savings extends Account {
	public Savings (String name, double balance){
		super(name, balance);
	}
	
	public void Withdraw(double amount){
		balance -= amount;
	}
}
