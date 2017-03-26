package account.domain;

import java.util.ArrayList;

public class AccountList {
	private static ArrayList<Account> accountList;
	
	public AccountList(){
		accountList = new ArrayList<Account>();
	}
	
	public void addAccount(String name, double balance, int type){
		Account aAccount = null;
		if (type == 1 || type == 2){
			if(1 == type){
				aAccount = new Checking(name, balance);
			}else{
				aAccount = new Savings(name, balance);
			}
			accountList.add(aAccount);
			System.out.println("Account " + name + " added");
			System.out.println();
		}else{
			System.out.println("Invalid input");
		}
	}
	
	public int searchAccount(String name){
		boolean found = false;
		int i = 0;
		int accountNumber = 0;
		while(i<accountList.size() && !found){
			Account aAccount = accountList.get(i);
			if (aAccount.getName().equals(name)){
				System.out.println("Account is in list");
				System.out.println("Amount left: " + aAccount.getBalance());
				accountNumber = i;
				found = true;
			} else {
				i++;
			}
		}
		
		if(found == false){
			System.out.println("Account is not in list");
		}
		return accountNumber;
	}
	
	public void accountOperation(int operation, int accountNumber, double amount){
		if(operation == 1){
			accountList.get(accountNumber).Deposit(amount);
		}else{
			accountList.get(accountNumber).Withdraw(amount);
		}
		System.out.println("Operation complete, remaining amount: " + accountList.get(accountNumber).getBalance());
	}
	
	public boolean isEmpty(){
		return accountList.isEmpty();
	}
}
