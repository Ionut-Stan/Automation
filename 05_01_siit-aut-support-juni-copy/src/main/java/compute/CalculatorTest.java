package compute;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author alexgabor
 *
 */
public class CalculatorTest {

	Calculator calc = new Calculator();

	@Test
	public void testMultiply_for_0() {
		double result = calc.compute(0, 1, "*");
		Assert.assertEquals(0, result, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidOperator() {
		calc.compute(10, -5, "aaa");
	}
}
