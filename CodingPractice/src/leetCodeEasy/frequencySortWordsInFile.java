package leetCodeEasy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class frequencySortWordsInFile {

	public static void main(String[] args)  {
		HashMap<String,Integer> wordCount = new HashMap<String,Integer>();
		try {
			FileReader file = new FileReader("otherFiles/textFile.txt");
			BufferedReader reader = new BufferedReader(file);
			Pattern replacePattern = Pattern.compile("[{}!@:;#$%^&()'?|/<>.,~+]*");
			int i=0;
			String lineRead=null;
			while(( lineRead= reader.readLine())!=null){
				String line = lineRead.replaceAll(replacePattern.toString(), "").trim();
				String[] lineData =lineRead.split(" ");
				for(String word:lineData){
					if(!wordCount.containsKey(word))
						wordCount.put(word, 1);
					else
						wordCount.put(word, wordCount.get(word)+1);
				}
				i++;
			}
			
//			for(String word:wordCount.keySet())
//				System.out.println(word+": "+wordCount.get(word));
			List<Map.Entry<String, Integer>> output = 
					new ArrayList<Map.Entry<String, Integer>>(wordCount.entrySet());
			Collections.sort(output, new Comparator<Map.Entry<String, Integer>>(){

				@Override
				public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
					return arg0.getValue().compareTo(arg1.getValue());
				}
			});
			for(Map.Entry<String, Integer> entry:output){
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
