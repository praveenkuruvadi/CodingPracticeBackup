package BlackRock;

import java.util.Arrays;
import java.util.Comparator;


public class orderJobsMinLoss {
	class JobComparator implements Comparator<Job>{

		@Override
		public int compare(Job arg0, Job arg1) {
			// TODO Auto-generated method stub
			return arg0.loss*arg1.time- arg1.loss*arg0.time;
		}
		
	}
	class Job{
		int time;
		int loss;
		int id;
		public Job(int id,int time,int loss){
			this.id = id;
			this.time = time;
			this.loss = loss;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		orderJobsMinLoss orderJobs = new orderJobsMinLoss();
		int[] Loss = {3, 1, 2, 4};
		int[] Time = {4, 1000, 2, 5};
		Job[] job = new Job[Loss.length];
		for(int i=0;i<Loss.length;i++)
			job[i] = orderJobs.new Job(i,Time[i],Loss[i]);
		Arrays.sort(job,orderJobs.new JobComparator());
		for(Job j:job)
			System.out.println(j.id);
	}

}