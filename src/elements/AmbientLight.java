package elements;
import java.awt.Color;
import java.util.Map;

public class AmbientLight extends Light	{
	
	private final double _Ka = 0.1;
	
	// ***************** Constructors ********************** //
	public AmbientLight(){
		//_color = new Color(0); 	/////////
		super();
	}
	public AmbientLight(AmbientLight aLight){
		super(aLight._color);
	}
	public AmbientLight(int r, int g, int b){
		_color = new Color(r, g, b);
	}
	public AmbientLight(Map<String, String> attributes){
		// TODO
	}
	// ***************** Getters/Setters ********************** //
	public Color getColor(){
		//TODO
		int r = _color.getRed();
		int g = _color.getGreen();
		int b = _color.getBlue();
		return new Color(r,g,b);
	}
	public void setColor(Color color){
		_color = new Color(color.getRed(),color.getGreen(),color.getBlue());
	}
	public double getKa(){
		return _Ka;
	}
	@Override
	public Color getIntensity(){
		int r = Math.min((int)(_Ka * _color.getRed()),255 );
		int g = Math.min((int)(_Ka * _color.getGreen()),255 );
		int b = Math.min((int)(_Ka * _color.getBlue() ),255);
		return new Color(r,g,b);
	}

}
