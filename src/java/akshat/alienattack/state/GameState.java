package akshat.alienattack.state;

public interface GameState {

	/**
	 * A game state will need to load resources and get ready for prime time. Initialize doesn't take over and should
	 * return back as quickly as possible.
	 */
	void initialize();
	
	/**
	 * Entering a state means that the gameboard will keep control until the game is ready to exit
	 * out of this state
	 */
	void enter();

}
