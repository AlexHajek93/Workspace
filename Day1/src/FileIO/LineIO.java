package FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LineIO {
	public static void main(String[] args) {
			try {
				File file = new File("data.txt"); //does not make a file
				if(!file.exists())
					file.createNewFile();
				new LineIO().writeToFile("Some test data",file);
				System.out.println("Op complete.");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public void tryWithResources(String line, File file) throws IOException{
		try(PrintWriter writer = new PrintWriter(new FileWriter(file,true))){
			writer.println(line);
		}
	}
	public void writeToFile(String line, File file) throws IOException{
		PrintWriter writer = new PrintWriter(new FileWriter(file));
		try{
			writer.append(line);
		}finally{
			writer.close();
		}
	}
	public List<String> readLinesFromFile(File file) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> data = new ArrayList<String>();
		String line = null;
		try{
			while((line = reader.readLine()) != null){
				System.out.println("Readine line into array: " + line);
				data.add(line);
		}
		}finally{
			reader.close();
		}
		return null;
	}
}
