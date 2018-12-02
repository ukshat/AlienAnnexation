package akshat.alienattack.game.level;

import akshat.alienattack.game.Ship;
import akshat.alienattack.game.alien.Alien;
import akshat.alienattack.game.alien.CloakAlien;
import akshat.alienattack.game.alien.NastyAlien;
import akshat.alienattack.game.alien.SimpleAlien;

public final class Level1 implements GameLevel {

	@Override
	public int getGameSpeed() {
		return 50;
	}

	public int getAlienCount() {
		return 10;
		
	}
	
	@Override
	public int getMissileCount() {
		return 10;
	}

	@Override
	public int getTorpedoCount() {               
		return 10;
	}

	@Override
	public int getTorpedoVelocity() {
		return -15;
	}

	@Override
	public int getMissileVelocity() {
		return 10;
	}

	@Override
	public int getScoreThreshold() {
		return 100;
	}

	@Override
	public Alien createNextAlien(int x, int y, int vx, int vy, Ship target) {
		// In Level 1, we create Simple aliens, Nasty aliens, and Cloak aliens
		double coinFlip = Math.random();
		if (coinFlip < 0.34) {
			return new SimpleAlien(x, y, vx, vy, null, target);
		} else if (coinFlip < 0.67)
			return new NastyAlien(x, y, vx, vy, target);
		else
			return new CloakAlien(x, y, vx, vy, target);
	}

}
