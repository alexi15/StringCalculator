package alexi15.stringcalcultor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneString() {
		assertEquals(1, Calculator.add("1"));
	}	

	@Test
	public void testTwoStrings() {
		assertEquals(2, Calculator.add("1,1"));
	}

	@Test
	public void testThreeStrings() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testTenStrings() {
		assertEquals(1+2+3+4+5+6+7+8+9+10, Calculator.add("1,2,3,4,5,6,7,8,9,10"));
	}

	@Test
	public void testNewLineThree() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testNewLineInFive() {
		assertEquals(15, Calculator.add("1\n2,3\n4,5"));
	}

	@Rule
 	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNegativeOne() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Negatives not allowed: -1");
		Calculator.add("-1");
	}

	@Test
	public void testNegativeTwo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Negatives not allowed: -1,-2");
		Calculator.add("-1,-2");
	}

	@Test
	public void testNegativeMultiple() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Negatives not allowed: -1,-2,-5");
		Calculator.add("-1,-2, 2\n-5");
	}

	@Test
	public void testBiggerThen1000() {
		assertEquals(2, Calculator.add("1001,2"));
	}


	@Test
	public void testBiggerThen1000ButSumBiggerThen1000() {
		assertEquals(1001, Calculator.add("1001,2,999"));
	}

	@Test
	public void testDelimiterTwoNumbers() {
		assertEquals(3, Calculator.add("//;1;2"));
	}

	@Test
	public void testDelimiterFiveNumbers() {
		assertEquals(15, Calculator.add("//;1;2,3\n4;5"));
	}

	@Test
	public void testDelimiterDoublepointFiveNumbers() {
		assertEquals(15, Calculator.add("//:1:2,3\n4:5"));
	}
}
