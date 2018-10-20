package akshat.panel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.RepaintManager;

class JFrameGameBoard implements GameBoard {
	
	private final JFrame window;
	private BackgroundImagePanel panel;
	
	public JFrameGameBoard(int x, int y, int width, int height, URL backgroundImageURL) {
		window = new JFrame("Alien Attack");
		window.setBounds(x, y, width, height);
		panel = new BackgroundImagePanel(backgroundImageURL);
		window.getContentPane().add(panel);
		panel.setOpaque(true);
		window.getContentPane().validate();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	@Override
	public Graphics getCanvas() {
		return panel.getGraphics();
	}

	@Override
	public void addKeyListener(KeyListener listener) {
		// TODO Auto-generated method stub
		window.addKeyListener(listener);
	}

	@Override
	public void addMouseMotionListener(MouseMotionListener listener) {
		// TODO Auto-generated method stub
		window.addMouseMotionListener(listener);
	}

	@Override
	public void setBackgroundImage(URL backgroundImageURL) {
		window.getContentPane().remove(panel);
		panel = new BackgroundImagePanel(backgroundImageURL);
		window.getContentPane().add(panel);
		panel.setOpaque(true);
		repaint();
	}

	@Override
	public void clear() {
		panel.clear();
	}

	@Override
	public void repaint() {
		panel.repaint();
	}

}
