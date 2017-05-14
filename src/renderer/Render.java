package renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


//import elements.LightSource;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;
import sun.security.krb5.internal.ReplayCache;
public class Render	{
	private Scene _scene;
	private ImageWriter _imageWriter;
	private final int RECURSION_LEVEL = 3;
	
	// ***************** Constructors ********************** //
	/**
	 * this contractor 
	 * @param imageWriter
	 * @param scene
	 */
	public Render(ImageWriter imageWriter, Scene scene){
		_imageWriter = new ImageWriter(imageWriter);
		_scene = new Scene(scene);
	}
	
	public Render(Render render){
		this(render._imageWriter, render._scene);
	}
	
	// ***************** Operations ******************** //
	
	public void renderImage(){
		//TODO
		List<Point3D> intersectionPoints =	new ArrayList<Point3D>();
		for (int i = 0; i < _imageWriter.getHeight(); i++) {
			for (int j = 0; j < _imageWriter.getWidth(); j++) {
				Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(),
				_imageWriter.getNy(), j, i,_scene.getScreenDistance(), _imageWriter.getWidth(), 
				_imageWriter.getHeight());
				intersectionPoints = getSceneRayIntersections(ray);
				if (intersectionPoints.isEmpty()) {
					_imageWriter.writePixel(j, i, _scene.getBackground());
				}
				else{
					Point3D closestPoint = getClosestPoint(intersectionPoints);
					_imageWriter.writePixel(j, i, calcColor(closestPoint));
				}
					
			}
		}
		

	}
//	private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray);
	
	public void printGrid(int interval){
		//TODO
		for (int i = 0; i < _imageWriter.getWidth()/interval; i++) {
			for (int j = 0; j < _imageWriter.getHeight()/interval; j++) {
				_imageWriter.writePixel(interval*i + i/interval
						, interval*j + i/interval
						, 255, 255, 255);
			}
		}
		
	}
	public void writeToImage(){
		//TODO
		_imageWriter.writeToimage();
	}
	
	/* private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,
			List<Point3D>> intersectionPoints);	 */
	private Point3D getClosestPoint(List<Point3D> intersectionPoints) {
		double distance = Double.MAX_VALUE;
		Point3D P0 = _scene.getCamera().getP0();
		Point3D minDistancePoint = null;
		for (Point3D point: intersectionPoints){
			if (P0.distance(point) < distance) {
				minDistancePoint = new Point3D(point);
				distance = P0.distance(point);
			}
		}
		return minDistancePoint;
	}
	
	private Color calcColor(Point3D point) {
		return _scene.getAmbientLight().getIntensity();
	}
	/*
	private Color calcColor(Geometry geometry, Point3D point, Ray ray);
	private Color calcColor(Geometry geometry, Point3D point,
			Ray inRay, int level); // Recursive
	private Ray constructRefractedRay(Geometry geometry, Point3D point,
			Ray inRay);
	private Ray constructReflectedRay(Vector normal, Point3D point,
			Ray inRay);
	private boolean occluded(LightSource light, Point3D point,
			Geometry geometry);
	private Color calcSpecularComp(double ks, Vector v, Vector normal,
			Vector l, double shininess, Color lightIntensity);
	private Color calcDiffusiveComp(double kd, Vector normal, Vector l,
			Color lightIntensity);
	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,
			List<Point3D>> intersectionPoints);
	private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray);
	private Color addColors(Color a, Color b);
	*/
	
	private List<Point3D> getSceneRayIntersections(Ray ray){
		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		List<Point3D> intersectionPoints = new ArrayList<Point3D>();
		while (geometries.hasNext()) {
			Geometry geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
			//intersectionPoints.add(geometryIntersectionPoints.get(0));
			intersectionPoints.addAll(geometryIntersectionPoints);
		}
		return intersectionPoints;
	}
}