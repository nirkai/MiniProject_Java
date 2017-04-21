package geometries;
import java.util.ArrayList;
import java.util.List;

import primitives.*;
//import sun.net.www.content.text.plain;

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
	//	_normal = new Vector(plane._normal);
	//	_Q = new Point3D(plane._Q);
		this(plane._normal, plane._Q);
	}
	public Plane (Vector normal, Point3D q){
		_normal = new Vector(normal);
		_Q = new Point3D(q);
	}
	// ***************** Getters/Setters ********************** //
	@Override
	public Vector getNormal(Point3D point){
		/*_normal = new Vector(point);
		_normal.normalize();*/
		
		/*Vector normal = new Vector(_normal);
		Point3D point3d = new Point3D(point);
		point3d.subtract(normal);
		normal.setHead(point3d);*/
		return _normal;
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
		
		Vector vector = new Vector(ray.getPOO(), _Q);
		Vector vector2 = new Vector(ray.getDirection());
		
		double t = - vector.dotProduct(_normal) / vector2.dotProduct(_normal);
		if (t >= 0) {
			Point3D P = new Point3D(ray.getPOO());
			vector.setHead(_normal.getHead());
			vector.scale(t);
			P.add(vector);
			List<Point3D> pArrayList = new ArrayList<Point3D>();
			pArrayList.add(P);
			return pArrayList;
		}

		return null;
	}
}
