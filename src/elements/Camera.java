package elements;
import primitives.*;

public class Camera {
	 //Eye point of the camera
	private Point3D _P0;
	private Vector _vUp;
	private Vector _vTo;
	 //Should be calculated as the cross product if vUp and vTo
	private Vector _vRight;
	// ***************** Constructors ********************** //
	public Camera(){
		_P0 = new Point3D(); 
		_vUp = new Vector();
		_vTo = new Vector();
	}
	public Camera (Camera camera){
		this(camera._P0,camera._vUp,camera._vTo);
	}
	public Camera (Point3D P0, Vector vUp, Vector vTo){
		_P0 = new Point3D(P0);
		_vUp = new Vector(vUp);
		_vTo = new Vector(vTo);
		_vRight = new Vector(vUp.crossProduct(vTo));
	}
//	public Camera (Map<String, String> attributes(;

	// ***************** Getters/Setters ********************** //
	public Vector get_vUp(){
		return _vUp;
	}
	public void  set_vUp(Vector vUp){
		_vUp.setHead(vUp.getHead());
	}
	public Vector get_vTo(){
		return _vTo;
	}
	public void set_vTo(Vector vTo){
		_vTo.setHead(vTo.getHead());
	}
	public Point3D getP0(){
		return _P0;
	}
	public void setP0(Point3D P0){
		_P0.setPoint(P0);
	}
	public Vector get_vRight(){
		return _vRight;
	}
	// ***************** Administration ********************** //
	public String toString(){
		return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + "."; 
	}
	// ***************** Operations ******************** //
	public Ray constructRayThroughPixel (int Nx, int Ny,
	 double x, double y,
	 double screenDist,
	 double screenWidth,
	 double screenHeight){
		
	}

}