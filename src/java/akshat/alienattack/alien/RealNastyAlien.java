package akshat.alienattack.alien;

import akshat.alienattack.Ship;

public class RealNastyAlien extends MultiShootAlien {

	public RealNastyAlien(int x, int y, int vx, int vy, Ship target){
		super(x, y, vx, vy, target); 
	}
	
	

	public void move(){ 
		super.move();

		x = (int)(0.98*x + 0.02*target.getX());  //(x + target.getX())/2;
	}
	
}
