package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class SetCalculator {
	private List<TreeSet<Integer>> listOfSet = new LinkedList<>();
	private char operator;

	/**
	 * Separates the in line command into two sets and calculates the operation
	 * on these sets
	 * 
	 * @param theSet
	 * @return 
	 */
	public List<TreeSet<Integer>> separateSets(String theSet) {
		System.out.println(theSet);
		/**
		 * Reads the operator
		 */
		this.operator = 'e';

		if (theSet.contains("-")) {
			this.operator = '-';
		}
		if (theSet.contains("+")) {
			this.operator = '+';
		}
		if (theSet.contains("*")) {
			this.operator = '*';
		}
		/**
		 * Removes blank spaces
		 */
		String theSecondSet = theSet.replaceAll(" ", "");
		/**
		 * Splits the sets by the operator
		 */
		String[] tabOfSets = theSecondSet.split("(\\+|\\-|\\*)");
		/**
		 * For each set in the table we need to take every number and put it in
		 * a TreeSet (one for each set in the table)
		 */
		for (int i = 0; i < tabOfSets.length; i++) {
			System.out.println("test");
			System.out.println(tabOfSets[i]);
			/**
			 * Removes the brackets
			 */
			tabOfSets[i] = tabOfSets[i].replaceAll("(\\[|\\])", "");
			System.out.println("enleve les bracket" + tabOfSets[i]);

			TreeSet<Integer> treeSetOfNumbers = new TreeSet<>();
			/**
			 * For each element from the set
			 */
			for (int j = 0; j < tabOfSets[i].length(); j++) {
				System.out.println(tabOfSets[i].charAt(j));
				/**
				 * If it is a number, put it on the list
				 */
				if (Character.isDigit(tabOfSets[i].charAt(j)) == true) {
					System.out.println("digit");
					treeSetOfNumbers.add(Character.getNumericValue(tabOfSets[i].charAt(j)));
				}

				else {
					System.out.println("non digit");
				}
			} // end for every element of the set

			System.out.println();
			/**
			 * Puts the treeSetOfNumbers into the listOfSet
			 */
			this.getListOfSet().add(treeSetOfNumbers);
			System.out.println(this.getListOfSet());

		} // end for all sets in the table
		return this.getListOfSet();
	}

	/**
	 * Calculates the operation on two sets according to the operator given in
	 * entry using TreeSet's methods
	 * 
	 * @param operator
	 */
	public void calculateOnTwoSets() {

		TreeSet<Integer> firstSet = new TreeSet<>();
		firstSet = getListOfSet().get(0);
		TreeSet<Integer> secondSet = new TreeSet<>();
		secondSet = getListOfSet().get(1);

		switch (this.operator) {

		case '+':
			System.out.print(firstSet + "+" + secondSet + "=");
			firstSet.addAll(secondSet);
			System.out.print(firstSet);
			break;
		case '*':
			System.out.print(firstSet + "*" + secondSet + "=");
			firstSet.retainAll(secondSet);
			System.out.print(firstSet);

			break;
		case '-':
			System.out.print(firstSet + "-" + secondSet + "=");
			firstSet.removeAll(secondSet);
			System.out.print(firstSet);

			break;
		default:
			break;
		}

	}

	public List<TreeSet<Integer>> getListOfSet() {
		return listOfSet;
	}

	public void setListOfSet(List<TreeSet<Integer>> listOfSet) {
		this.listOfSet = listOfSet;
	}

	
}