package akshat.alienattack.alien;

import java.awt.*;

import javax.swing.ImageIcon;

import akshat.alienattack.*;

public class ImmortalAlien extends SimpleAlien{
	private static Image defaultImage = new ImageIcon(SimpleAlien.class.getResource("/yellowAlien.png")).getImage();

	public ImmortalAlien(int x, int y, int vx, int vy, Ship target) {
		super(x, y, vx, vy, defaultImage, target);
	}

	public boolean isHit(Torpedo torpedo){

		if(torpedo.getX()>=x-width/2-Torpedo.getWidth()/2 &&
				torpedo.getX()<=x+width/2+Torpedo.getWidth()/2 &&
				torpedo.getY()>=y-height-Torpedo.getHeight()   &&
				torpedo.getY()<=y){
 
		}

		return false;
	}

}
