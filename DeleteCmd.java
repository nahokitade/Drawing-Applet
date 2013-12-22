import java.awt.Point;
/**
 * DeleteCmd.java
 * 
 * Command called when the deleteButton is pressed.
 * 
 * @author Naho Kitade
 */
public class DeleteCmd extends Command {
	
	/**
	 * deletes the front most shape that was clicked.
	 */
  public void executeClick(Point p, Drawing dwg) { 
  	dwg.deleteFrontmostContainer(p); // Most of the work done in Drawing.java
  }
}
