package akshat.alienattack.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import akshat.alienattack.Coordinator;
import akshat.panel.DrawingBoardFactory;
import akshat.panel.GameBoard;
import akshat.sound.WAVPlayer;
import javafx.scene.input.MouseEvent;

public class Welcome implements GameState {
	private GameBoard board;
	private WAVPlayer bgSound;
	private boolean ready;


	public void initialize() {
		ready = false;
		board = DrawingBoardFactory.createGameBoard(200, 0, Coordinator.SCREEN_WIDTH, 750, Coordinator.class.getResource("/bg1.png"));
		try {
			bgSound = new WAVPlayer(Coordinator.class.getResource("/bg1Music.wav"));
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
	} 


	public void enter() {

		JLabel welcome = new JLabel("Alien Attack");
		welcome.setBounds(300, 275, 200, 50);
		welcome.setFont(new Font("Superclarendon", Font.BOLD, 24));
		welcome.setHorizontalTextPosition(SwingConstants.CENTER);
		welcome.setForeground(Color.white);
		JButton button = new JButton("Start game");
		button.setBounds(250, 375, 300, 50);
		welcome.setHorizontalTextPosition(SwingConstants.CENTER);
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
		JLabel credit = new JLabel("Producer: Akshat Mehta");
		credit.setBounds(250, 575, 300, 50);
		credit.setFont(new Font("Superclarendon", Font.PLAIN, 18));
		credit.setHorizontalTextPosition(SwingConstants.CENTER);
		credit.setForeground(Color.lightGray);

		board.setVisible(true);
		bgSound.playLoop();
		board.add(welcome);
		board.add(button);
		board.add(credit);
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
