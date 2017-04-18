package geometries;
import java.util.List;

import primitives.*;

//import com.sun.javafx.geom.Vec2d;
//import sun.net.www.content.text.plain;

public class Plane extends Geometries implements FlatGeometry {
	
	private Vector _normal;
	private Point3D _Q;

	// ***************** Constructors ********************** //
	public Plane(){
		_normal = new Vector();
		_Q = new Point3D();
	}
	public Plane (Plane plane){
		_normal = new Vector(plane._normal);
		_Q = new Point3D(plane._Q);
	}
	public Plane (Vector normal, Point3D q){
		_normal = new Vector(normal);
		_Q = new Point3D(q);
	}
	// ***************** Getters/Setters ********************** //
	public Vector getNormal(Point3D point){
		/*_normal = new Vector(point);
		_normal.normalize();*/
		Vector normal = new Vector(_normal);
		Point3D point3d = new Point3D(point);
		point3d.subtract(normal);
		normal.setHead(point3d);
		return normal;
	}
	public Point3D getQ(){
		return _Q;   ///
	}
	public void setNormal(Vector normal){
		_normal.setHead(normal.getHead());
		_normal.normalize();
	}
	public void setQ(Point3D d){
		_Q.setPoint(d);
	}
	// ***************** Operations ******************** //
	//public List<Point3D> FindIntersections(Ray ray);
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
}
