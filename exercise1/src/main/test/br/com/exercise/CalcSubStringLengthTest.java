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

}
