package primitives;

/**
 * This class take care the point in space
 * Extends from Point2D class
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
		_z = new Coordinate();
	}
	
	public Point3D(Point3D point3D) {
		this(point3D._x,point3D._y,point3D._z);
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Coordinate getZ() {
		return _z;
	}
	
	public void setZ(Coordinate z) {
		_z = new Coordinate(z);
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
		return String.format("X = s%\nY = %s\nZ = %s\n", _x.getCoordinate(), _y.getCoordinate(), _z.getCoordinate());
	}
	
	// ***************** Operations ******************** //
	public void add(Vector vector){
		_x.setCoordinate( _x.getCoordinate() + vector.getX() );
		_y.setCoordinate( _y.getCoordinate() + vector.getY() );
		_z.setCoordinate( _z.getCoordinate() + vector.getZ() );

	}
	
	public void subtract(Vector vector) {
		_x.setCoordinate( _x.getCoordinate() - vector.getX() );
		_y.setCoordinate( _y.getCoordinate() - vector.getY() );
		_z.setCoordinate( _z.getCoordinate() - vector.getZ() );
	}
	public double distance(Point3D point){
		return Math.sqrt( Math.pow((_x.getCoordinate() - point._x.getCoordinate()),2)
				+ Math.pow((_y.getCoordinate() - point._y.getCoordinate()),2)
				+ Math.pow((_z.getCoordinate() - point._z.getCoordinate()),2) );					//////////
	}
	
}
