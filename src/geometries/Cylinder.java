package geometries;

import java.util.List;

// import com.sun.org.apache.regexp.internal.recompile;

import primitives.*;

public class Cylinder extends RadialGeometry{
	
	private Point3D _axisPoint;
	private Vector _axisDirection;
	
	// ***************** Constructors ********************** //
	
	public Cylinder(){
		
	}
	public Cylinder(Cylinder cylinder){
		
	}
	public Cylinder(double radius, Point3D axisPoint, Vector axisDirection){
		
	}
	// ***************** Getters/Setters ********************** //
	
	public Point3D getAxisPoint(){
		//TODO
		return null;
	}
	public Vector getAxisDirection(){
		//TODO
		return null;
	}
	public void setAxisPoint(Point3D axisPoint){
		_axisPoint.setPoint(axisPoint);
	}
	public void setAxisDirection(Vector axisDirection){
		_axisDirection.setHead(axisDirection.getHead());
	}
	
	// ***************** Operations ******************** //
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		//TODO
		return null;
	}
	public Vector getNormal(Point3D point){
		//TODO
		return null;
	}
}
