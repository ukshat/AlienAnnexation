package akshat.alienattack.game.level;

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
	public AlienChallenge getAlienChallenge() {
		return AlienChallenge.NASTY_ALIEN;
	}
	
	@Override
	public int getScoreThreshold() {
		// TODO Auto-generated method stub
		return 300;
	}


}
