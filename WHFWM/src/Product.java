import java.util.*;
import java.lang.*;
import java.io.*;
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private String manufacturer;
  private String id;
  private int quantity;
  private int price;
  private ArrayList<String> waiting_clients;
  private ArrayList<Integer> waiting_amounts;
  public Product() {}

  public Product(String name, String manufacturer, String id, int quantity, int price) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.id = id;
    this.quantity = quantity;
	this.price = price;
    this.waiting_clients = new ArrayList();
    this.waiting_amounts = new ArrayList();
  }

  public String getAuthor() {
    return manufacturer;
  }
  public String getTitle() {
    return name;
  }
  public String getId() {
    return id;
  }
  public int removeQuantity(int number, String clientId) {
    if(quantity >= number)
      quantity -= number;
    else {
      number-=quantity;
      quantity = 0;
      waiting_clients.add(clientId);
      waiting_amounts.add(number);
      return number;
    }
    return 0;
  }
  public boolean equals(String id) {
    return this.id.equals(id);
  }
  public String getWaitlist() {
    if(!waiting_amounts.isEmpty()) {
      String string = "\nProduct " + id + ": " + name + "\nClient ID, Amount";
      for(int i = 0; i < waiting_amounts.size(); i++) {
        string += "\n" + waiting_clients.get(i) + ", " + waiting_amounts.get(i);
      }
      return string;
    }
    else
      return "\nProduct " + id + ":" + name +"\nNo one is waiting for this.";
  }
  public int getPrice() {
	  return price;
  }
  public void setPrice(int price) {
	  this.price = price;
  }
  public void addQuantity(int amount) {
	quantity += amount;  
  }
  public String getWaitingClient() {
	return waiting_clients.get(0);
  }
  public int getWaitingAmount() {
	return waiting_amounts.get(0);
  }
  public void changeWaitingAmount(int amount) {
	waiting_amounts.set(0, amount);
  }
  public void removeWaiting() {
	waiting_clients.remove(0);
	waiting_amounts.remove(0);
  }
  public String toString() {
      return "name:" + name + ", manufacturer:" + manufacturer +
      		", id:" + id + ", quantity:" + quantity + " price: " + price;
  }
}
