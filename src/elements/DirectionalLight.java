package elements;

import primitives.*;
import java.awt.Color;

public class DirectionalLight extends Light	{

	private Vector _direction;
	// ***************** Constructors ********************** //
	public DirectionalLight(Color color, Vector direction){
		super(color);
		_direction = new Vector(direction);
	}
	// ***************** Getters/Setters ********************** //
	public Color getIntensity(Point3D point){
		// TODO
		return super.getIntensity();
	}
	public Vector getDirection() {
		return new Vector(_direction);
	}
	public void setDirection(Vector direction){
		_direction.setHead(direction.getHead());
	}
	public Vector getL(Point3D point){
		return new Vector(point);
	}
}
