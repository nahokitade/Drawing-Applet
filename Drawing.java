import java.awt.*;
import java.util.ArrayList;

/**
 * Drawing.java
 * 
 * Class that is used in Editor.java that draws all the shapes drawn in the canvas.
 * Also deals with implementing the core codes for many of the command sub-classes. 
 * @author Naho Kitade
 *
 */
public class Drawing{
	private ArrayList<Shape> drawingArrayList; //List containing all the Shape objects drawn on the campus.
	private Color drawingColor; // color that the drawings will be drawn in.
	
	/**
	 * Constructor for the Drawing object. 
	 * @param color the color that the drawings will be drawn in.
	 */
	public Drawing(Color color){
		drawingArrayList = new ArrayList<Shape>(); //Create a new arraylist to contain the Shapes.
		drawingColor = color;
	}
	
	/**
	 * Copies the entire drawing object into a new drawing object
	 * @return Drawing the new copied drawing object.
	 */
	public Drawing copyDrawing(){
		Drawing copiedDrawing = new Drawing(this.drawingColor);
		for (Shape shapes : this.drawingArrayList){
			copiedDrawing.drawingArrayList.add(shapes.copyShape());
		}
		return copiedDrawing;
	}
	
	/**
	 * Draws all the shapes stored in the drawingArrayList.
	 * @param page graphics page to draw the shapes on. 
	 */
	public void draw(Graphics page){
		// Call draw method on all the shapes.
		for (int i = drawingArrayList.size() - 1; i >= 0; i--){
			drawingArrayList.get(i).draw(page);
		}
	}
	
	/**
	 * Add a new shape at the front of the drawingArrayList. 
	 * @param shape Shape object to add to the list.
	 */
	public void add(Shape shape){
		drawingArrayList.add(0, shape); // add at the 0 index.
	}
	
	/**
	 * Add a new shape at a given index of the drawingArrayList. 
	 * @param index index to insert the shape.
	 * @param shape Shape object to add to the list.
	 */
	public void addAtIndex(int index, Shape shape){
		drawingArrayList.add(index, shape); // add at the specified index.
	}
	
	/**
	 * Clear the drawingArrayList to clear the canvas.
	 */
	public void clear(){
		drawingArrayList.clear();
	}
	
	/**
	 * set the drawing color to a given color.
	 * @param color the color to set the drawing color to.
	 */
	public void setDrawingColor(Color color){
		drawingColor = color;
	}
	
	/**
	 * get the drawing color.
	 * @return the drawingColor color
	 */
	public Color getDrawingColor(){
		return drawingColor;
	}
	
	/**
	 * gets the front most shape that contains a given point. 
	 * @param p the point that is contained in shape.
	 * @return the front most shape that contains the point. 
	 */
	public Shape getFrontmostContainer(Point p){
		for (Shape shapes:drawingArrayList){ // traverse fron the front of the list.
			if (shapes.containsPoint(p)){
				return shapes; //return the first object that contains the point.
			}
		}
		return null;
	}
	
	/**
	 * gets the index of the front most shape that contains a given point. 
	 * @param p the point that is contained in shape.
	 * @return the index of the front most shape that contains the point. 
	 */
	public int getFrontmostContainerIndex(Point p){
		//Same thing as getFrontmostContainer method but returns the index by traversing the 
		//list using a regular forloop.
		for (int i = 0; i < drawingArrayList.size(); i++){
			if (drawingArrayList.get(i).containsPoint(p)){
				return i; 
			}
		}
		return (Integer) null;
	}
	
	/**
	 * deletes the front most shape that contains a given point. 
	 * @param p the point that is contained in shape.
	 */
	public void deleteFrontmostContainer(Point p){
		Shape deletingShape = null;
		for (Shape shapes:drawingArrayList){
			if (shapes.containsPoint(p)){ //check if a shape contains a point
				deletingShape = shapes; //cant directly delete the shape so break after storing the chosen shape
				break;
			}
		}
		if (!(deletingShape == null)){
			drawingArrayList.remove(deletingShape); // if a deleting shape exists, remove that shape.
		}
	}
	
	/**
	 * bring front the front most shape that contains a given point. 
	 * @param p the point that is contained in shape.
	 */
	public void bringFrontFrontmostContainer(Point p){
		Shape bringFrontShape = null;
		//same thing as deleteFrontmostContainer
		for (Shape shapes:drawingArrayList){
			if (shapes.containsPoint(p)){
				bringFrontShape = shapes;
				break;
			}
		}
		if (!(bringFrontShape == null)){
			drawingArrayList.remove(bringFrontShape); //remove the shape from the list
			drawingArrayList.add(0, bringFrontShape); //re add the shape to the front of the list.
		}
	}
	
	/**
	 * bring back the front most shape that contains a given point. 
	 * @param p the point that is contained in shape.
	 */
	public void bringBackFrontmostContainer(Point p){
		Shape bringBackShape = null;
	//same thing as deleteFrontmostContainer
		for (Shape shapes:drawingArrayList){
			if (shapes.containsPoint(p)){
				bringBackShape = shapes;
				break;
			}
		}
		if (!(bringBackShape == null)){
			drawingArrayList.remove(bringBackShape); //remove the shape from the list
			drawingArrayList.add(bringBackShape); //re add the shape to at the back of the list.
		}
	}

}