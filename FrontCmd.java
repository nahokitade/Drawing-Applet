import java.awt.Point;
/**
 * FrontCmd.java
 * 
 * Command called when the frontButton is pressed.
 * 
 * @author Naho Kitade
 */
public class FrontCmd extends Command {
	
	/**
	 * bring the selected shape to the front.
	 */
  public void executeClick(Point p, Drawing dwg) { 
  	dwg.bringFrontFrontmostContainer(p); // Most of the work done in Drawing.java
  }
}
