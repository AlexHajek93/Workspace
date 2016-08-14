import java.util.*;
import java.text.*;
import java.io.*;
public class Managerstate extends WHState {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Warehouse warehouse;
  private WHContext context;
  private static Managerstate instance;
  private static final int EXIT = 0;
  private static final int MOD_SALE_PRICE = 1;
  private static final int ADD_MANUF = 2;
  private static final int ASSIGN_ITEM = 3;
  private static final int CLERKMENU = 10;
  private static final int HELP = 11;
  private Managerstate() {
      super();
      warehouse = Warehouse.instance();
      //context = WHContext.instance();
  }

  public static Managerstate instance() {
    if (instance == null) {
      instance = new Managerstate();
    }
    return instance;
  }

  public String getToken(String prompt) {
    do {
      try {
        System.out.println(prompt);
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
        if (tokenizer.hasMoreTokens()) {
          return tokenizer.nextToken();
        }
      } catch (IOException ioe) {
        System.exit(0);
      }
    } while (true);
  }

  private boolean yesOrNo(String prompt) {
    String more = getToken(prompt + " (Y|y)[es] or anything else for no");
    if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
      return false;
    }
    return true;
  }

  public int getNumber(String prompt) {
    do {
      try {
        String item = getToken(prompt);
        Integer num = Integer.valueOf(item);
        return num.intValue();
      } catch (NumberFormatException nfe) {
        System.out.println("Please input a number ");
      }
    } while (true);
  }
  public Calendar getDate(String prompt) {
    do {
      try {
        Calendar date = new GregorianCalendar();
        String item = getToken(prompt);
        DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
        date.setTime(df.parse(item));
        return date;
      } catch (Exception fe) {
        System.out.println("Please input a date as mm/dd/yy");
      }
    } while (true);
  }

  public int getCommand() {
    do {
      try {
        int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
        if (value >= EXIT && value <= HELP) {
          return value;
        }
      } catch (NumberFormatException nfe) {
        System.out.println("Enter a number");
      }
    } while (true);
  }

  public void help() {
    System.out.println("Enter a number between 0 and 12 as explained below:");
    System.out.println(EXIT + " to Exit");
    System.out.println(MOD_SALE_PRICE + " to modify a sales price of an item");
    System.out.println(ADD_MANUF + " to add a manufacturer");
    System.out.println(ASSIGN_ITEM + " to assign an item to a manufacturer");
    System.out.println(CLERKMENU + " to  switch to the clerk menu");
    System.out.println(HELP + " for help");
  }

  public boolean password(){
	  String passwd = getToken("Confirm action with password");
	  if(passwd.equals("manager"))
	  	return true;
	  return false;
  }
  
  public void modSalePrice(){
	  if(password()){
		  String id = getToken("Enter item ID: ");
		  if(warehouse.findProduct(id) == null){
		  	System.out.println("Product not Found.");
		  	
		  }
		  else {
			int price = getNumber("Enter new price of the item: ");
			warehouse.setPrice(id,price);
		  }
	  }
  }
  public void addManuf(){
	  //Nothing at the moment no manufacturer class
	  System.out.println("Not implemented.");
  }
  public void assignItem(){
	  //Due to no manufacturers nothing
	  System.out.println("Not implemented.");
  }
  
  public void clerkmenu()
  {     
    (WHContext.instance()).changeState(1);
  }

  public void logout()
  {
    (WHContext.instance()).changeState(0); // exit with a code 0
  }
 

  public void process() {
    int command;
    help();
    while ((command = getCommand()) != EXIT) {
      switch (command) {
        case MOD_SALE_PRICE:    modSalePrice();
                                break;
        case ADD_MANUF:         addManuf();
                                break;
        case ASSIGN_ITEM:       assignItem();
                                break;
        case CLERKMENU:         clerkmenu();
                                break;
        case HELP:              help();
                                break;
      }
    }
    logout();
  }
  public void run() {
    process();
  }
}
