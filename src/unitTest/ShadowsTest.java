package unitTest;

import primitives.*;
import geometries.*;
import elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;

import renderer.*;


//import static org.junit.Assert.*;

//import org.junit.Test;

public class ShadowsTest {

	@Test
	public void test() {
		Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		ImageWriter imageWriter = new ImageWriter("spotLightShadowsTest1", 500, 500, 500, 500);
		/*Sphere sph = new Sphere(900, new Point3D(0,0,-1300));
		sph.setKd(1); sph.setKs(1); sph.setKr(0); sph.setKt(0);
		sph.setShininess(35);
		sph.setEmmission(new Color(17,15,116));
		Triangle tri = new Triangle(new Point3D(200, 200,-300), new Point3D(0,200,-300), new Point3D(100, 400,-300));
		tri.setEmmission(new Color(30,144,255));
		tri.setShininess(1);
		tri.setKd(0.2); tri.setKs(0.2);


		Triangle tri5 = new Triangle(new Point3D(-400, 2000,-1100), new Point3D(200,-100,-1200), new Point3D(-500,-700,-900));

		tri5.setShininess(10);
		tri5.setEmmission(new Color(30,144,255));
		DirectionalLight directionalLight = new DirectionalLight(new Color(250, 50, 50), new Vector(-1, -1, -1));
		PointLight pointLight = new PointLight(new Color(255,50,50), new Point3D(-50,50,-10), 0.0000056, 0.0000056, 0.000032);
		SpotLight spotLight = new SpotLight(new Color(255,50,50), new Point3D(200,200,-20), new Vector(-200 ,-200 ,-1280), 0.0000056, 0.0000056, 0.000032);
		scene.addGeometry(sph);
		scene.addGeometry(tri);
		//scene.addGeometry(tri5);
		scene.addLight(pointLight);
		//scene.addLight(directionalLight);
		//scene.addLight(spotLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		//render.printGrid(50);
		render.writeToImage();
		 */


		/*scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 250);
		imageWriter = new ImageWriter("Shadow Point Test1", 500, 500, 500, 500);
		Plane plane = new Plane(new Vector(0,0,1), new Point3D(0,0,-520));
		plane.setShininess(200);
		Sphere sph1 = new Sphere(120, new Point3D(0,0,-400));
		PointLight pointLight = new PointLight(new Color(255,50,50), new Point3D(200,-50,-20), 0.0000005, 0.0000005, 0.000006);
		sph1.setShininess(35);
		sph1.setEmmission(new Color(17,15,116));
		scene.addGeometry(plane);
		scene.addGeometry(sph1);
		scene.addLight(pointLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();

		imageWriter = new ImageWriter("PointLightBallsShadowsTest", 500, 500, 500, 500);
		plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -350, -1600));
		Sphere sp2 = new Sphere(30, new Point3D(0,100, -150));
		Sphere sp3 = new Sphere(30, new Point3D(-80,120, -160));
		Sphere sp4 = new Sphere(30, new Point3D(80,110, -160));
		sp2.setShininess(35);
		sp3.setShininess(35);
		sp4.setShininess(35);
		sp2.setEmmission(new Color(17,15,116));
		sp3.setEmmission(new Color(17,15,116));
		sp4.setEmmission(new Color(17,15,116));
		pointLight = new PointLight(new Color(255, 50, 50), new Point3D(0, 500, -155), 0.00000056, 0.00000056, 0.000032);
		SpotLight spotLight = new SpotLight(new Color(255, 250, 50), new Point3D(0, 300, 0), new Vector(0,-1, -1), 0.00000056, 0.00000056, 0.000032);
		Scene scene1 = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		scene1.addGeometry(plane);
		scene1.addGeometry(sp2);
		scene1.addGeometry(sp3);
		scene1.addGeometry(sp4);
		scene1.addLight(pointLight);
		scene1.addLight(spotLight);*/

		scene = new Scene();
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));

		scene.addGeometry(sphere);

		Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500,  3500, -1000),
				new Point3D( -3500, -3500, -1000));

		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


		imageWriter = new ImageWriter("Shadow test New", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		//render = new Render(imageWriter, scene1);
		render.renderImage();
		render.writeToImage();
	}

}
