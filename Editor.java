/**
 * Editor.java
 * An applet for an object-oriented graphical editor.
 * This class implements the GUI for the editor.
 * 
 * This is a provided file with parts to be filled in.
 *
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 * @author Naho Kitade
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Editor extends JApplet {
  private static final long serialVersionUID = 1L;
  
  private final int APPLET_WIDTH = 700, APPLET_HEIGHT = 500;
  private final Color initialColor = Color.red; // default color starts as red

  private Command cmd; // the command being executed
  private Drawing dwg; // the drawing: shapes in order
  private Drawing undoDwg; // "snapshot" of drawing that dwg is set to when undoButton is pressed.
  private Drawing redoDwg; // "snapshot" of drawing that dwg is set to when redoButton is pressed.
  private Boolean undo = false; // boolean to see if undo was called previously.
  private ColorIndicator colorBox; // a GUI component to show the current default color

  /**
   * Set up the buttons and canvas and register the listeners.
   */
  public void init() {
    cmd = new Command(); // all methods in Command are empty
    dwg = new Drawing(initialColor); // make an empty drawing

    // The drawing will appear in a white CanvasPanel.
    CanvasPanel canvasPanel = new CanvasPanel();
    canvasPanel.setBackground(Color.white);

    // Make JButton objects for all the command buttons.
    JButton rectButton = new JButton("Rectangle");
    JButton ellipseButton = new JButton("Ellipse");
    JButton lineButton = new JButton("Line");
    JButton moveButton = new JButton("Move");
    JButton copyButton = new JButton("Copy");
    JButton deleteButton = new JButton("Delete");
    JButton frontButton = new JButton("Front");
    JButton backButton = new JButton("Back");
    JButton exchangeButton = new JButton("Exchange");
    JButton undoButton = new JButton("Undo");
    JButton redoButton = new JButton("Redo");
    JButton clearButton = new JButton("Clear");
    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");
    JButton yellowButton = new JButton("Yellow");
    JButton cyanButton = new JButton("Cyan");
    JButton magentaButton = new JButton("Magenta");
    JButton randomButton = new JButton("Random");
    
    // Add listeners for all the command buttons.
    rectButton.addActionListener(new RectButtonListener());
    ellipseButton.addActionListener(new EllipseButtonListener());
    lineButton.addActionListener(new LineButtonListener());
    moveButton.addActionListener(new MoveButtonListener());
    copyButton.addActionListener(new CopyButtonListener());
    deleteButton.addActionListener(new DeleteButtonListener());
    frontButton.addActionListener(new FrontButtonListener());
    backButton.addActionListener(new BackButtonListener());
    exchangeButton.addActionListener(new ExchangeButtonListener());
    undoButton.addActionListener(new UndoButtonListener());
    redoButton.addActionListener(new RedoButtonListener());
    clearButton.addActionListener(new ClearButtonListener());
    redButton.addActionListener(new RedButtonListener());
    greenButton.addActionListener(new GreenButtonListener());
    blueButton.addActionListener(new BlueButtonListener());
    yellowButton.addActionListener(new YellowButtonListener());
    cyanButton.addActionListener(new CyanButtonListener());
    magentaButton.addActionListener(new MagentaButtonListener());
    randomButton.addActionListener(new RandomButtonListener());

    // The command buttons will be arranged in 3 rows.  Each row will
    // appear in its own JPanel, and the 3 JPanels will be stacked
    // vertically.
    JPanel shapePanel = new JPanel(); // holds buttons for adding shapes
    JLabel shapeLabel = new JLabel("Add shape:");
    shapePanel.setLayout(new FlowLayout());
    shapePanel.add(shapeLabel);
    rectButton.setBackground(Color.yellow);
    ellipseButton.setBackground(Color.yellow);
    lineButton.setBackground(Color.yellow);
    shapePanel.add(rectButton);
    shapePanel.add(ellipseButton);
    shapePanel.add(lineButton);

    JPanel editPanel = new JPanel(); // holds buttons for editing operations
    JLabel editLabel = new JLabel("Edit:");
    editPanel.setLayout(new FlowLayout());
    editPanel.add(editLabel);
    moveButton.setBackground(Color.yellow);
    copyButton.setBackground(Color.yellow);
    deleteButton.setBackground(Color.yellow);
    frontButton.setBackground(Color.yellow);
    backButton.setBackground(Color.yellow);
    exchangeButton.setBackground(Color.yellow);
    undoButton.setBackground(Color.yellow);
    redoButton.setBackground(Color.yellow);
    clearButton.setBackground(Color.yellow);
    editPanel.add(moveButton);
    editPanel.add(copyButton);
    editPanel.add(deleteButton);
    editPanel.add(frontButton);
    editPanel.add(backButton);
    editPanel.add(exchangeButton);
    editPanel.add(undoButton);
    editPanel.add(redoButton);
    editPanel.add(clearButton);

    // The color panel is slightly different from the other two. In
    // addition to a label and buttons for the color commands, this
    // panel holds a ColorIndicator that gives the current default
    // color.
    JPanel colorPanel = new JPanel();
    JLabel colorLabel = new JLabel("Colors:");
    colorPanel.setLayout(new FlowLayout());
    colorPanel.add(colorLabel);
    colorBox = new ColorIndicator();
    colorBox.show(initialColor);
    redButton.setBackground(Color.yellow);
    greenButton.setBackground(Color.yellow);
    blueButton.setBackground(Color.yellow);
    yellowButton.setBackground(Color.yellow);
    cyanButton.setBackground(Color.yellow);
    magentaButton.setBackground(Color.yellow);
    randomButton.setBackground(Color.yellow);
    colorPanel.add(colorBox);
    colorPanel.add(redButton);
    colorPanel.add(greenButton);
    colorPanel.add(blueButton);
    colorPanel.add(yellowButton);
    colorPanel.add(cyanButton);
    colorPanel.add(magentaButton);
    colorPanel.add(randomButton);

    // Use a grid layout to stack the button panels vertically.  Also,
    // give them a cyan background.
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(3, 1));
    shapePanel.setBackground(Color.cyan);
    editPanel.setBackground(Color.cyan);
    colorPanel.setBackground(Color.cyan);
    buttonPanel.add(shapePanel);
    buttonPanel.add(editPanel);
    buttonPanel.add(colorPanel);

    // Now we have two panels: buttonPanel and canvasPanel.  We want
    // buttonPanel to appear above canvasPanel, and canvasPanel should
    // grow with the applet.
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(buttonPanel, BorderLayout.NORTH);
    cp.add(canvasPanel, BorderLayout.CENTER);

    setSize(APPLET_WIDTH, APPLET_HEIGHT);
  }

  /**
   * What to do when rectButton is pressed.
   */
  private class RectButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	cmd = new AddRectangle();
      repaint();
    }
  }

  /**
   * What to do when ellipseButton is pressed.
   */
  private class EllipseButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	cmd = new AddEllipse();
      repaint();
    }
  }

  /**
   * What to do when lineButton is pressed.
   */
  private class LineButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	cmd = new AddSegment();
      repaint();
    }
  }

  /**
   * What to do when moveButton is pressed.
   */
  private class MoveButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	cmd = new MoveCmd();
      repaint();
    }
  }
  
  /**
   * What to do when copyButton is pressed.
   */
  private class CopyButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	cmd = new CopyCmd();
      repaint();
    }
  }

  /**
   * What to do when deleteButton is pressed.
   */
  private class DeleteButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	cmd = new DeleteCmd();
      repaint();
    }
  }

  /**
   * What to do when frontButton is pressed.
   */
  private class FrontButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	cmd = new FrontCmd();
      repaint();
    }
  }

  /**
   * What to do when backButton is pressed.
   */
  private class BackButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	cmd = new BackCmd();
      repaint();
    }
  }

  /**
   * What to do when exchangeButton is pressed.
   */
  private class ExchangeButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	cmd = new ExchangeCmd();
      repaint();
    }
  }
  
  /**
   * What to do when exchangeButton is pressed.
   */
  private class UndoButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	// If there is an undoDwg and undoDwg isnt identical to current dwg
    	if (undoDwg != null && undoDwg != dwg){ 
    		redoDwg = dwg; // keep current drawing in the redoDwg variable
    		dwg = undoDwg; // make dwg into undoDwg (dwg state before a specific mouse action)
    		undo = true; // undo was called
      	repaint(); // paint the new dwg (undoDwg) Drawing.
    	}
    }
  }
  
  /**
   * What to do when exchangeButton is pressed.
   */
  private class RedoButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	// if there is a redoDwg and undo was called previously
    	if (redoDwg != null && undo){
    	undoDwg = dwg; // keep current dwg into undoDwg
    	dwg = redoDwg; // make the dwg into redoDwg (dwg state before the redo was called)
    	undo = false; // undo is false because redo was just called.
      repaint(); // paint the new dwg (redoDwg) Drawing.
    	}
    }
  }
  
  /**
   * What to do when clearButton is pressed.
   */  
  private class ClearButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	undoDwg = dwg.copyDrawing(); // store dwg into undoDwg before it is cleared.
    	dwg.clear(); //call clear on the instance variable of a Drawing Object, dwg.
      repaint(); //repaint the cleared state.
    }
  }

  /**
   * What to do when redButton is pressed.
   */
  private class RedButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      dwg.setDrawingColor(Color.red); //Simply change the drawing color of the instance variable dwg to red.
      colorBox.show(Color.red); //update color indicator
    }
  }

  /**
   * What to do when greenButton is pressed.
   */
  private class GreenButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	dwg.setDrawingColor(Color.green); //Simply change the drawing color of the instance variable dwg to green.
      colorBox.show(Color.green); //update color indicator
    }
  }

  /**
   * What to do when blueButton is pressed.
   */
  private class BlueButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	dwg.setDrawingColor(Color.blue); //Simply change the drawing color of the instance variable dwg to blue.
      colorBox.show(Color.blue); //update color indicator
    }
  }
  
  /**
   * What to do when yellowButton is pressed.
   */
  private class YellowButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	dwg.setDrawingColor(Color.yellow); //Simply change the drawing color of the instance variable dwg to yellow.
      colorBox.show(Color.yellow); //update color indicator
    }
  }
  
  /**
   * What to do when cyanButton is pressed.
   */
  private class CyanButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	dwg.setDrawingColor(Color.cyan); //Simply change the drawing color of the instance variable dwg to cyan.
      colorBox.show(Color.cyan); //update color indicator
    }
  }
  
  /**
   * What to do when magentaButton is pressed.
   */
  private class MagentaButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	dwg.setDrawingColor(Color.magenta); //Simply change the drawing color of the instance variable dwg to magenta.
      colorBox.show(Color.magenta); //update color indicator
    }
  }

  /**
   * What to do when randomButton is pressed.
   */
  private class RandomButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	int numberLimit = 256; //highest int that rbg can be.
    	Random randint = new Random(); // create new random generator
    	//Store three random numbers between 0 - 255
    	int randomNumber1 = randint.nextInt(numberLimit);  
      int randomNumber2 = randint.nextInt(numberLimit);
      int randomNumber3 = randint.nextInt(numberLimit);
      //make each random number the r, g, b, parameter of the new Color object, and make
      // that the drawing color. 
      Color randomColor = new Color(randomNumber1, randomNumber2, randomNumber3);
    	dwg.setDrawingColor(randomColor);
    	colorBox.show(randomColor); //update color indicator
    }
  }
  
  /**
   * A ColorIndicator shows what the current color is.
   */
  private class ColorIndicator extends JPanel {
    private static final long serialVersionUID = 0;
    
    private final int COLORBOX_WIDTH = 20, COLORBOX_HEIGHT = 20;

    /**
     * Constructor sets the size and border.
     */
    public ColorIndicator() {
      setBorder(BorderFactory.createEtchedBorder());
      setPreferredSize(new Dimension(COLORBOX_WIDTH, COLORBOX_HEIGHT));
    }

    /**
     * Show a new color.
     * @param color the color to show
     */
    public void show(Color color) {
      setBackground(color);
    }
  }

  /** 
   * CanvasPanel is the class upon which we actually draw.  It listens
   * for mouse events and calls the appropriate method of the current
   * command.
   */ 
  private class CanvasPanel extends JPanel implements MouseListener,
      MouseMotionListener {
    private static final long serialVersionUID = 0;
    
    /**
     * Constructor just needs to set up the CanvasPanel as a listener.
     */
    public CanvasPanel() {
      addMouseListener(this);
      addMouseMotionListener(this);
    }

    /**
     * Paint the whole drawing
     * @page the Graphics object to draw on
     */
    public void paintComponent(Graphics page) {
      super.paintComponent(page); // execute the paint method of JPanel
      dwg.draw(page); // have the drawing draw itself
    }

    /**
     * When the mouse is clicked, call the executeClick method of the
     * current command.
     */
    public void mouseClicked(MouseEvent event) {
    	undoDwg = dwg.copyDrawing(); // Take snapsot of dwg before the actual executeClick of current command is called.
    	cmd.executeClick(event.getPoint(), dwg);
      repaint();
    }

    /**
     * When the mouse is pressed, call the executePress method of the
     * current command.
     */
    public void mousePressed(MouseEvent event) {
    	undoDwg = dwg.copyDrawing(); // Take snapsot of dwg before the actual executePress of current command is called.
    	cmd.executePress(event.getPoint(), dwg);
      repaint();
    }

    /** 
     * When the mouse is dragged, call the executeDrag method of the
     * current command.
     */
    public void mouseDragged(MouseEvent event) {
      cmd.executeDrag(event.getPoint(), dwg);
      repaint();
    }

    // We don't care about the other mouse events.
    public void mouseReleased(MouseEvent event) { }
    public void mouseEntered(MouseEvent event) { }
    public void mouseExited(MouseEvent event) { }
    public void mouseMoved(MouseEvent event) { }
  }
}
