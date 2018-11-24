package akshat.alienattack.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import akshat.alienattack.Coordinator;
import akshat.alienattack.game.level.GameLevelManager;
import akshat.panel.DrawingBoardFactory;
import akshat.panel.GameBoard;
import akshat.sound.WAVPlayer;

public class GameOver implements GameState {

	private static final Image imageGO = new ImageIcon(Coordinator.class.getResource("/gameOver1.png")).getImage();
	private GameBoard board;
	private WAVPlayer bgSound;
	private boolean ready;
	
	@Override
	public void initialize() {
		board = DrawingBoardFactory.createGameBoard(200, 0, Coordinator.SCREEN_WIDTH, 750, Coordinator.class.getResource("/bg1.png"));
		try {
			bgSound = new WAVPlayer(Coordinator.class.getResource("/bg1Music.wav"));
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void enter() {
		board.setVisible(true);
		Graphics canvas = board.getCanvas();
		ready = false;
		int score = Playing.score;
		
		JLabel result = new JLabel("Score: " + score);
		result.setBounds(300, 175, 200, 50);
		result.setFont(new Font("Superclarendon", Font.BOLD, 24));
		result.setHorizontalTextPosition(SwingConstants.CENTER);
		result.setForeground(Color.white);

		JLabel message = new JLabel();
		message.setBounds(250, 275, 300, 50);
		message.setFont(new Font("Superclarendon", Font.BOLD, 18));
		message.setHorizontalTextPosition(SwingConstants.CENTER);
		message.setForeground(Color.white);

		boolean niceOrNot = Math.random() >= 0.5;
		switch (GameLevelManager.getInstance().getCurrentLevel().getAlienChallenge()) {
		case SIMPLE_ALIEN:
			message.setText(niceOrNot ? "That was sad :(" : "Better luck next time!");
			break;
		case CLOAK_ALIEN:
			message.setText(niceOrNot ? "Can't you get 100?" : "You can do better.");
			break;
		case NASTY_ALIEN:
			message.setText(niceOrNot ? "You're an alien serial killer!" : "Nice one! :]");
			break;
		case INVISIBLE_ALIEN:
		case MULTI_SHOOT_ALIEN:
		case CLONING_ALIEN:
		case REAL_NASTY_ALIEN:
		case IMMORTAL_ALIEN:
			message.setText("You win!!");
			break;
		}
		canvas.drawImage(imageGO, 0, 0, Coordinator.SCREEN_WIDTH, 750, null);

		JButton button = new JButton("New game");
		button.setBounds(300, 375, 200, 50);
		message.setHorizontalTextPosition(SwingConstants.CENTER);
		button.addActionListener(new ActionListener() {		    
			public void actionPerformed(ActionEvent evt) { ready = true; } }
		);

		board.add(result);
		board.add(message);
		board.add(button);
		board.repaint();

		try {
			do {
				Thread.sleep(1000);
			} while (!ready);
		} catch (InterruptedException e) { }
		
		board.setVisible(false);
		bgSound.stop();
		
	}

}
