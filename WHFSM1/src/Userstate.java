import java.util.*;
import java.text.*;
import java.io.*;
public class Userstate extends WHState {
  private static Userstate userstate;
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Warehouse warehouse;
  private static final int EXIT = 0;
  private static final int VIEW_ACCT = 1;
  private static final int MAKE_ORDER = 2;
  private static final int GET_ORDERS = 3;
  private static final int PAYMENT = 4;
  private static final int GET_PRODS = 5;
  private static final int HELP = 11;
  private Userstate() {
    warehouse = Warehouse.instance();
  }

  public static Userstate instance() {
    if (userstate == null) {
      return userstate = new Userstate();
    } else {
      return userstate;
    }
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
    System.out.println(VIEW_ACCT + " to view account information");
    System.out.println(MAKE_ORDER + " to make an order");
    System.out.println(GET_ORDERS + " to get a list of all orders");
    System.out.println(PAYMENT + " to make a payment towards your balance");
    System.out.println(GET_PRODS + " to get a list of products with stock and price");
    System.out.println(HELP + " for help");
  }

  public void viewAccount(){
  	System.out.println(warehouse.findClient((WHContext.instance()).getUser()));
  }

  public void makeOrder(){
  	ArrayList<String> productIds = new ArrayList();
    ArrayList<Integer> quantities = new ArrayList();
    do {
      productIds.add(getToken("Enter Product ID"));
      quantities.add(getNumber("Enter Quantity"));
      if(!yesOrNo("Enter more Products"))
        break;
    } while(true);
    String output = warehouse.processOrder((WHContext.instance()).getUser(), productIds, quantities);
    System.out.println(output);
  }

  public void getOrders(){
  	System.out.println(warehouse.getOrders((WHContext.instance()).getUser()));  
  }

  public void payment(){
  	int pay = getNumber("Enter Amount to Pay");
  	String output = warehouse.processPayment((WHContext.instance().getUser()),pay);
  	System.out.println(output);
  }

  public void getProducts(){
  	Iterator allProducts = warehouse.getProducts();
    while (allProducts.hasNext()){
    	Product product = (Product)(allProducts.next());
      System.out.println(product.toString());
    }
  }

/*
  public void issueBooks() {
    Book result;
    String memberID = LibContext.instance().getUser();
    do {
      String bookID = getToken("Enter book id");
      result = library.issueBook(memberID, bookID);
      if (result != null){
        System.out.println(result.getTitle()+ "   " +  result.getDueDate());
      } else {
          System.out.println("Book could not be issued");
      }
      if (!yesOrNo("Issue more books?")) {
        break;
      }
    } while (true);
  }

  public void renewBooks() {
    Book result;
    String memberID = LibContext.instance().getUser();
    Iterator issuedBooks = library.getBooks(memberID);
    while (issuedBooks.hasNext()){
      Book book = (Book)(issuedBooks.next());
      if (yesOrNo(book.getTitle())) {
        result = library.renewBook(book.getId(), memberID);
        if (result != null){
          System.out.println(result.getTitle()+ "   " + result.getDueDate());
        } else {
          System.out.println("Book is not renewable");
        }
      }
    }
  }


  public void placeHold() {
    String memberID = LibContext.instance().getUser();
    String bookID = getToken("Enter book id");
    int duration = getNumber("Enter duration of hold");
    int result = library.placeHold(memberID, bookID, duration);
    switch(result){
      case Library.BOOK_NOT_FOUND:
        System.out.println("No such Book in Library");
        break;
      case Library.BOOK_NOT_ISSUED:
        System.out.println(" Book is not checked out");
        break;
      case Library.NO_SUCH_MEMBER:
        System.out.println("Not a valid member ID");
        break;
      case Library.HOLD_PLACED:
        System.out.println("A hold has been placed");
        break;
      default:
        System.out.println("An error has occurred");
    }
  }

  public void removeHold() {
    String memberID = LibContext.instance().getUser();
    String bookID = getToken("Enter book id");
    int result = library.removeHold(memberID, bookID);
    switch(result){
      case Library.BOOK_NOT_FOUND:
        System.out.println("No such Book in Library");
        break;
      case Library.NO_SUCH_MEMBER:
        System.out.println("Not a valid member ID");
        break;
      case Library.OPERATION_COMPLETED:
        System.out.println("The hold has been removed");
        break;
      default:
        System.out.println("An error has occurred");
    }
  }

  public void getTransactions() {
    Iterator result;
    String memberID = LibContext.instance().getUser();
    Calendar date  = getDate("Please enter the date for which you want records as mm/dd/yy");
    result = library.getTransactions(memberID,date);
    if (result == null) {
      System.out.println("Invalid Member ID");
    } else {
      while(result.hasNext()) {
        Transaction transaction = (Transaction) result.next();
        System.out.println(transaction.getType() + "   "   + transaction.getTitle() + "\n");
      }
      System.out.println("\n  There are no more transactions \n" );
    }
  }
*/
  public void process() {
    int command;
    help();
    while ((command = getCommand()) != EXIT) {
      switch (command) {

        case VIEW_ACCT:         viewAccount();
                                break;
        case MAKE_ORDER:        makeOrder();
                                break;
        case GET_ORDERS:        getOrders();
                                break;
        case PAYMENT:           payment();
                                break;
        case GET_PRODS:         getProducts();
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

  public void logout()
  {
    if ((WHContext.instance()).getLogin() == WHContext.IsClerk || (WHContext.instance()).getLogin() == WHContext.IsManager) 
       { //stem.out.println(" going to clerk \n ");
         (WHContext.instance()).changeState(1); // exit with a code 1
        }
    else if (WHContext.instance().getLogin() == WHContext.IsUser)
       {  //stem.out.println(" going to login \n");
        (WHContext.instance()).changeState(0); // exit with a code 2
       }
    else 
       (WHContext.instance()).changeState(2); // exit code 2, indicates error
  }
 
}
