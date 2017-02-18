package test.calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import calculator.Reader;

public class ReaderTest {

	@Test
	public void testVerifySet() {
		//blank space
		String test1 = "[1,3,4] +  [2,3,4]";
		assertFalse("content",Reader.verifySet(test1));
		//negative number
		String test2 = "[-1,3,4] + [2,3,4]";
		assertFalse("negative number",Reader.verifySet(test2));
		String test3 = "[1,3,4] * [2,3,4]";
		assertTrue("content",Reader.verifySet(test3));
		String test4 = "[1,3,4] - [2,3,4]";
		assertTrue("content",Reader.verifySet(test4));
		String test5 = "[1,3,4] + [2,3,4]";
		assertTrue("content",Reader.verifySet(test5));
		String test6 = "[1,3,4] /  [2,3,4]";
		assertFalse("different operator",Reader.verifySet(test6));
		String test7 = "[1,3,4]+[2,3,4]";
		assertFalse("blank space missing",Reader.verifySet(test7));

	}


}
