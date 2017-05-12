package leetCodeEasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class frequencySort {

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));

	}
    public static String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        List<String>[] list = new List[s.length()+1];
        for(Character key: map.keySet()){
            int value = map.get(key);
            System.out.println(key);
            if(list[value] == null){
                list[value]=new ArrayList<String>();
                list[value].add(String.valueOf(key));
            }else{
                list[value].add(String.valueOf(key));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=list.length-1;i>0;i--){
            if(list[i]!= null){
                List<String> letterList = list[i];
                for(String k: letterList){
                    for(int j=0;j<i;j++)
                        sb.append(k);
                }
                
            }
        }
        
        return sb.toString();
        
    }

}
