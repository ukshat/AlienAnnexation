package akshat.alienattack;

import java.awt.Graphics;

import akshat.alienattack.level.GameLevelManager;

public class TorpedoManager {
	
	private static TorpedoManager instance = 
			new TorpedoManager(GameLevelManager.getInstance().getCurrentLevel().getTorpedoCount());

	public static TorpedoManager getInstance() {
		return instance;
	}
	
	public static void notifyLevelChange() {
		instance = new TorpedoManager(GameLevelManager.getInstance().getCurrentLevel().getTorpedoCount());
	}
	
	private final Torpedo[] torpedoes;

	private TorpedoManager(int torpedoCount) {
		 torpedoes = new Torpedo[torpedoCount];
	}
	
	public boolean seatAvailable(){
		for(int i=0; i<torpedoes.length; i++){
			if(torpedoes[i]==null) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public void add(Torpedo torpedo){
		for(int i=0; i<torpedoes.length; i++){
			if(torpedoes[i]==null){
				torpedoes[i] = torpedo;
				break;
			}
		}
	}
	
	
	public void remove(Torpedo torpedo){
		for(int i=0; i<torpedoes.length; i++){
			if(torpedoes[i]==torpedo){
				torpedoes[i] = null;
				break;
			}
		}
	}
	
	
	public void move(){
		for(int i=0; i<torpedoes.length; i++){
			if(torpedoes[i]!=null) torpedoes[i].move();
		}
	}
	
	
	public void draw(Graphics canvas){
		for(int i=0; i<torpedoes.length; i++){
			if(torpedoes[i]!=null) torpedoes[i].draw(canvas);
		}
	}
	
}










