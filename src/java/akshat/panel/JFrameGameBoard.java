package akshat.panel;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JFrame;

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
	}
	
	@Override
	public Graphics getCanvas() {
		return panel.getGraphics();
	}

	@Override
	public void addKeyListener(KeyListener listener) {
		window.addKeyListener(listener);
	}

	@Override
	public void addMouseMotionListener(MouseMotionListener listener) {
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

	@Override
	public void setVisible(boolean visible) {
		window.setVisible(visible);
	}

	@Override
	public void add(JComponent comp) {
		panel.add(comp);
		
	}

}
