package linkedList;

public class timerClass {
	private static long start;
	private static long stop;
	
	public timerClass(){
		
	}
	public void startTimer(){
		start = System.currentTimeMillis();
	}
	public void stopTimer(){
		stop = System.currentTimeMillis();
	}
	public double elapsedTime(){
		return (stop-start)/1000.0;
	}

}
