package akshat.alienattack.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

import akshat.alienattack.Coordinator;
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
		Graphics canvas = board.getCanvas();
		bgSound.playLoop();
		
		canvas.setColor(Color.white); 
		canvas.drawString("Welcome to Alien Attack!", 200, 200);
		
		JButton button = new JButton("Next level");
		button.setBounds(100, 100, 200, 50);
		button.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent evt) { ready = true; } });
		button.setVisible(true);
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
