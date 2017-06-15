package unitTest;
import primitives.*;
import geometries.*;
import elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;

import renderer.*;


public class EmmissionTest {

	@Test
	public void emmissionSemple() {
		//Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		//ImageWriter imageWriter = new ImageWriter("ReflectionsTest7", 500, 500, 500, 500);
		
		
		/*Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		ImageWriter imageWriter = new ImageWriter("ReflectionsTest7", 500, 500, 500, 500);
		
		
		scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		imageWriter = new ImageWriter("Point Light Test", 500, 500, 500, 500);
		Sphere sph1 = new Sphere(900, new Point3D(0,0,-1300));
		sph1.setShininess(35);
		sph1.setEmmission(new Color(17,15,116));
		PointLight pointLight = new PointLight(new Color(255,50,50), new Point3D(220,200,-20), 0.0008, 0.00008, 0.0002);
		scene.addGeometry(sph1);
		scene.addLight(pointLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();*/
		
		/*scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 250);
		imageWriter = new ImageWriter("Shadow Test", 500, 500, 500, 500);
		Plane plane = new Plane(new Vector(0,0,1), new Point3D(0,0,-520));
		plane.setShininess(200);
		Sphere sph1 = new Sphere(120, new Point3D(0,0,-400));
		PointLight pointLight = new PointLight(new Color(255,50,50), new Point3D(200,-50,-20), 0.000005, 0.000005, 0.000006);
		sph1.setShininess(35);
		sph1.setEmmission(new Color(17,15,116));
		scene.addGeometry(plane);
		scene.addGeometry(sph1);
		scene.addLight(pointLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();*/
		
		/*Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		ImageWriter imageWriter = new ImageWriter("PointSpotLightTest3", 500, 500, 500, 500);
		
		
		Triangle triangle1 = new Triangle(new Point3D(401, -400,-150), 
				new Point3D(-399,-400,-150), new Point3D(401, 400,-200));
		Triangle triangle2 = new Triangle(new Point3D(-401, -400, -150), 
				new Point3D(399,400,-200), new Point3D(-401, 400, -200));
		
		Sphere sphere = new Sphere(40, new Point3D(-60, 160, -80));
		
		
		triangle1.setEmmission(new Color(0,0,0));
		triangle2.setEmmission(new Color(0,0,0));
		triangle1.setShininess(1);
		triangle2.setShininess(1);
		//triangle1.se
		triangle1.setEmmission(new Color(0, 0, 0));
		triangle2.setEmmission(new Color(0, 0, 0));
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addGeometry(sphere);

		DirectionalLight directionalLight = new DirectionalLight(new Color(250, 50, 50), new Vector(0, 0, -1));
		PointLight pointLight = new PointLight(new Color(255, 50, 50), new Point3D(0, 0,0), 0.0000056, 0.0000056, 0.0000032);
		SpotLight spotLight = new SpotLight(new Color(255, 50, 50), new Point3D(0, 0,-50), new Vector(0, 0, -1), 0.0000056, 0.0000056, 0.000032);
		//scene.addLight(pointLight);
		//scene.addLight(spotLight);
		scene.addLight(directionalLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();
		*/
		
		/*Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0, 0, 0), 
						new Camera(), 100);
		ImageWriter imageWriter = new ImageWriter("pointLightTest1", 500, 500, 500, 500);
		Triangle triangle1 = new Triangle(new Point3D(-300,10,-110),
				new Point3D(-200, 200, -140), new Point3D(200, 200, -140));
		Triangle triangle2 = new Triangle( new Point3D(300, 10, -110),
				new Point3D(-300,10,-1100),new Point3D(200, 200, -140));
		triangle1.setEmmission(new Color(0, 0, 0));
		triangle2.setEmmission(new Color(0, 0, 0));
		triangle1.setShininess(100);
		triangle2.setShininess(100);
		PointLight pointLight = new PointLight(new Color(255, 255, 0), new Point3D(0,40,-130), 0.002, 0.002, 0.001);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addLight(pointLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();*/
		
		/*
		Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		ImageWriter imageWriter = new ImageWriter("Spot Light Test", 500, 500, 500, 500);
		Sphere sph1 = new Sphere(900, new Point3D(0,0,-1300));
		sph1.setShininess(35);
		sph1.setEmmission(new Color(17,15,116));
		PointLight pointLight = new PointLight(new Color(255,50,50), new Point3D(220,200,-20), 0.002, 0.002, 0.001);
		SpotLight spotLight = new SpotLight(new Color(255,50,50), new Point3D(0,0,0), new Vector(0,0,-1), 0.000002, 0.000002, 0.000001);
		scene.addGeometry(sph1);
		//scene.addLight(spotLight);
		scene.addLight(pointLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();
		*/
		
		
		
		
		
		
		/*Scene scene1 = new Scene(new AmbientLight(255,255,255), 
    			new Color(0,0,0), 
    			new Camera(), 100);
		 Sphere sphere = new Sphere(900, new Point3D(0.0, 0.0, -3000));
		 sphere.setShininess(200);
		 sphere.setEmmission(new Color(255, 255, 0));
		// sphere.setKt(1);
	        
		 Plane plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -130, 0));
		 plane.setKd(0);
		 plane.setShininess(200);
		 plane.setEmmission(new Color(0, 10, 0));
		 
		 Triangle triangle = new Triangle(new Point3D( 1000, -200, -600),
                 new Point3D(  -100, -200, -1000),
                 new Point3D( 400, 1000, -800));
		 triangle.setKs(0);
		 triangle.setKd(0);
		// triangle.setKr(1);
		 triangle.setShininess(1);
		 triangle.setEmmission(new Color(0, 5, 0));
		 
		 
		 
	    
		
		scene1.addGeometry(sphere);
		scene1.addGeometry(triangle);
		scene1.addGeometry(plane);
	
		
		Color color = new Color(255,255,0);
		Point3D point3d = new Point3D(200,200,-20);
		Vector vector = new Vector(200,-200,-1280);
		
		PointLight pointLight = new PointLight(color, point3d, 0.02, 0.02,0.01);
		
		SpotLight spotLight = new SpotLight(color, point3d, vector, 0.01, 0.01, 0.02);

		DirectionalLight sun = new DirectionalLight(color, vector);
		
		scene1.addLight(sun);
		scene1.addLight(spotLight);
		
		ImageWriter imageWriter1 = new ImageWriter("spotLight Test", 500, 500, 500, 500);

		Render render1 = new Render(imageWriter1, scene1);

		render1.renderImage();
		//render1.printGrid(50);
		render1.writeToImage();
        */
		
		
		/*
		Scene scene = new Scene(new AmbientLight(255,255,255), 
				new Color(0.3f,0.5f,0.74f), 
				new Camera(), 152);

		sphere = new Sphere(50, new Point3D(0.0, 0.0, -50));
		triangle = new Triangle(new Point3D( 150, 0, -50),
				new Point3D(  0, 150, -50),
				new Point3D( 150, 150, -50));

		triangle2 = new Triangle(new Point3D( 150, 0, -50),
				new Point3D(  0, -150, -50),
				new Point3D( 150,-150, -50));

		triangle3 = new Triangle(new Point3D(-150, 0, -50),
				new Point3D(  0, 150, -50),
				new Point3D(-150, 150, -50));

		triangle4 = new Triangle(new Point3D(-150, 0, -50),
				new Point3D(  0,  -150, -50),
				new Point3D(-150, -150, -50));

		sphere.setEmmission(new Color (255, 255, 255));
		triangle.setEmmission(new Color (255, 255, 255));
		triangle2.setEmmission(new Color (255, 255, 255));
		triangle3.setEmmission(new Color (255, 255, 255));
		triangle4.setEmmission(new Color (255, 255, 255));

		scene.addGeometry(sphere);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

		ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50);
		render.writeToImage();*/
	}
}
