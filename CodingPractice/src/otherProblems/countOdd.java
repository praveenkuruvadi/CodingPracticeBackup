package otherProblems;

public class countOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = {1,2,3,4,5,6,7,8,9,10};
		try{
			System.out.println("Number of Odd Elements: "+ countOdd(inputArray,3));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private static int countOdd(int[] arr, int pos) throws Exception{
		if(pos<0 || pos>=arr.length)
			throw new Exception("Position out of Array bounds");
		else if(pos == arr.length-1 && arr[pos]%2==0)
			return 0;
		else if(pos == arr.length-1 && arr[pos]%2!=0)
			return 1;
		else{
			if(arr[pos]%2==0)
				return countOdd(arr,pos+1);
			else
				return 1+countOdd(arr,pos+1);
		}
	}
}
