package other;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class trieSuggestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> inputList = new ArrayList<String>();
		trie trieTest = new trie();
		try {
			inputList = readFromFile("otherFiles/EnglishWordFile.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		for(String s:inputList)
			trieTest.insert(s);
		System.out.println(trieTest.search("th"));
		ArrayList<String> suggestions = new ArrayList<String>();
		try {
			suggestions = trieTest.getSuggestions("config");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		for(String s:suggestions)
			System.out.println(s);
	}

	private static ArrayList<String> readFromFile(String filePath) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String> out = new ArrayList<String>();
		BufferedReader bf = new BufferedReader(new FileReader(filePath));
		String line = null;
		while((line=bf.readLine())!=null){
			out.add(line.toLowerCase().trim());
		}
		return out;
	}

}
