package scene;

import primitives.*;
import geometries.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import elements.AmbientLight;
import elements.Camera;
//import elements.LightSource;
//import geometries.Geometry;
public class Scene
{
	private Color _background;
	private AmbientLight _ambientLight;
	private List<Geometry> _geometries = new ArrayList<Geometry>();
	private Camera _camera;
	private double _screenDistance;
//	private List<LightSource> _lights = new ArrayList<LightSource>();
	private String _sceneName = "scene";
	// ***************** Constructors ********************** //
	public Scene(){
		
	}
	public Scene (Scene scene){
		
	}
	public Scene(AmbientLight aLight, Color background,
			Camera camera, double screenDistance){
		
	}
	//***************** Getters/Setters ********************** //
	public Color getBackground(){
		return _background;
	}
	public AmbientLight getAmbientLight(){
		return _ambientLight;
	}
	public Camera getCamera(){
		return _camera;
	}
	public String getSceneName(){
		return _sceneName;
	}
	public double getScreenDistance(){
		return _screenDistance;
	}
	public void setBackground(Color background){
		_background = background; ///////////////// 
	}
	public void setAmbientLight(AmbientLight ambientLight){
		_ambientLight = new AmbientLight(ambientLight);
	}
	public void setCamera(Camera camera){
		_camera = new Camera(camera);
	}
	public void setSceneName(String sceneNAme){
		_sceneName = sceneNAme;
	}
	public void setScreenDistance(double screenDistance){
		_screenDistance = screenDistance;
	}
	//***************** Operations ******************** //
	public void addGeometry(Geometry geometry){
		_geometries.add(geometry);
	}
	public Iterator<Geometry> getGeometriesIterator(){
		return _geometries.iterator();
	}
//	public void addLight(LightSource light);
//	public Iterator<LightSource> getLightsIterator();
}
