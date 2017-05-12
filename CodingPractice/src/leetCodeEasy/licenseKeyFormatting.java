package leetCodeEasy;

public class licenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        String sNew = S.replaceAll("-","").toUpperCase();
        int extraChar = sNew.length()%K;
        int count =0,countK=K;
        StringBuilder sb =new StringBuilder();
        if(extraChar != 0){
            while(count<extraChar){
                sb.append(sNew.charAt(count));
                count++;
            }
            if(count<sNew.length())
                sb.append("-");
        }
        
        while(count<sNew.length()){
            if(countK!=0){
                sb.append(sNew.charAt(count));
                countK--;
                count++;
            }else{
                sb.append("-");
                countK=K;
            }
        }
        
        return sb.toString();
            
        
    }

}
