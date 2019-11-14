package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
	
	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		
		
		String file = "/Users/Yasin/eclipse-workspace/emailapp/src/bankaccountapp/bankaccountapp/utilities/NewBankAccounts.csv";
		/*
		 Checking chkacc1 = new Checking("Yasin Yildirim","987654321",1500);
		
		Savings savacc1 = new Savings("Busra Cakil","987654321", 2500);
		
		
		
		savacc1.showInfo();
		System.out.println("***************");
		chkacc1.showInfo();
		*/
		
		// read a csv file 
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			//System.out.println(name + " " + sSN + accountType + " $" + initDeposit);
		
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
				
			} else if (accountType.equals("Checking")) {

				accounts.add(new Checking(name, sSN, initDeposit));
				
			} else {

			}
		}
 		
	
	
	
	
	for (Account acc : accounts) {
		System.out.println("************\n");
		acc.showInfo();
	}
	
	//Account accTest = new account.get((int) Math.random() * accounts.size()).deposit(110000100);
	int randomAccount = (int) (Math.random() * accounts.size());
	System.out.println("*******\n");
	accounts.get(randomAccount).showInfo();
	System.out.println("*******\n");
	accounts.get(randomAccount).deposit(100000);
	accounts.get(randomAccount).showInfo();
	
	
	}
}
