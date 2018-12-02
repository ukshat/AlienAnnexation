package akshat.alienattack.game;

import java.awt.Graphics;

import akshat.alienattack.game.level.GameLevelManager;

public class MissileManager {
	
	private static MissileManager instance = 
			new MissileManager(GameLevelManager.getCurrentLevel().getMissileCount());
	
	public static MissileManager getInstance() {
		return instance;
	}
	
	public void notifyLevelChange() {
		instance = new MissileManager(GameLevelManager.getCurrentLevel().getMissileCount());
	}
	
	private final Missile[] missiles;

	private MissileManager(int missileCount) {
		missiles = new Missile[missileCount];
	}	
	
	public boolean seatAvailable(){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]==null) return true;
		}
		return false;
	}
	
	
	public void add(Missile missile){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]==null){
				missiles[i] = missile;
				break;
			}
		}
	}
	
	
	public void remove(Missile missile){  
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]==missile){
				missiles[i] = null;
				break;
			}
		}
	}
	
	
	
	public void move(){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]!=null) missiles[i].move();
		}
	}
	
	
	public void draw(Graphics canvas){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]!=null) missiles[i].draw(canvas);
		}
	}
	
	
	public boolean isHit(Torpedo torpedo){
		for(int i=0; i<missiles.length; i++){
			if(missiles[i]!=null && missiles[i].isHit(torpedo)) return true;
		}
		return false;
	}
	
	
}












