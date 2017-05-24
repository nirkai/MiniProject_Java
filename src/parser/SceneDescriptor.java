package parser;

import java.util.Map;
//import java.util.logging.Handler;

import org.xml.sax.helpers.DefaultHandler;
import elements.AmbientLight;
import elements.Camera;

import java.util.List;

public class SceneDescriptor extends DefaultHandler {
	Map <String, String> _sceneAttributes;
	Map <String, String> _cameraAttributes;
	Map <String, String> _ambientLightAttributes;
	List <Map <String, String>> _spheres;
	List < Map <String, String>> _triangles;
	
	
	
	public Map<String, String> getSceneAttributes() {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Map<String, String>> getSpheres() {
		// TODO Auto-generated method stub
		return null;
	}



	public Camera getCameraAttributes() {
		// TODO Auto-generated method stub
		return null;
	}



	public void fromXML(String sceneXMLDesc) {
		// TODO Auto-generated method stub
		
	}



	public AmbientLight getAmbientLightAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//InitializeFromXMLstring(String xmlText);
}
