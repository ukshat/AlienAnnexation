package akshat.alienattack.game.alien;

import java.awt.Graphics;

import java.awt.Image;

import javax.swing.ImageIcon;

import akshat.alienattack.game.AlienManager;
import akshat.alienattack.game.Ship;
import akshat.alienattack.game.Torpedo;
import akshat.alienattack.state.Playing;

public abstract class Alien {
	private static Image explosionImage = new ImageIcon(Alien.class.getResource("/explosion1.png")).getImage();
	private static Image defaultImage = new ImageIcon(AlienManager.class.getResource("/blueAlien.png")).getImage();
	
	protected int x, y; // center. bottom
	protected int vx, vy;
	protected int width, height;
	protected Image alienImage; 
	protected boolean isCollided = false, wasHit = false;
	protected Ship target;

	public abstract void shootMissile();

	public Alien(int x, int y, int vx, int vy, Image image, Ship target){
		this.x = x;
		this.y  = y;
		this.vx = vx;
		this.vy = vy;
		this.alienImage = image == null ? defaultImage : image;
		width = alienImage.getWidth(null);
		height = alienImage.getHeight(null);
		this.target = target;
	}


	public int getX(){ return x; }
	public int getY(){ return y; }
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }

	public void move() {
		x += vx;
		y += vy;
		
		if(y>720) AlienManager.getInstance().remove(this); 
		
		if(x<0+width/2 || x>800-width/2) vx *= -1;
		
		shootMissile();
		isCollided = target.isHit(this);
	}

	public void draw(Graphics canvas) {
		if (wasHit || isCollided) {
			boolean exploded = canvas.drawImage(explosionImage, x, y, null);
			System.out.println((exploded ? "Exploded ":"Could not explode ") + "an alien");
			AlienManager.getInstance().remove(this);
		} else 
			canvas.drawImage(alienImage, x-width/2, y-height, null);
		
		if (isCollided){			
			Playing.gameOn = false;
		}
	}

	public boolean isHit(Torpedo torpedo) {

		if(torpedo.getX()>=x-width/2-Torpedo.getWidth()/2 &&
				torpedo.getX()<=x+width/2+Torpedo.getWidth()/2 &&
				torpedo.getY()>=y-height-Torpedo.getHeight()   &&
				torpedo.getY()<=y){

			Playing.score += 3;
			wasHit = true;
			
			
			return true;
		}

		return false;
	}

	/*
	public void shootMissile(){
		if(Math.random()<0.1 && MissileManager.seatAvailable()) {
			MissileManager.add( new Missile(x, y + Missile.getHeight(), 2*vy, target) );
		}

	}*/

}
