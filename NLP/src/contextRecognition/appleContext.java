package contextRecognition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class appleContext {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Integer> computerData = new HashMap<String,Integer>();
		HashMap<String, Integer> fruitData = new HashMap<String,Integer>();
		BufferedReader bf =new BufferedReader(new FileReader("dataFiles/apple-computers.txt"));
		String line =null;
		Pattern p = Pattern.compile("[\\w']+");
		while((line = bf.readLine()) != null) {
			line = line.toLowerCase().replaceAll("[^a-zA-Z &]+"," ");
			String data[] = line.split(" ");
			//Matcher m = p.matcher(line);
			for(String word:data){
				if(computerData.containsKey(word))
					computerData.put(word, computerData.get(word)+1);
				else
					computerData.put(word, 1);
			}
//			while ( m.find() ) {
//				if(computerData.containsKey(line.substring(m.start(), m.end())))
//					computerData.put(line.substring(m.start(), m.end()),
//							computerData.get(line.substring(m.start(), m.end()))+1);
//				else
//					computerData.put(line.substring(m.start(), m.end()),1);
//			}
        }
		bf =new BufferedReader(new FileReader("dataFiles/apple-fruit.txt"));
		line =null;
		
		while((line = bf.readLine()) != null) {
			line = line.toLowerCase().replaceAll("[^a-zA-Z &]+"," ");
			String data[] = line.split(" ");
			for(String word:data){
				if(fruitData.containsKey(word))
					fruitData.put(word, fruitData.get(word)+1);
				else
					fruitData.put(word, 1);
			}
        }
		for(String c:fruitData.keySet())
			System.out.println(c+":" +fruitData.get(c));
		
		

		

	}

}
