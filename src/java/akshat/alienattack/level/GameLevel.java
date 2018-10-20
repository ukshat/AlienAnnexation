package akshat.alienattack.level;

/**
 * The game level is a mechanism to control speeds and density of various actors - ships and aliens -
 * in the game. At any time the game is in a single level. 
 * 
 * @author akshatmehta
 *
 */
public interface GameLevel {
		
	public int getGameSpeed();
	
	public int getMissileCount();
	
	public int getTorpedoCount();
	
	public int getTorpedoVelocity();
	
	public int getMissileVelocity();
	
	public AlienChallenge getAlienChallenge();
}
