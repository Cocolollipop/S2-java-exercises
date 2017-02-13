package user;

import calculator.Reader;
import calculator.SetCalculator;

public class UserMain {
	/**
	 * Introduces the calculator
	 */
	public void rulesOfSet() {

		System.out.println("Welcome to the setCalculator");
		System.out.println("You can make an addition, intersection and difference operation on sets");
		System.out.println("Pay attention to the format:");
		System.out.println("For exemple:[1,2,3] * [17,42,9] makes an intersection");
		System.out.println("For exemple:[1,2,3] + [17,42,9] makes an addition");
		System.out.println("For exemple:[1,2,3] - [17,42,9] makes a difference");
		return;
	}

	public static void main(String[] args) {

		UserMain main = new UserMain();
		main.rulesOfSet();
		Reader reader = new Reader();
		reader.readSet();


	}

}
