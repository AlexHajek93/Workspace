import java.util.*;
import java.io.*;
public class Client implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private String address;
  private String phone;
  private String email;
  private String id;
  private int balance;
  private ArrayList<Order> orders;
  private ArrayList<String> waiting_products;
  private ArrayList<Integer> waiting_amounts;
  private static final String CLIENT_STRING = "C";
  /*
  private List booksBorrowed = new LinkedList();
  private List booksOnHold = new LinkedList();
  private List transactions = new LinkedList();
  */
  public Client () {}

  public  Client (String name, String address, String phone, String email) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.id = CLIENT_STRING + (IdServer.instance()).getId();
	this.balance = 0;
    this.orders = new ArrayList();
    this.waiting_products = new ArrayList();
    this.waiting_amounts = new ArrayList();
  }

  public String getName() {
    return name;
  }
  public String getPhone() {
    return phone;
  }
  public String getAddress() {
    return address;
  }
  public String getId() {
    return id;
  }
  public void setName(String newName) {
    name = newName;
  }
  public void setAddress(String newAddress) {
    address = newAddress;
  }
  public void setPhone(String newPhone) {
    phone = newPhone;
  }
  public boolean equals(String id) {
    return this.id.equals(id);
  }
  public String getOrders() {
    String string = new String();
    if(orders == null)
      return "No order history for " + name +".";
    for(int i = 0; i < orders.size(); i++) {
      string += orders.get(i).toString();
    }
    return string;
  }
  public void addOrder(Order order, int cost) {
    orders.add(order);
	balance += cost;
  }
  public void waitlist(String productId, int amount) {
    waiting_products.add(productId);
    waiting_amounts.add(amount);
  }
  public String getWaitlist() {
    if(!waiting_amounts.isEmpty()) {
      String string = "\nClient " + id + ": " + name + "\nProduct ID, Amount";
      for(int i = 0; i < waiting_amounts.size(); i++) {
        string += "\n" + waiting_products.get(i) + ", " + waiting_amounts.get(i);
      }
      return string;
    }
    else
      return "\n" + name + " is not waiting for products.";
  }
  public void payment(int amount) {
	balance -= amount;  
  }
	public void changeWaitingAmount(int amount) {
	waiting_amounts.set(0, amount);
  }
  public void removeWaiting() {
	waiting_products.remove(0);
	waiting_amounts.remove(0);
  }
  public String toString() {
    String string = "Client name:" + name + ", address:" + address + 
    		", id:" + id + ", phone:" + phone + ", email:" + email + ", balance owed:" + balance;
    return string;
  }
}
