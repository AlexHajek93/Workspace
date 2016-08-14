import java.util.*;
import java.text.*;
import java.io.*;
public class Loginstate extends WHState{
  private static final int MANAGER_LOGIN = 0;
  private static final int CLERK_LOGIN = 1;
  private static final int USER_LOGIN = 2;
  private static final int EXIT = 3;
  private static final String M_PASSWD = "manager";
  private static final String C_PASSWD = "salesclerk";
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
  private WHContext context;
  private static Loginstate instance;
  private Loginstate() {
      super();
     // context = WHContext.instance();
  }

  public static Loginstate instance() {
    if (instance == null) {
      instance = new Loginstate();
    }
    return instance;
  }

  public int getCommand() {
    do {
      try {
        int value = Integer.parseInt(getToken("Enter command:" ));
        if (value <= EXIT && value >= MANAGER_LOGIN) {
          return value;
        }
      } catch (NumberFormatException nfe) {
        System.out.println("Enter a number");
      }
    } while (true);
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

  boolean verifyPasswd(String Id,String passwd){
    if(Id == "M"){
      if(passwd.equals(M_PASSWD))
        return true;
    }
    else if(Id == "C"){
      if(passwd.equals(C_PASSWD))
        return true;
    }
    else{
      if(passwd.equals(Id))
        return true;
    }
    return false;
  }

  private void manager(){
    String Mpassword = getToken("Please input the manager password (it is manager): ");
    if(verifyPasswd("M",Mpassword)){
      (WHContext.instance()).setLogin(WHContext.IsManager);
      (WHContext.instance()).changeState(0);
    }
    else
      System.out.println("Invalid Password.");
  }

  private void clerk(){
    String Cpassword = getToken("Please input the clerk password (it is salesclerk): ");
    if(verifyPasswd("C",Cpassword)){
      (WHContext.instance()).setLogin(WHContext.IsClerk);
      (WHContext.instance()).changeState(1);
    }
    else
      System.out.println("Invalid Password.");
  }

  private void user(){
    String userID = getToken("Please input the user id: ");
    String Upassword = getToken("Please input the user password: ");
    if (Warehouse.instance().searchClients(userID) != null){
      if(verifyPasswd(userID,Upassword)){
        (WHContext.instance()).setLogin(WHContext.IsUser);
        (WHContext.instance()).setUser(userID);      
        (WHContext.instance()).changeState(2);
      }
      else
        System.out.println("Invalid Password.");
    }
    else 
      System.out.println("Invalid user id.");
  } 

  public void process() {
    int command;
    System.out.println("Please input 0 to login as Manager\n"+ 
                        "input 1 to login as Clerk\n" +
                        "input 2 to login as User\n" +
                        "input 3 to exit the system\n");    
    while ((command = getCommand()) != EXIT) {

      switch (command) {
        case MANAGER_LOGIN:     manager();
                                break;
        case CLERK_LOGIN:       clerk();
                                break;
        case USER_LOGIN:        user();
                                break;
        default:                System.out.println("Invalid choice");
                                
      }
      System.out.println("Please input 0 to login as Manager\n"+ 
                        "input 1 to login as Clerk\n" +
                        "input 2 to login as User\n" +
                        "input 3 to exit the system\n"); 
    }
    (WHContext.instance()).changeState(3);
  }

  public void run() {
    process();
  }
}
