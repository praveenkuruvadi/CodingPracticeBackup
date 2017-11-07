package BlackRock;

import java.util.Arrays;
import java.util.Comparator;

public class JobPickingWithDeadline {
	class Job{
		char id;
		int deadline;
		int profit;
		
		public Job(char id,int deadline,int profit){
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	
	class JobComparator implements Comparator<Job>{

		@Override
		public int compare(Job o1, Job o2) {
			// TODO Auto-generated method stub
			return o2.profit-o1.profit;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JobPickingWithDeadline jobDealine = new JobPickingWithDeadline();
		Job[] jobs = new Job[5];
		jobs[0] = jobDealine.new Job('a', 2, 100);
		jobs[1] = jobDealine.new Job('b', 1, 19);
		jobs[2] = jobDealine.new Job('c', 2, 27);
		jobs[3] = jobDealine.new Job('d', 1, 25);
		jobs[4] = jobDealine.new Job('e', 3, 15);
		Arrays.sort(jobs,jobDealine.new JobComparator());
		scheduleJobs(jobs);
	}
	private static void scheduleJobs(Job[] jobs) {
		// TODO Auto-generated method stub
		int[] holder = new int[jobs.length];
		Arrays.fill(holder, 0);
		int maxProfit = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<jobs.length;i++){
			Job currJob = jobs[i];
			for(int j = currJob.deadline-1;j>=0;j--){
				if(holder[j]==0){
					holder[j]=1;
					maxProfit+=currJob.profit;
					sb.append(currJob.id+" ");
					break;
				}
			}
		}
		System.out.println("Jobs: "+sb.toString()+" with profit: "+maxProfit);
	}

}