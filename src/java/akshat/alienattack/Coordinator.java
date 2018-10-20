package akshat.alienattack;

import java.awt.*;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import akshat.alienattack.level.GameLevel;
import akshat.alienattack.level.GameLevelManager;
import akshat.panel.DrawingBoardFactory;
import akshat.panel.GameBoard;
import akshat.sound.WAVPlayer;

public class Coordinator {

	public static boolean gameOn = true;
	public static int score;
	public static int scoreB = score;
	public static final int SCREEN_WIDTH = 800;

	private static final Image imageGO = new ImageIcon(Coordinator.class.getResource("/gameOver1.png")).getImage();

	public static void main(String[] args) {

		GameBoard board = DrawingBoardFactory.createGameBoard(200, 0, SCREEN_WIDTH, 750, Coordinator.class.getResource("/bg1.png"));
		Graphics canvas = board.getCanvas();

		try {
			/*
			 * This is the start of the game set up.
			 * Levels are introduced into the game here.
			 */
			Ship ship = new Ship(300, 590);
			
			board.addKeyListener(ship);
			board.addMouseMotionListener(ship); 
			
			WAVPlayer bgSound = new WAVPlayer(Coordinator.class.getResource("/bg1Music.wav"));
			bgSound.playLoop();
	
			Font scoreFont = new Font("luminari", Font.ITALIC, 23); //athelas hoefler text impact superclarendon luminari marion
			Font scoreFontB = new Font("impact", Font.BOLD, 45);
			canvas.setFont(scoreFont);
	
			while(gameOn){
	
				AlienManager.create(ship);
				AlienManager.move();
				TorpedoManager.getInstance().move();
				MissileManager.move();
	
				board.clear();
	
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
				
				if(score>=100) GameLevelManager.advanceLevel();
			}
			
			canvas.setFont(scoreFontB);
			try {
				Thread.sleep(1975);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			double rand3 = Math.random();
			if(score<50){
				if(rand3>=0.5)canvas.drawString("Score: " + score + " 	 Better luck next time!", 75, 700);
				if(rand3<0.5)canvas.drawString("Score: " + score + "  	That was sad :(", 75, 700);
				canvas.drawImage(imageGO, 0, 0, SCREEN_WIDTH, 750, null);
			}
			else if(score>=50 && score<100){
				if(rand3>=0.5)canvas.drawString("Score: " + score + " 	 You can do better.", 75, 700);
				if(rand3<0.5)canvas.drawString("Score: " + score + " 	 Can't you get 100?", 75, 700);
				canvas.drawImage(imageGO, 0, 0, SCREEN_WIDTH, 750, null);
			}
			else if(score>=100 && score<500){
				if(rand3>=0.5)canvas.drawString("Score: " + score + "  You're an alien serial killer!", 30, 700);
				if(rand3<0.5)canvas.drawString("Score: " + score + " 	Nice one! :]", 75, 700);
				canvas.drawImage(imageGO, 0, 0, SCREEN_WIDTH, 750, null);
			}		
	
			else if(score>=500 && score<1000){
				canvas.drawString("Score: " + score + "    You win!!", 75, 700);
				canvas.drawImage(imageGO, 0, 0, SCREEN_WIDTH, 750, null);
			}
			
			board.repaint();
			bgSound.stop();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		
	} 

}







