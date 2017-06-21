package unitTest;

import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import geometries.*;
import elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;

import com.sun.javafx.geom.AreaOp.AddOp;

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
		Plane plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -300, -3000));
		plane.setEmmission(new Color(20, 20, 50));
		plane.setShininess(1000);
		plane.setKs(0.2);
		
		Triangle triangle1 = new Triangle(new Point3D(-700,-100,-2700), new Point3D(-700, -10, -2700), new Point3D(-680, -10, -2700));
		Triangle triangle2 = new Triangle(new Point3D(-680,-10,-2700), new Point3D(-700, -100, -2700), new Point3D(-700, -100, -2750));
		Triangle triangle3 = new Triangle(new Point3D(-100,-100,-2700), new Point3D(-100, -80, -2700), new Point3D(-120, -10, -2700));
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
		//scene.addGeometry(triangle2);
		//scene.addGeometry(triangle3);
		
		PointLight pointLight = new PointLight(new Color(150, 100, 100), new Point3D(0,0,-2500), 0.00004, 0.0008, 0.000005);
		scene.addLight(pointLight);
		
		ImageWriter imageWriter = new ImageWriter("Special14", 1024, 1024, 1024, 1024);
		
		Render render = new Render(imageWriter, scene);
		render.renderImage0();
		render.writeToImage();
	}
	
	/*@Test
	public void Test9(){
		Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 200);
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		Triangle triangle = new Triangle(new Point3D(-224, -125, -260), new Point3D(-125, -225, -260), new Point3D(-225, -225, -270));
		triangle.setEmmission(new Color(0, 0, 100));
		triangle.setShininess(0.1);
		scene.addGeometry(triangle);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		ImageWriter imageWriter = new ImageWriter("Shadow Test 5", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		render.renderImage0();
		render.writeToImage();
		
		scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		imageWriter = new ImageWriter("Shadow Test 7", 500, 500, 500, 500);
		sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		Triangle triangle1 = new Triangle(new Point3D(3500,  3500, -2000), new Point3D(-3500, -3500, -1000), new Point3D(3500, -3500, -2000));
		Triangle triangle2 = new Triangle(new Point3D(3500,  3500, -2000), new Point3D(-3500,  3500, -1000), new Point3D(-3500, -3500, -1000));
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), new Vector(-2, -2, -3), 0, 0.000001, 0.000005));
		render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();

	}*/
}
