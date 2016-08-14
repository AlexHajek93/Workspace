import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class PolyButton  extends JButton implements ActionListener {
  protected JPanel drawingPanel;
  protected View view;
  private MouseHandler mouseHandler;
  private PolyCommand polyCommand;
  private UndoManager undoManager;
  public PolyButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
    super("Polygon");
    this.undoManager = undoManager;
    addActionListener(this);
    view = jFrame;
    drawingPanel = jPanel;
    mouseHandler = new MouseHandler();
  }
  public void actionPerformed(ActionEvent event) {
    view.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    // Change cursor when button is clicked
    drawingPanel.addMouseListener(mouseHandler);
  // Start listening for mouseclicks on the drawing panel
  }
  private class MouseHandler extends MouseAdapter {
    private int pointCount = 0;
    private boolean atHome = false;
    public void mouseClicked(MouseEvent event) {
	    if (++pointCount == 1) {
	    	polyCommand = new PolyCommand(View.mapPoint(event.getPoint()));
	      undoManager.beginCommand(polyCommand);
	    } else if(!atHome) {
	      polyCommand.setLinePoint(View.mapPoint(event.getPoint()));
	    }
	    else {
	    	polyCommand.setLinePoint(View.mapPoint(event.getPoint()));
        drawingPanel.removeMouseListener(this);
        view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        undoManager.endCommand(polyCommand);
	    }
    }
  }
}