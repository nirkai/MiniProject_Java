package geometries;

import primitives.*;
import java.util.List;
import java.util.Map;

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
		return null;
	}
	
	public Vector getNormal(Point3D point){
		Vector vector = new Vector(point,_center);
		vector .normalize();
		return vector;
	}
}
