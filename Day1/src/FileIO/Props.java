package FileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Prop files are K,V pairs
//Configs
//MessageResources (storing messages and internationalization)
public class Props {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		InputStream resource = Props.class.getClassLoader().getResourceAsStream("config.properties");
		props.load(resource);
		props.list(System.out);
		
//		props.load(new FileReader("C:/Users/Alex/workspace/Day1/src/configs.properties"));
//		props.put("userHome", "/usr/home/");
//		props.store(new FileWriter("C:/Users/Alex/workspace/Day1/src/configs.properties"), null);
//		String value = (String) props.get("url");
//		System.out.println(value);
	}
	
}
