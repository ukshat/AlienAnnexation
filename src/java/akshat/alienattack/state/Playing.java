package akshat.alienattack.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import akshat.alienattack.Coordinator;
import akshat.alienattack.game.AlienManager;
import akshat.alienattack.game.MissileManager;
import akshat.alienattack.game.Ship;
import akshat.alienattack.game.TorpedoManager;
import akshat.alienattack.game.level.AlienChallenge;
import akshat.alienattack.game.level.GameLevelManager;
import akshat.panel.DrawingBoardFactory;
import akshat.panel.GameBoard;
import akshat.sound.WAVPlayer;

public class Playing implements GameState {
	public static boolean gameOn;
	public static int score;
	private Font scoreFont = new Font("luminari", Font.ITALIC, 23); //athelas hoefler text impact superclarendon luminari marion
	private WAVPlayer bgSound;
	private GameBoard board;

	@Override
	public void initialize() {
		gameOn = false;
		score = 0;
		board = DrawingBoardFactory.createGameBoard(200, 0, Coordinator.SCREEN_WIDTH, 750, Coordinator.class.getResource("/bg1.png"));
		try {
			bgSound = new WAVPlayer(Coordinator.class.getResource("/bg1Music.wav"));
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		board.repaint();
	} 

	@Override
	public void enter() {
		board.setVisible(true);
		Graphics canvas = board.getCanvas();
		gameOn = true;
		
		/*
		 * This is the start of the game set up.
		 * Levels are introduced into the game here.
		 */
		Ship ship = new Ship(300, 590);
		
		board.addKeyListener(ship);
		board.addMouseMotionListener(ship); 
		bgSound.playLoop();

		canvas.setFont(scoreFont);

		while (gameOn){

			AlienManager.create(ship);
			AlienManager.move();
			TorpedoManager.getInstance().move();
			MissileManager.move();

			board.clear();
			if (AlienChallenge.NASTY_ALIEN.compareTo(AlienChallenge.CLOAK_ALIEN) < 0)
				System.out.println("Nasty Alien before Cloak Alien");

			ship.draw(canvas); 
			TorpedoManager.getInstance().draw(canvas);
			MissileManager.draw(canvas); 
			AlienManager.draw(canvas); 

			canvas.setColor(Color.white); 
			canvas.drawString("Score: " + score, 30, 30); 
//				board.repaint();

			try {
				Thread.sleep(GameLevelManager.getInstance().getCurrentLevel().getGameSpeed());
			} catch (InterruptedException e) { }
			/*
			 * Let's check score and decide if they go to the next level
			 */
			if (score > GameLevelManager.getInstance().getCurrentLevel().getScoreThreshold())
				break;			
		}
		bgSound.stop();
		board.setVisible(false);
		
	}

}
