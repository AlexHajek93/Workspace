import java.awt.*;
import java.text.*;
import java.util.*;
public class PolyCommand extends Command {
	private Polygon poly;
  private Vector<Line> lineList;
  private int pointCount;
  private Point prevPoint;
  public PolyCommand() {
    this(null);
    pointCount = 0;
  }
  public PolyCommand(Point point) {
    lineList = new Vector();
    prevPoint = point;
    pointCount = 1;
  }
  public void setLinePoint(Point point) {
    if(prevPoint != null) {
    	lineList.addElement(new Line(prevPoint,point));
    }
  }
  public void execute() {
    model.addItem(poly);
  }
  public boolean undo() {
    model.removeItem(poly);
    return true;
  }
  public boolean redo() {
    execute();
    return true;
  }
  public boolean end() {
    if (lineList.isEmpty()) {
      undo();
      return false;
    }
    return true;
  }
}
