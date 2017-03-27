package primitives;


 /**
  * 
  * @author Uria 
  * @author Nir
  * 
  * This class take care the base of the coordinate in the Number Line
  *
  */
public  class Coordinate {
	
	// coordinate in the Number Line
	private double _coordinate;
	
	// ***************** Constructors ********************** //
	public Coordinate() {
		_coordinate = 0;
	}
	public Coordinate(double coordinate) {
		_coordinate = coordinate;
	}
	public Coordinate(Coordinate coordinate){
		_coordinate = coordinate._coordinate;
	}

	// ***************** Getters/Setters ********************** //
	public double getCoordinate() {
		return _coordinate;
	}
	public void setCoordinate(double coordinate){
		_coordinate = coordinate;
	}
	
	// ***************** Administration ******************** //
	public int compareTo(Coordinate coordinate){
		//return Double.compare(_coordinate, coordinate._coordinate);
		 return (int)(_coordinate - coordinate._coordinate);
		// we need to check if it length. if so - need to check if the coordinate negative !!! 
		/*if (_coordinate > coordinate._coordinate ) {
			return 1;
		}else if (_coordinate < coordinate._coordinate ) {
			return -1;
		}
		else {
			return 0;
		}*/
	}
	
	
	// ***************** Operations ******************** //
	public void add (Coordinate coordinate){
		_coordinate = Math.abs(_coordinate);
		_coordinate += Math.abs(coordinate._coordinate);
		
	}
	
	public void subtract (Coordinate coordinate){
		if (_coordinate >= coordinate._coordinate) {
			_coordinate -= coordinate._coordinate;
		}else {
			_coordinate = coordinate._coordinate - _coordinate;
		}
	}
	
	
}
