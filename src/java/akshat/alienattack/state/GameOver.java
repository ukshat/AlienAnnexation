package akshat.alienattack.state;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import akshat.alienattack.Coordinator;
import akshat.panel.DrawingBoardFactory;
import akshat.panel.GameBoard;

public class GameOver implements GameState {

	private static final Image imageGO = new ImageIcon(Coordinator.class.getResource("/gameOver1.png")).getImage();
	private GameBoard board;
	
	@Override
	public void initialize() {
		board = DrawingBoardFactory.createGameBoard(200, 0, Coordinator.SCREEN_WIDTH, 750, Coordinator.class.getResource("/bg1.png"));
	}

	@Override
	public void enter() {
		board.setVisible(true);
		Graphics canvas = board.getCanvas();

		int score = Playing.score;
		Font scoreFontB = new Font("impact", Font.BOLD, 45);
		
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
			canvas.drawImage(imageGO, 0, 0, Coordinator.SCREEN_WIDTH, 750, null);
		}
		else if(score>=50 && score<100){
			if(rand3>=0.5)canvas.drawString("Score: " + score + " 	 You can do better.", 75, 700);
			if(rand3<0.5)canvas.drawString("Score: " + score + " 	 Can't you get 100?", 75, 700);
			canvas.drawImage(imageGO, 0, 0, Coordinator.SCREEN_WIDTH, 750, null);
		}
		else if(score>=100 && score<500){
			if(rand3>=0.5)canvas.drawString("Score: " + score + "  You're an alien serial killer!", 30, 700);
			if(rand3<0.5)canvas.drawString("Score: " + score + " 	Nice one! :]", 75, 700);
			canvas.drawImage(imageGO, 0, 0, Coordinator.SCREEN_WIDTH, 750, null);
		}		

		else if(score>=500 && score<1000){
			canvas.drawString("Score: " + score + "    You win!!", 75, 700);
			canvas.drawImage(imageGO, 0, 0, Coordinator.SCREEN_WIDTH, 750, null);
		}
		
		board.repaint();
		board.setVisible(false);
	
		
	}

}
