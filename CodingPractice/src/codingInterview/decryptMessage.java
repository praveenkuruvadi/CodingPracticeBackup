package codingInterview;

public class decryptMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] key = {4,0,7,1,3,2,1};
		System.out.println(decrypt2("Li, ailu jw au facntll"));

	}
	
	public static String decrypt(String input, int[] key) {
		StringBuilder res = new StringBuilder();
		int i = 0;
		for(char c: input.toCharArray()) {
    		if(i == key.length) 
    			i = 0;
    		if(Character.isLetter(c)) {
        			char firstLetter = c <= 'Z' ? 'A' : 'a';
        			c = (char)(c - key[i]);
        			if(c < firstLetter) c = (char)(c + 26);
        			i++;
    		}
    		res.append(c);
		}	
		return res.toString();
	}
	
	public static String decrypt2(String encrypted_message){
        int[] key = {4,0,7,1,3,2,1};
        
        StringBuilder sb = new StringBuilder();
        int count =0;
        char StartPlace = 'x';
        char toAppend = 'x';
        for(int i=0;i<encrypted_message.length();i++){
            if(!Character.isLetter(encrypted_message.charAt(i))){
                sb.append(encrypted_message.charAt(i));
                continue;
            }
            if(count == key.length)
                count=0;
            StartPlace = (encrypted_message.charAt(i)<='Z')?'A':'a';
            toAppend = (char)(encrypted_message.charAt(i)-key[count]);
            if(toAppend < StartPlace)
                toAppend = (char)(toAppend+26);
            count++;
            sb.append(toAppend);
        }
        return sb.toString();
	}

}
