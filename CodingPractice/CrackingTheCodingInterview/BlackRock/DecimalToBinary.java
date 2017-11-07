package BlackRock;

public class DecimalToBinary {
	
	public static void main(String[] args){
		
		int input = 15;
		System.out.println(convertToBinaryNoDecimalPoint(input));
		System.out.println(convertToBinaryWithDecimal(6.986,8));
	}

	private static String convertToBinaryNoDecimalPoint(int input) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		while(input>0){
			if(input == 1){
				sb.append(1);
				break;
			}
			sb.append(input%2);
			input = input/2;
		}
		return sb.reverse().toString();
	}
	
	private static String convertToBinaryWithDecimal(double input,int precise){
		StringBuilder sb = new StringBuilder();
		int num = (int)input;
		double fraction = input- (double)num;
		sb.append(convertToBinaryNoDecimalPoint(num));
		sb.append('.');
		while(precise>0){
			fraction = fraction*2;
			sb.append((int)fraction);
			fraction = fraction - (int)fraction;
			precise--;
		}
		return sb.toString().toString();
	}

}
