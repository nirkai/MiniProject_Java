package elements;

import primitives.*;
import java.awt.Color;

public class SpotLight extends PointLight {
	private Vector _direction;
	// ***************** Constructor ********************** //
	public SpotLight(Color color, Point3D position, Vector direction,
	double kc, double kl, double kq){
		super(color, position, kc, kl, kq);
		_direction = new Vector(direction);
	}
	// ***************** Getters/Setters ********************** //
	@Override
	public Color getIntensity(Point3D point){
		// TODO
		Vector dVector = new Vector(_direction);
		double d = dVector.length();
		Vector lVector = new Vector(point, _position);
		dVector.normalize();
		lVector.normalize();
		double dot = dVector.dotProduct(lVector);
		float I = (float)(dot * _color.getRGB());
		I /= (_Kc * d * _Kl * Math.pow(d, 2) * _Kq);
		
		float r = _color.getRed() * I / 255;
		float g = _color.getGreen() * I / 255;
		float b = _color.getBlue() * I / 255;
		
		return new Color(r, g, b);

	}
}
