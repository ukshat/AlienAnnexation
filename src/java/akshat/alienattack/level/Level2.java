package akshat.alienattack.level;

public final class Level2 implements GameLevel {

	@Override
	public int getGameSpeed() {
		return 30;
	}

	@Override
	public int getMissileCount() {
		return 10;
	}

	@Override
	public int getTorpedoCount() {
		return 30;
	}

	@Override
	public int getTorpedoVelocity() {
		return -15;
	}

	@Override
	public int getMissileVelocity() {
		return 15;
	}

	@Override
	public AlienChallenge getAlienChallenge() {
		return AlienChallenge.CLOAK_ALIEN;
	}

}
