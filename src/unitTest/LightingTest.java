package unitTest;

import java.awt.Color;

import org.junit.Test;

import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class LightingTest {

	@Test
	public void spotLightTest2(){

		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);

		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
				new Point3D(-225, -110, -260),
				new Point3D(-210, -225, -270));

		triangle.setEmmission(new Color (0, 0, 100));
		triangle.setShininess(4);
		scene.addGeometry(triangle);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		/*scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				new Vector(2, 2, -3), 0.001, 0.000001, 0.000005));*/

		ImageWriter imageWriter = new ImageWriter("Spot lighting test 2.1", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}


	@Test
	public void spotLightTest(){

		Scene scene = new Scene();
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
				new Vector(2, 2, -3), 0, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("Spot lighting test 1", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}


	@Test
	public void pointLightTest(){

		Scene scene = new Scene();
		Sphere sphere = new Sphere (800, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
				0.0002, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("Point lighting test 1", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();


	}

	@Test
	public void spotLightTest3(){

		Scene scene = new Scene();

		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500,  3500, -1000),
				new Point3D( -3500, -3500, -1000));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Spot lighting test 3.1", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}

	@Test
	public void pointLightTest2(){

		Scene scene = new Scene();
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));

		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500,  3500, -1000),
				new Point3D( -3500, -3500, -1000));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Point lighting test 2.1", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}

	@Test
	public void shadowTest(){

		Scene scene = new Scene();
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));

		scene.addGeometry(sphere);

		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500,  3500, -1000),
				new Point3D( -3500, -3500, -1000));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("shadow lighting test1", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}


	@Test
	public void pointLightTest3(){

		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);

		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
				new Point3D(-225, -125, -260),
				new Point3D(-225, -225, -270));

		triangle.setEmmission(new Color (0, 0, 100));
		triangle.setShininess(1);
		scene.addGeometry(triangle);

		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				 0.1, 0.00001, 0.000005));
		/*scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				new Vector(2, 2, -3), 0.001, 0.000001, 0.000005));*/

		ImageWriter imageWriter = new ImageWriter("shadow point lighting test 3", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}

}
