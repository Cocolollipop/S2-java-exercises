import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Import from EXERCISE 4.3:
 * 
 * @see http://math.hws.edu/eck/cs124/javanotes7/c4/exercises.html
 * @author Jules BESSON-LEGOFF
 * @author Caroline VONG
 * @see https://github.com/Cocolollipop/s2-java-exercises/tree/master/S2-EE4-3/src/DiceExercise.java
 */
public class PairOfDice {

	/**
	 * Rolls two dices
	 * 
	 * @param x the number chosen
	 * @return cpt the number rolled
	 */
	public int rollDice(int x) {
		if (x < 2 || x > 12) {
			throw new IllegalArgumentException("Choisissez un nombre entre 2 et 12");
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
		}
		return cpt;

	}

} // end class PairOfDice