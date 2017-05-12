package fibonacciSeries;

import timerClass.timer;
public class fibonacci {
	
	private final static int num=40;

	public static void main(String[] args) {
		timer t = new timer();
		t.startTimer();
		System.out.println(recursive(num));
		System.out.println("REcursive Time: "+t.getElapsedTime());
		t.startTimer();
		System.out.println(dynamic(num));
		System.out.println("Dynamic TIme: "+t.getElapsedTime());

	}
	
	private static int recursive(int num){
		if(num ==0)
			return 0;
		else if(num == 1)
			return 1;
		else
			return recursive(num-1)+recursive(num-2);
	}
	
	private static int dynamic(int num){
		int arr[] = new int[num+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<=num;i++){
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[num];
	}

}
