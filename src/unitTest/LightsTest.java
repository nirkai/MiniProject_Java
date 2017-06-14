package unitTest;
import primitives.*;
import geometries.*;
import elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;

import renderer.*;



public class LightsTest {

	@Test
	public void test() {
		Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		ImageWriter imageWriter = new ImageWriter("PointLightTest4", 500, 500, 500, 500);
		
		
		Triangle triangle1 = new Triangle(new Point3D(401, -400,-150), 
				new Point3D(-399,-400,-150), new Point3D(401, 400,-200));
		Triangle triangle2 = new Triangle(new Point3D(-401, -400, -150), 
				new Point3D(399,400,-200), new Point3D(-401, 400, -200));
		
		Sphere sphere = new Sphere(40, new Point3D(-60, 160, -80));
		
		
		triangle1.setEmmission(new Color(0,0,0));
		triangle2.setEmmission(new Color(0,0,0));
		triangle1.setShininess(1);
		triangle2.setShininess(1);

		triangle1.setEmmission(new Color(0, 0, 0));
		triangle2.setEmmission(new Color(0, 0, 0));
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);

		DirectionalLight directionalLight = new DirectionalLight(new Color(250, 50, 50), new Vector(0, 0, -1));
		PointLight pointLight = new PointLight(new Color(255, 50, 50), new Point3D(0, 0,-50), 0.0000056, 0.0000056, 0.000032);
		SpotLight spotLight = new SpotLight(new Color(255, 50, 50), new Point3D(0, 0,-50), new Vector(0, 0, -1), 0.0000056, 0.0000056, 0.000032);
		scene.addLight(pointLight);
		//scene.addLight(spotLight);
		//scene.addLight(directionalLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();
		
		scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		imageWriter = new ImageWriter("Point Light Test4", 500, 500, 500, 500);
		Sphere sph1 = new Sphere(900, new Point3D(0,0,-1300));
		sph1.setShininess(35);
		sph1.setEmmission(new Color(17,15,116));
		pointLight = new PointLight(new Color(255,50,50), new Point3D(220,200,-20), 0.000008, 0.000008, 0.000002);
		scene.addGeometry(sph1);
		scene.addLight(pointLight);
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();
	}

}
