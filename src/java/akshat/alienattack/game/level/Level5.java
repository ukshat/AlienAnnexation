package akshat.alienattack.game.level;

import akshat.alienattack.game.Ship;
import akshat.alienattack.game.alien.Alien;
import akshat.alienattack.game.alien.CloakAlien;
import akshat.alienattack.game.alien.ImmortalAlien;
import akshat.alienattack.game.alien.InvisibleAlien;
import akshat.alienattack.game.alien.MultiShootAlien;
import akshat.alienattack.game.alien.NastyAlien;
import akshat.alienattack.game.alien.RealNastyAlien;
import akshat.alienattack.game.alien.SimpleAlien;

public class Level5 implements GameLevel{

	@Override
	public int getAlienCount() {
		// TODO Auto-generated method stub
		return 15;
	}

	@Override
	public int getGameSpeed() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getTorpedoCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getTorpedoVelocity() {
		// TODO Auto-generated method stub
		return -13;
	}

	@Override
	public int getMissileVelocity() {
		// TODO Auto-generated method stub
		return 16;
	}

	@Override
	public int getScoreThreshold() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public Alien createNextAlien(int x, int y, int vx, int vy, Ship target) {
		// In Level 5, we create fewer Simple, Cloak, Nasty, Multi Shoot, Real Nasty, and Invisible aliens, but we create Immortal aliens
		double coinFlip = Math.random();
		if (coinFlip < 0.12) 
			return new SimpleAlien(x, y, vx, vy, null, target);
		else if (coinFlip < 0.24)
			return new NastyAlien(x, y, vx, vy, target);
		else if (coinFlip < 0.36)
			return new CloakAlien(x, y, vx, vy, target);
		else if (coinFlip < 0.48)
			return new InvisibleAlien(x, y, vx, vy, target);
		else if (coinFlip < 0.63)
			return new MultiShootAlien(x, y, vx, vy, target);
		else if (coinFlip < 0.78)
			return new RealNastyAlien(x, y, vx, vy, target);
		else
			return new ImmortalAlien(x, y, vx, vy, target);
	}
	
}
