package akshat.alienattack.game.alien;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import akshat.alienattack.game.Ship;

public class InvisibleAlien extends SimpleAlien{
	protected float transparency = 0.0f; // completely opaque.
	private static Image defaultImage = new ImageIcon(SimpleAlien.class.getResource("/pinkAlien.png")).getImage();
	
	public InvisibleAlien(int x, int y, int vx, int vy, Ship target){
		super(x, y, vx, vy, defaultImage, target);
	}
	
	
	public void draw(Graphics canvas){
		super.draw(canvas);
		Graphics2D canvas2D = (Graphics2D) canvas;
		
		Composite original = canvas2D.getComposite();		
		
		Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
		canvas2D.setComposite(c);
		
		canvas2D.setComposite(original);

		if(isCollided){
			transparency = 1.0f;			
		}
	}
	
}
