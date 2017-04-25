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
		_vRight = new Vector(1.0,0.0,0.0);
		_vUp = new Vector(0.0,1.0,0.0);
		_vTo = new Vector(0.0,0.0,-1.0);
	
		
	}
	public Camera (Camera camera){
		this(camera._P0,camera._vUp,camera._vTo);
	}
	public Camera (Point3D P0, Vector vUp, Vector vTo){
		_P0 = new Point3D(P0);
		_vUp = new Vector(vUp);
		_vTo = new Vector(vTo);
		_vRight = vUp.crossProduct(vTo);
		_vRight.normalize();
		_vTo.normalize();
		_vUp.normalize();
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
	@Override
	public String toString(){
		return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + "."; 
	}
	// ***************** Operations ******************** //
	/*public Ray constructRayThroughPixel (int Nx, int Ny,
	 double x, double y,
	 double screenDist,
	 double screenWidth,
	 double screenHeight){
		double Rx = screenWidth/Nx;
		double Ry = screenHeight/Ny;
		double Xscalar = CalculationOfScalar(x,Nx,Rx);
		double Yscalar = CalculationOfScalar(y,Ny,Ry);
		//Vector Pc= new Vector(0,0,-screenDist );
		Vector V = new Vector(Xscalar,-Yscalar,-screenDist);
		//V.normalize();
		//Point3D point = new Point3D();
		return new Ray(pcCalc(screenDist),V);
//		Vector Vright= new Vector(1,0,0 );
//		Vector Pup= new Vector(0,1,0 );
//		Vright.scale(CalculationOfScalar(x,Nx,Rx));
//		Pup.scale(CalculationOfScalar(y,Ny,Ry));
		
	}
	private double CalculationOfScalar(double Point,int Pixels,double R){
		return ( ((Point - (Pixels/2.0)) * R) + R/2.0 );
	}
	private Point3D pcCalc(double sDist){
		//Vector vTo = new Vector(_vTo);
		//Point3D p0 = new Point3D(_P0);
		//vTo.scale(sDist);
		//p0.add(vTo);
		Vector vTo = new Vector(0,0,-sDist);
		Point3D p0 = new Point3D(_P0);
		p0.add(vTo);
		return new Point3D(p0);
	}*/
	
	
	public Ray constructRayThroughPixel (int Nx, int Ny,
			 double x, double y,
			 double screenDist,
			 double screenWidth,
			 double screenHeight){
			// TODO
				Point3D Pc = pcCalc(screenDist);
				Vector vX = pixelCalc(Nx, x, screenWidth, _vRight);
				Vector vY = pixelCalc(Ny, y, screenHeight, _vUp);
				vX.subtract(vY);
				Pc.add(vX);
				Vector vector = new Vector(Pc);
				return new Ray(vector.getHead(), vector);
				
			}
			private Vector pixelCalc(int N, double ePoint, double sLengh, Vector vec) {
				Vector vector = new Vector(vec);
				ePoint -= N/2.0;
				double R = sLengh / N;
				R = (R * ePoint) + (R / 2.0);
				vector.scale(R);
				return new Vector(vector);
			}
			private Point3D pcCalc(double screenDist) {
				Point3D p0 = new Point3D(_P0);
				Vector vTo = new Vector(_vTo); 
				vTo.scale(screenDist);
				p0.add(vTo);
				return new Point3D(p0);
			}
}
