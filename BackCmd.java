import java.awt.Point;
/**
 *BackCmd.java
 *
 *Command called when backButton is pressed.
 *
 *@author Naho Kitade
 */

public class BackCmd extends Command {
	
	/**
	 * Brings the selected shape to back.
	 */
  public void executeClick(Point p, Drawing dwg) { 
  	dwg.bringBackFrontmostContainer(p); //Most of work done in Drawing.java
  }
}
