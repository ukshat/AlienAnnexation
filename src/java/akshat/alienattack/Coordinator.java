package akshat.alienattack;

import akshat.alienattack.game.level.GameLevelManager;
import akshat.alienattack.state.GameOver;
import akshat.alienattack.state.GameState;
import akshat.alienattack.state.LevelAdvance;
import akshat.alienattack.state.Playing;
import akshat.alienattack.state.Welcome;

public class Coordinator {
	public static final int SCREEN_WIDTH = 800;

	public static void main(String[] args) {

		GameState welcome = new Welcome();
		GameState playingState = new Playing();
		GameState overState = new GameOver();
		GameState advanceState = new LevelAdvance();
		welcome.initialize();
		playingState.initialize();
		advanceState.initialize();
		overState.initialize();

		/* Welcome the user and orient them towards the game
		 * When the player "starts" the game, we will switch to the playing game board.
		 * While the game is being played, the board remains active
		 * When the player reaches some milestone, we switch into another "welcome" board and tell the player
		 * they are moving to the next level
		 * When the player "enters" the next level, we will switch to the game board with the next level
		 * In the end, when the game is over, we will switch into another board where the player can choose to restart
		 * or quit.   
		 */
		welcome.enter();
		do {
			playingState.enter();
			if (Playing.gameOn) {
				// we are still playing but need to go to next level
				GameLevelManager.advanceLevel();
				advanceState.enter();
			} else {
				overState.enter();
				playingState.initialize();
			}
		} while (true);
	} 

}







