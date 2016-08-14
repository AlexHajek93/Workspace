import java.awt.Graphics;
public class NewSwingUI implements UIContext {
  private Graphics graphics;
  private static NewSwingUI swingUI;
  private NewSwingUI() {
  }
  public static NewSwingUI getInstance() {
    if (swingUI == null) {
      swingUI = new NewSwingUI();
    }
    return swingUI;
  }
  public  void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }
  public void draw(Ellipse ellipse) {
	  int i1 = 0;
	  int i2 = 0;
	  int i3 = 0;
	  int i4 = 0;
	  int width;
	  int height;
	  if (ellipse.getPoint1() != null && ellipse.getPoint2() != null) {
	    i1 = Math.round((float) (ellipse.getPoint1().getX()));
	    i2 = Math.round((float) (ellipse.getPoint1().getY()));
	    i3 = Math.round((float) (ellipse.getPoint2().getX()));
	    i4 = Math.round((float) (ellipse.getPoint2().getY()));
	    //Width = x difference
	    width = Math.abs(i1-i3);
	    //Height = y difference
	    height = Math.abs(i2-i4);
	    //Point 1 is left of Point 2
	    if(i1 < i3) {
	    	//Point 1 is above Point 2
	    	//Left Corner is (i1,i2)
	    	if(i2 < i4) {
	    		graphics.drawOval(i1,i2,width,height);
	    	}
	    	//Point 2 is above Point 1
	    	//Left Corner is (i1,i4)
	    	else {
	    		graphics.drawOval(i1,i4,width,height);
	    	}
	    }
	    //Point 2 is left of Point 1
	    else {
	      //Point 1 is above Point 2
	    	//Left Corner is (i3,i2)
	    	if(i2 < i4) {
	    		graphics.drawOval(i3,i2,width,height);
	    	}
	    	//Point 2 is above Point 1
	    	//Left Corner is (i3,i4)
	    	else {
	    		graphics.drawOval(i3,i4,width,height);
	    	}
	    }
	  }
  }
  public void draw(Label label) {
    if (label.getStartingPoint() != null) {
      if (label.getText() != null) {
        graphics.drawString(label.getText(), (int) label.getStartingPoint().getX(), (int) label.getStartingPoint().getY());
      }
    }
    int length = graphics.getFontMetrics().stringWidth(label.getText());
    graphics.drawString("_", (int) label.getStartingPoint().getX() + length, (int) label.getStartingPoint().getY());
  }
  public void draw(Line line) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (line.getPoint1() != null) {
      i1 = Math.round((float) (line.getPoint1().getX()));
      i2 = Math.round((float) (line.getPoint1().getY()));
      if (line.getPoint2() != null) {
        i3 = Math.round((float) (line.getPoint2().getX()));
        i4 = Math.round((float) (line.getPoint2().getY()));
      } else {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    }
  }
  public void draw(Polygon poly) {
  	for (Line l : poly.getList())
  		draw(l);
  }
  public void draw(Item item) {
    System.out.println( "Cant draw unknown Item \n");
  }
}