import java.util.ArrayList;
import java.util.Collections;

/**
 * EXERCISE 5-3: The program rolls dices several times and reports the average
 * and the standard deviation and the maximum number of rolls. It uses a
 * PaiPairOfDice object to represent the dice and uses a StatCalc object to
 * compute the statistics. (You'll need a new StatCalc object for each possible
 * total, 2, 3, ..., 12.
 * 
 * @see http://math.hws.edu/eck/cs124/javanotes7/c5/exercises.html
 * @author Caroline Vong
 * @see https://github.com/Cocolollipop/s2-java-exercises
 * 
 */
public class RollDiceStats {
	private int maxRolls;

	private static RollDiceStats RollDiceStats() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Rolls dices several times and reports the average and the standard
	 * deviation and the maximum number of rolls.
	 */
	public void RollDiceAndStats() {
		/**
		 * Create the
		 */
		RollDiceStats test = RollDiceStats();
		PairOfDice dice = new PairOfDice();
		double calcul = 0;
		int currentNumber;
		StatCalc calculator = new StatCalc();
		System.out.println("hello");
		int nbExp = 5;
		ArrayList maxNumberOfRolls = new ArrayList();
		/**
		 * For each possible total 2,3,....12
		 */
		for (int j = 2; j <= 5; j++) {

			ArrayList listCountOfRolls = new ArrayList();
			currentNumber = j;
			/**
			 * Rolls the dice to get the currentNumber currentNumber is the
			 * target number
			 */
			for (int i = 0; i < nbExp; i++) {
				int number = dice.rollDice(currentNumber);
				System.out.print(number + "|| ");
				listCountOfRolls.add(number);
			}
			/**
			 * maxNumber is the max of the experiences
			 */
			int maxNumber = (int) Collections.max(listCountOfRolls);
			calcul = calculator.getAverage(listCountOfRolls, nbExp);
			double standardDeviation = calculator.getStandardDeviation(listCountOfRolls, nbExp);
			/**
			 * Prints statistics
			 */
			System.out.println("\nMax of rolls for the number:" + currentNumber + " is " + maxNumber);
			System.out.println(
					"The average to get the number" + currentNumber + "after" + nbExp + "experiences is:" + calcul);
			System.out.println("The standard deviation to get the number" + currentNumber + "after" + nbExp
					+ "experiences is" + standardDeviation);
		}

	}

	public static void main(String[] args) {
		RollDiceStats test = new RollDiceStats();
		test.RollDiceAndStats();
	}

}
