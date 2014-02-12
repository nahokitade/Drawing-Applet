import java.awt.Point;


	/**
	 * AddEllipse.java
	 * 
	 * Commands called after ellipseButton is pressed. 
	 * 
	 * @author Naho Kitade
	 */


public class AddEllipse extends Command{
	private Point pressedPoint;
	private Ellipse currentEllipse = null;
	
	/**
	 * Store the point that was pressed and create a ellipse with 0 area with the top left corner
	 * being the pressed point.
	 * @param p point of the mouse at event
	 * @param dwg the drawing on which to draw on.
	 */
	public void executePress(Point p, Drawing dwg) {
		pressedPoint = p;
		currentEllipse = new Ellipse(p.x, p.y, 0, 0, dwg.getDrawingColor());
		dwg.add(currentEllipse);
	}
	
	/**
	 * keep appropriately updating the x, y, width and height of the new ellipse.
	 * @param p point of the mouse at event
	 * @param dwg the drawing on which to draw on.
	 */
	public void executeDrag(Point p, Drawing dwg) {
		if (currentEllipse != null) { // make sure that currentEllipse exists
			//Math same as AddRectangle.java
			currentEllipse.setX(Math.min(p.x, pressedPoint.x));
			currentEllipse.setY(Math.min(p.y, pressedPoint.y));
			currentEllipse.setWidth(Math.abs(p.x - pressedPoint.x));
			currentEllipse.setHeight(Math.abs(p.y - pressedPoint.y));
		}
	}
}