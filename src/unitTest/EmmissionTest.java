package unitTest;
import primitives.*;
import geometries.*;
import elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;

import renderer.*;


public class EmmissionTest {

	Scene scene;
	ImageWriter imageWriter;
	Triangle triangle;
	Triangle triangle1;
	Triangle triangle2;
	Triangle triangle3;
	Triangle triangle4;
	Sphere sphere;
	Sphere sph1;
	PointLight pointLight;
	SpotLight spotLight;
	Render render;
	
	
	@Test 
	public void emmissionTest(){

		Scene scene = new Scene();
		scene.setScreenDistance(48);
		scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));

		Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
				new Point3D(  0, 100, -49),
				new Point3D( 100, 100, -49));

		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
				new Point3D(  0, -100, -49),
				new Point3D( 100,-100, -49));
		triangle2.setEmmission(new Color (50, 200, 50));

		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
				new Point3D(  0, 100, -49),
				new Point3D(-100, 100, -49));
		triangle3.setEmmission(new Color (50, 50, 200));

		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
				new Point3D(  0,  -100, -49),
				new Point3D(-100, -100, -49));
		triangle4.setEmmission(new Color (200, 50, 50));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

		ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50);
		render.writeToImage();
	}



}
