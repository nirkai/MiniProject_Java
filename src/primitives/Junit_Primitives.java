package primitives;

import static org.junit.Assert.*;

import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;

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
	    test1 = new Vector(-6,15,12); 
	    test2 = new Vector(6,0,3);    
	    vector1 = new Vector(1,2,3);
	    vector2 = new Vector(2, 4, 6);
	}
	
	@Test
	public void test() { 
		double x = test1.dotProduct(test2);
		result = vector1.crossProduct(vector2);
		int y = result.compareTo(source);

		assertEquals(0,y,0);
		assertEquals(0,x, 0);
		//fail("Not yet implemented");
	}

}
