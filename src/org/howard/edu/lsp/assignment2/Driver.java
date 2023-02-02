package src.org.howard.edu.lsp.assignment2;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Driver {
	public static void main(String[] args) {
		FileReader fr = new FileReader();
		HashMap<String, Integer> map = new HashMap<>();

		try {
			String fileText = fr.readToString("src/main/resources/words.txt").toLowerCase();
			System.out.println(fileText);
			for(String word : fileText.split("\\W")) {
				if(word.isEmpty()) {
				}
				if(map.containsKey(word)) {
					map.put(word, map.get(word)+1);
				}
				else {
					if(word.length() > 3){
						try {
							Integer.parseInt(word);
						}catch (NumberFormatException e){
							map.put(word, 1);
						}
					}
				}
			}
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open resource");
		}
	}
}
