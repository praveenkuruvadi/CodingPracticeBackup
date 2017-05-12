package timerClass;

public class timer {
	private static long start;
	
	public static void startTimer(){
		start = System.currentTimeMillis();
	}
	
	public static double getElapsedTime(){
		long end = System.currentTimeMillis();
		return (end-start)/1000.0;
	}
	

}
