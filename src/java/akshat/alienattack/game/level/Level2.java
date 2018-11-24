package akshat.alienattack.game.level;

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
	public AlienChallenge getAlienChallenge() {
		return AlienChallenge.CLOAK_ALIEN;
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


}
