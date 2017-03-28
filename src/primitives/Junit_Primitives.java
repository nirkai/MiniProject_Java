package primitives;

import static org.junit.Assert.*;

import org.junit.Test;

public class Junit_Primitives {

	@Test
	public void test() {
		Point3D  x = new Point3D();
		
		Vector test1 = new Vector(x,x);
		
		Vector test2 = new Vector(0, 0, 0);
		
		test1.subtract(test2);
		
		
		assertEquals(test1.compareTo(test2), 0);
		//fail("Not yet implemented");
	}

}
