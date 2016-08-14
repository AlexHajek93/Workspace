import javax.swing.*;

import java.awt.Cursor;
import java.awt.event.*;
public class MoveButton  extends JButton implements ActionListener {
  protected JPanel drawingPanel;
  protected View view;
  private MouseHandler mouseHandler;
  private MoveCommand moveCommand;
  private UndoManager undoManager;
  public MoveButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
    super("Move");
    addActionListener(this);
    view = jFrame;
    drawingPanel = jPanel;
    this.undoManager = undoManager;
    mouseHandler = new MouseHandler();
  }
  public void actionPerformed(ActionEvent event) {
  	view.setCursor(new Cursor(Cursor.MOVE_CURSOR));
    drawingPanel.addMouseListener(mouseHandler);
  }
  private class MouseHandler extends MouseAdapter {
  	private int pointCount = 0;
    public void mouseClicked(MouseEvent event) {
    if (++pointCount == 1) {
        moveCommand = new MoveCommand();
        moveCommand.setPoint(View.mapPoint(event.getPoint()));
        undoManager.beginCommand(moveCommand);
    } else if (pointCount == 2) {
        pointCount = 0;
        moveCommand.setMovePoint(View.mapPoint(event.getPoint()));
        drawingPanel.removeMouseListener(this);
        view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        undoManager.endCommand(moveCommand);
      }
    }
    public void mouseMoved(MouseEvent event) {
    	moveCommand.setMotionPoint(View.mapPoint(event.getPoint()));
    }
  }
}
