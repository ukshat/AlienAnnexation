package akshat.alienattack.game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Torpedo {

	private int x, y; // center, top
	private int vy; // vy<0
	private static int width, height;
	//private static Color color;
	private static Image imageT, imageES, imageE;
	private boolean isCollidedWithAlien, isCollidedWithMissile;
	private static int explosionRadiusBig, explosionRadiusSmall;
	//private static Color explosionColorBig, explosionColorSmall;
	
	
	static {
		imageT = new ImageIcon(Torpedo.class.getResource("/torpedo1.png")).getImage();
		imageES = new ImageIcon(Torpedo.class.getResource("/explosionS.png")).getImage();
		imageE = new ImageIcon(Torpedo.class.getResource("/explosion1.png")).getImage();
		width = imageT.getWidth(null);
		height = imageT.getHeight(null); 
		//color = Color.blue;
		explosionRadiusBig = 60;
		explosionRadiusSmall = 40;
		//explosionColorBig = Color.orange;
		//explosionColorSmall = Color.magenta;
	}
	
	
	public Torpedo(int x, int y, int vy){
		this.x = x;
		this.y = y;
		this.vy = vy;
	}
	
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public static int getWidth(){ return width; }
	public static int getHeight(){ return height; }
	
	
	public void move(){
		y += vy;
		
		if(y<30) TorpedoManager.getInstance().remove(this); 
		
		isCollidedWithAlien = AlienManager.getInstance().isHit(this);
		isCollidedWithMissile = MissileManager.getInstance().isHit(this);
	}
	
	
	public void draw(Graphics canvas){
		//canvas.setColor(color);
		//canvas.drawRect(x-width/2, y, width, height);
		canvas.drawImage(imageT, x-width/2, y, null);
	
		if(isCollidedWithAlien){
			//canvas.setColor(explosionColorBig);
//			//canvas.drawOval(x-explosionRadiusBig, y-explosionRadiusBig, 2*explosionRadiusBig, 2*explosionRadiusBig);
			TorpedoManager.getInstance().remove(this); 
//			canvas.drawImage(imageE, x-explosionRadiusBig, y-explosionRadiusBig, null);
		}
		
		if(isCollidedWithMissile){
//			canvas.setColor(explosionColorSmall);
//			//canvas.drawOval(x-explosionRadiusSmall, y-explosionRadiusSmall, 2*explosionRadiusSmall, 2*explosionRadiusSmall);
			TorpedoManager.getInstance().remove(this);
//			canvas.drawImage(imageES, x-explosionRadiusSmall, y-explosionRadiusSmall, null);
		}
		
	}
	
}
 











