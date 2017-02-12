package element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetCalculator {
	private Set<Integer> firstSet = new TreeSet();
	private Set<Integer> secondSet = new TreeSet();

	public void readASet() {
		System.out.println("A set looks like that [1,4,5,5,6] so please be careful to the format");
		Scanner sc = new Scanner(System.in);
		String theSet = sc.nextLine();
		if (verifyASet(theSet) == true) {

		} else {
			System.out.println("This is not a good format...please, try again");
			readASet();
		}
		

	}

	public void calculate(){
		
		String newSet = theSet.replaceAll("\\s", "").replaceAll("[", "").replaceAll("]", "");
		String[] tab = newSet.split(",");
	}
	
	public boolean verifyASet(String theSet) {

		/**
		 * Verify that there is no negative value
		 */
		for (int k = 0; k < theSet.length(); k++) {
			if (theSet.charAt(k) == '-') {
				return false;
			}
		}
		/**
		 * Should start with '[' and end with ']'
		 */
		if (theSet.charAt(0) == '[' && theSet.charAt(theSet.length() - 1) == ']') {
			return true;

		}
		return false;
	}

	public void calc(String operator) {
		switch (operator) {
		case "+":
			System.out.print(firstSet + "+" + secondSet + "=");
			firstSet.addAll(secondSet);
			System.out.print(firstSet);
		case "-":
			System.out.print(firstSet + "-" + secondSet + "=");
			firstSet.retainAll(secondSet);
			System.out.print(firstSet);

		case "*":
			System.out.print(firstSet + "*" + secondSet + "=");
			firstSet.removeAll(secondSet);
			System.out.print(firstSet);

		default:
			break;
		}

	}

	public static void main(String[] args) {
		SetCalculator calculator = new SetCalculator();
		calculator.readASet();
		System.out.println("Let\'s create another set:");

	}
}
