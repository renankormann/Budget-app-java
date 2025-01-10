package application;

public class SpendChart {
	
	Category[] categArray;

	public SpendChart(Category[] categs) {
		 categArray = new Category[categs.length];
		 for(int i = 0 ; i < categs.length ; i ++) {
			 categArray[i] = categs[i];
		 }
		 System.out.println(toString());
	}
	
	/*
	 * This method sets up a string that will be printed as a graph showing the percentage spent
	 * on each category.
	 */
	
	@Override
	public String toString() {
		//Title of the graph
		String chart = "Percentage spent by category\n";
		String longestCategory = "";
		
		for(int i = 0; i < categArray.length ; i++) {
			if((categArray[i].name).length() > longestCategory.length()) {
				longestCategory = categArray[i].name;
			}
		}
		
		int[] percentage = new int[categArray.length];
		for(int i = 0 ; i < categArray.length ; i ++) {
			 percentage[i] = (int) (categArray[i].categMoneySpent / Category.totalMoneySpent * 100);
			 
		 }
		
		String newLine = "";
		//body of the graph
		for(int i = 100; i >= 0; i -= 10) {
			if(i == 100) {
				newLine = Integer.toString(i) + "| ";
			}else if(i < 100 & i > 0) {
				newLine = " " + Integer.toString(i) + "| ";
			}else {
				newLine = "  " + Integer.toString(i) + "| ";
			}
			
			for(int element : percentage) {
				if(element >= i) {
					newLine += "o  ";
				}else {
					newLine += "   ";
				}
			}
			newLine += "\n";
			chart += newLine;
		}
		
		//x-axis of the graph + subtitles
		chart += "    -";
		for(int i = 1; i <= percentage.length ; i++) {
			chart += "---";
		}
		chart += "\n";
		
		for(int i = 0; i < longestCategory.length() ; i++) {
			chart += "     ";
			for(Category element : categArray) {
				if(i < (element.name).length()) {
					chart += (element.name).subSequence(i, i + 1) + "  ";
				}else {
					chart += "   ";
				}
			}
			chart += "\n";
		}
		
		
		return chart;
	}
	

}
