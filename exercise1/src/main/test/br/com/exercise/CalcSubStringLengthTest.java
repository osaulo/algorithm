/**
 * 
 */
package br.com.exercise;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author SAULO
 *
 */
class CalcSubStringLengthTest {

	private CalcSubStringLength calcSubStringLength; 
	
	public CalcSubStringLengthTest() {
		super();
		calcSubStringLength = new CalcSubStringLength();
	}

	@Test
	public void testCalcStringEmpty() {
		int actual = calcSubStringLength.calc("");
		
		Assert.assertEquals(0, actual);
	}
	
	@Test
	public void testCalcStringOnlyOneChar() {
		int actual = calcSubStringLength.calc("a");
		
		Assert.assertEquals(1, actual);
	}
	
	@Test
	public void testCalcStringOneCharRepeated() {
		int actual = calcSubStringLength.calc("aaaaaaaaaaaaa");
		
		Assert.assertEquals(1, actual);
	}
	
	@Test
	public void testCalcStringOneCharRepeatedCaseSensitive() {
		int actual = calcSubStringLength.calc("aAaAaAaAaAaAaA");
		
		Assert.assertEquals(2, actual);
	}
	
	@Test
	public void testCalcStringAllAlphabet() {
		int actual = calcSubStringLength.calc("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		Assert.assertEquals(26, actual);
	}
	
	@Test
	public void testCalcMoreOneSameSize3() {
		int actual = calcSubStringLength.calc("abcabcabc");
		
		Assert.assertEquals(3, actual);
	}
	
	@Test
	public void testCalcMoreOneSameSize4() {
		int actual = calcSubStringLength.calc("abbacdcabbacdc");
		
		Assert.assertEquals(4, actual);
	}
	
	@Test
	public void testCalcStringHappyCase() {
		int actual = calcSubStringLength.calc("abbacdc");
		
		Assert.assertEquals(4, actual);
	}
}
