package tech.kent.maze;

public class particle {

	public double x, 
		y,
		index,
		charge,
		accelerationx,
		accelerationy,
		velocityx,
		velocityy,
	//	mField,
		mass,
		deltax,
		deltay,
		sizex, 
		sizey;
	public boolean fixed;
	public void forces(particle[] stuff, double inputTime){
		cLaw(stuff, inputTime);
	}
	double gravity(double otherx, double othery){
		//calculate distance between objects.
		//calculate angle relative to x-axis
		//calculate force on the other object.
		
		
		return 0.0;
	}
		
	void cLaw(particle[] me, double delatTime){
		for (int i = 0; i < me.length; i++){
			if(i != index){
			double constant = 1;
			double othercharge = me[i].charge;
			double otherx = me[i].x;
			double othery = me[i].y;
			double magnitude =  -1 * (constant * othercharge * charge)/(distance(otherx, x, othery, y));
			double angle = Math.atan((x - otherx)/(y - othery));
			if((otherx - x) < 0){
				angle += Math.PI;
			}
			
			deltay += Math.sin(angle) * magnitude;
			deltax += Math.cos(angle) * magnitude;
			System.out.print(index + " ");
			System.out.println(deltay);
			
			//calculate x component
			//calculate y component
			}
		}
	}
	double distance(double x1, double x2, double y1, double y2){
		return Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2));
	}
	public void start(double inputx, double inputy,
			double inputsizex, double inputsizey,
			double inputCharge, double inputMass,
			boolean inputFixed, int inputIndex){
		x = inputx;
		y = inputx;
		sizex = inputsizex;
		sizey = inputsizey;
		charge = inputCharge;
		mass = inputMass;
		fixed = inputFixed;
		index = inputIndex;
	}
	public void update(){
		x += deltax;
		y += deltay;
	}
}
