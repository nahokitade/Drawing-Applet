import java.awt.*;

/**
 * AddSegment.java
 * @author Naho Kitade
 */
public class Segment extends Shape {
	private int myX;
	private int myY;
	private int myX2;
	private int myY2;
	
	/**
	 * Constructor for the Segment object
	 * @param x the x coordinate of the first point
	 * @param y the y coordinate of the first point
	 * @param x2 the x coordinate of the second point
	 * @param y the y coordinate of the second point
	 * @param theColor the color if the Segment
	 */
	public Segment(int x, int y, int x2, int y2, Color theColor){
		super(theColor);
		myX = x;
		myY = y;
		myX2 = x2;
		myY2 = y2;
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
   * set the top left corner x2 coordinate of the Ellipse to new x2.
   * @param x2 the new x2 coordinate to change to.
   */
  public void setX2(int x2){
		myX2 = x2;
  }
  
  /**
   * set the top left corner y2 coordinate of the Ellipse to new y2.
   * @param y2 the new y2 coordinate to change to.
   */
  public void setY2(int y2){
		myY2 = y2;
  }
	
  /**
   * Draw the shape in the grapics page.
   * @param page graphics page to draw on.
   */
  public void drawShape(Graphics page){ // draw the Shape
		// Draw the segment.
		page.drawLine(myX, myY, myX2, myY2);
  }
  
  /**
   * copy the Ellipse as a new Segment object.
   * @return the new copied Shape object
   */
  public Shape copyShape(){
  	Shape copiedShape = new Segment(myX, myY, myX2, myY2, color);
  	return copiedShape;
  }
  
  /**
   * returns a boolean of whether a point is contained in the shape.
   * @param p point to see whether the point is contained in shape.
   * @return boolean of whether a point is contained in shape.
   */
  public boolean containsPoint(Point p){ 
  	// contains point if the distance to the point is smaller than 3, and inside a 
  	// bounded box containing the segment.
  	return (almostContainsPoint(p, Math.min(myX, myX2), Math.min(myY, myY2), 
  													Math.max(myX, myX2), Math.max(myY, myY2), 3.0)
  													&& (distanceToPoint(p, myX, myY, myX2, myY2)) <= 3); 
  }
  
  /**
   * move the shape.
   * @param deltaX distance to move the shape in x direction
   * @param deltaY distance to move the shape in y direction
   */
  public void move(int deltaX, int deltaY){ // move the Shape
  	myX += deltaX;
  	myY += deltaY;
  	myX2 += deltaX;
  	myY2 += deltaY;
  }
  
  /**
   * return the Shape's center
   * @return point of the center of the shape.
   */
  public Point getCenter(){ // return the Shape's center
  	int midX = (myX + myX2)/2; 
  	int midY = (myY + myY2)/2;
  	return new Point(midX, midY);
  }
	
  // Helper method that returns true if Point p is within a tolerance of a
  // given bounding box. Here, the bounding box is given by the coordinates of
  // its left, top, right, and bottom.
  private static boolean almostContainsPoint(Point p, int left, int top, int right, int bottom, double tolerance) {
    return p.x >= left - tolerance && p.y >= top - tolerance
        && p.x <= right + tolerance && p.y <= bottom + tolerance;
  }

  // Helper method that returns the distance from Point p to the line
  // containing a line segment whose endpoints are given.
  private static double distanceToPoint(Point p, int x1, int y1, int x2, int y2) {
    if (x1 == x2) // vertical segment?
      return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
    else if (y1 == y2) // horizontal segment?
      return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
    else {
      // Here, we know that the segment is neither vertical nor
      // horizontal.
      // Compute m, the slope of the line containing the segment.
      double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

      // Compute mperp, the slope of the line perpendicular to the
      // segment.
      double mperp = -1.0 / m;

      // Compute the (x, y) intersection of the line containing the
      // segment and the line that is perpendicular to the segment and that
      // contains Point p.
      double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
          / (mperp - m);
      double y = m * (x - x1) + y1;

      // Return the distance between Point p and (x, y).
      return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
  }
}
