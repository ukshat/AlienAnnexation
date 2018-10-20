package akshat.alienattack.alien;

import java.awt.Image;

import javax.swing.ImageIcon;

import akshat.alienattack.Missile;
import akshat.alienattack.MissileManager;
import akshat.alienattack.Ship;

public class MultiShootAlien extends SimpleAlien{
	private static Image defaultImage = new ImageIcon(MultiShootAlien.class.getResource("/sortOfGreenAlien.png")).getImage();

	public MultiShootAlien(int x, int y, int vx, int vy, Ship target) {
		super(x, y, vx, vy, defaultImage, target);
		 
		  
	}
	public void shootMissile(){
		if(Math.random()<0.1 && MissileManager.seatAvailable()) {
			MissileManager.add( new Missile(x - width/4, y + Missile.getHeight(), 2*vy, target) );
			MissileManager.add( new Missile(x, y + Missile.getHeight(), 2*vy, target) );
			MissileManager.add( new Missile(x + width/4, y + Missile.getHeight(), 2*vy, target) );
		}
		
	}

}
