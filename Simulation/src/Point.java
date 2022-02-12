
import java.lang.Object;
import java.awt.geom.Point2D;

/**
 * Immutable location in two dimensional space.
 */
public class Point {
	private final double x;
	private final double y;

	
	// a points ia a coordinate of an object with n x and y position 
	public Point(double xCoord, double yCoord) {
		// TODO
	this.x=xCoord;
		this.y=yCoord;
	}
	

	public double x() {
		return x;
	}
	//returns the value of x 
	public double y() {
		return y;
	}
	
	

	//rounds the point to the nearest AWT point
	public java.awt.Point asAWT() {
		// TODO
	
		

		//took round out to fix problem in test particle?
		int x = (int) Math.round(this.x);
		int y = (int) Math.round(this.y);
		


		
		//this returns the instance of java.awt.Point
		java.awt.Point p = new java.awt.Point(x, y);


	return p = new java.awt.Point(x, y);
		
	
	}
	

	public double distance(Point other) {
		// TODO
		
		if( other==null) {
			throw new IllegalArgumentException(" another point cannot be null");
		}
		
		//trying to figure out how to find distance between two points

		
		
		double x= Math.abs(other.x-this.x);
		double y= Math.abs(other.y-this.y);
		double total = Math.sqrt(Math.pow(x, 2)+ Math.pow(y, 2));

		return total;
	}
	

	@Override // implementation
	public String toString() {
		// TODO
		return "("+x() + ","+ y()+")";
	}

	
	
	
}
