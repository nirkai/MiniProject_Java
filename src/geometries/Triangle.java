package geometries;
import java.util.List;
import java.util.Map;

import primitives.*;

public class Triangle extends Geometries implements FlatGeometry {
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;
	// ***************** Constructors ********************** //
	public Triangle(){
		
	}
	public Triangle(Triangle triangle){
		_p1 = new Point3D();
		_p2 = new Point3D();
		_p3 = new Point3D();
	}
	public Triangle(Point3D p1, Point3D p2, Point3D p3){
		_p1 = new Point3D(p1);
		_p2 = new Point3D(p2);
		_p3 = new Point3D(p3);
	}
	public Triangle(Map<String, String> attributes){
		
	}
	// ***************** Getters/Setters ********************** //
	public Point3D getP1(){
		return _p1;
	}
	public Point3D getP2(){
		return _p2;
	}
	public Point3D getP3(){
		return _p3;
	}
	public void setP1(Point3D p1){
		_p1.setPoint(p1);
	}
	public void setP2(Point3D p2){
		_p2.setPoint(p2);
	}
	public void setP3(Point3D p3){
		_p3.setPoint(p3);
	}
	// ***************** Operations ******************** //
	public Vector getNormal(Point3D point){
		// TODO
		Vector AB = new Vector(_p1, _p2);
		Vector AC = new Vector(_p1, _p3);
		Vector normal = AB.crossProduct(AC);
		Point3D point3d = new Point3D(point);
		point3d.subtract(normal);
		normal.setHead(point3d);
		return normal;
	}
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
}
