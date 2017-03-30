package unitTest;
import primitives.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTests {

	public class VectorTest {
		@Test
		public void testNormalize(){
			/*
			double z = 1;
			double x = test1.dotProduct(test2);
			result = vector1.crossProduct(vector2);
			try{			// normal the vector and done a dot-product
				vector1.normalize();
				vector1 = vector1.crossProduct(vector2);
				z = vector1.compareTo(source);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.err.println(e);
			}
			int y = result.compareTo(source);
		//	double t = Double.compare(0.0, -0.0);
			assertEquals(0,z,0);  
//			assertEquals(0,Double.compare(0.0,0.0),0);  
			assertEquals(0,y,0);
			assertEquals(-30,x, 0);
			//fail("Not yet implemented");
	*/		
			/*Vector v = new Vector(3.5,-5,10);
			v.normalize();
			assertEquals("", 1, v.length(),1e-10);
			v = new Vector(0,0,0);
			try {
				v.normalize();
				fail("Didn't throw divide by zero exception!");
			} catch (ArithmeticException e) {
				assertTrue(true);
			}*/
		}
	}

}
