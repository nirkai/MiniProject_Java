package primitives;

public  class Point2D  {
	
	protected Coordinate _x;
	protected Coordinate _y;
	
	// ***************** Constructors ********************** //
	
	public Point2D() {
		_x=new Coordinate();
		_y=new Coordinate();
	}
	

	public Point2D(Coordinate x, Coordinate y) {
		_y = new Coordinate(y);
		_x = new Coordinate(x);
	}
	public Point2D(Point2D point2D) {
		this(point2D._x,point2D._y);
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Coordinate getX() {
		return _x;
	}
	public Coordinate getY() {
		return _y;
		
	}
	public void setX(Coordinate x) {
		_x =new Coordinate(x) ;                     
	}
	public void setY(Coordinate y) {
		_y = new Coordinate(y) ;
	}
	
	// ***************** Administration ******************** //
	

	public int compareTo(Point2D point2D) {
		
		if (_x.compareTo(point2D._x) == 0) {
			return _y.compareTo(point2D._y);
		} 
		return 1;
		//return (int)(_x.getCoordinate()*_x.getCoordinate() + _y.getCoordinate()*_y.getCoordinate() - 
			//	(point2D._x.getCoordinate()*point2D._x.getCoordinate() + point2D._y.getCoordinate()*point2D._y.getCoordinate()));
		/*int length = (int)(_x.getCoordinate()*_x.getCoordinate() + _y.getCoordinate()*_y.getCoordinate() - 
				(point2D._x.getCoordinate()*point2D._x.getCoordinate() + point2D._y.getCoordinate()*point2D._y.getCoordinate()));
		if (length > 0) {
			return 1;
		}else if (length < 0) {
			return -1;
		}else {
			return 0;
		}*/
		
	}
}
