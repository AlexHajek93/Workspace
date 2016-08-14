package FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializing {
	public static void main(String[] args) {
		try{
			Employee obj = new Employee();
			obj.id = 1; obj.name = "Name";
			obj.salary = 100; obj.ssn = 12;
			new Serializing().serialize(obj);
			Employee em = new Employee();
			em = deserializeable();
			System.out.println(em);
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	public static void serialize(Serializable o)throws IOException{
		try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("employee.ser"))){
			writer.writeObject(o);
		}
	}
	public static Employee deserializeable() throws IOException, ClassNotFoundException{
		try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("employee.ser"))){
			return (Employee) reader.readObject();
		}
	}
}
class Employee implements Serializable{
	private static final long serialVersionUID = -5L;
	int id;
	String name;
	double salary;
	transient int ssn;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
