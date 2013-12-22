import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 *
 * @author Thomas H. Cormen 
 * @author Naho Kitade Modified for Editor.java use. EC.
 * @see Shape
 */
public class Ellipse extends Shape {
	private int myX;
	private int myY;
	private int myWidth;
	private int myHeight;
	
	/**
	 * Constructor for the Ellipse object
	 * @param x the x coordinate of the top left corner
	 * @param y the y coordinate of the top left corner
	 * @param width the width if the Ellipse
	 * @param height the height if the Ellipse
	 * @param theColor the color if the Ellipse
	 */
	public Ellipse(int x, int y, int width, int height, Color theColor){
		super(theColor); // color set in the super class.
		myX = x;
		myY = y;
		myWidth = width;
		myHeight = height;
	}
	
	/**
	 * set the top left corner x coordinate of the Ellipse to new x.
	 * @param x the new x coordinate to change to.
	 */
  public void setX(int x){
  	myX = x;
  }
  
	/**
	 * set the top left corner y coordinate of the Ellipse to new y.
	 * @param y the new y coordinate to change to.
	 */
  public void setY(int y){
  	myY = y;
  }
  
  /**
   * set the width of the ellipse to new width.
   * @param width new width to change to.
   */
  public void setWidth(int width){
		myWidth = width;
  }
  
  /**
   * set the height of the ellipse to new height.
   * @param width new height to change to.
   */
  public void setHeight(int height){
		myHeight = height;
  }
	
  /**
   * Draw the shape in the grapics page.
   * @param page graphics page to draw on.
   */
  public void drawShape(Graphics page){ 
  	page.fillOval(myX, myY, myWidth, myHeight);
  }
  
  /**
   * copy the Ellipse as a new Ellipse object.
   * @return the new copied Shape object
   */
  public Shape copyShape(){ 
  	Shape copiedShape = new Ellipse(myX, myY, myWidth, myHeight, color);
  	return copiedShape;
  }
  
  /**
   * returns a boolean of whether a point is contained in the shape.
   * @param p point to see whether the point is contained in shape.
   * @return boolean of whether a point is contained in shape.
   */
  public boolean containsPoint(Point p){ 
  	return pointInEllipse(p, myX, myY, myWidth, myHeight); // just call premade code
  }
  
  /**
   * move the shape.
   * @param deltaX distance to move the shape in x direction
   * @param deltaY distance to move the shape in y direction
   */
  public void move(int deltaX, int deltaY){ // move the Shape
  	myX += deltaX;
  	myY += deltaY;
  }
  
  /**
   * return the Shape's center
   * @return point of the center of the shape.
   */
  public Point getCenter(){ 
  	int centerX = (myX + (myX + myWidth))/2; // some math to get the centers.
  	int centerY = (myY + (myY + myHeight))/2;
  	return new Point(centerX, centerY);
  }
  
	
  // Helper method that returns whether Point p is in an Ellipse with the given
  // top left corner and size.
  private static boolean pointInEllipse(Point p, int left, int top, int width,
      int height) {
    double a = width / 2.0; // half of the width
    double b = height / 2.0; // half of the height
    double centerx = left + a; // x-coord of the center
    double centery = top + b; // y-coord of the center
    double x = p.x - centerx; // horizontal distance between p and center
    double y = p.y - centery; // vertical distance between p and center

    // Now we just apply the standard geometry formula.
    // (See CRC, 29th edition, p. 178.)
    return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
  }
}
