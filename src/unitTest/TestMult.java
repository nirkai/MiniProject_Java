package unitTest;
import primitives.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * this test class take care of dotProduct, crossProduct and scalarProduct
 * 
 * @author Uria
 * @author Nir
 *
 */

public class TestMult {
	
	Coordinate xCoordinate;
	Coordinate yCoordinate;
	Coordinate zCoordinate;
	Point3D p1;
	Point3D p11;
	Point3D p2;
	Point3D p22;
	Point3D pResult;
	Point3D temp;
	Vector vector1;
	Vector vector2;
	Vector temV;
	
	@Before
	public void forTest(){
		
		xCoordinate = new Coordinate(-2);
		yCoordinate = new Coordinate(-4);
		zCoordinate = new Coordinate(6);
		
		p1  = new Point3D(1,2,3);
		p11 = new Point3D(xCoordinate,yCoordinate,zCoordinate);
		
		vector1 = new Vector(p1);
		vector2 = new Vector(p11);
		temp = new Point3D(24,-12,0);
		temV = new Vector(temp);
		
		p2  = new Point3D(-5.5, 2.8432, -4.4);
		p22 = new Point3D(3.4,-2.8432,-6.6);
		
		
		
	}
	

	@Test
	public void test() {
		
		// ********* Regular Tests *************** //
		
		double dot = vector1.dotProduct(vector2);
		assertEquals(8, dot, 0);
		vector1 = vector1.crossProduct(vector2);
		int cross = vector1.compareTo(temV);
		assertEquals(0, cross, 0);
		
		vector1.setHead(p2);
		vector2.setHead(p22);
		dot = vector1.dotProduct(vector2);
		assertEquals(2.25621376, dot, 1e-10);
		temV = new Vector(-31.2752, -51.26, 5.97072);
		vector1 = vector1.crossProduct(vector2);
		cross = vector1.compareTo(temV);
		assertEquals(0, cross, 0);
	
	//	fail("Not yet implemented");
		
		// ************ Edge point Tests *********** //
		
		
		
		
		// *********** More Tests	****************//
		
		System.out.println("Test09: Vector Dot product test");
        Vector v1 = new Vector(3.5, -5, 10);
        Vector v2 = new Vector(2.5, 7, 0.5);
        assertTrue(Double.compare(v1.dotProduct(v2), (8.75 + -35 + 5)) == 0);
        
        Vector V1 = new Vector(2, 2, 2);
        double a =-1;
        V1.scale(a);
        Vector VResult = new Vector(-2, -2, -2);
        assertEquals(V1.toString(), VResult.toString());
        
        V1 = new Vector(-2, 4, 0);
        Vector V2 = new Vector(1, -3, 5);
        Vector V3 = new Vector(3, 2, 1);
        Vector VE = new Vector( V1.crossProduct(V2));
        V2.crossProduct(V3);
        System.out.println(V1);
        System.out.println(V2);
        VResult = new Vector(20, 10, 2);
        assertEquals(VE.toString(), VResult.toString());
        
        
	}

}
