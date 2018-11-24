package akshat.alienattack.game.alien;

import java.awt.Image;

import javax.swing.ImageIcon;

import akshat.alienattack.game.Ship;

public class NastyAlien extends SimpleAlien{
	private static Image defaultImage = new ImageIcon(NastyAlien.class.getResource("/purpleAlien.png")).getImage();

	public NastyAlien(int x, int y, int vx, int vy, Ship target) {
		super(x, y, vx, vy, defaultImage, target);
		
	}
	
	public void move(){
		super.move();
 		x = (int)(0.98*x + 0.02*target.getX());/// (x + target.getX())/2;
	}
}
