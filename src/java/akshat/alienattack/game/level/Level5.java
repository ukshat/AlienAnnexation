package akshat.alienattack.game.level;

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
	public AlienChallenge getAlienChallenge() {
		// TODO Auto-generated method stub
		return AlienChallenge.IMMORTAL_ALIEN;
	}
	
	@Override
	public int getScoreThreshold() {
		// TODO Auto-generated method stub
		return 500;
	}


	
}
