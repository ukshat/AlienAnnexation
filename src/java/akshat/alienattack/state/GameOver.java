package akshat.alienattack.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		board.repaint();
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

		boolean nice = Math.random() >= 0.5;
		String levelClassName = GameLevelManager.getCurrentLevel().getClass().getCanonicalName();
		int levelClass = Integer.parseInt(levelClassName.substring(levelClassName.length() - 1));
		switch (levelClass) {
		case 1:
			message.setText(!nice ? "That was sad :(" : "Better luck next time!");
			break;
		case 2:
			message.setText(!nice ? "Can't you get 200?" : "You can do better.");
			break;
		case 3:
			message.setText(!nice ? "You're an alien serial killer!" : "Nice one! :]");
			break;
		case 4:
		case 5:
			message.setText("Congratulations, you win!!");
			break;
		}
		canvas.drawImage(imageGO, 0, 0, Coordinator.SCREEN_WIDTH, 750, null);

		JButton button = new JButton("New game");
		button.setBounds(300, 375, 200, 50);
		message.setHorizontalTextPosition(SwingConstants.CENTER);
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
