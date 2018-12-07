package akshat.alienattack.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import akshat.alienattack.game.alien.Alien;
import akshat.alienattack.game.level.GameLevelManager;
import akshat.alienattack.state.Playing;
import akshat.sound.WAVPlayer;

public class Ship implements KeyListener, MouseMotionListener {

	private int x, y; // top center
	//private Color color = Color.red;
	private final int eachHeight;
	private int topWidth = 4, middleWidth = 20, bottomWidth = 60;
	private WAVPlayer laser;
	private boolean wasHit = false;
	private static Image 
		shipImage = new ImageIcon(Ship.class.getResource("/ship1.png")).getImage(),
		explosionImage = new ImageIcon(Ship.class.getResource("/explosion1.png")).getImage();
	private int width, height;
	
	
	public Ship(int x, int y){
		this.x = x;
		this.y = y;
		try {
			laser = new WAVPlayer(Ship.class.getResource("/laser.wav"));
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		eachHeight = 20;
		
		width = shipImage.getWidth(null);
		height = shipImage.getHeight(null);
	}
	
	public int getX(){return x;}
	
	public boolean isHit(Missile missile){
		
		if(     missile.getX()>=x-topWidth/2-Missile.getWidth()/2 &&
				missile.getX()<=x+topWidth/2+Missile.getWidth()/2 &&
				missile.getY()>=y &&
				missile.getY()<=y+eachHeight+Missile.getHeight()  ||
				
			    missile.getX()>=x-middleWidth/2-Missile.getWidth()/2 &&
				missile.getX()<=x+middleWidth/2+Missile.getWidth()/2 &&
				missile.getY()>=y+eachHeight &&
				missile.getY()<=y+2*eachHeight+Missile.getHeight()  ||
				
			    missile.getX()>=x-bottomWidth/2-Missile.getWidth()/2 &&
				missile.getX()<=x+bottomWidth/2+Missile.getWidth()/2 &&
				missile.getY()>=y+2*eachHeight &&
				missile.getY()<=y+3*eachHeight+Missile.getHeight()  ){
			
			Playing.gameOn = false;
			wasHit = true;
			return true;
		}
		
		
		return false;
	}
	
	
	
	public boolean isHit(Alien alien){
		
		if(     alien.getX()>=x-topWidth/2-alien.getWidth()/2 &&
				alien.getX()<=x+topWidth/2+alien.getWidth()/2 &&
				alien.getY()>=y &&
				alien.getY()<=y+eachHeight+alien.getHeight()  ||
				
			    alien.getX()>=x-middleWidth/2-alien.getWidth()/2 &&
				alien.getX()<=x+middleWidth/2+alien.getWidth()/2 &&
				alien.getY()>=y+eachHeight &&
				alien.getY()<=y+2*eachHeight+alien.getHeight()  ||
				
			    alien.getX()>=x-bottomWidth/2-alien.getWidth()/2 &&
				alien.getX()<=x+bottomWidth/2+alien.getWidth()/2 &&
				alien.getY()>=y+2*eachHeight &&
				alien.getY()<=y+3*eachHeight+alien.getHeight()  ){
			
			Playing.gameOn = false;
			wasHit = true;
			return true;
		}
		
		return false;
	}
	
	
	
	public void draw(Graphics canvas){
		/*
		canvas.setColor(color);
		canvas.drawRect(x-topWidth/2, y, topWidth, eachHeight); 
		canvas.drawRect(x-middleWidth/2, y+eachHeight, middleWidth, eachHeight);
		canvas.drawRect(x-bottomWidth/2, y+2*eachHeight, bottomWidth, eachHeight);
		*/
		if (wasHit) {
			canvas.drawImage(explosionImage, x-60, y, null);
		} else {
			canvas.drawImage(shipImage, x-width/2, y, null);
		}
	}



	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode==KeyEvent.VK_SPACE && TorpedoManager.getInstance().seatAvailable()){
			laser.play();
			TorpedoManager.getInstance().add( new Torpedo(x, y-Torpedo.getHeight(), 
					GameLevelManager.getCurrentLevel().getTorpedoVelocity()) );
		}
		
	}

	
	public void keyTyped(KeyEvent e) { }
	public void keyReleased(KeyEvent e) { }

	public void mouseDragged(MouseEvent e) {
		
	}


	public void mouseMoved(MouseEvent e) { 
		x = e.getX();
	}
}




















