package primitives;

//import sun.net.www.content.audio.x_aiff;

/**
 * This class take care the point in space
 * Extends from Point2D class
 * 
 * @author Uria
 * @author Nir
 * 
 * 
 */
public class Point3D extends Point2D {
	
	protected Coordinate _z;	// coordinate on axis Z
	
	// ***************** Constructors ********************** //
	
	public Point3D() {
		super();
		_z = new Coordinate();
	}
	
	public Point3D(double x, double y, double z){
		_x = new Coordinate(x);
		_y = new Coordinate(y);
		_z = new Coordinate(z);
		
	}
	
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x, y);
		_z = new Coordinate(z);
	}
	
	public Point3D(Point3D point3D) {
		this(point3D._x,point3D._y,point3D._z);
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Coordinate getZ() {
		return new Coordinate(_z);
	}
	
	public void setZ(Coordinate z) {
		//_z = new Coordinate(z);
		_z.setCoordinate(z.getCoordinate());
	}
	
	public void setPoint(Point3D point) {
		setX(point._x);
		setY(point._y);
		setZ(point._z);
	}
	
	// ***************** Administration ******************** //
	@Override
	public int compareTo(Point2D point3D) {
		if (point3D instanceof Point3D) {
			if (_x.compareTo(point3D._x) == 0 && _y.compareTo(point3D._y) == 0) {              /// check it !!!
				return _z.compareTo( ((Point3D)point3D)._z );
			}
			else return 1;
		}
		throw new IllegalAccessError("invalid valiue");  ///////////////
	}
	
	@Override
	public String toString() {
		return String.format("(X = %.2f, Y = %.2f, Z = %.2f)", _x.getCoordinate(), _y.getCoordinate(), _z.getCoordinate());
	}
	
	// ***************** Operations ******************** //
	/**
	 * Adding two points
	 * @param vector
	 */
	public void add(Vector vector){
		
		_x.add(vector.getHead()._x);
		_y.add(vector.getHead()._y);
		_z.add(vector.getHead()._z);

	}
	
	public void subtract(Vector vector) {
		
		_x.subtract(vector.getHead()._x);
		_y.subtract(vector.getHead()._y);
		_z.subtract(vector.getHead()._z);
		
	}
	/**
	 * one point get a second point. Calculate the distance between the two points
	 * @param point
	 * @return The distance between the two points
	 */
	public double distance(Point3D point)	{
		return Math.sqrt( Math.pow((_x.getCoordinate() - point._x.getCoordinate()),2)
				+ Math.pow((_y.getCoordinate() - point._y.getCoordinate()),2)
				+ Math.pow((_z.getCoordinate() - point._z.getCoordinate()),2) );					//////////
	}
}
