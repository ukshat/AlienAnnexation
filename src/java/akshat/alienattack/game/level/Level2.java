package akshat.alienattack.game.level;

import akshat.alienattack.game.Ship;
import akshat.alienattack.game.alien.Alien;
import akshat.alienattack.game.alien.CloakAlien;
import akshat.alienattack.game.alien.CloningAlien;
import akshat.alienattack.game.alien.InvisibleAlien;
import akshat.alienattack.game.alien.NastyAlien;
import akshat.alienattack.game.alien.SimpleAlien;

public final class Level2 implements GameLevel {

	@Override
	public int getGameSpeed() {
		return 45;
	}

	@Override
	public int getMissileCount() {
		return 15;
	}

	@Override
	public int getTorpedoCount() {
		return 8;
	}

	@Override
	public int getTorpedoVelocity() {
		return -15;
	}

	@Override
	public int getMissileVelocity() {
		return 12;
	}


	@Override
	public int getAlienCount() {
		return 11;
	}

	@Override
	public int getScoreThreshold() {
		// TODO Auto-generated method stub
		return 200;
	}

	@Override
	public Alien createNextAlien(int x, int y, int vx, int vy, Ship target) {
		// In Level 2, we create fewer Simple, Cloak, and Nasty aliens, but we create Invisible and Cloning aliens
		double coinFlip = Math.random();
		if (coinFlip < 0.2) 
			return new SimpleAlien(x, y, vx, vy, null, target);
		else if (coinFlip < 0.4)
			return new NastyAlien(x, y, vx, vy, target);
		else if (coinFlip < 0.6)
			return new CloakAlien(x, y, vx, vy, target);
		else if (coinFlip < 0.8)
			return new InvisibleAlien(x, y, vx, vy, target);
		else return new CloningAlien(x, y, vx, vy, target);
	}


}
