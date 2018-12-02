package akshat.alienattack.game.level;

import akshat.alienattack.game.Ship;
import akshat.alienattack.game.alien.Alien;
import akshat.alienattack.game.alien.CloakAlien;
import akshat.alienattack.game.alien.InvisibleAlien;
import akshat.alienattack.game.alien.MultiShootAlien;
import akshat.alienattack.game.alien.NastyAlien;
import akshat.alienattack.game.alien.SimpleAlien;

public class Level3 implements GameLevel{

	
	public int getAlienCount() {

		return 12;
	}

	@Override
	public int getGameSpeed() {
		
		return 35;
	}

	@Override
	public int getMissileCount() {
		
		return 20;
	}

	@Override
	public int getTorpedoCount() {
		
		return 6;
	}

	@Override
	public int getTorpedoVelocity() {
		
		return -15;
	}

	@Override
	public int getMissileVelocity() {
		
		return 14;
	}

	
	@Override
	public int getScoreThreshold() {
		// TODO Auto-generated method stub
		return 300;
	}
	
	@Override
	public Alien createNextAlien(int x, int y, int vx, int vy, Ship target) {
		// In Level 3, we create fewer Simple, Cloak, Nasty, and Invisible aliens, but we create Multi Shoot aliens
		double coinFlip = Math.random();
		if (coinFlip < 0.17) 
			return new SimpleAlien(x, y, vx, vy, null, target);
		else if (coinFlip < 0.34)
			return new NastyAlien(x, y, vx, vy, target);
		else if (coinFlip < 0.51)
			return new CloakAlien(x, y, vx, vy, target);
		else if (coinFlip < 0.68)
			return new InvisibleAlien(x, y, vx, vy, target);
		else
			return new MultiShootAlien(x, y, vx, vy, target);
	}


}
