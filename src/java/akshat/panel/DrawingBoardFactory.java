package akshat.panel;

import java.net.URL;

/**
 * This class is used to produce Panels that can provide all the capabilities
 * of the canvas used to make a game. The class will produce an object with
 * the interface we want with all the functions of a panel.
 * 
 * @author akshatmehta
 *
 */
public final class DrawingBoardFactory {	
	/**
	 * We want to create a GameBoard the provides facilities to create canvas
	 * and listen for events.
	 * 
	 * @return GameBoard that implements various canvas/events.
	 */
	public final static GameBoard createGameBoard(int x, int y, int width, int height, URL backgroundImageURL) {
//		return new JrJavaDrawingBoard(x, y, width, height);
		return new JFrameGameBoard(x, y, width, height, backgroundImageURL);
	}
}
