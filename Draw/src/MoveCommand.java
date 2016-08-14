import java.awt.*;
import java.util.*;
public class MoveCommand extends Command {
  private Item item;
  private int x;
  private int y;
  public MoveCommand() {
  }
  public void setPoint(Point point) {
    Enumeration enumeration = model.getItems();
    while (enumeration.hasMoreElements()) {
      item = (Item)(enumeration.nextElement());
      if (item.includes(point)) {
      	x = point.x;
      	y = point.y;
        model.hideSelected(item);
        break;
      }
    }
  }
  public void setMovePoint(Point point) {
    x = point.x - x;
    y = point.y - y;
    model.moveItem(item, x, y);
    model.unHide(item);
  }
  public void setMotionPoint(Point point) {
  	
  }
  public boolean undo() {
  	model.moveItem(item, -x, -y);
    return true;
  }
  public boolean  redo() {
  	model.moveItem(item, x, y);
    execute();
    return true;
  }
  public void execute() {
  }
}
