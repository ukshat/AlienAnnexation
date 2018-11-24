package akshat.alienattack.game;

import java.awt.Graphics;

import akshat.alienattack.game.level.GameLevelManager;

public class MissileManager {

	
	private static Missile[] missiles = new Missile[GameLevelManager.getInstance().getCurrentLevel().getMissileCount()];
	
	
	public static boolean seatAvailable(){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]==null) return true;
		}
		return false;
	}
	
	
	public static void add(Missile missile){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]==null){
				missiles[i] = missile;
				break;
			}
		}
	}
	
	
	public static void remove(Missile missile){  
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]==missile){
				missiles[i] = null;
				break;
			}
		}
	}
	
	
	
	public static void move(){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]!=null) missiles[i].move();
		}
	}
	
	
	public static void draw(Graphics canvas){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]!=null) missiles[i].draw(canvas);
		}
	}
	
	
	public static boolean isHit(Torpedo torpedo){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]!=null && missiles[i].isHit(torpedo)) return true;
		}
		return false;
	}
	
	
}












