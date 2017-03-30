package unitTest;
import primitives.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * this test class take care of normalization of vector
 * 
 * @author Uria
 * @author Nir
 *
 */

public class TestNormal {

	@Test
	public void test() {
		Vector v = new Vector(3.5,-5,10);
		v.normalize();
		assertEquals("", 1, v.length(),1e-10);
		v = new Vector(0,0,0);
		try {
			v.normalize();
			fail("Didn't throw divide by zero exception!");
		} catch (ArithmeticException e) {
			assertTrue(true);
		}
	//	fail("Not yet implemented");
	}

}
