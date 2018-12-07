package akshat.alienattack.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import akshat.alienattack.Coordinator;
import akshat.alienattack.game.level.GameLevelManager;
import akshat.panel.DrawingBoardFactory;
import akshat.panel.GameBoard;
import akshat.sound.WAVPlayer;

public class LevelAdvance implements GameState {
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
		ready = false;
		bgSound.playLoop();

		String levelClassName = GameLevelManager.getCurrentLevel().getClass().getCanonicalName();
		int levelClass = Integer.parseInt(levelClassName.substring(levelClassName.length() - 1));

		JLabel result = new JLabel("Advancing to Level " + levelClass);
		result.setBounds(200, 175, 450, 50);
		result.setFont(new Font("Superclarendon", Font.BOLD, 24));
		result.setHorizontalTextPosition(SwingConstants.CENTER);
		result.setForeground(Color.white);

		JButton button = new JButton("Press to Start");
		button.setBounds(250, 275, 200, 50);
		button.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == ' ')
					e.consume();
			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ready = true;

			}
		});

		button.setVisible(true);

		board.add(result);
		board.add(button);
		board.repaint();
		try {
			do {
				Thread.sleep(1000);
			} while (!ready);
		} catch (InterruptedException e) { }

		board.remove(result);
		board.remove(button);

		board.setVisible(false);
		bgSound.stop();
	}

}
