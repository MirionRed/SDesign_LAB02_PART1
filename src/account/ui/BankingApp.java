package account.ui;
import java.util.ArrayList;
import java.util.Scanner;

import account.domain.Account;
import account.domain.AccountList;
import account.domain.Checking;
import account.domain.Savings;

public class BankingApp {
	private static AccountList accounts;
	private static Scanner scanner;
	
	public static void main(String[] args){
		accounts = new AccountList();
		scanner = new Scanner(System.in);
		
		int choice;
		boolean error;
		
		do{
			System.out.println("Do you want to:");
			System.out.println("1. Create new account");
			System.out.println("2. Deposit into account");
			System.out.println("3. Withdraw from account");
			System.out.println("4. Search account and display amount");
			System.out.println("5. Exit");
			System.out.print("Enter your choice (1-5): ");
			choice = scanner.nextInt();
			
			error = false;
			switch(choice){
				case 1: addAccount(); break;
				case 2: accountOperation(1); break;
				case 3: accountOperation(2); break;
				case 4: searchAccount(); break;
				default: error = true; break;
			}
			
			if(error){
				System.out.println("Invalid choice. Please enter again");
			}
			System.out.println();
		}while (choice != 5);
	}
	
	public static void addAccount(){
		scanner = new Scanner(System.in);
		System.out.print("Enter account name: ");
		String name = scanner.nextLine();
		
		scanner = new Scanner(System.in);
		System.out.print("Enter balance: ");
		double balance = Double.parseDouble(scanner.nextLine());
		
		scanner = new Scanner(System.in);
		System.out.print("Enter type (1 for Checking or 2 for Savings): ");
		int type = Integer.parseInt(scanner.next());
		
		accounts.addAccount(name, balance, type);
	}
	
	public static int searchAccount(){
		int accountNumber = 0;
		if(accounts.isEmpty()){
			System.out.println("The list is empty");
			return accountNumber;
		} else {
			boolean found = false;
			int i = 0;
			
			System.out.println("Enter name of account: ");
			scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			
			return accounts.searchAccount(name);
		}
	}
	
	public static void accountOperation(int operation){
		int accountNumber = searchAccount();
		System.out.print("Enter amount: ");	
		scanner = new Scanner(System.in);
		double amount = scanner.nextDouble();
		
		accounts.accountOperation(operation, accountNumber, amount);
	}
}
