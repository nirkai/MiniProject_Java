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

		Vector dVector = new Vector(_direction);
		Vector lVector = getL(point);
		double d = lVector.length();
		dVector.normalize();
		lVector.normalize();
		double dot = Math.abs(dVector.dotProduct(lVector));
		dot /= (_Kc + _Kl * d + _Kq * Math.pow(d, 2)); // equal to => Kc * Ki*d * Kq*d^2

		int r = Math.min((int)(_color.getRed() * dot), 255);
		int g = Math.min((int)(_color.getGreen() * dot), 255);
		int b = Math.min((int)(_color.getBlue() * dot), 255);
		return new Color(r, g, b);

	}
}
