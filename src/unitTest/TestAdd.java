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
		
		
	}

}
