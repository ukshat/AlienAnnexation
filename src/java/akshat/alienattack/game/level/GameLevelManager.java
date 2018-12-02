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
	
	public static GameLevel getCurrentLevel() {
		return currentLevel;
	}
	
	public static void advanceLevel() {
		String levelClass = GameLevelManager.getCurrentLevel().getClass().getCanonicalName();
		switch (levelClass.substring(levelClass.length() - 1)) {
		case "1":
			GameLevelManager.currentLevel = new Level2();
			break;
		case "2":
			GameLevelManager.currentLevel = new Level3();
			break;
		case "3":
			GameLevelManager.currentLevel = new Level4();
			break;
		case "4":
			GameLevelManager.currentLevel = new Level5();
			break;
		}
	}
}