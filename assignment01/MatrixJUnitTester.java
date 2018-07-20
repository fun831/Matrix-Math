/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
 */
package assignment01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the Matrix class
 * 
 * @author Miriah Meyer & Matthew Farnsworth
 * @version January 19, 2018
 */
public class MatrixJUnitTester {

	Matrix threeByTwo, twoByThree, twoByTwoResult, twoByTwoOther, twoByTwoResult2, matrixAddition;
	/*Initialize some matrices we can play with for every test!*/
	
	@Before
	public void setup() {
		twoByThree = new Matrix(new int[][]
                {{1, 2, 3},
				 {2, 5, 6}});
		threeByTwo = new Matrix(new int[][]
                {{4, 5},
				 {3, 2},
				 {1, 1}});
		twoByTwoResult = new Matrix(new int[][]
                                    {{13, 12},
									 {29, 26}});
		twoByTwoOther = new Matrix(new int[][] 
									{{1, 2},
									 {3, 4}});
		twoByTwoResult2 = new Matrix(new int[][]
									 {{49, 74},
									 {107, 162}});
		matrixAddition = new Matrix(new int[][]		//Result of twoByTwoOther plus twoByTwoResult
				   {{50, 76},
				   {110, 166}});;
	}
	
	@Test
	public void timesWithBalancedDimensions() {
		Matrix matrixProduct = twoByThree.times(threeByTwo);
		Assert.assertTrue(twoByTwoResult.equals(matrixProduct));
	}
	
	@Test
	public void timesWithUnbalancedDimensions(){
		Assert.assertNull(twoByThree.times(twoByTwoOther));
	}
	
	@Test
	public void twoByTwoResultTimesTwoByTwoOther() {
		Assert.assertEquals(twoByTwoResult2, twoByTwoResult.times(twoByTwoOther));
	}
	
	@Test
	public void twoByTwoDoesNotEqualOther(){
		Assert.assertFalse(twoByTwoResult.equals(twoByThree));
	}
	
	@Test
	public void twoByTwoEqualsItself(){
		Assert.assertTrue(twoByTwoResult.equals(twoByTwoResult));
	}
	
	@Test
	public void twoByTwoDoseNotEqualTwoByTwoOther() {
		Assert.assertFalse(twoByTwoResult.equals(twoByTwoOther));
	}
	
	@Test
	public void threeByTwoEqualsItself(){
		Assert.assertTrue(threeByTwo.equals(threeByTwo));
	}
	
	@Test
	public void twoByTwoToString() {
		String resultString = "13 12\n29 26\n";
		Assert.assertEquals(resultString, twoByTwoResult.toString());
	}
	
	@Test
	public void twoByTwoPlusThreeByTwo() {
		Assert.assertNull(twoByTwoResult.plus(threeByTwo));
	}
	
	@Test
	public void twoByTwoPlusTwoByTwoOther() {
		Assert.assertNotNull(twoByTwoResult.plus(twoByTwoOther));
	}
	
	@Test
	public void twoByTwoPlusTwoByTwoOtherResult() {
		Assert.assertEquals(matrixAddition, twoByTwoOther.plus(twoByTwoResult2));
	}
}
