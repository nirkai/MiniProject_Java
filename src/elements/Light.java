package elements;

import java.awt.Color;

public abstract class Light {
	protected Color _color;
	// ***************** Constructors ********************** //
	public Light(){
		_color = new Color(255,255,255); 	/////////
	}
	public Light (Color color){
		
		_color = new Color(color.getRed(),color.getGreen(),color.getBlue());
	}
	// ***************** Getters/Setters ********************** //
	public Color getIntensity(){
		int r = _color.getRed();
		int g = _color.getGreen();
		int b = _color.getBlue();
		return new Color(r,g,b);
	}
}
