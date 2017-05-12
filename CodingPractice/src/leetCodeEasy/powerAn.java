package leetCodeEasy;

public class powerAn {

	public static void main(String[] args) {
		System.out.println(power(2,9));

	}
	
	private static int power(int a, int n){
		int result=1;
		while(n !=0){
			///if runs only once if odd
			if(n%2 !=0)
				result = result*a;
			
			a = a*a;
			n=n/2;
			if(n==1)
				return result*a;
		}
		return result;
	}

}
