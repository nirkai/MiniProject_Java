package primitives;

/**
 * 
 * @author Nir
 * @author Uria
 * 
 * This class take care the point in space
 * Extends from Point2D class
 * 
 */
public class Point3D extends Point2D {
	
	// the space coordinate
	protected Coordinate _z;
	
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
		if (_x.compareTo(point3D._x) == 0 && _y.compareTo(point3D._y) == 0) {              /// check it !!!
			return _z.compareTo( ((Point3D)point3D)._z );
		}
		else return 1;
	}
	
	@Override
	public String toString() {
		return String.format("X = s%\nY = %s\nZ = %s\n", _x.getCoordinate(), _y.getCoordinate(), _z.getCoordinate());
	}
	
	// ***************** Operations ******************** //
	public void add(Vector vector){
		_x.setCoordinate(_x.getCoordinate() + vector.getHead().getX().getCoordinate());
		_y.setCoordinate(_y.getCoordinate() + vector.getHead().getY().getCoordinate());
		_z.setCoordinate(_z.getCoordinate() + vector.getHead().getZ().getCoordinate());
	}
	
	public void subtract(Vector vector) {
		_x.setCoordinate(_x.getCoordinate() - vector.getHead().getX().getCoordinate());
		_y.setCoordinate(_y.getCoordinate() - vector.getHead().getY().getCoordinate());
		_z.setCoordinate(_z.getCoordinate() - vector.getHead().getZ().getCoordinate());
	}
	public double distance(Point3D point){
		
		return 0;					//////////
	}
	
}
