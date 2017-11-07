package other;

public class reverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 1252;
		System.out.println(reverseInt(input));

	}

	private static int reverseInt(int input) {
		// TODO Auto-generated method stub
		int output = 0;
		
		while(input >0){
			output = output*10 + input%10;
			input = input/10;
		}
		return output;
	}

}
