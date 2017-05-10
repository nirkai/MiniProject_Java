package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import elements.AmbientLight;
import elements.Camera;
//import elements.LightSource;
import geometries.Geometry;
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
		_screenDistance = 100;
		_camera = new Camera();
		_background = new Color(0, 0, 0);
		_ambientLight = new AmbientLight();
		_geometries = new ArrayList<Geometry>();
	}
	public Scene (Scene scene){
		this(scene._ambientLight, scene._background,
				scene._camera, scene._screenDistance);
	}
	public Scene(AmbientLight aLight, Color background,
			Camera camera, double screenDistance){
		_ambientLight = new AmbientLight(aLight);
		_background = new Color(background.getRGB());
		_camera = new Camera(camera);
		_screenDistance = screenDistance;
		_geometries = new ArrayList<Geometry>();
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
