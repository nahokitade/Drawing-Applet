import java.awt.Point;


/**
 * AddRectangle.java
 * @author Naho Kitade
 */

public class AddRectangle extends Command{
	private Point pressedPoint;
	private Rectangle currentRect = null;
	
	/**
	 * Store the point that was pressed and create a rectangle with 0 area with the top left corner
	 * being the pressed point.
	 * @param p point of the mouse at event
	 * @param dwg the drawing on which to draw on.
	 */
	public void executePress(Point p, Drawing dwg) {
		pressedPoint = p;
		currentRect = new Rectangle(p.x, p.y, 0, 0, dwg.getDrawingColor());
		dwg.add(currentRect); //add the rectangle in the drawing.
	}
	
	/**
	 * keep appropriately updating the x, y, width and height of the new rectangle.
	 * @param p point of the mouse at event
	 * @param dwg the drawing on which to draw on.
	 */
	public void executeDrag(Point p, Drawing dwg) {
		if (currentRect != null) { // make sure that currentRect exists
		//Find which point should be the top left corner.
			currentRect.setX(Math.min(p.x, pressedPoint.x)); 
			currentRect.setY(Math.min(p.y, pressedPoint.y));
			//Find distance between the x and y coordinates to update the dimentions of the rectangle.
			currentRect.setWidth(Math.abs(p.x - pressedPoint.x));
			currentRect.setHeight(Math.abs(p.y - pressedPoint.y));
		}
	}
}