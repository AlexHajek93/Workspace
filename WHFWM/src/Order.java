import java.util.*;
import java.io.*;
public class Order implements Serializable {
  private String clientId;
  private ArrayList<String> productIds;
  private ArrayList<Integer> quantities;
  private int cost;
  private static final String ORDER_STRING = "O";

  public  Order (String clientID, ArrayList productIds, ArrayList quantities, int cost) {
    this.clientId = clientID;
    this.productIds = productIds;
    this.quantities = quantities;
    this.cost = cost;
  }

  public String toString() {
    String string = "Product ID, Quantities:\n";
    for(int i = 0; i< productIds.size(); i++) {
      string += productIds.get(i) + ", " + quantities.get(i) + "\n";
    }
    string += "Client:" + clientId;
    return string;
  }
}
