package codingInterview;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerFibonacci {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger t1=in.nextBigInteger();
        BigInteger t2= in.nextBigInteger();
        int n= in.nextInt();
        BigInteger temp = new BigInteger("0");
        for(int i=3;i<=n;i++){
            temp = t1.add(t2.multiply(t2));
            t1=t2;
            t2=temp;
        }
        System.out.println(t2);

	}

}
