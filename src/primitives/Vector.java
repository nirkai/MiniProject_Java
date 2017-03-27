package primitives;

/**
 * 
 * @author Uria
 * @author Nir
 * 
 * This class make a Vector
 *
 */

public class Vector {
	
	private Point3D _head;
	// ***************** Constructors ********************** //
	
	public Vector() {
		_head = new Point3D();
	}
	public Vector(Point3D head) {
		_head = new Point3D(head);
	}
	
	public Vector(Vector vector) {
		this(vector._head);
	}
	
	public Vector(double xHead, double yHead, double zHead) {
		_head = new Point3D(xHead,yHead,zHead);
	}
	
	public Vector(Point3D p1, Point3D p2) { // i suppose this is for tabbing the vector
		_head = new Point3D(p2);
		p1.subtract(this);
	}
	
	// ***************** Getters/Setters ********************** //
	public Point3D getHead() {
		return _head;
	}
	public void setHead(Point3D head) {
		_head = new Point3D(head);
	}
	// ***************** Administration ******************** //
	public int compareTo(Vector vector){   //////////
		return _head.compareTo(vector._head);
	}
	
	@Override
	public String toString() {
		return String.format("(s%, %s, %s)\n", 
				_head._x.getCoordinate(), _head._y.getCoordinate(), _head._z.getCoordinate());
	}
	// ***************** Operations ******************** //
//	public void add (Vector vector );
//	public void subtract (Vector vector);
	
	public void scale(double scalingFactor) {
		_head._x.setCoordinate(scalingFactor * _head._x.getCoordinate()); 
		_head._y.setCoordinate(scalingFactor * _head._y.getCoordinate()); 
		_head._z.setCoordinate(scalingFactor * _head._z.getCoordinate()); 
	}
	
//	public Vector crossProduct(Vector vector);
	public double length(){
		return Math.sqrt(Math.pow(_head._x.getCoordinate(),2)
				+ Math.pow(_head._y.getCoordinate(),2)
				+ Math.pow(_head._z.getCoordinate(),2));
	}
	public void normalize() throws Exception {	// Throws exception if length = 0
		if (length() == 0) {
			throw new Exception("Can't devide in zero");
		}
		_head._x.setCoordinate(coordinate(1) / length());
		_head._y.setCoordinate(coordinate(2) / length());
		_head._z.setCoordinate(coordinate(3) / length());
	}
	public double dotProduct(Vector vector){
		return (  coordinate(1) * vector.coordinate(1)
				+ coordinate(2) * vector.coordinate(2)
				+ coordinate(3) * vector.coordinate(3) );
	}
	
	
	// *************** internal Functions ****************** //
	private double coordinate(int num) {
		switch (num) {
		case 1:
			return _head._x.getCoordinate();
		case 2:
			return _head._y.getCoordinate();
		case 3:
			return _head._z.getCoordinate();
		default:
			return 0; ///
		}
	}
}
