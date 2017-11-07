package ArraysNStrings;

public class checkInterleave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inA = "XY";
		String inB = "WZ";
		String inC = "WZXY";
		
		System.out.println(isInterleaved(inA,inB,inC,0,0,0));

	}

	private static boolean isInterleaved(String inA, String inB, String inC, int i, int j, int k) {
		// TODO Auto-generated method stub
		if(i>=inA.length()&&j>=inB.length()&&k>=inC.length())
			return true;
		else if(k>=inC.length())
			return false;
		if(inC.charAt(k) != inA.charAt(i) && inC.charAt(k) != inB.charAt(j))
			return false;
		else
			return isInterleaved(inA,inB,inC,i+1,j,k+1) || isInterleaved(inA,inB,inC,i,j+1,k+1);
	}

}
