package ArraysNStrings;

public class removeOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input= {34,10,3,2,33,1,80};
		removeOddElem(input);
		for(int i:input)
			System.out.print(i+" ");

	}

	private static void removeOddElem(int[] input) {
		// TODO Auto-generated method stub
		int shift = 0;
		for(int i=0;i<input.length;i++){
			if(input[i]%2 == 0)
				input[shift++]=input[i];
		}
		for(int i=shift;i<input.length;i++)
			input[i]=0;
	}

}
