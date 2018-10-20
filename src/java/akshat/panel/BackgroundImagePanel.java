package akshat.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class BackgroundImagePanel extends JPanel {
	Image image;
	public BackgroundImagePanel(URL imageURL) {
		try {
			image = ImageIO.read(imageURL);
		} catch (IOException e) {
			throw new RuntimeException("There's a problem in the path " + imageURL + " of our background image", e);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		this.paintInternal(g);
	}
	
	public void clear() {
		this.paintInternal(this.getGraphics());
	}
	
	private void paintInternal(Graphics g) {
		g.drawImage(image, 0, 0, null, null);				
	}
}