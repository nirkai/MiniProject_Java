package primitives;

import static org.junit.Assert.*;

//import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;

//import com.sun.corba.se.impl.orb.NormalDataCollector;

public class Junit_Primitives {

	Vector test1;
	Vector test2;
	Vector vector1;
	Vector vector2;
	Vector result;
	Vector source;
	
	@Before
	public void Before() {
		result = new Vector();
		source = new Vector();
	    test1 = new Vector(6,0,3); 
	    test2 = new Vector(-4,3,-2);    
	    vector1 = new Vector(1,2,3);
	    vector2 = new Vector(2, 4, 6);
	}
	
	@Test
	public void test() { 
		/*double z = 1;
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
//		assertEquals(0,Double.compare(0.0,0.0),0);  
		assertEquals(0,y,0);
		assertEquals(-30,x, 0);
		//fail("Not yet implemented");
*/		
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
	}

}
