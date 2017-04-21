package primitives;

/**
 * This class make a Vector
 * 
 * @author Uria
 * @author Nir
 * 
 * Enables vector adding/subtraction 
 * scalar multiplication
 * displacement 
 * vector length calculation
 * vector normalization
 * vector multiplication
 * 
 * המחלקה מאפשרת בניית וקטור
 *  מאפשרת לבצע חיבור/חיסור וקטורי, מכפלה סקלארית, הזזה, חישוב אורך הוקטור, נרמול הוקטור, מכפלה וקטורית 
 *
 */

public class Vector implements Comparable<Vector> {
	
	// Head of the Vector. Base from the first of the contractions
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
			/*_head = new Point3D(p1);
			p2.subtract(this);
			_head.setPoint(p2);*/
		_head = new Point3D(p2);
		Point3D point3d = new Point3D(p1);
		point3d.subtract(this);
		_head.setPoint(point3d);
	//	else problem
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Point3D getHead() {
		return _head;
	}
	// Getters for the coordinates of the vector head
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
		//_head = new Point3D(head);
		_head.setX(head.getX());
		_head.setY(head.getY());
		_head.setZ(head.getZ());
	}
/*	// Setters for the coordinates of the vector head
	public void setX(double x) {
		_head.getX().setCoordinate(x);
	}
	public void setY(double y) {
		_head.getY().setCoordinate(y);
	}
	public void setZ(double z) {
		_head.getZ().setCoordinate(z);
	}*/
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
	/**
	 * Add two Vectors
	 * @param vector
	 */
	public void add (Vector vector ){
		_head.add(vector);
	}
	/**
	 * Subtract two Vectors
	 * @param vector
	 */
	public void subtract (Vector vector){
		_head.subtract(vector);
	}
	/**
	 * Dot a Vector with a scalar
	 * @param scalingFactor
	 */
	public void scale(double scalingFactor) {
		_head._x.setCoordinate(scalingFactor * getX() ); 
		_head._y.setCoordinate(scalingFactor * getY() ); 
		_head._z.setCoordinate(scalingFactor * getZ() ); 
	}
	/**
	 * Done a Vectors product between two vectors
	 * @param vector
	 * @return new third Vector that that stand to the two vectors
	 */
	public Vector crossProduct(Vector vector){
		double x = ( (getY() * vector.getZ()) - (getZ() * vector.getY()) );		
		double y = ( (getZ() * vector.getX()) - (getX() * vector.getZ()) );	// == -( (getX() * vector.getZ()) - (getZ() * vector.getX()) )
		double z = ( (getX() * vector.getY()) - (getY() * vector.getX()) );
		return new Vector(x,y,z);
	}
	/**
	 * Calculate the length of the Vector
	 * @return The length of the Vector
	 */
	public double length(){
		return Math.sqrt(Math.pow(getX(),2)
				+ Math.pow(getY(),2)
				+ Math.pow(getZ(),2));
	}
	/**
	 * Calculates the normalization of the vector 
	 * @throws Exception if the length of the vector equal to 0
	 */
	public void normalize() {	// Throws exception if length = 0
		if (length() == 0) {
			throw new ArithmeticException("Can't devide in zero");
		}
		double len = length();
		_head._x.setCoordinate(getX() / len);
		_head._y.setCoordinate(getY() / len);
		_head._z.setCoordinate(getZ() / len);
	}
	/**
	 * Done a dot product between two vectors
	 * @param vector
	 * @return The scalar of the dot-product 
	 */
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
