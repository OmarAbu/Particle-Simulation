

import java.awt.Color;
import java.awt.Graphics;


public class Particle {
	private volatile Point position; // must be "volatile" because of animation (not for other fields)
	// TODO: more fields.
	private Vector v;
	private final double  mass; 
	
	private final  Color c;

	public Particle(Point p, Vector v, double m, Color c) {
		// TODO
		if(p.equals(null)) {
			throw new IllegalArgumentException("point  cannot be null");
		}
		this.position=p;
		if(v.equals(null)){
			throw new IllegalArgumentException("vector movement cannot be null");
		}
		this.v=v;
		if(c.equals(null)) {
			throw new IllegalArgumentException("color  cannot be null");
		}
		this.c=c;
		
	

		this.mass=m;

	
		}
	
	
	
	public Point getPosition() {
		// TODO
		if(this.position==null) {
			throw new IllegalStateException("velocity can never be null");
		}
		return this.position;
	}
	

	public Vector getVelocity() {
		// TODO
		if(this.v==null) {
			throw new IllegalStateException("velocity can never be null");
		}
		return this.v;
	}
	

	public void move() {
	

		double  pX= v.dx()+position.x();
		double pY=v.dy()+position.y();
		
		Point p3= new Point(pX,pY);
		this.position=p3;
	}
	

	public void draw(Graphics g) {
		
		if(g.equals(null)) {
			throw new IllegalArgumentException("particle cannot be drawn because it is null");
		}

	
		int f=(int) (2*(Math.sqrt(this.mass)));
		
		//this is to get the radius that means the distance from the center to where it touches the bounded rectangular wall which will give me the coorect values for upper left coordinates
		
		int radius = (int) (Math.sqrt(this.mass));

		
		//this equation for each of the new values for fillOval 
		int upX = position.asAWT().x-radius;
		int upY = position.asAWT().y-radius;
		
		

		g.setColor(this.c);

		g.fillOval(upX, upY, f, f);
		
	
	}

	
	private static final double G = 1;

	public Vector gravForceOn(Particle other) {
		// TODO;
		if(other==null) {
			throw new IllegalArgumentException("other particle cannot be null");
		}
		
//logic here is get the distance for d from other point to original points
		Vector t=new Vector(other.position,this.position  ); 

		
	//magntiude of Vector t which is the distance between two points 
	double d=t.magnitude();
	




//formula for calculating the gravity on that will be used for the vector
	double grav =((this.mass*other.mass)/Math.pow(d, 2));
	

	//this is a rough idea 
Vector z = t.normalize();

Vector test= z.scale(grav);




	return test;
	
	//Vector result = ((this.mass*other.mass)/t.magnitude())
		
	}
	
	
	public void applyForce(Vector force) {
		
		
		// establish m component for equation,
		

	if(force==null) {
		throw new IllegalArgumentException("object force is null");
	}
	
		
	

	//z is a variable type vector the has the same values as the current v in particle
	Vector z=this.v;
	
	//acceleration equals force and each value *1/mass
Vector a=force.scale(1/mass);


//the changed vector equals to the this.v vector plus acceleration
Vector changed=z.add(a);


//current vector is changed to the values of the changed vector 
this.v=changed;



		
		

	
		
	}
}
