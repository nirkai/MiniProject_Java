package geometries;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import primitives.*;

public class Triangle extends Geometry implements FlatGeometry {
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;
	
	// ***************** Constructors ********************** //
	
	/**
	 * default constructor
	 * define a triangle by 3 vertex.
	 */
	public Triangle(){
		_p1 = new Point3D();
		_p2 = new Point3D();
		_p3 = new Point3D();
	}
	/**
	 * copy constructor
	 * @param triangle
	 */
	public Triangle(Triangle triangle){
		this(triangle._p1, triangle._p2, triangle._p3);
	}
	/**
	 * constructor. define the triangle by 3 vertex.
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public Triangle(Point3D p1, Point3D p2, Point3D p3){
		_p1 = new Point3D(p1);
		_p2 = new Point3D(p2);
		_p3 = new Point3D(p3);
	}
	public Triangle(Map<String, String> attributes){
		
	}
	// ***************** Getters/Setters ********************** //
	public Point3D getP1(){
		return new Point3D(_p1);
	}
	public Point3D getP2(){
		return new Point3D(_p2);
	}
	public Point3D getP3(){
		return new Point3D(_p3);
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
	/**
	 * calculate the normal of the triangle by cross product of two vectors of the triangle.
	 */
	@Override
	public Vector getNormal(Point3D point){
		Vector AB = new Vector(_p1, _p2);
		Vector AC = new Vector(_p1, _p3);
	//	this will make a cross product like => -1 x (AB x AC) 
		Vector normal = AC.crossProduct(AB);
		normal.normalize();
		return normal;
	}
	/*
	 * (non-Javadoc)
	 * @see geometries.Geometry#FindIntersections(primitives.Ray)
	 */
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		Vector normal = new Vector(this.getNormal(_p1));
		normal.normalize();
		Plane plane = new Plane(normal,_p3);
		List<Point3D> tArrayList = plane.FindIntersections(ray);
		if (tArrayList.size() > 0) {
			if (checkInstructions(ray.getPOO(), tArrayList.get(0))){
				return tArrayList;
			}
		}
		return new ArrayList<Point3D>();		
	}
	
	
 // find if the intersection fell in with the triangle on the plane	 
	private boolean checkInstructions(Point3D rayPoo, Point3D p0) {
		Vector P_P0 = new Vector(p0, rayPoo);
		Vector vProjector[] = new Vector[3];
		vProjector[0] = projector(_p1, _p2, p0);
		vProjector[1] = projector(_p2, _p3, p0);
		vProjector[2] = projector(_p3, _p1, p0);
		double[] sign = new double[3];
		for (int i = 0; i < vProjector.length; i++) {
			vProjector[i].normalize();
			sign[i] = P_P0.dotProduct(vProjector[i]);	
		}
	//	if all the dot product between the vector P_P0 and the normal of every triangle we make
	//	have the same sign - we will add this point of the triangle to the list of the instructions.
		if ((sign[0] > 0 && sign[1] > 0 && sign[2] > 0)
			|| (sign[0] <= 0 && sign[1] <= 0 && sign[2] <= 0)){
			return true;
		}
		return false;
		
	}
	// calculate if the projector of the triangle 
	private Vector projector(Point3D vertex1, Point3D vertex2, Point3D p0) {
		Vector v1 = new Vector(vertex1,p0);
		Vector v2 = new Vector(vertex2,p0);
		return v2.crossProduct(v1);
	}
}
