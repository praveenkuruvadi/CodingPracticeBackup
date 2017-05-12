package leetCodeEasy;

public class CountPrimes {
    public int countPrimes(int n) {
        if(n<=2)
            return 0;
        boolean[] primes = new boolean[n];
        for(int i=0;i<n;i++)
            primes[i]=true;
        int endPoint = (int)Math.sqrt(n);
        int count=0;
        
        for(int i=2;i<=endPoint;i++){
            if(primes[i] != false){
                for(int j=i*i;j<n;j=j+i){
                    primes[j]=false;
                    
                }
            }
        }
        
        for(int i=2;i<n;i++){
            if(primes[i] !=false)
                count++;
        }
        return count;
    }

}
