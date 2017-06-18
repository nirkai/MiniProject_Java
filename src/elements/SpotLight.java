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
	//Il=I0(D*L)/(Kc+Kj*D+KqD^2)
	@Override
	public Color getIntensity(Point3D point){
		Vector dVector = new Vector(_direction);
		Vector lVector = getL(point);//The point of impact on geometry
		double d = point.distance(_position);
		dVector.normalize();
		lVector.normalize();
		double attenuation = Math.abs(dVector.dotProduct(lVector));//dotProduct  between L and D
		if (attenuation < 0) {
			return new Color(0, 0, 0);
		}
		attenuation /= (_Kc + _Kl * d + _Kq * Math.pow(d, 2)); // equal to => Kc * Ki*d * Kq*d^2

		int r = Math.min((int)(_color.getRed() * attenuation), 255);
		int g = Math.min((int)(_color.getGreen() * attenuation), 255);
		int b = Math.min((int)(_color.getBlue() * attenuation), 255);
		return new Color(r, g, b);

	}
}
