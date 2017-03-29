package primitives;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

/**
 * 
 * @author Uria
 * @author Nir
 * 
 * This class make a Vector
 *
 */

public class Vector implements Comparable<Vector> {
	
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
	//	else problem
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Point3D getHead() {
		return _head;
	}
	public double getX() {
		return _head._x.getCoordinate();
	}
	public double getY() {
		return _head._y.getCoordinate();
	}
	public double getZ() {
		return _head._z.getCoordinate();
	}
	
	public void setHead(Point3D head) {
		_head = new Point3D(head);
	}
	public void setX(double x) {
		_head.getX().setCoordinate(x);
	}
	public void setY(double y) {
		_head.getY().setCoordinate(y);
	}
	public void setZ(double z) {
		_head.getZ().setCoordinate(z);
	}
	// ***************** Administration ******************** //
	@Override
	public int compareTo(Vector vector){   //////////
		return _head.compareTo(vector._head);
	}
	
	@Override
	public String toString() {
		return String.format("(s%, %s, %s)\n", 
				getX(), getY(), getZ());
	}
	// ***************** Operations ******************** //
	public void add (Vector vector ){
		_head.add(vector);
	}
	public void subtract (Vector vector){
		
	}
	
	public void scale(double scalingFactor) {
		_head._x.setCoordinate(scalingFactor * getX() ); 
		_head._y.setCoordinate(scalingFactor * getY() ); 
		_head._z.setCoordinate(scalingFactor * getZ() ); 
	}
	
	public Vector crossProduct(Vector vector){   /// vectory product ????
		double x = ( (getY() * vector.getZ()) - (getZ() * vector.getY()) );		
		double y = -( (getX() * vector.getZ()) - (getZ() * vector.getX()) );
		double z = ( (getX() * vector.getY()) - (getY() * vector.getX()) );
		return new Vector(x,y,z);
	}
	
	public double length(){
		return Math.sqrt(Math.pow(getX(),2)
				+ Math.pow(getY(),2)
				+ Math.pow(getZ(),2));
	}
	public void normalize() throws Exception {	// Throws exception if length = 0
		if (length() == 0) {
			throw new Exception("Can't devide in zero");
		}
		double len = length();
		_head._x.setCoordinate(getX() / len);
		_head._y.setCoordinate(getY() / len);
		_head._z.setCoordinate(getZ() / len);
	}
	public double dotProduct(Vector vector){
		return (  getX() * vector.getX()
				+ getY() * vector.getY()
				+ getZ() * vector.getZ() );
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
