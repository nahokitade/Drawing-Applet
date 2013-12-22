import java.awt.Point;
/**
 *MoveCmd.java
 *
 *commands called when moveButton is pressed.
 *
 *@author Naho Kitade
 */
public class MoveCmd extends Command {
	private Point dragPoint = null;
	private Shape moveShape = null;
	
	/**
	 * gets shape that the mouse is on, and sets the drag point to p.
	 */
  public void executePress(Point p, Drawing dwg) { 
  	dragPoint = p;
  	moveShape = dwg.getFrontmostContainer(p);
  }
  
  /**
   * if there is a shape selected, move the shape the appropriate 
   * distance, and keep updating the drag point.
   */
  public void executeDrag(Point p, Drawing dwg) { 
  	if (!(moveShape == null)){
  		moveShape.move((p.x - dragPoint.x), (p.y - dragPoint.y));
  		dragPoint = p;
  	}
  }
}