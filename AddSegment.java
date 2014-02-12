import java.awt.Point;


/**
 * AddSegment.java
 * 
 * Commands called after segmentButton is pressed.
 * 
 * @author Naho Kitade
 */

public class AddSegment extends Command{
	private Segment currentSegment = null;
	
	/**
	 * Adds a new segment at the point clicked with the length of 0, and the selected drawing color.
	 * @param p point of the mouse at event
	 * @param dwg the drawing on which to draw on.
	 */
	public void executePress(Point p, Drawing dwg) {
		currentSegment = new Segment(p.x, p.y, p.x, p.y, dwg.getDrawingColor()); // 0 length
		dwg.add(currentSegment); //Add segment into the Drawing object.
	}
	
	/**
	 * Keeps updating the X2 and Y2 of the newly created segment to the new mouse point.
	 * @param p point of the mouse at event
	 * @param dwg the drawing on which to draw on.
	 */
	public void executeDrag(Point p, Drawing dwg) {
		if (currentSegment != null) { // make sure that currentSegment exists
		// setting the new x and y points for the second segment point.
			currentSegment.setX2(p.x); 
			currentSegment.setY2(p.y);
		}
	}
}