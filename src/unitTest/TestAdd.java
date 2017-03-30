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
	Point3D p2;
	Vector vector;
	Point3D pResult;
	@Before
	public void forTest(){
		xCoordinate = new Coordinate(2);
		yCoordinate = new Coordinate(3);
		zCoordinate = new Coordinate(6);
		p1 = new Point3D(1,2,3);
		p2 = new Point3D(xCoordinate,yCoordinate,zCoordinate);
		vector = new Vector(p2);
		pResult = new Point3D(3, 5, 9);
	}
	
	@Test
	public void test() {
		p1.add(vector);
		
		assertEquals(0, p1.compareTo(pResult), 0);
		
	//	fail("Not yet implemented");
	}

}
