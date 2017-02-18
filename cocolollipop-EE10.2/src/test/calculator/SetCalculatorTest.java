package test.calculator;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

import calculator.SetCalculator;

public class SetCalculatorTest {


	@Test
	public void SeparateSets() {
		SetCalculator calc = new SetCalculator();
		String text = "[1,3,4] + [2,3,4]";
		calc.setListOfSet(calc.separateSets(text));


		TreeSet<Integer> treeSetOfNumbers1 = new TreeSet<>();
		treeSetOfNumbers1.add(1);
		treeSetOfNumbers1.add(3);
		treeSetOfNumbers1.add(4);
		TreeSet<Integer> treeSetOfNumbers2 = new TreeSet<>();
		treeSetOfNumbers2.add(2);
		treeSetOfNumbers2.add(3);
		treeSetOfNumbers2.add(4);
		List<TreeSet<Integer>> listOfSetTest = new LinkedList<>();
		listOfSetTest.add(treeSetOfNumbers1);
		listOfSetTest.add(treeSetOfNumbers2);
		assertEquals(listOfSetTest,calc.getListOfSet());

	}

}
