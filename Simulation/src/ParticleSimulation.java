
import java.awt.Graphics;

import javax.swing.JPanel;


public class ParticleSimulation extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final Particle[] particles;
	
	
	public ParticleSimulation(Particle p1, Particle p2, Particle p3) {
		if (p1 == null || p2 == null || p3 == null) {
			throw new NullPointerException("Cannot simulate with null particles");
		}
		particles = new Particle[] {p1, p2, p3};
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Particle p : particles) {
			p.draw(g);
		}
	}
	

	public void move() {
		for (Particle p : particles) {
			Vector force = new Vector();
			for (Particle other : particles) {
				if (other == p) continue; // no force from particle on itself
				force = force.add(other.gravForceOn(p));
			}
			p.applyForce(force);
		}
		for (Particle p : particles) {
			p.move();
		}
		repaint();
	}
}


