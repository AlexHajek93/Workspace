/*
Class: CSCI 430
Project: Warehouse Stage 1
Team Members:
  Drew Freeman
  Alexander Hajek
  Andrew Hellweg
Current Version: 03
Assignment distribution:
  Drew Freeman:
    Client/ClientList
  Alexander Hajek
    UserInterface/Warehouse/Order
  Andrew Hellweg
    Product/Catalog
Undistributed Items:
    IdServer

Current Tasks For Stage 1:
  Populate Client & Products
  Process Orders
    Waitlisting

Completed Tasks for Stage 1:
  Populate Client & Products
  Process Orders
    Waitlisting 
*/
import java.util.*;
import java.text.*;
import java.io.*;
public class UserInterface {
  private static UserInterface userInterface;
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Warehouse warehouse;
  
  /*Populate*/
  private static final int ADD_CLIENT = 1;
  private static final int ADD_PRODUCTS = 2;
  /*Modify*/
  private static final int PROCESS_ORDER = 3;
  private static final int RECIEVE_SHIPMENT = 4;
  private static final int RECIEVE_PAYMENT = 5;
  /*Queries*/
  private static final int SHOW_PRODUCTS = 6;
  private static final int SHOW_CLIENTS = 7;
  private static final int GET_ORDERS = 8;
  private static final int GET_P_WAITLISTS = 9;
  private static final int GET_C_WAITLISTS = 10;
  /*Data Storage*/
  private static final int SAVE = 11;
  private static final int RETRIEVE = 12;
  /*Other*/
  private static final int EXIT = 0;
  private static final int HELP = 13;
  
  /* Start-Up Functions */

  // Asks to gather data for user from storage
  private UserInterface() {
    if (yesOrNo("Look for saved data and  use it?")) {
      retrieve();
    } else {
      warehouse = Warehouse.instance();
    }
  }
  
  //Initializer for the interface
  public static UserInterface instance() {
    if (userInterface == null) {
      return userInterface = new UserInterface();
    } else {
      return userInterface;
    }
  }

  /* Useful/Helper functions */

  //Obtains inputs from the command line as Strings
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

  //Asks the user a question with a yes or no response
  //Returns TRUE is Y||y and False for anything else
  private boolean yesOrNo(String prompt) {
    String more = getToken(prompt + " (Y|y)[es] or anything else for no");
    if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
      return false;
    }
    return true;
  }

  //Obtains input from the command line as an Integer
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

  //Creates a Calendar object from user's input
  //Currently used only in orders, but hidden from user
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

  //Asks user for what action they would like to perform
  //Displays Help command to show user how to open menu
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

  //Will tell the user the actions they can perform
  //Will also show the associated numbers for the actions
  public void help() {
    System.out.println("Enter a number as explained below:");
    System.out.println(EXIT + " to Exit");
    System.out.println(ADD_CLIENT + " to add a client");
    System.out.println(ADD_PRODUCTS + " to add prodcuts");
    System.out.println(PROCESS_ORDER + " to place and process an order");
	System.out.println(RECIEVE_SHIPMENT + " to process a recieved shipment");
	System.out.println(RECIEVE_PAYMENT + " to process a recieved payment from client");
	System.out.println(SHOW_PRODUCTS + " to print products");
	System.out.println(SHOW_CLIENTS + " to print clients");
    System.out.println(GET_ORDERS + " to get the order history of a client");
    System.out.println(GET_P_WAITLISTS + " to  see products in backorders");
    System.out.println(GET_C_WAITLISTS + " to  see customers with backorders");
    System.out.println(SAVE + " to  save data");
    System.out.println(RETRIEVE + " to  retrieve");
    //Taken out due to redundancy
    //System.out.println(HELP + " for help");
  }

  /* Pupulation Actions */

  //Action to add client with inputted data
  public void addClient() {
    String name = getToken("Enter client name");
    String address = getToken("Enter address");
    String phone = getToken("Enter phone number");
    String email = getToken("Enter email");
    Client result;
    result = warehouse.addClient(name, address, phone, email);
    if (result == null) {
      System.out.println("Could not add client");
    }
    System.out.println(result);
  }

  //Action to add product with inputted data
  public void addProducts() {
    Product result;
    do {
      String name = getToken("Enter  name of product");
      String productID = getToken("Enter id");
      String manufacturer = getToken("Enter manufacturer");
      int quantity = getNumber("Enter initial amount");
	  int price = getNumber("Enter initial price");
      result = warehouse.addProduct(name, manufacturer, productID, quantity, price);
      if (result != null) {
        System.out.println(result);
      } else {
        System.out.println("Product could not be added");
      }
      if (!yesOrNo("Add more prodcuts?")) {
        break;
      }
    } while (true);
  }

  /* Modification Actions */

  //Action to create and process order for users
  public void processOrder() {
    ArrayList<String> productIds = new ArrayList();
    ArrayList<Integer> quantities = new ArrayList();
    String clientId = getToken("Enter Client ID");
    do {
      productIds.add(getToken("Enter Product ID"));
      quantities.add(getNumber("Enter Quantity"));
      if(!yesOrNo("Enter more Products"))
        break;
    } while(true);
    String output = warehouse.processOrder(clientId, productIds, quantities);
    System.out.println(output);
  }

  public void processShipment() {
	String productId = getToken("Enter Product ID");
	int amount = getNumber("Enter Amount Recieved");
	boolean fill = yesOrNo("Fill Waitlists?");
	String output = warehouse.processShipment(productId, amount, fill);
	System.out.println(output);
	}
  
  public void processPayment() {
	String clientId = getToken("Enter Client ID");
	int pay = getNumber("Enter Amount Paid");
	String output = warehouse.processPayment(clientId,pay);
	System.out.println(output);
  }
  
  /* Queries */

  //Shows a list of all the products to the user
  public void showProducts() {
      Iterator allProducts = warehouse.getProducts();
      while (allProducts.hasNext()){
	  Product product = (Product)(allProducts.next());
          System.out.println(product.toString());
      }
  }

  //Shows a list of all the clients to the user
  public void showClients() {
      Iterator allClients = warehouse.getClients();
      while (allClients.hasNext()){
	  Client client = (Client)(allClients.next());
          System.out.println(client.toString());
      }
  }

  //Shows a list of previous orders from 1 client  
  public void getOrders() {
    String clientId = getToken("Enter Client ID");
    if (clientId == null) {
      System.out.println("Could not find ID");
    }
    System.out.println(warehouse.getOrders(clientId));   
  }

  //Shows Waitlists associated with Products
  public void getPWaitlists() {
    String string = warehouse.getPWaitlists();
    System.out.println(string);
  }

  //Shows Waitlists associated with Clients
  public void getCWaitlists() {
    String string = warehouse.getCWaitlists();  
    System.out.println(string);
  }

  /* Data Storage Functions */

  //Saving to Storage
  private void save() {
    if (warehouse.save()) {
      System.out.println(" The warehouse has been successfully saved in the file WarehouseData \n" );
    } else {
      System.out.println(" There has been an error in saving \n" );
    }
  }

  //Obtaining from file
  private void retrieve() {
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

  /* Execution Functions */

  //The interface
  public void process() {
    int command;
    help();
    while ((command = getCommand()) != EXIT) {
      switch (command) {
        /*Populate*/
        case ADD_CLIENT:        addClient();
                                break;
        case ADD_PRODUCTS:      addProducts();
                                break;
        /*Modify*/
        case PROCESS_ORDER:     processOrder();
                                break;
		case RECIEVE_SHIPMENT:  processShipment();
                                break;
		case RECIEVE_PAYMENT:   processPayment();
                                break;
        /*Query*/
        case SHOW_CLIENTS:      showClients();
                                break;
        case SHOW_PRODUCTS:     showProducts();
                                break;
        case GET_ORDERS:        getOrders();
				break;
        case GET_P_WAITLISTS:   getPWaitlists();
                                break;
        case GET_C_WAITLISTS:   getCWaitlists();
				break;
        /*Data Storage*/
        case SAVE:              save();
                                break;
        case RETRIEVE:          retrieve();
                                break;
	/*Other*/	
        case HELP:              help();
                                break;
      }
    }
  }

  //Main loop initializer
  public static void main(String[] s) {
    UserInterface.instance().process();
  }
}
