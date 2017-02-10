import java.util.ArrayList;
/**
 * Part of the solution for EXERCISE 5-3:
 * 
 * @see http://math.hws.edu/eck/cs124/javanotes7/c5/exercises.html
 * @author Caroline Vong
 * @see https://github.com/Cocolollipop/s2-java-exercises
 * 
 */

/**
 * An object of class StatCalc can be used to compute several simple statistics
 * for a set of numbers. Numbers are entered into the dataset using the
 * enter(double) method. Methods are provided to return the following statistics
 * for the set of numbers that have been entered: The average, the standard
 * deviation, the average of squared observations
 */
public class StatCalc {
	/**
	 * Calculates the average of entered observations
	 * @param list is the list of observations
	 * @param nbExp is the number of experiences
	 * @return the average of 
	 */
	public double getAverage(ArrayList<Integer> list, int nbExp) {
		double average = 0;
		for (int i = 0; i < list.size(); i++) {
			average += list.get(i);
		}
		average = average / nbExp;
		return average;
	}

	/**
	 * Calculates E(X^2): the average of squared observations
	 * 
	 * @param list is the list of observations
	 * @param nbExp is the number of experiences
	 * @return the average of squared observations entered
	 */
	public double squareAverage(ArrayList<Integer> list, int nbExp) {
		double squareAverage = 0;
		for (int i = 0; i < list.size(); i++) {
			squareAverage += Math.pow(list.get(i), 2);
		}
		squareAverage = squareAverage / nbExp;
		return squareAverage;
	}

	/**
	 * Koning Huygens's formula: Var(X) = E(X^2) - E(X)^2 E(X^2) will be named
	 * averageSquareX E(X)^2 will be named squareAverage Standard Deviation is
	 * the root of the variance Var(X)
	 * 
	 * @param list is the list of observations
	 * @param nbExp is the number of experiences
	 * @return
	 */
	public double getStandardDeviation(ArrayList<Integer> list, int nbExp) {

		double squareAverage = Math.pow(getAverage(list, nbExp), 2);
		double averageSquareX = squareAverage(list, nbExp);
		double standardDeviation = Math.sqrt(averageSquareX - squareAverage);

		return standardDeviation;
	}

} // end class StatCalc