import java.util.*;
import java.io.*;
public class Warehouse implements Serializable {
  private static final long serialVersionUID = 1L;
  public static final int PRODUCT_NOT_FOUND  = 1;
  public static final int PRODUCT_NOT_ISSUED  = 2;
  public static final int PRODUCT_HAS_HOLD  = 3;
  public static final int PRODUCT_ISSUED  = 4;
  public static final int WAITLISTED  = 5;
  public static final int NOT_WAITLISTED  = 6;
  public static final int OPERATION_COMPLETED= 7;
  public static final int OPERATION_FAILED= 8;
  public static final int NO_SUCH_CLIENT = 9;
  private Catalog catalog;
  private ClientList clientList;
  private static Warehouse warehouse;
  private Warehouse() {
    catalog = Catalog.instance();
    clientList = ClientList.instance();
  }
  public static Warehouse instance() {
    if (warehouse == null) {
      IdServer.instance(); // instantiate all singletons
      return (warehouse = new Warehouse());
    } else {
      return warehouse;
    }
  }

  public Product addProduct(String name, String manufacturer, String id, int quantity, int price) {
    Product product = new Product(name, manufacturer, id, quantity, price);
    if (catalog.insertProduct(product)) {
      return (product);
    }
    return null;
  }
  public Product findProduct(String id){
	  boolean breaker = false;
	  Product product = new Product();
	  Iterator allProducts = warehouse.getProducts();
		while (!breaker && allProducts.hasNext()){
		  product = (Product)(allProducts.next());
		  if(product.equals(id)) {
		    breaker = true;
			break;
		  }
		}
		if(!breaker)
	            return null;
		return product;
  }
  public Client addClient(String name, String address, String phone, String email) {
    Client client = new Client(name, address, phone, email);
    if (clientList.insertClient(client)) {
      return (client);
    }
    return null;
  }
  public Client findClient(String id){
	  boolean breaker = false;
	  Client client = new Client();
	  Iterator allClients = warehouse.getClients();
		while (!breaker && allClients.hasNext()){
			client = (Client)(allClients.next());
		  if(client.equals(id)) {
		    breaker = true;
			break;
		  }
		}
		if(!breaker)
	            return null;
		return client;
  }
  public String processOrder(String clientId, ArrayList<String> productIds, ArrayList<Integer> quantities) {
		boolean breaker = false;
		int cost = 0;
    Iterator allClients = clientList.getClients();
    Iterator allProducts = warehouse.getProducts();
    Client client = new Client();
    Product product = new Product();
    ArrayList<Integer> missing = new ArrayList();
    while (!breaker && allClients.hasNext()){
	  client = (Client)(allClients.next());
          if(client.equals(clientId)) {
            breaker = true;
            break;
          }
    }
    if(!breaker)
      return "Client not Found.";
    for(int i = 0; i < productIds.size(); i++) {
      product = findProduct(productIds.get(i));
      missing.add(product.removeQuantity(quantities.get(i),clientId));
	  cost += product.getPrice()*(quantities.get(i)-missing.get(i));
      if(missing.get(i)!=0)
       client.waitlist(productIds.get(i),missing.get(i));
    }
    String string = "Order Processed.\n";
    for(int i = 0; i < missing.size(); i++) {
      if(missing.get(i) != 0)
        string += "Missing " + missing.get(i) + " of Product " + productIds.get(i) + ".\n";
    }
    Order order = new Order(clientId, productIds, quantities, cost);
    if(order != null)
      client.addOrder(order, cost);
    return string;
  }

  public String processShipment(String id, int amount, boolean fill) {
	boolean breaker = false;
        Product product = new Product();
        Client client = new Client();
	product = findProduct(id);
	if(product == null)
		return "Product not found";
	product.addQuantity(amount);
	breaker = false;
	if(fill) {
		while(amount != 0){
			ArrayList<String> productIds = new ArrayList();
			ArrayList<Integer> quantities = new ArrayList();
			String clientId = product.getWaitingClient();
			Iterator allClients = clientList.getClients();
			while (allClients.hasNext()){
				client = (Client)(allClients.next());
				if(client.equals(clientId)) {
					breaker = true;
					break;
				}
			}
			if(breaker) {
				int waitAmount = product.getWaitingAmount();
				productIds.add(id);
				if(amount >= waitAmount) {
					quantities.add(waitAmount);
					amount -= waitAmount;
					product.removeWaiting();
					client.removeWaiting();
				}
				else {
					quantities.add(amount);
					product.changeWaitingAmount(waitAmount-amount);
					client.changeWaitingAmount(waitAmount-amount);
					amount = 0;
				}
				processOrder(clientId, productIds, quantities);
				breaker = false;
			}
			else
				break;
		}
	}
	return "Shipment Processed";
  }
  public String processPayment(String id, int amount) {
		boolean breaker = false;
        Client client = new Client();
		Iterator allClients = clientList.getClients();
		while (allClients.hasNext()){
			client = (Client)(allClients.next());
			if(client.equals(id)) {
				breaker = true;
				break;
			}
		}
		if(!breaker)
      return "Client not Found.";
		client.payment(amount);
		return "Payment Processed.";
  }
  public String getOrders(String clientId) {
    boolean breaker = false;
    String string = new String();
    Client client = new Client();
    Iterator allClients = clientList.getClients();
    while (allClients.hasNext()){
	  client = (Client)(allClients.next());
          if(client.equals(clientId)) {
            breaker = true;
            break;
          }
    }
    if(!breaker)
      return "Client not Found.";
    string = client.getOrders();
    return string;
  }
  public String getPWaitlists() {
    String string = new String();
    Product product = new Product();
    Iterator allProducts = warehouse.getProducts();
    while (allProducts.hasNext()){
	  product = (Product)(allProducts.next());
          string += product.getWaitlist();
    }
    return string;
  }
  public String getCWaitlists() {
    String string = new String();
    Client client = new Client();
    Iterator allClients = clientList.getClients();
    while (allClients.hasNext()){
	  client = (Client)(allClients.next());
          string += client.getWaitlist();
    }
    return string; 
  }
  public Iterator getProducts() {
      return catalog.getProducts();
  }
  public Iterator getClients() {
      return clientList.getClients();
  }
  public Client searchClients(String clientId) {
    return clientList.search(clientId);
  }
  public int setPrice(String id,int price){
	  Product product = new Product();
	  product = findProduct(id);
	  product.setPrice(price);
	  return 1;
  }
  public static Warehouse retrieve() {
    try {
      FileInputStream file = new FileInputStream("WarehouseData");
      ObjectInputStream input = new ObjectInputStream(file);
      input.readObject();
      IdServer.retrieve(input);
      return warehouse;
    } catch(IOException ioe) {
      ioe.printStackTrace();
      return null;
    } catch(ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
      return null;
    }
  }
  public static  boolean save() {
    try {
      FileOutputStream file = new FileOutputStream("WarehouseData");
      ObjectOutputStream output = new ObjectOutputStream(file);
      output.writeObject(warehouse);
      output.writeObject(IdServer.instance());
      return true;
    } catch(IOException ioe) {
      ioe.printStackTrace();
      return false;
    }
  }
  private void writeObject(java.io.ObjectOutputStream output) {
    try {
      output.defaultWriteObject();
      output.writeObject(warehouse);
    } catch(IOException ioe) {
      System.out.println(ioe);
    }
  }
  private void readObject(java.io.ObjectInputStream input) {
    try {
      input.defaultReadObject();
      if (warehouse == null) {
        warehouse = (Warehouse) input.readObject();
      } else {
        input.readObject();
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  public String toString() {
    return catalog + "\n" + clientList;
  }
}
