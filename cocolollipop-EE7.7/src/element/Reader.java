package element;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Reader {
	
	

	private ArrayList<String> listOfWords;
	private FileReader in = null;
	
	public void openFile() throws FileNotFoundException{
		in =  new FileReader("input.txt");
	}
	
	
	
	
}
