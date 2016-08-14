import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class GUI extends JFrame {
  private JPanel topPanel;
  private JPanel bottomPanel;
  private JButton[] buttons;
  private int whstate;
  public GUI() {
  	super("Warehouse GUI");
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });
    whstate = 3;
    topPanel = new JPanel();
    bottomPanel = new JPanel();
    Container contentpane = getContentPane();
    contentpane.add(topPanel, "North");
    contentpane.add(bottomPanel, "South");
    buttons = new JButton[12];
    for(int i = 0; i < 12; i++){
    	buttons[i] = new Button(i);
    	buttons[i].setPreferredSize(new Dimension(70,50));
    }
    for(int i = 0; i < 6; i++){
    	topPanel.add(buttons[i]);
    	bottomPanel.add(buttons[i+6]);
    }
    this.setSize(480, 160);
  }
  
  public void setState(int state){
  	
  	update();
  }
  
  public void update(){
  	for(int i = 0; i < 12; i++){
    	buttons[i].setText("");
    }
  	if(whstate == 0){
  		
  	}
  }
}