package codingInterview;

import java.text.*;
public class Interest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "1~2~3";
		String[] split = test.split("~");
		System.out.println(split[1]);
		double MonthlyPayment = Math.round((0.005*6000)/(1-Math.pow((1+0.005),-60)));
		System.out.println(GetInterestAndMonthly("25000~10~6~0"));

	}
	
	 public static String GetInterestAndMonthly(String s){
	      String[] input = s.split("~");
	      DecimalFormat df = new DecimalFormat(".##");
	      double loanAmt = Double.parseDouble(input[0]);
	      double years = Double.parseDouble(input[1]);
	      double roi = (Double.parseDouble(input[2])/100.0)/12.0;
	      double downpayment = Double.parseDouble(input[3]);
	      double numberOfPayment = years*12;
	      loanAmt = loanAmt - downpayment;
	      double MonthlyPayment = (roi*loanAmt)/(1-Math.pow((1+roi),-numberOfPayment));
	      int interestPaid = (int)Math.round(MonthlyPayment*numberOfPayment-loanAmt);
	      return "$"+String.valueOf(df.format(MonthlyPayment))+"~$"+String.valueOf(interestPaid);
	  }

}
