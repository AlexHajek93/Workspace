import java.awt.*;
import java.util.*;
public class Polygon extends Item {
	private Point start;
  private Vector<Line> lineList;
  public Polygon(Vector<Line> inLineList) {
    //Build from list
  }
  public Polygon() {
  	lineList = new Vector();
  }
  public boolean includes(Point point) {
  	for (Line l : lineList) {
  		return (l.includes(point));
  	}
  	return false;
  }
  public void move(int x_diff,int y_diff) {
  	for (Line l : lineList) {
  		l.move(x_diff, y_diff);
  	}
  }
  public void render() {
    uiContext.draw(this);
  }
  public Point getStart() {
    if(!lineList.isEmpty()) {
    	return lineList.get(0).getPoint1();
    }
    return null;
  }
  public Vector<Line> getList() {
  	return lineList;
  }
  public String toString() {
  	if(!lineList.isEmpty()) {
  		return "Polygon  start " + lineList.get(0).getPoint1() + " with " + lineList.size() + " lines";
    }
    return "Polygon is empty";
  }
}

