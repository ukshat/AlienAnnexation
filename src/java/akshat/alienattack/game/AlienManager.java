package akshat.alienattack.game;

import java.awt.Graphics;

import akshat.alienattack.Coordinator;
import akshat.alienattack.game.alien.*;
import akshat.alienattack.game.level.GameLevelManager;

public class AlienManager {

	private static AlienManager instance = 
			new AlienManager(GameLevelManager.getCurrentLevel().getAlienCount());
	
	public static AlienManager getInstance() {
		return instance;
	}
	
	public void notifyLevelChange() {
		instance = new AlienManager(GameLevelManager.getCurrentLevel().getAlienCount());
	}
	
	private final Alien[] aliens;

	private AlienManager(int alienCount) {
		aliens = new Alien[alienCount];
	}
	
	public void create(Ship target){
		// a small chance that we won't even create an alien
		if(Math.random()>0.05) return; 

		for (int i=0; i < aliens.length; i++){
			// let's find the first alien slot that is empty
			// any time the alien is hit, its slot is made empty
			if (aliens[i] == null){
				int x = (int)(Math.random()*Coordinator.SCREEN_WIDTH);
				int y = 0;
				int vx = (int)(Math.random()*11-5);
				int vy = (int)(Math.random()*5+3);
				aliens[i] = GameLevelManager.getCurrentLevel().createNextAlien(x, y, vx, vy, target);
				
				break;
			}
		}

	}


	public void remove(Alien alien){ 
		for (int i = 0; i < aliens.length; i++){
			if (aliens[i]==alien){
				aliens[i] = null;
				break;
			}
		}
	}


	public boolean isHit(Torpedo torpedo){
		
		for (int i=0; i < aliens.length; i++){
			if (aliens[i]!=null && aliens[i].isHit(torpedo)) 
				return true;
		}
		return false;
	}


	public void move(){
		for (int i=0; i<aliens.length; i++){ 
			if (aliens[i]!=null) 
				aliens[i].move();
		}

	}


	public void draw(Graphics canvas){
		for (int i=0; i<aliens.length; i++){ 
			if (aliens[i]!=null) 
				aliens[i].draw(canvas); 
		}
	}


	public void add(Alien alien) {

		for (int i=0; i<aliens.length; i++){
			if (aliens[i]==null){
				aliens[i] = alien;
				break;
			}
		}
	}
}
