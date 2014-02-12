import java.awt.*;

/**
 * Rectangle.java
 * @author Naho Kitade
 */

public class Rectangle extends Shape {
	private int myX;
	private int myY;
	private int myWidth;
	private int myHeight;

	/**
	 * Constructor for the Rectangle object
	 * @param x the x coordinate of the top left corner
	 * @param y the y coordinate of the top left corner
	 * @param width the width if the Rectangle
	 * @param height the height if the Rectangle
	 * @param theColor the color if the Rectangle
	 */
	public Rectangle(int x, int y, int width, int height, Color theColor){
		super(theColor);
		myX = x;
		myY = y;
		myWidth = width;
		myHeight = height;
	}
	
  /**
   * Draw the shape in the grapics page.
   * @param page graphics page to draw on.
   */
  public void drawShape(Graphics page){ // draw the Shape
  	page.fillRect(myX, myY, myWidth, myHeight);
  }
  
  /**
   * copy the Rectangle as a new Rectangle object.
   * @return the new copied Shape object
   */
  public Shape copyShape(){
  	Shape copiedShape = new Rectangle(myX, myY, myWidth, myHeight, color);
  	return copiedShape;
  }
  
	/**
	 * set the top left corner x coordinate of the Rectangle to new x.
	 * @param x the new x coordinate to change to.
	 */
  public void setX(int x){
  	myX = x;
  }
  
	/**
	 * set the top left corner y coordinate of the Rectangle to new y.
	 * @param y the new y coordinate to change to.
	 */
  public void setY(int y){
  	myY = y;
  }
  
  /**
   * set the width of the Rectangle to new width.
   * @param width new width to change to.
   */
  public void setWidth(int width){
		myWidth = width;
  }
  
  /**
   * set the height of the Rectangle to new height.
   * @param width new height to change to.
   */
  public void setHeight(int height){
		myHeight = height;
  }
  
  /**
   * returns a boolean of whether a point is contained in the shape.
   * @param p point to see whether the point is contained in shape.
   * @return boolean of whether a point is contained in shape.
   */
  public boolean containsPoint(Point p){ 
  	// contains the point if the x and y is with in the right, left, top, bottom bounds of the rectangle.
  	return ((myX < p.x) && (p.x < (myX + myWidth)) && ((myY + myHeight) > p.y  && p.y > myY)) ;
  }
  
  /**
   * move the shape.
   * @param deltaX distance to move the shape in x direction
   * @param deltaY distance to move the shape in y direction
   */
  public void move(int deltaX, int deltaY){
  	myX += deltaX;
  	myY += deltaY;
  }
  
  /**
   * return the Shape's center
   * @return point of the center of the shape.
   */
  public Point getCenter(){ 
  	int centerX = (myX + (myX + myWidth))/2;
  	int centerY = (myY + (myY + myHeight))/2;
  	return new Point(centerX, centerY);
  }
}
