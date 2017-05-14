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
	public Color getIntensity(Point3D point){
		// TODO
		double d = _position.distance(point);
		//_direction.dotProduct(_direction)
		return null;
	}
}
