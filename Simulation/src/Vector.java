


public class Vector {
	// TODO: declare fields
	private final double dX;
	private final double dY;
	
	public Vector() {
		
		//default vector has not chnaged any value so it is 0,0 
		
		this.dX=0;
		this.dY=0;
	}
	
	public double dx() {
		return dX;
	}

	public double dy() {
		return dY;
	}


	public Vector(double deltaX, double deltaY) {
		// TODO
		
		
		this.dX=deltaX;
		this.dY=deltaY;
	}

	

	public Vector(Point p1, Point p2) {
		

this.dX=p2.x()-p1.x();

this.dY= p2.y()-p1.y();
Vector p3 = new Vector (dX, dY);
	}


	public Point move(Point p) {
		
		// created two new points that has added the change in x and y to the original point in p 
		
		//adds the delta x and delta y to p1.x and p1.y
	int px=(int) (this.dX+p.x());
	int py=(int) (this.dY+p.y());
		Point t;
	return t = new Point(px,py);
	}
	
	
	public double magnitude() {
		// TODO
		
		
		// square root formula to return magnitude
	double answer=Math.sqrt(Math.pow(dX, 2)+ Math.pow(dY, 2));
			
			return answer;
	}
	

	public Vector add(Vector other) {
		// TODO
		
		if (other==null) {
			throw new IllegalArgumentException(" other cannot be null");
		}
		Vector v;
		double newDX=  (this.dX+other.dX);
		double newDY = (this.dY+other.dY);
		
		return v= new Vector(newDX, newDY);
	}
	

	public Vector scale(double s) {
	
		
		Vector c;
		
		double newDx = this.dX*s;
		
		double newDy =  dY*s;
		return c= new Vector(newDx, newDy); 
	}
	
	
	public Vector normalize() {
		
		double dX = (1/magnitude())*this.dX;
		double dY = (1/magnitude())*this.dY;
		Vector c;
		return  c= new Vector(dX, dY);
	}
	

	
	@Override
	public String toString() {
		return "<" + this.dx()+ ","+ this.dy()+ ">";	}
}

