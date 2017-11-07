package otherProblems;

public class printSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 10;
		try{
			printSequence(number);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void printSequence(int num) throws Exception{
		if(num<0)
			throw new Exception("Cant print for negative input");
		else if (num ==0){
			System.out.print("0 ");
			return;
		}
		System.out.print(num+" ");
		printSequence(num-1);
		System.out.print(num+" ");
	}
}
