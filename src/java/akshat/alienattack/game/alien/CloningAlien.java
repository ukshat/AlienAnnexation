package akshat.alienattack.game.alien;

import java.awt.Image;

import javax.swing.ImageIcon;

import akshat.alienattack.game.AlienManager;
import akshat.alienattack.game.Ship;

public class CloningAlien extends SimpleAlien {
	private static Image defaultImage = new ImageIcon(SimpleAlien.class.getResource("/orangeAlien.png")).getImage();

	protected int distance;
	protected int requiredDistance;
	protected boolean hasCloned;
	

	public CloningAlien(int x, int y, int vx, int vy, Ship target){
		super(x, y, vx, vy, defaultImage, target);
		distance = 0;
		requiredDistance = (int)(100 + 200*Math.random());
	}
	
	

	public void move(){
		super.move();
		
		if(!hasCloned && distance>requiredDistance){
			AlienManager.add(new CloningAlien(x, y, -vx, vy, target));
			hasCloned = true;
		}
		
		isCollided = target.isHit(this);
	}
	
	
}










