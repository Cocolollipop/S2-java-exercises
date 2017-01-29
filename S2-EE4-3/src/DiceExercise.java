import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DiceExercise {

	/**
	 * EXERCISE 4.3:Write a function that simulates rolling a pair of dice until
	 * the total on the dice comes up to be a given number. The parameter should
	 * be one of the possible totals: 2, 3, ..., 12. The function should throw
	 * an IllegalArgumentException if this is not the case.
	 * 
	 * @author Jules B.
	 * @author Cocolollipop
	 * @see https://github.com/Cocolollipop/s2-java-exercises/tree/master/S2-EE4-3/src/DiceExercise.java
	 */

	/**
	 * Rolls two dices
	 * 
	 * @param x the number chosen
	 * @return cpt the number rolled
	 */
	private int rollDice(int x) {
		if (x < 2 || x > 12) {
			throw new IllegalArgumentException("Choisis un nombre entre 2 et 12");
		}

		Random dice1 = new Random();
		Random dice2 = new Random();
		int max = 6;
		int min = 1;
		int randomNumber1 = 0;
		int randomNumber2 = 0;
		int sum = 0;
		int cpt = 0;

		while (sum != x) {
			randomNumber1 = dice1.nextInt(max - min + 1) + min;
			randomNumber2 = dice2.nextInt(max - min + 1) + min;
			sum = randomNumber1 + randomNumber2;
			cpt++;
			System.out.println("Vous avez tiré " + randomNumber1 + " et " + randomNumber2 + ", la somme est donc " + sum);
		}
		return cpt;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DiceExercise test = new DiceExercise();
		int snakeEyes = test.rollDice(2);
		System.out.println("Nombre de tentatives pour trouver un snake eyes : " + snakeEyes);

	}

}
