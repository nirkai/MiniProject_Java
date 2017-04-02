package primitives;


 /**
  * This class take care the base of the coordinate in the Number Line
  * @author Uria 
  * @author Nir
  * 
  * Can Adding and Subtracting between two coordinates
  *
  */
public  class Coordinate implements Comparable<Coordinate>{
	
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
	@Override
	public int compareTo(Coordinate coordinate){
		//return Double.compare(_coordinate, coordinate._coordinate);
		double ab = Math.abs(_coordinate - coordinate.getCoordinate());
		if (ab > 1e-10) {
			return 1;
		}
		return 0;
		// return (int)(_coordinate - coordinate._coordinate);
	}
	
	
	// ***************** Operations ******************** //
	/**
	 * One coordinate get second coordinate and adding the second the the first
	 * @param coordinate
	 */
	public void add (Coordinate coordinate){
		_coordinate += coordinate.getCoordinate();
	}
	
	/**
	 * One coordinate get second coordinate and subtract the second from the first
	 * @param coordinate
	 */
	public void subtract (Coordinate coordinate){
		_coordinate -= coordinate.getCoordinate();		
	}
	
	
}
