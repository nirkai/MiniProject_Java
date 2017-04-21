package primitives;

/**
 * This class take care of the rays. 
 * This is a vector that does not necessarily come from the beginning of the contractions
 * 
 * @author Uria
 * @author Nir
 *
 *	
 */
public class Ray {
	// Point of origin
	private Point3D _POO;
	// Ray direction
	private Vector _direction;
	// ***************** Constructors ********************** //
	
	public Ray(){
		/*_POO = new  Point3D();
		_direction = new Vector();*/
		this(new Point3D(), new Vector());
	}
	
	public Ray(Ray ray){
		/*_POO = new Point3D(ray._POO);
		_direction = new Vector(ray._direction);*/
		
		this(ray._POO, ray._direction);		
	}
	
	public Ray(Point3D poo, Vector direction){
		_POO = new Point3D(poo);
		_direction = new Vector(direction.getHead());
		//_direction.normalize();
	}
	// ***************** Getters/Setters ********************** //
	public void setPOO(Point3D _POO){
		_POO=new Point3D(_POO);
	}
	public void setDirection(Vector _direction){
		_direction=new Vector(_direction);
	}
	public Vector getDirection(){
		return _direction;
	}
	public Point3D getPOO(){
		return _POO;
	}

}
