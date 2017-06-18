package renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import elements.LightSource;
//import elements.LightSource;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class Render	{
	private Scene _scene;
	private ImageWriter _imageWriter;
	private final int RECURSION_LEVEL = 3;
	private final double EPS = 0.0001;
	
	// ***************** Constructors ********************** //
	/**
	 * this contractor take all the parameters of a scene and make a picture. 
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
	/**
	 * Finding a collection of cut points If there is no cut point it will be colored in the appropriate color 
	 * if a function is sent to the next point
	 */
	public void renderImage1(){
		List<Point3D> intersectionPoints =	new ArrayList<Point3D>();
		for (int i = 0; i < _imageWriter.getNx(); i++) {
			for (int j = 0; j < _imageWriter.getNy(); j++) {
				Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(),
				_imageWriter.getNy(), j, i,_scene.getScreenDistance(), _imageWriter.getWidth(), 
				_imageWriter.getHeight());
				intersectionPoints = getSceneRayIntersections1(ray);
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
	
	private List<Point3D> getSceneRayIntersections1(Ray ray){
		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		List<Point3D> intersectionPoints = new ArrayList<Point3D>();
		while (geometries.hasNext()) {
			Geometry geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
			intersectionPoints.addAll(geometryIntersectionPoints);
		}
		return intersectionPoints;
	}
	
//	private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray);
	
	public void printGrid(int interval){
		for (int i = 0; i < _imageWriter.getNx()/interval; i++) {
			for (int j = 0; j < _imageWriter.getNy(); j++) {
				_imageWriter.writePixel(j, i * interval, 255, 255, 255);
				_imageWriter.writePixel(i * interval, j, 255, 255, 255);
			}
		}	
	}
	public void writeToImage(){
		_imageWriter.writeToimage();
	}
	
	/*Finds from a list of the closest cutting points.
	  private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,
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
	
	/**
	 * A function that checks a point with the importance of which geometry is involved because the emission.
	 * For this purpose users are used Map 
	 */
	
	public void renderImage(){
		Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
		for (int i = 0; i < _imageWriter.getNx(); i++) {
			for (int j = 0; j < _imageWriter.getNy(); j++) {
				Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(),
				_imageWriter.getNy(), j, i,_scene.getScreenDistance(), _imageWriter.getWidth(), 
				_imageWriter.getHeight());
				intersectionPoints = getSceneRayIntersections(ray);
				if (intersectionPoints.isEmpty()) {
					_imageWriter.writePixel(j, i, _scene.getBackground());
				}
				else{
					Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
					Entry<Geometry, Point3D> clos;
					Iterator<Entry<Geometry, Point3D>> iterator = closestPoint.entrySet().iterator();
					clos = iterator.next();
					_imageWriter.writePixel(j, i, 
						calcColor3(clos.getKey(), //////
								clos.getValue()));
				}
					
			}
		}
	}
	
	private Color calcColor1(Geometry geometry, Point3D point){
		Color ambientLight = _scene.getAmbientLight().getIntensity();
		Color emissionLight = geometry.getEmmission();
		int r = Math.min((ambientLight.getRed() + emissionLight.getRed()),255);
		int g = Math.min((ambientLight.getGreen() + emissionLight.getGreen()),255);
		int b = Math.min((ambientLight.getBlue() + emissionLight.getBlue()),255);
		Color I0 = new Color (r,g,b);
		return I0;
	}
	/**
	 * 
	 * @param ray =  to examine whether it is in intersection with one of the geometries
	 * @return Map<Geometry, List<Point3D>>
	 */
	private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray){
		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
		while (geometries.hasNext()) {
			Geometry geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
			if (geometryIntersectionPoints.size() > 0) 				
				intersectionPoints.put(geometry, geometryIntersectionPoints);
		}
		return intersectionPoints;
	}
	/**
	 * 
	 * @param intersectionPoints = Collects all points that the ray hits geometrically
	 * @return The nearest point
	 */
	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,
			List<Point3D>> intersectionPoints){
		double distance = Double.MAX_VALUE;
		Point3D P0 = _scene.getCamera().getP0();
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet()){
			for (Point3D point: entry.getValue()){
				if (P0.distance(point) < distance)	{
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.distance(point);
				}
			}
		}		
		return minDistancePoint;
	}
	
	private Color calcColor2(Geometry geometry, Point3D point){
		Color emissionLight = geometry.getEmmission();
		Color ambientLight = _scene.getAmbientLight().getIntensity();
		Color diffuseLight = new Color(0, 0, 0);
		Color specularLight = new Color(0, 0, 0);
		Iterator<LightSource> lights = _scene.getLightsIterator();
		while (lights.hasNext()){
			LightSource light = lights.next();
			diffuseLight = addColors(diffuseLight, 
					calcDiffusiveComp(geometry.getMaterial().getKd(), geometry.getNormal(point),
												light.getL(point), light.getIntensity(point)));
		
			specularLight = addColors(specularLight, calcSpecularComp(geometry.getMaterial().getKs(),
				new Vector(point, _scene.getCamera().getP0()),	geometry.getNormal(point),
					light.getL(point), geometry.getShininess(),	light.getIntensity(point)));
		}
		
		return addColors(addColors(ambientLight, emissionLight), 
						 addColors(diffuseLight, specularLight)); 
	}
	
	/**
	 * 
	 * @param geometry = Type of geometry
	 * @param point = Clash point
	 * @return Color calculated by emission+ambientLight+diffuseLight+specularLight
	 * 
	 * The function check whether there is a barrier between lighting and geometry
	 */
	private Color calcColor3(Geometry geometry, Point3D point){
		Color emissionLight = geometry.getEmmission();
		Color ambientLight = _scene.getAmbientLight().getIntensity();
		Color diffuseLight = new Color(0, 0, 0);
		Color specularLight = new Color(0, 0, 0);
		Iterator<LightSource> lights = _scene.getLightsIterator();
		while (lights.hasNext()){
			LightSource light = lights.next();
			
			//Check whether there is a barrier between lighting and geometry
			if (!occluded(light, point, geometry)) {
				diffuseLight = addColors(diffuseLight, 
						calcDiffusiveComp(geometry.getMaterial().getKd(), geometry.getNormal(point),
													light.getL(point), light.getIntensity(point)));
			
				specularLight = addColors(specularLight, calcSpecularComp(geometry.getMaterial().getKs(),
					new Vector(point, _scene.getCamera().getP0()),	geometry.getNormal(point),
						light.getL(point), geometry.getShininess(),	light.getIntensity(point)));
			}
		}
		
		return addColors(addColors(ambientLight, emissionLight), 
						 addColors(diffuseLight, specularLight)); 
	}
	
	private Color calcColor(Geometry geometry, Point3D point, Ray ray){
		return calcColor(geometry, point, ray, 0);
	}
	
	private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level){ 
		
		if (level == RECURSION_LEVEL) 
			return new Color(0, 0, 0);
		Color emissionLight = geometry.getEmmission();
		Color ambientLight = _scene.getAmbientLight().getIntensity();
		Color diffuseLight = new Color(0, 0, 0);
		Color specularLight = new Color(0, 0, 0);
		Iterator<LightSource> lights = _scene.getLightsIterator();
		while (lights.hasNext()){
			LightSource light = lights.next();
			if (!occluded(light, point, geometry)) {
				
				diffuseLight = addColors(diffuseLight, 
						calcDiffusiveComp(geometry.getMaterial().getKd(), geometry.getNormal(point),
													light.getL(point), light.getIntensity(point)));			
				specularLight = addColors(specularLight, calcSpecularComp(geometry.getMaterial().getKs(),
					new Vector(point, _scene.getCamera().getP0()),	geometry.getNormal(point),
						light.getL(point), geometry.getShininess(),	light.getIntensity(point)));
			}
		}
		
		// Recursive call for a reflected ray
		Vector vector = geometry.getNormal(point);
		Ray reflectedRay = constructReflectedRay(vector, point, inRay);
		Map<Geometry, Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
		Color reflectedColor = new Color(0, 0, 0);
		Color reflectedLight = new Color(0, 0, 0);
		if (!reflectedEntry.isEmpty()) {
			
			reflectedColor = calcColor(reflectedEntry.entrySet().iterator().next().getKey(), 
											reflectedEntry.entrySet().iterator().next().getValue(), 
											reflectedRay, level + 1);
			reflectedLight = multColor(reflectedColor, geometry.getMaterial().getKr());
		}
		
		// Recursive call for a refracted ray
		Ray refractedRay = constructRefractedRay(geometry, point, inRay);
		Map<Geometry, Point3D> refractedEntry = findClosesntIntersection(refractedRay);
		Color refractedColor = new Color(0, 0, 0);
		Color refractedLight = new Color(0, 0, 0);
		if (!refractedEntry.isEmpty()) {
			refractedColor = calcColor(refractedEntry.entrySet().iterator().next().getKey(), 
										refractedEntry.entrySet().iterator().next().getValue(), 
										refractedRay, level + 1);
			refractedLight = multColor(refractedColor, geometry.getMaterial().getKt());		
		}
		
		
		return addColors( addColors(addColors(ambientLight, emissionLight), 
				 addColors(diffuseLight, specularLight)), 
				addColors(reflectedLight, refractedLight)); 
	}
	
	private Ray constructReflectedRay(Vector normal, Point3D point,	Ray inRay){
		//TODO
		Vector R = inRay.getDirection(); // already normalize
		
		double scal = 2 * Math.abs(R.dotProduct(normal));
		Vector N = new Vector(normal);
		N.normalize();
		N.scale(scal);
		R.subtract(N);
		Vector epsV = new Vector(EPS, EPS, EPS);
		Point3D eps = new Point3D(point);
		eps.add(epsV);
		
		return new Ray(eps, R);
		
		/*
		N.setHead(normal.getHead());
		N.scale(2);
		Point3D geometryPoint = new Point3D(point);
		geometryPoint.add(N);
		return new Ray(geometryPoint, R);
		 */
	}
	
	private Ray constructRefractedRay(Geometry geometry, Point3D point,	Ray inRay){
		//TODO
		double n1 = 1;
		double n2 = 1;
		double n = n1/n2;
		Vector N = geometry.getNormal(point);
		double cosOi = N.dotProduct(inRay.getDirection());
		//double cosOr = 
		Point3D pointEps = new Point3D(point);
		N.scale(-2);
		Vector epsVec = inRay.getDirection();
		epsVec.scale(EPS);
		pointEps.add(N);
		Vector temp = new Vector(EPS, EPS, EPS);
		//pointEps.add(temp);
		return new Ray(pointEps, inRay.getDirection());
	}
	
	private Map<Geometry, Point3D> findClosesntIntersection(Ray ray){
		Map<Geometry, List<Point3D>> intersections = getSceneRayIntersections(ray);
		double distance = Double.MAX_VALUE;
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, List<Point3D>> entry: intersections.entrySet()){
			for (Point3D point: entry.getValue()){
				if (ray.getPOO().distance(point) < distance)	{
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = ray.getPOO().distance(point);
				}
			}
		}
		return minDistancePoint;
	}
	/**
	 * 
	 * @param light = Type of LightSource
	 * @param geometry = Type of geometry
	 * @param point = Clash point
	 * @return  true if the point is hidden from light source and false if not
	 */
	private boolean occluded(LightSource light, Point3D point, Geometry geometry) {
		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);
		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(2);
		geometryPoint.add(epsVector);//because floting point
		Ray lightRay = new Ray(geometryPoint, lightDirection);//ray direction the light
		Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
		
		// Flat geometry cannot self intersect
		if (geometry instanceof FlatGeometry){
			intersectionPoints.remove(geometry);
		}
		
		/*for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())
			if (entry.getKey().getMaterial().getKt() == 0)
				return true;
		return false;*/
		
		return !intersectionPoints.isEmpty();
	}
	//kd*(n*l)Il
	private Color calcDiffusiveComp(double kd, Vector normal, Vector l,	Color lightIntensity){
		l.normalize();
		normal.normalize();
		double dot = normal.dotProduct(l);
		/*if (dot > 0) {
			return new Color(0, 0, 0);
		}*/
		dot = kd * (Math.abs(dot));
		return multColor(lightIntensity, dot);
	}
	
	//ks*(v*r)^n*Il
	private Color calcSpecularComp(double ks, Vector v, Vector normal,
			Vector l, double shininess, Color lightIntensity){
		l.normalize();
		normal.normalize();
		double scal = 2 * l.dotProduct(normal);
		normal.scale(scal);
		Vector R = new Vector(l);//R = Vector reflection of light
		R.subtract(normal);
		R.normalize();

		v.normalize();
		double rgb = v.dotProduct(R);
		if (rgb > 0) {
			return new Color(0, 0, 0);
		}
		rgb = Math.abs(rgb);
		rgb = Math.pow(rgb, shininess);
		rgb *= ks;
		
		return multColor(lightIntensity, rgb);
		
	}
	//Connecting two color dots
	private Color addColors(Color c1, Color c2){
		int r = Math.min((c1.getRed() + c2.getRed()),255);
	    int g = Math.min((c1.getGreen() + c2.getGreen()),255);
	    int b = Math.min((c1.getBlue() + c2.getBlue()),255);

	    return new Color(r,g,b);
	}
	
	private Color multColor(Color lightIntensity, double rgb){
		int r = Math.min((int)(rgb * lightIntensity.getRed()),255 );
		int g = Math.min((int)(rgb * lightIntensity.getGreen()),255 );
		int b = Math.min((int)(rgb * lightIntensity.getBlue() ),255);
		return new Color(r, g, b);
	}
}