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
		
		
		// ********** More Tests **************** //
		System.out.println("Test10: Vector Length test");
        v = new Vector(3.5, -5, 10);
        assertTrue(v.length() == Math.sqrt(12.25 + 25 + 100));
        

        System.out.printf("Test11: Vector Normalize test -> ");
        v = new Vector(100, -60.781, 0.0001);
        System.out.printf("Length = %f  ", v.length());
        v.normalize();
        System.out.printf("Length = %f\n", v.length());
        assertEquals(1, v.length(), 1e-10);

        v = new Vector(0, 0, 0);
        try {
            v.normalize();
            fail("Didn't throw divide by zero exception!");
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
        
        
        System.out.println("Test12: Vector Cross product test");

        Vector v1 = new Vector(3.5, -5.0, 10.0);
        Vector v2 = new Vector(2.5, 7, 0.5);
        Vector v3 = v1.crossProduct(v2);

        assertEquals(0, v3.dotProduct(v2), 1e-10);
        assertEquals(0, v3.dotProduct(v1), 1e-10);

        Vector v4 = v2.crossProduct(v1);
        v3.add(v4);
        assertEquals(0, v3.length(), 1e-10);
        
        Vector V1 = new Vector(-2, 4, 5);
        double b = V1.length();
        double a = 6.7;
        Vector V2 = new Vector(1, 1, 1);
        assertEquals(b, a, 0.5);
        
        V1 = new Vector(3,-2, 6);
        Vector VResult= new Vector(0.428,-0.285,0.857);
        V1.normalize();
        assertEquals(V1.toString(), VResult.toString());
        
        V1 = new Vector(-2, 4, 0);
        V2 = new Vector(1, -3, 5);
        Vector V3 = new Vector(3, 2, 1);
        V2.dotProduct(V3);
        System.out.println(V1);
        System.out.println(V2);
        a = -14;
        b =  V1.dotProduct(V2);
        assertEquals(b, a,0);
	}

}
