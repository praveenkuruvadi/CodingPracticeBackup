package HackerRank;

import java.util.Arrays;

public class twoCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxTwoLetter("beabeefeab"));
	}
	
    private static int maxTwoLetter(String s){
        char[] letters = getLetters(s.toLowerCase());
        int max = Integer.MIN_VALUE;
        for(int i=0;i<letters.length;i++){
            if(letters[i]!='0'){
                for(int j=i+1;j<letters.length;j++){
                    if(letters[j]!='0')
                        max = Math.max(wordLength(s,letters[i],letters[j]),max);
                }
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
    
    private static int wordLength(String s,char i,char j){
        char prevChar = '0';
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<s.length();k++){
            if(s.charAt(k)==i||s.charAt(k)==j){
                if(prevChar == '0'){
                    sb.append(s.charAt(k));
                    prevChar = s.charAt(k);
                }
                else if(prevChar != s.charAt(k)){
                    sb.append(s.charAt(k));
                    prevChar = s.charAt(k);
                }else
                    return Integer.MIN_VALUE;
            }
        }
        return sb.toString().length();
    }
    
    private static char[] getLetters(String s){
        char[] arr = new char[26];
        Arrays.fill(arr,'0');
        char[] charArr = s.toCharArray();
        for(int i=0;i<charArr.length;i++){
            arr[(int)charArr[i]-'a']= charArr[i];
        }
        return arr;
    }

}
