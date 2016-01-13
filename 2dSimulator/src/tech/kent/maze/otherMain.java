package tech.kent.maze;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*Main project work space and updates
 * Currently working on creating a particle that has
 * no collision and no acting forces.
 * However there will be a class that is designed to
 * calculate the forces on the other objects.
 * 
 * Will have to update the paint class to paint each of the
 * objects using a for loop that reads the array the stores
 * each particle and rigid body.
 * 
 * Will have to create a constructor class that will create
 * the new particles and the array that holds them.
 * 
 * Object classes will have to update only the forces on
 * them selves. Will do a force addition test to ensure that
 * there is no overall system movement. This will be done
 * before there is any mass assigned to the objects.
 * Adding all the resulting forces should equal zero.
 * 
 * Before Implementing forces. Will have to convert all 
 * positions to doubles to prevent variable errors.
 * 
 */
@SuppressWarnings("serial")
public class otherMain extends JPanel {
    int x = 0;
    int y = 0;
    public particle[] stuff;
    public static void main(String[] args) throws InterruptedException {
	    JFrame frame = new JFrame("Sample Frame");
	    otherMain otherMain = new otherMain();
	    frame.add(otherMain);
	    frame.setSize(300, 400);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    otherMain.defineParticles();
	    while (true) {
	    	//add segment updating particles.
	        otherMain.moveBall();
	        //input seconds
	        otherMain.updateR(0.001);
	        otherMain.repaint();
	        Thread.sleep(50);
	    }
	}
	private void moveBall() {
        x = x + 1;
        y = y + 1;
    }
	
	void updateR(double deltaTime){
		for(int i =0; i < stuff.length; i++){
			stuff[i].forces(stuff, deltaTime);
		}
		for(int i =0; i < stuff.length; i++){
			stuff[i].update();
		}
	}
    private void defineParticles(){
    	//d(x position, y position, x size, y size, charge, mass)
    	stuff = new particle[2];
    	stuff[0] = d(50,50,50,50,-1, 1, true, 0);
    	stuff[1] = d(100,100,50,50,1,1, true, 1);
    }
    private particle d(double a, double b, double c, double d, double e, double f, boolean g, int i){
    	particle s = new particle();
    	s.start(a, b, c, d, e, f, g, i);
    	return s;
    }
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.fillOval(x, y, 30, 30);
	    for(int i = 0; i < stuff.length; i++){
	    	g2d.fillOval((int)stuff[i].x, (int)stuff[i].y, (int)stuff[i].sizex, (int)stuff[i].sizey);
	    }
	    
	}
}