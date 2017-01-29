import java.util.Random;
import java.util.Scanner;

public class QuizzExercise {

	/**
	 * EXERCICE 4.7 Write a program that administers a basic addition quiz to
	 * the user. There should be ten questions. Write three subroutines:
	 * createTheQuizz: it should create the quizz; adminQuizz: it should
	 * administer the quizz; gradeTheQuizz: it should grade the quizz
	 * 
	 * @author Jules B.
	 * @author Cocolollipop
	 * @see https://github.com/Cocolollipop/s2-java-exercises/tree/master/S2-EE4-7/src/QuizzExercise.java
	 * 
	 */

	/**
	 * firstNumber will contain the first random number secondNumber will
	 * contain the second random number listUserAnswers will contain the user's
	 * answers
	 */
	private int[] firstNumber;
	private int[] secondNumber;
	private int[] listUserAnswers;

	/**
	 * Creates the quizz
	 */
	private void createTheQuizz() {
		// Creates three arrays
		firstNumber = new int[10];
		secondNumber = new int[10];
		listUserAnswers = new int[10];
		// range for the random number
		int max = 100;
		int min = 2;
		// init random numbers
		for (int i = 0; i < firstNumber.length; i++) {
			Random dice1 = new Random();
			Random dice2 = new Random();
		// puts the random numbers in an array
			firstNumber[i] = dice1.nextInt(max - min + 1) + min;
			secondNumber[i] = dice2.nextInt(max - min + 1) + min;

		}

	}

	/**
	 * Asks the user all ten questions and get the user's answers.
	 * After asking all the questions, the user should print each question
	 * again, with the user's answer.
	 */
	private void adminQuizz() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < firstNumber.length; i++) {
		// Ask the question
			System.out.println(
					"Question " + (i + 1) + ": Quelle est la somme de " + firstNumber[i] + " + " + secondNumber[i]);
		// ask the user's number	
			int answer = sc.nextInt();
		// puts the answers in listUserAnswers
			listUserAnswers[i] = answer;
		// If the user is right
		}
		sc.close();
	}

	/**
	 * Prints each question again tell the user their score on the
	 * quiz, where each correct answer counts for ten point
	 */
	private void gradeTheQuizz() {
		//good answers's counter 
		int cptGoodAnswer = 0;
		System.out.println("Récap:");
		for (int i = 0; i < firstNumber.length; i++) {
			System.out.print("A la Question " + (i + 1) + ": Quelle est la somme de " + firstNumber[i] + " + "
					+ secondNumber[i] + " Vous avez répondu: " + listUserAnswers[i] + "! ");
			if (listUserAnswers[i] == firstNumber[i] + secondNumber[i]) {
				System.out.println("Bonne réponse");
				cptGoodAnswer++;
			}
		// if the user is wrong
			else {
				System.out.println("Zut alors! La bonne réponse était:" + (firstNumber[i] + secondNumber[i]));
			}
		}
		cptGoodAnswer = cptGoodAnswer * 10;
		System.out.println("Vous avez obtenu: " + cptGoodAnswer + " points");

	}

	public static void main(String[] args) {

		QuizzExercise test = new QuizzExercise();
		System.out.println("EE-4.7");
		test.createTheQuizz();
		test.adminQuizz();
		test.gradeTheQuizz();

	}

}
