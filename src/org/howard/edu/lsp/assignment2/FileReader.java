package src.org.howard.edu.lsp.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	public String readToString(String filePath) throws FileNotFoundException{
	File myObj = new File(filePath);
	Scanner myReader = new Scanner(myObj);

    try {
	  String output = "";
      while (myReader.hasNextLine()) {
		output = output + myReader.nextLine() + " ";
        //String data = myReader.nextLine();
        //System.out.println(data);
      }
	  return output.trim();
	}	
	finally {
		myReader.close();
		}  
	}
}

