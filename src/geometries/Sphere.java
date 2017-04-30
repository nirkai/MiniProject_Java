package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import com.sun.java_cup.internal.runtime.virtual_parse_stack;

//import org.omg.IOP.TAG_MULTIPLE_COMPONENTS;

//import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class Sphere extends RadialGeometry{

	private Point3D _center;
	
	// ***************** Constructors ********************** //
	public Sphere(){
		_center = new Point3D();
	}
	public Sphere (Sphere sphere){
		this(sphere._radius, sphere._center);
		
	}
	public Sphere(double radius, Point3D center){
		super(radius);
		_center = new Point3D(center);
		
	}
	public Sphere(Map<String, String> attributes){
		
	}
	// ***************** Getters/Setters ********************** //
	public Point3D getCenter(){
		//TODO
		return _center;
	}
	public void setCenter(Point3D center){
		//TODO
		_center.setPoint(center);
	}
	// ***************** Operations ******************** //
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		// TODO Auto-generated method stub
		Point3D P0 = new Point3D(ray.getPOO());
		Vector L = new Vector(_center, P0);
		Vector V = new Vector(ray.getDirection());
		V.normalize();
		double t_m = L.dotProduct(V);
		double d = (Math.sqrt(  Math.pow(L.length(),2) - Math.pow(t_m, 2) ) );
		
		List<Point3D> pArrayList = new ArrayList<Point3D>();
		if (d <= _radius) {
			double t_h = (Math.sqrt( ( Math.pow(_radius,2) - Math.pow(d, 2) ) ));
			double t1 = t_m - t_h;
			double t2 = t_m + t_h;
			
			/*V.normalize();
			V.scale(t1);
			P0.add(V);
			Point3D P1 = new Point3D(P0);
			
			V.setHead(ray.getDirection().getHead());
			V.normalize();
			V.scale(t2);
			P0.setPoint(ray.getPOO());
			P0.add(V);
			Point3D P2 = new Point3D(P0);*/
			
			Point3D p1 = intersecPoint(ray, t1);
			Point3D p2 = intersecPoint(ray, t2);
			
			
			if (t1 > 0) {
				
				pArrayList.add(p1);
			}
			if (t2 > 0) {
				
				pArrayList.add(p2);
			}
			return pArrayList;
		}
		
		return pArrayList;
	}
	
	private  Point3D intersecPoint(Ray ray, double t) {
		Point3D P0 = new Point3D(ray.getPOO());
		Vector V = new Vector(ray.getDirection());
		V.normalize();
		V.scale(t);
		P0.add(V);
		return new Point3D(P0);
	}
	
	public Vector getNormal(Point3D point){
		Vector vector = new Vector(point,_center);
		vector.normalize();
		return vector;
	}
}
