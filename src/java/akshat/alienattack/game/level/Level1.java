package akshat.alienattack.game.level;

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
	public AlienChallenge getAlienChallenge() {
		return AlienChallenge.SIMPLE_ALIEN;
	}

	@Override
	public int getScoreThreshold() {
		return 100;
	}

}
