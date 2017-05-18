package unitTest;

import geometries.*;
import primitives.*;

import renderer.*;
import scene.*;
import elements.*;
import java.awt.Color;

import org.junit.Test;

public class RenderTest 
{
	 
    @Test
    public void basicRendering(){
         
    	Scene scene = new Scene(new AmbientLight(255,255,255), 
				    			new Color(0.3f,0.5f,0.74f), 
				    			new Camera(), 48);
         Sphere sphere = new Sphere(50, new Point3D(0.0, 0.0, -50));
        
         
        Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
                                         new Point3D(  0, 100, -49),
                                         new Point3D( 100, 100, -49));
         
        Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
                                          new Point3D(  0, -100, -49),
                                          new Point3D( 100,-100, -49));
         
        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
                                          new Point3D(  0, 100, -49),
                                          new Point3D(-100, 100, -49));
         
        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
                                          new Point3D(  0,  -100, -49),
                                          new Point3D(-100, -100, -49));
        
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
         
        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
         
        Render render = new Render(imageWriter, scene);
         
        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
         
        
        Scene scene1 = new Scene(new AmbientLight(255,255,255), 
    			new Color(0,0,0), 
    			new Camera(), 48);
        

		sphere.setEmmission(new Color (0, 0, 0));
		triangle.setEmmission(new Color (0, 255, 255));
		triangle2.setEmmission(new Color (255, 255, 0));
		triangle3.setEmmission(new Color (0, 0, 0));
		triangle4.setEmmission(new Color (255, 0, 255));
		
		scene1.addGeometry(sphere);
		scene1.addGeometry(triangle);
		scene1.addGeometry(triangle2);
		scene1.addGeometry(triangle3);
		scene1.addGeometry(triangle4);

		ImageWriter imageWriter1 = new ImageWriter("Test", 500, 500, 500, 500);

		Render render1 = new Render(imageWriter1, scene1);

		render1.renderImage1();
		render1.printGrid(50);
		render1.writeToImage();
        
    	/*Scene scene = new Scene(new AmbientLight(255,255,255), 
    			new Color(0.3f,0.5f,0.74f), 
    			new Camera(), 50);
                
        Sphere sphere = new Sphere(50, new Point3D(0.0, 0.0, -50));
		Triangle triangle = new Triangle(new Point3D( 150, 0, -50),
				 		    new Point3D(  0, 150, -50),
				 		    new Point3D( 150, 150, -50));
		
		Triangle triangle2 = new Triangle(new Point3D( 150, 0, -50),
				 		     new Point3D(  0, -150, -50),
				 		     new Point3D( 150,-150, -50));
		
		Triangle triangle3 = new Triangle(new Point3D(-150, 0, -50),
				 		      new Point3D(  0, 150, -50),
				 		      new Point3D(-150, 150, -50));
		
		Triangle triangle4 = new Triangle(new Point3D(-150, 0, -50),
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
     

