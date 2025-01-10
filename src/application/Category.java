package application;

import java.util.ArrayList;

public class Category {
	
	public static double totalMoneySpent = 0;
	public double categMoneySpent = 0;
	public double balance = 0;
	public String name;
	public ArrayList<String[]> ledger;

	/*
	 * Constructor Method to get the name of the category and set up the HashMap
	 */
	public Category(String categName) {
		name = categName;
		ledger = new ArrayList<String[]>();
	}
	
	/*
	 * Deposit method used to deposit an amount of money in the desired category with a description
	 */
	public void deposit(double amount, String description) {
		String[] element = {String.format("%.2f", amount), description};
		ledger.add(element);
		balance += amount;
		
		
	}
	
	/*
	 * Withdraw method similar to the deposit.
	 */
	public Boolean withdraw(double amount, String description) {
		if(checkFunds(amount)) {
			String[] element = {String.format("%.2f", -amount), description};
			ledger.add(element);
			totalMoneySpent += amount;
			categMoneySpent += amount;
			balance -= amount;
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * balance Getter
	 */
	public double getBalance() {
		return balance;
	}
	
	/*
	 * Transfer method that accepts an amount and a category to transfer money from one categ to another
	 */
	public Boolean transfer(double amount, Category categName) {
		if(checkFunds(amount)) {
			withdraw(amount, "Transfer to " + categName.name);
			categName.deposit(amount, "Transfer from " + name);
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Check funds method to make things easier.
	 */
	public Boolean checkFunds(double amount) {
		if(balance >= amount) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * This method consists on setting up the receipt that will be printed in a pretty way.
	 */
	@Override
	public String toString() {
		String receipt = "*";
		
		do {
			receipt += "*";
			
		}while(receipt.length() < 15 - name.length() / 2);
		receipt += name;
		do {
			receipt += "*";
			
		}while(receipt.length() < 30);
		receipt += "\n";
		
		String newLine;
		
		for(String[] i : ledger) {
			if(i[1].length() < 30 - i[0].length()) {
				newLine = i[1];
				while(newLine.length() < 30 - i[0].length()){
					newLine += " ";
				}
			}else {
				newLine = i[1].substring(0, 30 - i[0].length());
			}
			
			newLine += i[0];
			receipt = receipt + newLine + "\n"; 
		}
		receipt += "Total: " + String.format("%.2f", balance);
		
		return receipt;
	}
	

}
