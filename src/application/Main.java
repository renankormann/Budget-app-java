package application;

/*
 * This program consists of two classes. The Category class controls how much money
 * can be spent by using transfer/deposit/withdraw methods. It also prints a receipt
 * when a Category object is printed.
 * 
 * The SpendChart class returns us a string that consists of a graph of the percentage
 * of money spent in each category.
 */

public class Main {

	public static void main(String[] args) {
		Category food = new Category("food");
		food.deposit(200, "McDonalds");
		food.deposit(15, "Beer");
		food.deposit(200, "lds");
		
		food.withdraw(30, "fock");
		
		Category cloth = new Category("cloth");
		cloth.deposit(50, "Trade");
		cloth.transfer(25, food);
		
		Category studying = new Category("Studying");
		studying.deposit(1000, "Books");
		studying.withdraw(120, "Calculus Book");
		studying.withdraw(120.35, "arts Book");
		studying.transfer(200, food);
		food.transfer(25.23, studying);
		

		System.out.println(food + "\n");
		System.out.println(cloth + "\n");
		
		Category[] catgs = {food, cloth, studying};
 		SpendChart chart = new SpendChart(catgs) ;
		
		
	}

}
