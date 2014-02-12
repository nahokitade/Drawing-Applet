import java.awt.*;
/**
 * Command.java
 * Superclass for commands.
 * Provides empty definitions for the methods executeClick, executePress,
 * and executeDrag.
 * 
 * @author Naho Kitade
 */
public class Command {
  public void executeClick(Point p, Drawing dwg) { }
  public void executePress(Point p, Drawing dwg) { }
  public void executeDrag(Point p, Drawing dwg) { }
}
