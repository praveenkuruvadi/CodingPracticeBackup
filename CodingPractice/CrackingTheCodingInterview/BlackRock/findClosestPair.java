package BlackRock;

public class findClosestPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {10, 22, 28, 29, 30, 40};
		int elem = 54;
		System.out.println(closestPair(input,elem));

	}

	private static String closestPair(int[] input, int elem) {
		// TODO Auto-generated method stub
		String output = null;
		int diff = Integer.MAX_VALUE;
		int i =0,j = input.length-1;
		while(i<j){
			if(Math.abs(elem - (input[i]+input[j]))<diff){
				output = input[i]+" "+input[j];
				diff = Math.abs(elem - (input[i]+input[j]));
				i++;j--;
			}else if(input[i]+input[j]<elem)
				i++;
			else
				j--;
		}
		return output;
	}

}
