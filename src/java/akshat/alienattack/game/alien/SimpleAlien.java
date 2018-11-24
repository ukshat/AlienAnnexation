package akshat.alienattack.game.alien;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import akshat.alienattack.Coordinator;
import akshat.alienattack.game.Missile;
import akshat.alienattack.game.MissileManager;
import akshat.alienattack.game.Ship;

public class SimpleAlien extends Alien {
	
	private static Image defaultImage = new ImageIcon(SimpleAlien.class.getResource("/greenAlien.png")).getImage();

	public SimpleAlien(int x, int y, int vx, int vy, Image image, Ship target) {
		super(x, y, vx, vy, image == null ? defaultImage: image, target);
	}
		
	public void shootMissile() {
		if (Math.random()<0.1 && MissileManager.seatAvailable()) {
			MissileManager.add( new Missile(x, y + Missile.getHeight(), 2*vy, target) );
		}
	}
	
}
