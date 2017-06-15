package unitTest;
import primitives.*;
import geometries.*;
import elements.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.sun.javafx.sg.prism.web.NGWebView;


public class GetNormal {
	
	
		
	
	@Test
	 public void Test()
	    {
	        System.out.println("Test: Triangle getNormal test: ");
	        Triangle triangle = new Triangle(new Point3D( 0,  1, -2),
	                new Point3D( 1, -1, -2),
	                new Point3D(-1, -1, -2));
	        Vector normal = triangle.getNormal(new Point3D());
	        System.out.println(normal);
	        
	        Triangle triangle1 = new Triangle(new Point3D( 3,  -1, -2),
	                new Point3D( 4, -1, -2),
	                new Point3D(-1, -3, -2));
	        Vector normal1 = triangle1.getNormal(new Point3D());
	        System.out.println(normal1);
	        
	        assertEquals("Bad normal! ", normal.toString(),"(-0.00, 0.00, 1.00)");
	        assertEquals("Bad normal! ", normal1.toString(),"(-0.00, 0.00, 1.00)");
	        
	        System.out.println("Test: Sphere getNormal test: ");
	        Sphere sphere = new Sphere(10, new Point3D(0.0, 0.0, -3.0));
	        Vector Normal = sphere.getNormal(new Point3D(5.0,5.0,-3.0));
	        System.out.println(Normal);
	        
	        Sphere sphere1 = new Sphere(7, new Point3D(0.0, 0.0, -2.0));
	        Vector Normal1 = sphere1.getNormal(new Point3D(0.0,0.0,-5.0));
	        System.out.println(Normal1);
	        
	        assertEquals("Bad normal! ", Normal.toString(),"(0.71, 0.71, 0.00)"); 
	        assertEquals("Bad normal! ", Normal1.toString(),"(0.00, 0.00, -1.00)"); 
	       
	    }
	
	
	
	
	}


