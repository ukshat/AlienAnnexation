package akshat.panel;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JComponent;

/**
 * A Game Panel provides the means of manipulating a screen that will suffice for our game
 * design. The Panel can be implemented against an underlying technology such as Android
 * or jrJava.DrawingPanel.
 * 
 * @author akshatmehta
 *
 */
public interface GameBoard {
	/**
	 * We want to obtain a regular AWT Canvas object so that we can do all the drawing
	 * 
	 * @return Initialized Canvas suitable for the device we are running on
	 */
	public Graphics getCanvas();
	
	/**
	 * We have a key listening object that is interested in being notified when a key is
	 * pressed, depressed, etc.
	 * 
	 * @param listener the object that does the listener event processing
	 */
	public void addKeyListener(KeyListener listener);
	
	/**
	 * We have a mouse motion listening object that is interested in being notified when a 
	 * mouse is moved and when mouse is pressed, etc.
	 * 
	 * @param listener the object that does the listener event processing
	 */
	public void addMouseMotionListener(MouseMotionListener listener);

	/**
	 * Draw the image as the background of the gameboard
	 * 
	 * @param imageURL resolved URL of the requested image
	 * @throws IOException if the requested image cannot be found at the path specified
	 */
	public void setBackgroundImage(URL imageURL);

	/**
	 * Clear the canvas of all drawing.
	 */
	public void clear();

	/**
	 * We are done putting objects on the canvas and now want the canvas to be repainted
	 * to reflect everything we want on there.
	 */
	public void repaint();
	
	/**
	 * When we want to 
	 */
	public void setVisible(boolean visible);
	
	public void add(JComponent component);
}
