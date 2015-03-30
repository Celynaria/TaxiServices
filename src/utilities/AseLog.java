package utilities;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class AseLog {
	private static final AseLog  INSTANCE = new AseLog();
	
	private  AseLog(){}
	
	public static AseLog getInstance() {
		return INSTANCE;
	}
	/**
	 * Log writing method
	 */
	public synchronized void write(String text){
		String fileName = "log.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));)//this will close the file automatically
		{	
			writer.write(text);
			writer.newLine();
		} catch (FileNotFoundException e){
			System.err.println("Can not find "+fileName+" file.");
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
