package primitives;

import static org.junit.Assert.*;

import org.junit.Test;

public class Junit_Primitives {

	@Test
	public void test() {
//		Point3D  x = new Point3D();
		Vector source = new Vector();
		Vector test1 = new Vector(1,2,3);
		
		Vector test2 = new Vector(2, 4, 6);
		Vector reslt = test1.crossProduct(test2);
	//	test1.subtract(test2);
		
		
		assertEquals(source.compareTo(reslt), 0);
		//fail("Not yet implemented");
	}

}
