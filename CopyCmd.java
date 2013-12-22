import java.awt.Point;
/**
 *CopyCmd.java
 *
 *Command called when copyButton is pressed
 *
 *@author Naho Kitade
 */
public class CopyCmd extends Command {
	private Point dragPoint = null;
	private Shape moveShapeCopy = null;
	
	/**
	 * Gets the selected shape, and the index of that shape in the drawingArrayList, 
	 * copies that shape, and puts that copied shape right in front of the original selected
	 * shape.
	 */
  public void executePress(Point p, Drawing dwg) { 
  	dragPoint = p;
  	Shape moveShape = dwg.getFrontmostContainer(p);
  	int originalShapeIndex = dwg.getFrontmostContainerIndex(p);
  	moveShapeCopy = moveShape.copyShape();
  	dwg.addAtIndex(originalShapeIndex, moveShapeCopy);
  }
  
  /**
   * Same drag command as the MoveCmd, but now with the copied shape.
   */
  public void executeDrag(Point p, Drawing dwg) { 
  	if (!(moveShapeCopy == null)){
  		moveShapeCopy.move((p.x - dragPoint.x), (p.y - dragPoint.y));
  		dragPoint = p;
  	}
  }
}