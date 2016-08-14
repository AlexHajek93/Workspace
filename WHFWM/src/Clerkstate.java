import java.util.*;
import java.text.*;
import java.io.*;
public class Clerkstate extends WHState {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Warehouse warehouse;
  private WHContext context;
  private static Clerkstate instance;
  private static final int EXIT = 0;
  private static final int ADD_CLIENT = 1;
  private static final int ADD_PROD = 2;
  private static final int REC_ORDER = 3;
  private static final int PRINT_CLIENT = 4;
  private static final int PRINT_PROD = 5;
  private static final int GET_ORDERS = 6;
  private static final int GET_P_WAITLISTS = 7;
  private static final int GET_C_WAITLISTS = 8;
  private static final int LOAD_DATA = 9;
  private static final int USERMENU = 10;
  private static final int HELP = 11;
  private Clerkstate() {
      super();
      warehouse = Warehouse.instance();
      //context = WHContext.instance();
  }

  public static Clerkstate instance() {
    if (instance == null) {
      instance = new Clerkstate();
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
    System.out.println(ADD_CLIENT + " to add a client");
    System.out.println(ADD_PROD + " to add a product");
    System.out.println(REC_ORDER + " to recieve a shipment");
    System.out.println(PRINT_CLIENT + " to show all clients");
    System.out.println(PRINT_PROD + " to show all products");
    System.out.println(GET_ORDERS + " to show a list of all orders");
    System.out.println(GET_P_WAITLISTS + " to show what products have waitlists");
    System.out.println(GET_C_WAITLISTS + " to show what clients have waitlists");
    System.out.println(LOAD_DATA + " to reload the data of the system from the last save");
    System.out.println(USERMENU + " to  switch to the user menu");
    System.out.println(HELP + " for help");
  }

  public void addClient() {
    String name = getToken("Enter client name");
    String address = getToken("Enter address");
    String phone = getToken("Enter phone");
    String email = getToken("Enter email address");
    Client result;
    result = warehouse.addClient(name, address, phone,email);
    if (result == null) {
      System.out.println("Could not add client");
    }
    System.out.println(result);
  }

  public void addProd() {
  	String title = getToken("Enter name of product: ");
  	String manufacturer = getToken("Enter manufacturer: ");
  	String id = getToken("Enter ID for item: ");
  	int quantity = getNumber("Enter initial Amount: ");
  	int price = getNumber("Enter price: ");
  	Product result;
  	result = warehouse.addProduct(title, manufacturer, id, quantity, price);
  	if(result == null)
  		System.out.println("Could not add product");
  	System.out.println(result);
  }
  public void recOrder() {
  	String productId = getToken("Enter Product ID");
  	int amount = getNumber("Enter Amount Recieved");
  	boolean fill = yesOrNo("Fill Waitlists?");
  	String output = warehouse.processShipment(productId, amount, fill);
  	System.out.println(output);
  }
  public void printClient() {
  	Iterator allClients = warehouse.getClients();
    while (allClients.hasNext()){
    	Client client = (Client)(allClients.next());
      System.out.println(client.toString());
    }
  }
  public void printProd() {
  	Iterator allProducts = warehouse.getProducts();
    while (allProducts.hasNext()){
    	Product product = (Product)(allProducts.next());
      System.out.println(product.toString());
    }
  }
  public void getOrders() {
  	String clientId = getToken("Enter Client ID");
    if (clientId == null) {
      System.out.println("Could not find ID");
    }
    System.out.println(warehouse.getOrders(clientId)); 
  }
  public void pWaitlist() {
  	String string = warehouse.getPWaitlists();
    System.out.println(string);
  }
  public void cWaitlist() {
  	String string = warehouse.getCWaitlists();  
    System.out.println(string);
  }
  public void loadData() {
  	try {
      Warehouse tempWarehouse = Warehouse.retrieve();
      if (tempWarehouse != null) {
        System.out.println(" The warehouse has been successfully retrieved from the file WarehouseData" );
        warehouse = tempWarehouse;
      } else {
        System.out.println("File doesnt exist; creating new warehouse" );
        warehouse = Warehouse.instance();
      }
    } catch(Exception cnfe) {
      cnfe.printStackTrace();
    }
  }

  public void usermenu()
  {
    String userID = getToken("Please input the user id: ");
    if (Warehouse.instance().searchClients(userID) != null){
      (WHContext.instance()).setUser(userID);      
      (WHContext.instance()).changeState(2);
    }
    else 
      System.out.println("Invalid user id."); 
  }

  public void logout()
  {
    if ((WHContext.instance()).getLogin() == WHContext.IsManager)
       { //stem.out.println(" going to Manager \n ");
         (WHContext.instance()).changeState(1); // exit with a code 1
        }
    else if (WHContext.instance().getLogin() == WHContext.IsClerk)
       {  //stem.out.println(" going to login \n");
        (WHContext.instance()).changeState(0); // exit with a code 2
       }
    else 
       (WHContext.instance()).changeState(2); // exit code 2, indicates error
  }
 

  public void process() {
    int command;
    help();
    while ((command = getCommand()) != EXIT) {
      switch (command) {
        case ADD_CLIENT:        addClient();
                                break;
        case ADD_PROD:          addProd();
                                break;
        case REC_ORDER:         recOrder();
                                break;
        case PRINT_CLIENT:      printClient();
                                break;
        case PRINT_PROD:        printProd();
                                break;
        case GET_ORDERS:        getOrders();
                                break;
        case GET_P_WAITLISTS:   pWaitlist();
                                break;
        case GET_C_WAITLISTS:   cWaitlist();
                                break;
        case LOAD_DATA:         loadData();
                                break;
        case USERMENU:          usermenu();
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
