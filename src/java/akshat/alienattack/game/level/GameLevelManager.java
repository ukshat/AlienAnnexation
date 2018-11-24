package akshat.alienattack.game.level;

public class GameLevelManager {
	private static final GameLevelManager instance = new GameLevelManager();
	public static GameLevelManager getInstance() {
		return instance;
	}
	
	private static GameLevel currentLevel;
	
	private GameLevelManager() {
		currentLevel = new Level1();
	}
	
	public GameLevel getCurrentLevel() {
		return currentLevel;
	}
	
	public static void advanceLevel() {
		if (currentLevel.getClass().equals(Level1.class)) {
			GameLevelManager.currentLevel = new Level2();
		}
	}
}