package geometries;
import java.util.ArrayList;
import java.util.List;

import primitives.*;


public class Plane extends Geometry implements FlatGeometry {
	
	private Vector _normal;
	private Point3D _Q;

	// ***************** Constructors ********************** //
	/**
	 * default constructor
	 * define a plane by point on the plane and a normal of it.
	 */
	public Plane(){
		_normal = new Vector();
		_Q = new Point3D();
	}
	/**
	 * copy constructor
	 * @param plane
	 */
	public Plane (Plane plane){
		this(plane._normal, plane._Q);
	}
	/**
	 * constructor. get a point on the plane and normal to it. define the plane. 
	 * @param Vector normal
	 * @param Point3D q
	 */
	public Plane (Vector normal, Point3D q){
		_normal = new Vector(normal);
		_Q = new Point3D(q);
		_normal.normalize();
	}
	// ***************** Getters/Setters ********************** //
	@Override
	public Vector getNormal(Point3D point){
		return new Vector(_normal);
	}
	public Point3D getQ(){
		return new Point3D(_Q); 
	}
	public void setNormal(Vector normal){
		_normal.setHead(normal.getHead());
		_normal.normalize();
	}
	public void setQ(Point3D d){
		_Q.setPoint(d);
	}
	
	// ***************** Operations ******************** //
	/**
	 * find the intersections with the plane
	 * we calculate the 't' scalar by the formula .
	 * by the scalar and the ray normal  vector we can calculate the point P on the plane
	 */
	@Override
	public List<Point3D> FindIntersections(Ray ray) {	
		Vector vQ_P = new Vector(ray.getPOO(), _Q);
		Vector vector2 = new Vector(ray.getDirection());
		List<Point3D> pArrayList = new ArrayList<Point3D>();
		vector2.normalize();
		double t = - vQ_P.dotProduct(_normal) / vector2.dotProduct(_normal);
		if (t >= 0) {
			Point3D P = ray.getPOO();
			vector2.scale(t);
			P.add(vector2);
			pArrayList.add(P);
		}
		return pArrayList;
	}
}
