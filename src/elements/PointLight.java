package elements;

import primitives.*;
import java.awt.Color;

public class PointLight extends Light implements LightSource{
	Point3D _position;
	double _Kc, _Kl, _Kq;
	// ***************** Constructors ********************** //
	public PointLight(Color color, Point3D position,
	double kc, double kl, double kq){
		super(color);
		_position = new Point3D(position);
		_Kc = kc;
		_Kl = kl;
		_Kq = kq;
	}
	// ***************** Getters/Setters ********************** //
	@Override
	public Color getIntensity(Point3D point)
	{
		return super.getIntensity();
	}
	public Vector getL(Point3D point){
		
		return null;
	}
}