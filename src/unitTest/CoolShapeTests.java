package unitTest;

import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import geometries.*;
import jdk.net.NetworkPermission;
import elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;

import com.sun.javafx.geom.AreaOp.AddOp;
import com.sun.javafx.perf.PerformanceTracker.SceneAccessor;

public class CoolShapeTests {

	@Test
	public void test() {
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Sphere sphere = new Sphere(100, new Point3D(0, -100, -15000));
		Plane plane = new Plane(new Vector(0, -1, 0), new Point3D(0, -350, -1600));
		Plane plane1 = new Plane(new Vector(1.001,0,0.000001), new Point3D(-350,0,-1600));
		Plane plane2 = new Plane(new Vector(-1,001,-0.000001), new Point3D(350,0,-1600));
		Plane plane3 = new Plane(new Vector(0,0,1), new Point3D(0,-350,-2600));
		Triangle triangle = new Triangle(new Point3D(1000, -100, -15500), new Point3D(-1000, -100, -15500), 
				 new Point3D(0, 100, -9000));
		Triangle triangle4 = new Triangle(new Point3D(-35.506962, -78.999695, -434.673737),
				new Point3D(-59.492702, 134.999527, -261.325958),
				new Point3D(-35.506962, 134.999527, -434.673737));

		
		Triangle triangle2 = new Triangle(new Point3D(900, -350, -35500), new Point3D(1000, -350, -2502), 
				 new Point3D(1300, 1000, -2502));
		Triangle triangle3 = new Triangle(new Point3D(-900, -350, -35500), new Point3D(-1000, -350, -2502), 
				 new Point3D(-1300, 1000, -2502));
		plane.setEmmission(new Color(50,50,50));
		plane1.setEmmission(new Color(50, 50, 50));
		//plane2.setEmmission(new Color(50, 50, 50));
		plane3.setEmmission(new Color(100, 100, 100));
		plane3.setKt(1);
		plane3.setKr(0.5);
		sphere.setEmmission(new Color(224, 255, 255));
		sphere.setShininess(20);
		plane.setKr(0.3);
		plane1.setKr(0.9);
		plane2.setKr(0.9);
		plane1.setKt(0);
		plane2.setKt(0);
		triangle2.setKr(0.5);
		triangle3.setKr(0.5);
		//triangle.setKt(1);
		plane.setKt(1);
		PointLight pointLight = new PointLight(new Color(200, 50, 50), new Point3D(0, -100, 0), 0, 0.00005, 0.000005);
		PointLight pointLight2 = new PointLight(new Color(200, 50, 50), new Point3D(0, -400, -7500), 0, 0.00005, 0.000005);
		SpotLight spotLight = new SpotLight(new Color(20, 20, 20), new Point3D(0,300,-30000), new Vector(0,0,1), 0, 0.000005, 0.0000005);
		scene.addGeometry(plane);
		scene.addLight(spotLight);
		scene.addGeometry(plane1);
		scene.addGeometry(plane2);
		//scene.addGeometry(triangle2);
		//scene.addGeometry(triangle3);
		//scene.addGeometry(triangle);
		scene.addGeometry(sphere);
		//scene.addLight(pointLight2);
		//scene.addGeometry(plane3);
		
		ImageWriter imageWriter = new ImageWriter("Special2", 1000, 1000, 1000, 1000);

		Render render = new Render(imageWriter, scene);
	//	render.renderImage();
	//	render.writeToImage();
	}
	
	@Test
	public void test2() {
		Scene scene = new Scene();
		scene.setScreenDistance(250);
		Sphere sphere = new Sphere(200, new Point3D(0, 1000, -3000));
		Plane plane = new Plane(new Vector(0, -1, 0), new Point3D(0, -350, -1600));
		Plane plane1 = new Plane(new Vector(1.001,0,0.000001), new Point3D(-350,0,-1600));
		Plane plane2 = new Plane(new Vector(-1,001,-0.000001), new Point3D(350,0,-1600));
		Plane plane3 = new Plane(new Vector(0,0,1), new Point3D(0,-350,-2600));
		Triangle triangle = new Triangle(new Point3D(-500, 1500, -1000), new Point3D(5000, -560, -5400), 
				 new Point3D(7030, -560, -3400));
		Triangle triangle1 = new Triangle(new Point3D(500, 1500, -1000),
				new Point3D(-5030, -560, -5400),
				new Point3D(-7000, -560, -3400));

		Sphere sphere2 = new Sphere(500, new Point3D(1000, -480, -4000));
		sphere2.setEmmission(new Color(0, 200, 0));
		sphere2.setShininess(50);
		sphere2.setKs(0.0005);
		sphere2.setKt(0.9);
		Triangle triangle2 = new Triangle(new Point3D(900, -350, -35500), new Point3D(1000, -350, -2502), 
				 new Point3D(1300, 1000, -2502));
		Triangle triangle3 = new Triangle(new Point3D(-900, -350, -35500), new Point3D(-1000, -350, -2502), 
				 new Point3D(-1300, 1000, -2502));
		plane.setEmmission(new Color(0,0,50));
		plane1.setEmmission(new Color(50, 50, 50));
		//plane2.setEmmission(new Color(50, 50, 50));
		plane3.setEmmission(new Color(100, 100, 100));
		plane3.setKt(1);
		plane3.setKr(0.5);
		sphere.setEmmission(new Color(224, 50, 55));
		sphere.setShininess(20);
		plane.setKr(0.3);
		plane1.setKr(0.9);
		plane2.setKr(0.9);
		plane1.setKt(0);
		plane2.setKt(0);
		triangle2.setKr(0.5);
		triangle3.setKr(0.5);
		//triangle.setKt(1);
		plane.setKt(1);
		SpotLight spotLight1 = new SpotLight(new Color(180, 0, 0), new Point3D(900, -1000, -4000), new Vector(0,1,0), 0, 0.00005, 0.0000005);
		triangle.setEmmission(new Color(55, 0, 0));
		triangle1.setEmmission(new Color(0, 55, 0));
		triangle.setKr(0.7);
		triangle1.setKr(0.7);
		
		PointLight pointLight = new PointLight(new Color(200, 50, 50), new Point3D(0, -100, 0), 0, 0.00005, 0.000005);
		PointLight pointLight2 = new PointLight(new Color(0, 0, 180), new Point3D(0, 3000, -2800), 0, 0.00005, 0.000005);
		SpotLight spotLight = new SpotLight(new Color(20, 20, 20), new Point3D(0,300,-30000), new Vector(0,0,1), 0, 0.000005, 0.0000005);
		scene.addGeometry(plane);
		scene.addLight(spotLight);
		scene.addGeometry(sphere2);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle);
	scene.addLight(spotLight1);
		//scene.addGeometry(triangle2);
		//scene.addGeometry(triangle3);
		//scene.addGeometry(triangle);
		scene.addGeometry(sphere);
		scene.addLight(pointLight2);
		//scene.addGeometry(plane3);
		
		ImageWriter imageWriter = new ImageWriter("Special3", 1000, 1000, 1000, 1000);

		Render render = new Render(imageWriter, scene);
		//render.renderImage();
		//render.writeToImage();
	}
	
	@Test
	public void test3() {
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Sphere sphere = new Sphere(1000, new Point3D(0, 400, -30000));
		Plane plane = new Plane(new Vector(0, -1, 0), new Point3D(0, -500, -1600));
		PointLight pointLight = new PointLight(new Color(200, 50, 50), new Point3D(0, 0, -300), 0, 0.00005, 0.000005);
		SpotLight spotLight = new SpotLight(new Color(200, 50, 50), new Point3D(0, 0, -30000), new Vector(0,1,1), 0, 0.00005, 0.000005);
		sphere.setEmmission(new Color(50, 50, 50));
		
		Triangle triangle = new Triangle(new Point3D(0,-1000,-30000), new Point3D(700,-200, -25000 ), new Point3D(-700, -200, -24000));
		triangle.setEmmission(new Color(100, 100, 50));
		
		Triangle triangle1 = new Triangle(new Point3D(0,-1000,-30000), new Point3D(-700,-200, -35000 ), new Point3D(-700, -200, -25000));
		triangle1.setEmmission(new Color(100, 100, 50));
		
		Triangle triangle2 = new Triangle(new Point3D(0,-1000,-30000), new Point3D(700, -200, -24000 ), new Point3D(700,-200, -35000));
		triangle2.setEmmission(new Color(100, 100, 50));
		sphere.setKd(0.5);
		sphere.setKs(0.5);
		sphere.setKt(1);
		sphere.setKr(0);
		plane.setKt(0);
		plane.setKr(0.4);
		plane.setKs(0.5);
		plane.setShininess(4);
		scene.addGeometry(sphere);
		plane.setKd(0.8);
		plane.setKs(5);
		//scene.addLight(pointLight);
		scene.addLight(spotLight);
		scene.addGeometry(plane);
		SpotLight spotLight2 = new SpotLight(new Color(20, 50, 50), new Point3D(360, 650, -29450), new Vector(-0.5,-0.5,-0.5), 0, 0.00005, 0.000005);
		plane.setEmmission(new Color(0,0,100));
		DirectionalLight directionalLight = new DirectionalLight(new Color(70, 70, 0), new Vector(-1,-1,-1));
		Sphere sphere2 = new Sphere(150, new Point3D(200, 600, -29500));
		Sphere sphere3 = new Sphere(100, new Point3D(-180, -300, -30500));
		sphere2.setKs(0.5);
		sphere2.setKt(0.3);
		sphere2.setShininess(35);
		sphere2.setEmmission(new Color(250, 0, 0));
		sphere3.setEmmission(new Color(0,0,250));
		scene.addLight(spotLight2);
		scene.addGeometry(sphere2);
		scene.addGeometry(sphere3);
		scene.addLight(directionalLight);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		ImageWriter imageWriter = new ImageWriter("Special6", 1000, 1000, 1000, 1000);

		Render render = new Render(imageWriter, scene);
		//render.renderImage();
		//render.writeToImage();
		
		
	}

	@Test
	public void test4() {
		Scene scene = new Scene();
		scene.setScreenDistance(250);
		Sphere sphere = new Sphere(100, new Point3D(100, 0, -500));
		Plane plane = new Plane(new Vector(-1, 0, 0), new Point3D(0, -350, -1600));
		Plane plane1 = new Plane(new Vector(0, -1, 0), new Point3D(0, -350, -1600));
		plane.setEmmission(new Color(250, 250, 250));
		scene.addGeometry(plane);
		plane.setKr(1);
		plane1.setKr(1);
		plane.setKt(1);
		PointLight pointLight = new PointLight(new Color(200, 50, 50), new Point3D(0, 0, 0), 0, 0.00005, 0.000005);
		scene.addLight(pointLight);
		scene.addGeometry(plane);
		scene.addGeometry(plane1);
		scene.addGeometry(sphere);
		ImageWriter imageWriter = new ImageWriter("Special7", 1000, 1000, 1000, 1000);
		
		Render render = new Render(imageWriter, scene);
	//	render.renderImage();
	//	render.writeToImage();
	}
	
	@Test
	public void test5() {
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Sphere sphere = new Sphere(5, new Point3D(100, 38, -4975));
		Sphere sphere2 = new Sphere(5, new Point3D(-100, 38, -4975));
		Plane plane = new Plane(new Vector(0, 0, 5000), new Point3D(0, 0, -5000));
		Plane plane1 = new Plane(new Vector(0, -1, 0), new Point3D(0, -350, -1600));
		Triangle triangle1 = new Triangle(new Point3D(160, 70, -5100), new Point3D(100, 40, -4950),new Point3D(100, 140, -4950));
		Triangle triangle2 = new Triangle(new Point3D(40, 70, -5100), new Point3D(100, 40, -4950),new Point3D(100, 140, -4950));
		triangle1.setEmmission(new Color(0, 40, 90));
		triangle2.setEmmission(new Color(0, 30, 80));
		Triangle triangle3 = new Triangle(new Point3D(-160, 70, -5100), new Point3D(-100, 40, -4950),new Point3D(-100, 140, -4950));
		Triangle triangle4 = new Triangle(new Point3D(-40, 70, -5100), new Point3D(-100, 40, -4950),new Point3D(-100, 140, -4950));
		
	//	Triangle triangle5 = new Triangle(new Point3D(-100, 40, -1950), new Point3D(-))
		plane.setEmmission(new Color(20, 40, 20));
		plane.setKr(1);
		plane.setKd(1);
		plane.setKs(0);
		sphere.setKr(1);
		triangle1.setKr(1);
		triangle4.setKr(1);
		plane1.setKr(1);

		SpotLight spotLight1 = new SpotLight(new Color(50, 50, 200), new Point3D(0, 70, -4970), new Vector(0,0,-1), 0, 0.00005, 0.000005);
		
		//plane.setKt(1);
		PointLight pointLight = new PointLight(new Color(50, 50, 200), new Point3D(100, 70, -4975), 0, 0.00005, 0.000005);
		SpotLight spotLight = new SpotLight(new Color(50, 50, 200), new Point3D(-100, 70, -4975), new Vector(0,0.3,0.3), 0, 0.00005, 0.000005);
		scene.addGeometry(plane);
		scene.addLight(pointLight);
		scene.addGeometry(plane);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		scene.addLight(spotLight);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addGeometry(sphere);
		scene.addGeometry(sphere2);
		scene.addLight(spotLight1);
		ImageWriter imageWriter = new ImageWriter("Special9", 1024, 1024, 1024, 1024);
		
		Render render = new Render(imageWriter, scene);
//		render.renderImage0();
	//	render.writeToImage();
	}
	
	@Test
	public void test6() {
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Plane plane = new Plane(new Vector(0, 0, -1), new Point3D(0, -350, -2600));
		plane.setEmmission(new Color(20, 20, 50));
		plane.setKd(0);
		Triangle triangle1 = new Triangle(new Point3D(100, -40, -2603), new Point3D(80, 80, -2600),new Point3D(100, 120, -2550));
		Triangle triangle2 = new Triangle(new Point3D(100, -40, -2603), new Point3D(-80, 80, -2600),new Point3D(100, 120, -2550));
		triangle1.setEmmission(new Color(0, 40, 90));
		triangle2.setEmmission(new Color(0, 30, 80));
		Triangle triangle3 = new Triangle(new Point3D(-160, 70, -5100), new Point3D(-100, 40, -4950),new Point3D(-100, 140, -4950));
		Triangle triangle4 = new Triangle(new Point3D(-40, 70, -5100), new Point3D(-100, 40, -4950),new Point3D(-100, 140, -4950));
		scene.addGeometry(plane);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		
		PointLight pointLight = new PointLight(new Color(20, 20, 190), new Point3D(100, 20, -2590), 0, 0.00005, 0.000005);
		scene.addLight(pointLight);
		ImageWriter imageWriter = new ImageWriter("Special10", 1024, 1024, 1024, 1024);
		
		Render render = new Render(imageWriter, scene);
		//render.renderImage0();
		//render.writeToImage();
	}
	
	@Test
	public void test7() {
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Plane plane = new Plane(new Vector(0, 0, 1), new Point3D(0, 0, -3000));
		Plane plane2 = new Plane(new Vector(0, 1, 0), new Point3D(0, -500, -3000));
		Plane plane3 = new Plane(new Vector(0, -1, 0), new Point3D(0, 490, -3000));
		Plane plane4 = new Plane(new Vector(1, 0, 0), new Point3D(-600, 0, -3000));
		plane.setEmmission(new Color(20, 20, 50));
		plane2.setEmmission(new Color(0, 70, 0));
		plane3.setEmmission(new Color(0, 100, 0));
		plane4.setEmmission(new Color(0, 0, 100));
		

		plane.setKr(0);
		plane.setKd(1);
		plane.setKs(1);
		Triangle triangle1 = new Triangle(new Point3D(120, 100, -3000), new Point3D(100, 80, -2900),new Point3D(100, 40, -3010));
		Triangle triangle2 = new Triangle(new Point3D(80, 100, -3000), new Point3D(100, 80, -2900),new Point3D(100, 40, -3010));
		triangle1.setEmmission(new Color(100, 40, 90));
		triangle2.setEmmission(new Color(100, 30, 80));
		scene.addGeometry(plane);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
	//	scene.addGeometry(plane2);
	//	scene.addGeometry(plane3);
		//scene.addGeometry(plane4);
		Triangle triangle3 = new Triangle(new Point3D(400, 600, -3005), new Point3D(400, -500, -3005),new Point3D(600, 600, -2499));
		Triangle triangle4 = new Triangle(new Point3D(400, -500, -3005), new Point3D(600, 600, -2499),new Point3D(600, -600, -2499));
		triangle3.setEmmission(new Color(0, 70, 0));
		triangle4.setEmmission(new Color(0, 70, 0));
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		Triangle triangle9 = new Triangle(new Point3D(470, 120, -2750), new Point3D(470, 50, -2740),new Point3D(455,100, -2740));
		Triangle triangle10 = new Triangle(new Point3D(480, 115, -2720), new Point3D(470, 50, -2740),new Point3D(455, 100, -2740));
		triangle9.setEmmission(new Color(100, 0, 0));
		triangle10.setEmmission(new Color(100, 0, 0));
		scene.addGeometry(triangle9);
		scene.addGeometry(triangle10);
		
		Sphere sphere2 = new Sphere(5, new Point3D(465, 115, -2730));
		//sphere2.setKt(1);
		//sphere2.setShininess(35);
		sphere2.setEmmission(new Color(200,0,0));
		SpotLight spotLight1 = new SpotLight(new Color(10, 10, 30), new Point3D(462, 110, -2730), new Vector(0.5,0.5,0), 0, 0.00005, 0.000005);
		PointLight pointLight3 = new PointLight(new Color(10, 10, 30), new Point3D(473, 105, -2730), 0, 0.00005, 0.000005);
	//	scene.addLight(pointLight3);
	//	scene.addGeometry(sphere2);
	//	scene.addLight(spotLight1);
		
		Triangle triangle5 = new Triangle(new Point3D(-700, 3000, -3005), new Point3D(-700, -500, -3005),new Point3D(-350, -600, -2499));
		Triangle triangle6 = new Triangle(new Point3D(-700, -500, -3005), new Point3D(-350, -600, -2499),new Point3D(3000, -500, -3000));
		triangle5.setEmmission(new Color(0, 70, 0));
		triangle6.setEmmission(new Color(0, 70, 0));
		/*triangle5.setKd(0);
		triangle5.setKs(0);
		triangle6.setKd(0);
		triangle6.setKs(0);*/
		triangle5.setKt(1);
		//triangle6.setKt(0.1);
		scene.addGeometry(triangle5);
		scene.addGeometry(triangle6);
		
		Sphere sphere = new Sphere(40, new Point3D(-200, -200, -2600));
		sphere.setEmmission(new Color(200, 50, 50));
		scene.addGeometry(sphere);
		Triangle triangle7 = new Triangle(new Point3D(-500, -500, -2900), new Point3D(-500, 0, -2900),new Point3D(-200, 0, -3000));
		Triangle triangle8 = new Triangle(new Point3D(-500, -500, -2900), new Point3D(-200, -500, -3000),new Point3D(-200, 0, -3000));
		triangle7.setEmmission(new Color(50,50,50));
		triangle8.setEmmission(new Color(50,50,50));
		triangle7.setKr(1);
		triangle8.setKr(1);
		scene.addGeometry(triangle7);
		scene.addGeometry(triangle8);
		
		Triangle triangle11 = new Triangle(new Point3D(-520, -500, -2900), new Point3D(-520, -500, -2700),new Point3D(-520, 0, -2900));
		Triangle triangle12 = new Triangle(new Point3D(-520, -500, -2700), new Point3D(-520, 0, -2700),new Point3D(-520, 0, -2900));
		triangle11.setEmmission(new Color(50,50,50));
		triangle12.setEmmission(new Color(50,50,50));
		triangle11.setKr(1);
		triangle12.setKr(1);
		scene.addGeometry(triangle11);
		scene.addGeometry(triangle12);
		
		Triangle triangle13 = new Triangle(new Point3D(320, -500, -2900), new Point3D(399, -500, -2700),new Point3D(320, 0, -2900));
		Triangle triangle14 = new Triangle(new Point3D(399, -500, -2700), new Point3D(399, 0, -2700),new Point3D(320, 0, -2900));
		triangle13.setEmmission(new Color(50,50,50));
		triangle14.setEmmission(new Color(50,50,50));
		triangle13.setKr(1);
		triangle14.setKr(1);
		scene.addGeometry(triangle13);
		scene.addGeometry(triangle14);
		
		Sphere sphere3 = new Sphere(80, new Point3D(-100, -300, -2500));
		Sphere sphere4 = new Sphere(2, new Point3D(-80, -265, -2520));
		Sphere sphere5 = new Sphere(4, new Point3D(-140, -250, -2590));
		Sphere sphere6 = new Sphere(3, new Point3D(-90, -244, -2500));
		Sphere sphere7 = new Sphere(2, new Point3D(-155, -255, -2540));
		Sphere sphere8 = new Sphere(4, new Point3D(-87, -262, -2550));
		Sphere sphere9 = new Sphere(3, new Point3D(-143, -254, -2510));
		Sphere sphere10 = new Sphere(3.5, new Point3D(-120, -250, -2570));
		sphere10.setEmmission(new Color(80, 80, 80));
		sphere10.setKr(1);
		
		Sphere sphere11 = new Sphere(22, new Point3D(-100, -355, -2650));
		sphere11.setEmmission(new Color(80, 80, 80));
		sphere11.setKr(1);
		sphere3.setKt(1);
		
		sphere4.setEmmission(new Color(255, 255, 255));
		sphere5.setEmmission(new Color(250, 250, 250));
		sphere6.setEmmission(new Color(250, 250, 250));
		sphere7.setEmmission(new Color(255, 255, 255));
		sphere8.setEmmission(new Color(250, 250, 250));
		sphere9.setEmmission(new Color(250, 250, 250));
		
		sphere3.setEmmission(new Color(0, 20, 0));
		
		sphere4.setShininess(40);
		sphere5.setShininess(37);
		sphere6.setShininess(33);
		sphere7.setShininess(43);
		sphere8.setShininess(35);
		sphere9.setShininess(30);
		
		sphere4.setKr(1);
		sphere7.setKr(1);
		PointLight pointLight4 = new PointLight(new Color(20, 30, 40), new Point3D(-100,-350, -2650), 0.004, 0.0005, 0.00005);
		scene.addGeometry(sphere3);
		scene.addGeometry(sphere4);
		scene.addGeometry(sphere5);
		scene.addGeometry(sphere6);
		scene.addGeometry(sphere7);
		scene.addGeometry(sphere8);
		scene.addGeometry(sphere9);
		scene.addGeometry(sphere10);
		scene.addGeometry(sphere11);
		scene.addLight(pointLight4);
		
		
		
		SpotLight spotLight2 = new SpotLight(new Color(20, 120, 40), new Point3D(398, -200, -2800), new Vector(-1,0,0), 0, 0.00005, 0.000005);
		SpotLight spotLight = new SpotLight(new Color(10, 10, 30), new Point3D(100, 100, -2990), new Vector(0,-1,-1), 0, 0.00005, 0.000005);
		PointLight pointLight = new PointLight(new Color(10, 60, 60), new Point3D(0, 0, -2000), 0, 0.00005, 0.000005);
		PointLight pointLight2 = new PointLight(new Color(20, 20, 190), new Point3D(0, 0, -2500), 0, 0.00005, 0.000005) ;
		scene.addLight(pointLight);
		scene.addLight(spotLight);
	//	scene.addLight(spotLight1);
	//	scene.addLight(pointLight2);
	//	scene.addLight(spotLight2);
		ImageWriter imageWriter = new ImageWriter("Special11.2", 1024, 1024, 1024, 1024);
		
		Render render = new Render(imageWriter, scene);
	//	render.renderImage0();
	//	render.writeToImage();
	}
	
	@Test
	public void test8() {
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Plane plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -500, -3000));
		plane.setEmmission(new Color(20, 20, 50));
	//	plane.setShininess(1000);
	//	plane.setKs(0.2);
		Sphere sphere = new Sphere(100, new Point3D(50, -450, -2900));
		Sphere sphere1 = new Sphere(60, new Point3D(230, -475, -2840));
		Sphere sphere2 = new Sphere(94, new Point3D(-260, -480, -3000));
		Sphere sphere3 = new Sphere(78, new Point3D(-150, -450, -3400));
		Sphere sphere4 = new Sphere(150, new Point3D(0, 200, -3000) );
		sphere1.setEmmission(new Color(20, 40, 130));
		sphere2.setEmmission(new Color(250, 0, 0));
		sphere3.setEmmission(new Color(0, 250,0));
		sphere.setEmmission(new Color(0, 0, 0));
		sphere4.setEmmission(new Color(0, 0, 255));
		sphere4.setKr(1);
		sphere.setKr(1);
		sphere2.setKr(1);
		sphere3.setKr(1);
		sphere.setShininess(1200);
		sphere.setKs(0.2);
		sphere2.setKs(0.08);
		sphere1.setShininess(50);
		sphere1.setKs(0.02);
		sphere1.setKr(0.6);
		sphere3.setKd(0);
		sphere.setKd(0);
		
		Sphere sphere5 = new Sphere(1200, new Point3D(0, 50, -2400));
		sphere5.setKr(0.5);
		sphere5.setEmmission(new Color(20, 14, 20));
		scene.addGeometry(plane);
		scene.addGeometry(sphere);
		scene.addGeometry(sphere1);
		scene.addGeometry(sphere2);
		scene.addGeometry(sphere3);
		scene.addGeometry(sphere4);
		scene.addGeometry(sphere5);
		
		//sphere1.setEmmission(new Color(20, 40, 130));
		
		SpotLight spotLight2 = new SpotLight(new Color(0, 0, 150), new Point3D(220, -465, -2835), new Vector(1,0,0), 0.05, 0.005, 0.00005);
		SpotLight spotLight = new SpotLight(new Color(100, 100, 100), new Point3D(0,0,-3500), new Vector(-0.5,-1,1), 0, 0.005, 0.000005);
		SpotLight spotLight1 = new SpotLight(new Color(100, 100, 100), new Point3D(0,0,-3500), new Vector(0.5,-1,1), 0, 0.005, 0.000005);
		DirectionalLight directionalLight = new DirectionalLight(new Color(100, 0, 0), new Vector(-1,-1,-1));
		PointLight pointLight = new PointLight(new Color(150, 100, 0), new Point3D(0,0,-2550), 0, 0.0008, 0.00005);
		scene.addLight(pointLight);
		scene.addLight(directionalLight);
		scene.addLight(spotLight1);
		scene.addLight(spotLight);
		scene.addLight(spotLight2);;
		
ImageWriter imageWriter = new ImageWriter("Special12", 1024, 1024, 1024, 1024);
		
		Render render = new Render(imageWriter, scene);
//	render.renderImage0();
//		render.writeToImage();
	}
	
	@Test
	public void Test10(){
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Plane plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -400, -3000));
		plane.setEmmission(new Color(20, 20, 50));
		plane.setShininess(1000);
		plane.setKs(0.2);
		
		Triangle triangle1 = new Triangle(new Point3D(-700,-400,-2000), new Point3D(400, -450, -10000), new Point3D(400, 10000, -10010));
		Triangle triangle2 = new Triangle(new Point3D(500,-400,-2500), new Point3D(400, -450, -10000), new Point3D(400, 2000, -10010));
		Triangle triangle3 = new Triangle(new Point3D(500,-400,-2500), new Point3D(500, 2000, -2500), new Point3D(300, 2000, -10010));
		triangle1.setEmmission(new Color(245, 245, 245));
		triangle2.setEmmission(new Color(210, 210, 210));
		triangle3.setEmmission(new Color(210, 210, 210));
		triangle1.setKd(0);
		triangle1.setKs(0.002);
		triangle2.setKd(0);
		triangle2.setKs(0.002);
		triangle3.setKd(0);
		triangle3.setKs(0.002);
		
		scene.addGeometry(plane);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		
		Sphere sphere = new Sphere(70, new Point3D(50, -250, -2900));
		Sphere sphere1 = new Sphere(50, new Point3D(230, -300, -2840));
		sphere.setEmmission(new Color(250, 0, 0,0));
		sphere1.setEmmission(new Color(250, 0,0,255));
		
		sphere.setShininess(100);
		sphere.setKs(1);
		sphere1.setShininess(100);
		sphere1.setKs(1);
		
		scene.addGeometry(sphere);
		scene.addGeometry(sphere1);
		
		Triangle leg1 = new Triangle(new Point3D(360, -400, -4995), new Point3D(365, -85, -4965), new Point3D(360, -80, -4960));
		leg1.setEmmission(new Color(200, 0, 0));
		
		scene.addGeometry(leg1);
		
		
		PointLight pointLight = new PointLight(new Color(150, 100, 100), new Point3D(80,-200,-3000), 0.00004, 0.0008, 0.000005);
		scene.addLight(pointLight);
		
		ImageWriter imageWriter = new ImageWriter("Special13", 1024, 1024, 1024, 1024);
		
		Render render = new Render(imageWriter, scene);
	//	render.renderImage0();
	//	render.writeToImage();
	}
	
	@Test
	public void Test11() {
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Plane plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -400, -3000));
		plane.setEmmission(new Color(20, 20, 50));
		plane.setShininess(1000);
		plane.setKs(0.2);
		plane.setKd(0);
		
		Triangle wall1 = new Triangle(new Point3D(-1000, -50, -4000), new Point3D(1000, 700, -4000),new Point3D(-1000, 700, -4000));
		Triangle wall2 = new Triangle(new Point3D(-1000, -50, -4000),new Point3D(1000, -50, -4000), new Point3D(1000, 700, -4000));
		wall1.setEmmission(new Color(0.1f,0.18725f,0.1745f,0.8f));
		wall1.setKd(0.741);
		wall1.setKs(0.393548);
		wall1.setShininess(12.8);
		wall2.setEmmission(new Color(0.1f,0.18725f,0.1745f,0.8f));
		wall2.setKd(0.741);
		wall2.setKs(0.393548);
		wall2.setShininess(12.8);
		wall1.setKd(0);
		wall2.setKd(0);
		scene.addGeometry(wall1);
		scene.addGeometry(wall2);
		
		
		Triangle walLampRR = new Triangle(new Point3D(-260, 370, -4100), new Point3D(-200, 340, -3950),new Point3D(-200, 440, -3950));
		Triangle walLampRL = new Triangle(new Point3D(-140, 370, -4100), new Point3D(-200, 340, -3950),new Point3D(-200, 440, -3950));
		walLampRL.setEmmission(new Color(255, 255, 255));
		walLampRR.setEmmission(new Color(255, 255, 255));
		Triangle walLampLL = new Triangle(new Point3D(-460, 370, -4100), new Point3D(-400, 340, -3950),new Point3D(-400, 440, -3950));
		Triangle walLampLR = new Triangle(new Point3D(-340, 370, -4100), new Point3D(-400, 340, -3950),new Point3D(-400, 440, -3950));
		walLampLL.setEmmission(new Color(255, 255, 255));
		walLampLR.setEmmission(new Color(255, 255, 255));
		
		scene.addGeometry(walLampRR);
		scene.addGeometry(walLampRL);
		scene.addGeometry(walLampLL);
		scene.addGeometry(walLampLR);
		
		PointLight wallRLight = new PointLight(new Color(100, 0, 0), new Point3D(-200, 400, -4050), 0, 0.00005, 0.00000005);
		PointLight wallLLight = new PointLight(new Color(100, 0, 0), new Point3D(-400, 400, -4050), 0, 0.00005, 0.00000005);
		scene.addLight(wallLLight);
		scene.addLight(wallRLight);
		
		Triangle mirror1 = new Triangle(new Point3D(0,0,-3000), new Point3D(300, 0, -3000), new Point3D(300, 350, -3000));
		Triangle mirror2 = new Triangle(new Point3D(0,0,-3000), new Point3D(0, 350, -3000), new Point3D(300, 350, -3000));
		mirror1.setEmmission(new Color(0.23125f,	0.23125f,	0.23125f,	1));
		mirror1.setKd(0.2775);                                                
		mirror1.setKs(0.773911);                                              
		mirror1.setShininess(4);                                           
		mirror2.setEmmission(new Color(0.23125f,	0.23125f,	0.23125f,	1));
		mirror2.setKd(0.2775);
		mirror2.setKs(0.773911);
		mirror2.setShininess(4);
		mirror1.setKr(1);
		mirror2.setKr(1);
		
		scene.addGeometry(mirror1);
		scene.addGeometry(mirror2);
		
		Sphere ball = new Sphere(70, new Point3D(150, 250, -2600));
		ball.setEmmission(new Color(0.25f,	0.20725f,	0.20725f,	0.922f));
		ball.setKd(0.829);
		ball.setKs(0.296648);
		ball.setShininess(11.264);
		scene.addGeometry(ball);
		
		SpotLight balLight = new SpotLight(new Color(50, 140, 20), new Point3D(10, 40, -2580), new Vector(0.2, -0.1, 0), 0.004, 0.0004, 0.000005);
		scene.addLight(balLight);
		
		Triangle triangle1 = new Triangle(new Point3D(-500,-100,-2570), new Point3D(-500, 20, -2570), new Point3D(-480, 20, -2570));
		Triangle triangle2 = new Triangle(new Point3D(-500,-100,-2570), new Point3D(-500, 20, -2570), new Point3D(-505, 20, -2560));
		Triangle triangle3 = new Triangle(new Point3D(-100,-100,-2570), new Point3D(-100, 20, -2570), new Point3D(-120, 20, -2570));
		triangle1.setEmmission(new Color(0.2125f,0.1275f,0.054f,	1));
		triangle2.setEmmission(new Color(0.2125f,0.1275f,0.054f,	1));
		triangle3.setEmmission(new Color(0.2125f,0.1275f,0.054f,	1));
		triangle1.setKd(0.4284);
		triangle1.setKs(0.271906);
		triangle1.setShininess(25.6);
		triangle2.setKd(0.4284);
		triangle2.setKs(0.271906);
		triangle2.setShininess(25.6);
		triangle3.setKd(0.4284);
		triangle3.setKs(0.271906);
		triangle3.setShininess(25.6);
		
		Sphere leg1 = new Sphere(13, new Point3D(-490, 16, -2555));
		Sphere leg2 = new Sphere(13, new Point3D(-110, 16, -2560));
		leg1.setEmmission(new Color(0.2125f,0.1275f,0.054f,	1));
		leg2.setEmmission(new Color(0.2125f,0.1275f,0.054f,	1));
		leg1.setKd(0.4284);
		leg1.setKs(0.271906);
		leg1.setShininess(25.6);
		leg2.setKd(0.4284);
		leg2.setKs(0.271906);
		leg2.setShininess(25.6);
		
		Triangle backRightLeg = new Triangle(new Point3D(-91,30,-2795), new Point3D(-92, 29.5, -2790), new Point3D(-91, -100, -2793));
		Triangle backRightLeg1 = new Triangle(new Point3D(-96,30,-2797), new Point3D(-92, 29.5, -2790), new Point3D(-91, -100, -2793));
		backRightLeg.setEmmission(new Color(0.2125f,0.1275f,0.054f,	1));
		backRightLeg.setKd(0.4284);
		backRightLeg.setKs(0.271906);
		backRightLeg.setShininess(25.6);
		backRightLeg1.setEmmission(new Color(0.2125f,0.1275f,0.054f,	1));
		backRightLeg1.setKd(0.4284);
		backRightLeg1.setKs(0.271906);
		backRightLeg1.setShininess(25.6);
		Sphere leg3 = new Sphere(13, new Point3D(-92, 28, -2794));
		leg3.setEmmission(new Color(0.2125f,0.1275f,0.054f,	1));
		leg3.setKd(0.4284);
		leg3.setKs(0.271906);
		leg3.setShininess(25.6);
		scene.addGeometry(leg3);
		
		scene.addGeometry(backRightLeg);
		scene.addGeometry(backRightLeg1);
		
		Triangle backLeftLeg = new Triangle(new Point3D(-499,30,-2795), new Point3D(-502, 29.5, -2790), new Point3D(-500, -100, -2793));
		backLeftLeg.setEmmission(new Color(0.2125f,0.1275f,0.054f,	1));
		backLeftLeg.setKd(0.4284);
		backLeftLeg.setKs(0.271906);
		backLeftLeg.setShininess(25.6);
		scene.addGeometry(backLeftLeg);
		
	//	Triangle vaze1 = new Triangle(new Point3D(-480,20,-2770), new Point3D(-500, 20, -2700), new Point3D(-480, 20, -2700));
		
		Sphere vaze = new Sphere(60, new Point3D(-400, 80, -2700));
		vaze.setEmmission(new Color(0.24725f,	0.2245f,	0.0645f,	1));
		vaze.setKd(0.3143);
		vaze.setKs(0.723991);
		vaze.setShininess(83.2);
		vaze.setKt(0.1);
		Triangle vaze1 = new Triangle(new Point3D(-400,80,-2700), new Point3D(-400, 200, -2650), new Point3D(-360, 200, -2730));
		Triangle vaze2 = new Triangle(new Point3D(-400,80,-2700), new Point3D(-400, 200, -2650), new Point3D(-440, 200, -2730));
		vaze1.setEmmission(new Color(0.24725f,	0.2245f,	0.0645f,	1));
		vaze1.setKd(0.3143);
		vaze1.setKs(0.723991);
		vaze1.setShininess(83.2);
		vaze2.setEmmission(new Color(0.24725f,	0.2245f,	0.0645f,	1));
		vaze2.setKd(0.3143);
		vaze2.setKs(0.723991);
		vaze2.setShininess(83.2);
		
		scene.addGeometry(vaze);
		scene.addGeometry(vaze1);
		scene.addGeometry(vaze2);
		
		scene.addGeometry(leg1);
		scene.addGeometry(leg2);
		
		Triangle table1 = new Triangle(new Point3D(-500, 20, -2550), new Point3D(-490, 30, -2800), new Point3D(-90, 30, -2800));
		Triangle table2 = new Triangle(new Point3D(-90, 30, -2800), new Point3D(-500, 20, -2550), new Point3D(-90, 20, -2550));
		table1.setKd(0.4284);
		table1.setKs(0.271906);
		table1.setShininess(25.6);
		table2.setKd(0.4284);
		table2.setKs(0.271906);
		table2.setShininess(25.6);
		scene.addGeometry(table1);
		scene.addGeometry(table2);
		
		scene.addGeometry(plane);
		scene.addGeometry(triangle1);
//		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		
		Triangle lampStand = new Triangle(new Point3D(-250,25,-2650), new Point3D(-250, 150, -2650), new Point3D(-246, 150, -2650));
		Triangle lampRignt = new Triangle(new Point3D(-245,90,-2600), new Point3D(-235, 90, -2700), new Point3D(-250, 180, -2650));
		Triangle lampLeft = new Triangle(new Point3D(-245,90,-2600), new Point3D(-280, 90, -2700), new Point3D(-250, 180, -2650));
		
		lampStand.setEmmission(new Color(0.02f,	0.02f,	0.02f,	1));
		lampStand.setKd(0);
		
		lampRignt.setEmmission(new Color(0.23125f,	0.23125f,	0.23125f,	1));
		lampRignt.setKd(0.2775);
		lampRignt.setKs(0.773911);
		lampRignt.setShininess(89.6);
		lampLeft.setEmmission(new Color(0.23125f,	0.23125f,	0.23125f,	1));
		lampRignt.setKd(0.50754);
		lampRignt.setKs(0.508273);
		lampRignt.setShininess(51.2);
		lampLeft.setKt(0.1);
		lampRignt.setKt(0.1);
		
		scene.addGeometry(lampStand);
		scene.addGeometry(lampRignt);
		scene.addGeometry(lampLeft);
		
		PointLight lamp = new PointLight(new Color(100, 0, 0), new Point3D(-250, 70, -2650), 0.004, 0.0005, 0.00005);
		scene.addLight(lamp);
		
		DirectionalLight lights = new DirectionalLight(new Color(20, 60, 30), new Vector(-1,-1,0));
		scene.addLight(lights);
		
		PointLight pointLight = new PointLight(new Color(150, 100, 100), new Point3D(-300,100,-2650), 0.00004, 0.0008, 0.000005);
		scene.addLight(pointLight);
		
		ImageWriter imageWriter = new ImageWriter("Special15", 1024, 1024, 1024, 1024);
		
		Render render = new Render(imageWriter, scene);
	//	render.renderImage0();
	//	render.writeToImage();
	}
	
	@Test
	public void Test9(){
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Plane plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -700, -3000));
		//plane.setEmmission(new Color(0.329412f,	0.223529f,	0.027451f,	1));
		plane.setEmmission(new Color(0.12f,0.67f,0.23f, 0.2f));
		plane.setShininess(27.8974);
		plane.setKs(0.941176);
		plane.setKd(0.568627);
		plane.setKt(1);
		scene.addGeometry(plane);
		
		Plane plane1 = new Plane(new Vector(0, 0, -1), new Point3D(0, -200, -3000));
		plane1.setEmmission(new Color(0.45f,0.34f,0.54f, 0.2f));
		plane1.setShininess(27.8974);
		plane1.setKs(0.941176);
		plane1.setKd(0.568627);
		plane1.setKt(1);
		scene.addGeometry(plane1);
		
		Sphere vaze = new Sphere(140, new Point3D(-400, 0, -2700));
		vaze.setEmmission(new Color(0.24725f,	0.2245f,	0.0645f,	1));
		vaze.setKd(0.3143);
		vaze.setKs(0.723991);
		vaze.setShininess(83.2);
	//	vaze.setKt(0);
	//	vaze.setKr(0.8);
		Triangle vaze1 = new Triangle(new Point3D(-400,0,-2700), new Point3D(-400, 300, -2600), new Point3D(-330, 300, -2730));
		Triangle vaze2 = new Triangle(new Point3D(-400,0,-2700), new Point3D(-400, 300, -2600), new Point3D(-470, 300, -2730));
		vaze1.setEmmission(new Color(0.24725f,	0.2245f,	0.0645f,	1));
		vaze1.setKd(0.3143);
		vaze1.setKs(0.723991);
		vaze1.setShininess(83.2);
		vaze2.setEmmission(new Color(0.24725f,	0.2245f,	0.0645f,	1));
		vaze2.setKd(0.3143);
		vaze2.setKs(0.723991);
		vaze2.setShininess(83.2);
	//	vaze1.setKr(0.6);
		//vaze2.setKr(0.5);
		scene.addGeometry(vaze);
		scene.addGeometry(vaze1);
		scene.addGeometry(vaze2);
		
		Triangle tallVaze1 = new Triangle(new Point3D(0, -140, -2550), new Point3D(100, -135, -2700), new Point3D(60, 300, -2650));
		Triangle tallVaze2 = new Triangle(new Point3D(0, -140, -2550), new Point3D(-60, -135, -2700), new Point3D(60, 300, -2650));
		Triangle tallVaze3 = new Triangle(new Point3D(100, -135, -2700), new Point3D(-60, -135, -2700), new Point3D(60, 300, -2650));
		
		tallVaze1.setEmmission(new Color(0.1745f,	0.01175f,	0.01175f,	0.55f));
		tallVaze1.setKd(	0.04136	);
		tallVaze1.setKs(0.626959);
		tallVaze1.setShininess(76.8);
		tallVaze1.setKr(0.5);
		tallVaze1.setKt(0.5);
		tallVaze2.setEmmission(new Color(0.1745f,	0.01175f,	0.01175f,	0.55f));
		tallVaze2.setKd(	0.04136	);
		tallVaze2.setKs(0.626959);
		tallVaze2.setShininess(76.8);
		tallVaze2.setKr(0.5);
		tallVaze2.setKt(0.5);
		tallVaze3.setEmmission(new Color(0.1745f,	0.01175f,	0.01175f,	0.55f));
		tallVaze3.setKd(	0.04136	);
		tallVaze3.setKs(0.626959);
		tallVaze3.setShininess(76.8);
		tallVaze3.setKr(0.5);
		tallVaze3.setKt(0.5);
		scene.addGeometry(tallVaze1);
		scene.addGeometry(tallVaze2);
		scene.addGeometry(tallVaze3);
		
		Sphere ball = new Sphere(100, new Point3D(300, -40, -2700));
		ball.setEmmission(new Color(0.02f,	0.02f,	0.02f,	1));
		ball.setKd(0.1);
		ball.setKs(0.4);
		ball.setShininess(10);
		ball.setKr(0.05);
		scene.addGeometry(ball);
		
		PointLight pointLight = new PointLight(new Color(150, 100, 100), new Point3D(0,100,-2530), 0.00004, 0.0008, 0.000005);
		scene.addLight(pointLight);
		
		SpotLight spotLight = new SpotLight(new Color(200, 0, 0), new Point3D(50, 500, -2980), new Vector(-0.5,-0.5,-0.5), 0.004, 0.00005, 0.000005);
		scene.addLight(spotLight);
		
		ImageWriter imageWriter = new ImageWriter("Special16", 1024, 1024, 1024, 1024);
		Render render = new Render(imageWriter, scene);
		//	render.renderImage0();
		//	render.writeToImage();

	}
	
	@Test
	public void Test12(){
		Scene scene = new Scene();
		scene.setScreenDistance(2500);
		Plane plane = new Plane(new Vector(0, 0, 1), new Point3D(0, 0, -6000));
		plane.setEmmission(new Color(0.12f,0.67f,0.23f, 0.2f));
		plane.setShininess(27.8974);
		scene.addGeometry(plane);
		
		Triangle backPiramidR = new Triangle(new Point3D(850, -300, -5000), new Point3D(450, -350, -4700), new Point3D(550, 200, -4800));
		Triangle backPiramidL = new Triangle(new Point3D(310, -300, -4950), new Point3D(450, -350, -4700), new Point3D(550, 200, -4800));
		backPiramidL.setEmmission(new Color(0.2295f,	0.08825f,	0.0275f,	1));
		backPiramidL.setKd(0.2118);
		backPiramidL.setKs(0.223257);
		backPiramidL.setShininess(51.2);
		backPiramidR.setEmmission(new Color(0.2295f,	0.08825f,	0.0275f,	1));
		backPiramidR.setKd(0.2118);
		backPiramidR.setKs(0.223257);
		backPiramidR.setShininess(51.2);
		
		scene.addGeometry(backPiramidL);
		scene.addGeometry(backPiramidR);
		
		PointLight backLight = new PointLight(new Color(140, 140, 10), new Point3D(390, -350, -4800), 0, 0.00005, 0.000005);
		//scene.addLight(backLight);

		Triangle midPiramidR = new Triangle(new Point3D(380, -370, -4900), new Point3D(-140, -440, -4750), new Point3D(-5, 400, -4850));
		Triangle midPiramidL = new Triangle(new Point3D(-350, -250, -4900), new Point3D(-140, -440, -4750), new Point3D(-5, 400, -4850));
		midPiramidL.setEmmission(new Color(0.19125f,	0.0735f,	0.0225f,	1));
		midPiramidL.setKd(0.27048);
		midPiramidL.setKs(0.137622);
		midPiramidL.setShininess(12.8);
		midPiramidR.setEmmission(new Color(0.2295f,	0.08825f,	0.0275f,	1));
		midPiramidR.setKd(0.2118);
		midPiramidR.setKs(0.223257);
		midPiramidR.setShininess(51.2);
		scene.addGeometry(midPiramidL);
		scene.addGeometry(midPiramidR);
		
		Triangle frontPiramidR = new Triangle(new Point3D(-210, -445, -4790), new Point3D(-580, -520, -4600), new Point3D(-460, 90, -4650));
		Triangle frontPiramidL = new Triangle(new Point3D(-700, -350, -4850), new Point3D(-580, -520, -4600), new Point3D(-460, 90, -4650));
		frontPiramidL.setEmmission(new Color(0.2295f,	0.08825f,	0.0275f,	1));
		frontPiramidL.setKd(0.2118);
		frontPiramidL.setKs(0.223257);
		frontPiramidL.setShininess(51.2);
		frontPiramidR.setEmmission(new Color(0.2295f,	0.08825f,	0.0275f,	1));
		frontPiramidR.setKd(0.2118);
		frontPiramidR.setKs(0.223257);
		frontPiramidR.setShininess(51.2);
		scene.addGeometry(frontPiramidL);
		scene.addGeometry(frontPiramidR);
		
		Triangle shadTri1 = new Triangle(new Point3D(-700, -700, -2555), new Point3D(-700, -500, -2555), new Point3D(700, -700, -2555) );
		scene.addGeometry(shadTri1);
		Triangle shadTri2 = new Triangle(new Point3D(-400, -700, -2555), new Point3D(-400, -400, -2555), new Point3D(700, -700, -2555) );
		scene.addGeometry(shadTri2);
		
		PointLight pointLight = new PointLight(new Color(150, 100, 100), new Point3D(0,100,-2530), 0.00004, 0.0008, 0.000005);
		scene.addLight(pointLight);
		SpotLight spotLight =  new SpotLight(new Color(150, 100, 100), new Point3D(390, -250, -4800), new Vector(1,-0.5,-0.5), 0.00004, 0.0008, 0.000005);
		scene.addLight(spotLight);
		
		DirectionalLight lights = new DirectionalLight(new Color(20, 60, 30), new Vector(-1,-1,0));
		scene.addLight(lights);
		
		ImageWriter imageWriter = new ImageWriter("Piramid", 1024, 1024, 1024, 1024);
		Render render = new Render(imageWriter, scene);
			render.renderImage0();
			render.writeToImage();

	}
}
