package akshat.alienattack.alien;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import akshat.alienattack.Ship;

public class CloakAlien extends SimpleAlien{
	private static Image defaultImage = new ImageIcon(CloakAlien.class.getResource("/sortOfGreenAlien.png")).getImage();

	protected float transparency = 1.0f; // completely opaque.
	protected float cloakRate = 0.01f;
	
	
	public CloakAlien(int x, int y, int vx, int vy, Ship target){
		super(x, y, vx, vy, defaultImage, target);
	}
	
	
	public void draw(Graphics canvas){
		super.draw(canvas);
		Graphics2D canvas2D = (Graphics2D) canvas;
		
		Composite original = canvas2D.getComposite();
		
		transparency -= cloakRate;
		if(transparency<0) transparency = 0.0f;
		if(isCollided) transparency = 1.0f;
		
		Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency);
		canvas2D.setComposite(c);
		
		canvas2D.setComposite(original);
	}

}
