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
		ImageWriter imageWriter = new ImageWriter("DirectionLightShadowsTest", 500, 500, 500, 500);
		Sphere sph = new Sphere(900, new Point3D(0,0,-1300));
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
		PointLight pointLight = new PointLight(new Color(255,50,50), new Point3D(220,200,-20), 0.002, 0.002, 0.001);
		//SpotLight sointLight = new SpotLight(new Color(255,50,50), new Point3D(660,600,-60), new Vector(-1, -1, -1), 0.002, 0.002, 0.001);
		scene.addGeometry(sph);
		//scene.addGeometry(tri);
		//scene.addGeometry(tri5);
		//scene.addLight(pointLight);
		scene.addLight(directionalLight);
		//scene.addLight(pointLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage1();
		//render.printGrid(50);
		render.writeToImage();
	}

}
