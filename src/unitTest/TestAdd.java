package unitTest;
import primitives.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * this test class take care of adding and subtracting 
 * 
 * @author Uria
 * @author Nir
 *
 */
public class TestAdd {

	Coordinate xCoordinate;
	Coordinate yCoordinate;
	Coordinate zCoordinate;
	Point3D p1;
	Point3D p11;
	Point3D p2;
	Point3D p22;
	Vector vector;
	Point3D pResult;
	Point3D temp;
	Vector temV;
	@Before
	public void forTest(){
		
		xCoordinate = new Coordinate(2);
		yCoordinate = new Coordinate(3);
		zCoordinate = new Coordinate(6);
		
		p1  = new Point3D(1,2,3);
		p11 = new Point3D(xCoordinate,yCoordinate,zCoordinate);
		p2  = new Point3D(-5.5, 2.8432, -4.4);
		p22 = new Point3D(3.4,-2.8432,-6.6);
		temp = new Point3D();
		vector = new Vector(p11);
		temV = new Vector();
	}
	
	@Test
	public void test() {
		
	// ********* Regular Tests *************** //
		
		pResult = new Point3D(3, 5, 9);
		p1.add(vector);
		assertEquals(0, p1.compareTo(pResult), 0); // *
		
		vector.setHead(p22);
		temp.setPoint(p2);		 // temp = p2
		p2.add(vector);
		pResult = new Point3D(-2.1,0,-11);
		assertEquals(0, p2.compareTo(pResult), 0); // *
		
		assertEquals(1, p2.compareTo(temp), 0);
		vector.setHead(p22);
		
		pResult.subtract(vector);
		assertEquals(0, temp.compareTo(pResult), 0); // *
		
		
		
	//	fail("Not yet implemented");
		
		
	// ************ Edge point Tests *********** //
		
		xCoordinate.setCoordinate(0);
		yCoordinate.setCoordinate(0);
		zCoordinate.setCoordinate(0);
		
		p1 = new Point3D(xCoordinate,yCoordinate,zCoordinate);
		p11.setX(xCoordinate);
		p11.setY(yCoordinate);
		p11.setZ(zCoordinate);
		vector.setHead(p11);
		
		p11.subtract(vector);	
		p1.add(vector);
		assertEquals(0, p1.compareTo(p11), 0);
		
		p2.setPoint(p22);
		p2.add(vector);
		assertEquals(0, p2.compareTo(p22), 0);
		p22.subtract(vector);
		assertEquals(0, p2.compareTo(p22), 0);
		
		
	//	*************** More Tests *********************//
		System.out.println("Test01: Point3D compareTo");
        Point3D point3D = new Point3D(2.0, -7.5, 9.25);
        Point3D instance = new Point3D(2.0, -7.5, 9.25);
        int expResult = 0;
        int result = instance.compareTo(point3D);
        assertEquals(expResult, result);
        
        /*System.out.println("Test02: Point3D toString");
        Point3D instance1 = new Point3D(1.123, 2.569, 3.999);
        String expResult1 = "(1.12, 2.57, 4.00)";
        String result1 = instance1.toString();
        assertEquals(expResult1, result1);*/
        
        System.out.println("Test03: Point3D add");
        Vector vector = new Vector(1.25, -2.0, 3.0);
        Point3D instance2 = new Point3D(4.75, -5.0, 6.0);
        instance2.add(vector);
        assertTrue(instance2.compareTo(new Point3D(6.0, -7.0, 9.0)) == 0);
        
        System.out.println("Test04: Point3D subtract");
        Vector vector4 = new Vector(1.0, 2.0, 3.0);
        Point3D instance4 = new Point3D(4.0, 5.0, 6.0);
        instance4.subtract(vector4);
        assertTrue(instance4.compareTo(new Point3D(3.0, 3.0, 3.0)) == 0);
        
        System.out.println("Test05: Point3D distance");
        Point3D point5 = new Point3D(-20.5, 55, 9.25);
        Point3D instance5 = new Point3D(75, -10, -100);
        double expResult5 = 159.0;
        double result5 = instance5.distance(point5);
        assertEquals(expResult5, result5, 0.01);
        
        
        //***************** Vector Tests ************************//
        
        System.out.println("Test06: Vector Add test");
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);
        v1.add(v2);
        assertTrue(v1.compareTo(new Vector(0.0, 0.0, 0.0)) == 0);
        v2.add(v1);
        assertTrue(v2.compareTo(v2) == 0);
        
        System.out.println("Test07: Vector Substruct test");
        v1 = new Vector(1.0, 1.0, 1.0);
        v2 = new Vector(-1.0, -1.0, -1.0);
        v1.subtract(v2);
        assertTrue(v1.compareTo(new Vector(2.0, 2.0, 2.0)) == 0);
        v2.subtract(v1);
        assertTrue(v2.compareTo(new Vector(-3.0, -3.0, -3.0)) == 0);
        
        System.out.println("Test08: Vector Scaling test");

        v1 = new Vector(1.0, 1.0, 1.0);
        v1.scale(1);
        assertTrue(v1.compareTo(v1) == 0);
        v1.scale(2);
        assertTrue(v1.compareTo(new Vector(2.0, 2.0, 2.0)) == 0);
        v1.scale(-2);
        assertTrue(v1.compareTo(new Vector(-4.0, -4.0, -4.0)) == 0);
        
        
        Vector V1 = new Vector(2, 2, 2);
        Vector V2 = new Vector(3,3,3);
        System.out.println(V1);
        V1.add(V2);
        Vector V5 = new Vector(5,5,5);
        System.out.println(V1.toString());
        assertEquals(V1.toString(), V5.toString());
        
        V1 = new Vector(2, 2, 2);
        V2 = new Vector(3,3,3);
        System.out.println(V1);
        V1.subtract(V2);
        V5 = new Vector(-1,-1,-1);
        System.out.println(V1.toString());
        assertEquals(V1.toString(), V5.toString());
	}

}
