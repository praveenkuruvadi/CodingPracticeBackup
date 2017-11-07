package codingInterview;

import java.util.Arrays;
import java.util.Comparator;

class job{
	int start;
	int end;
	int weight;
	public job(int start,int end,int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
public class jobScheduling{

	public static void main(String[] args) {
		job jobs[] = new job[6];
        jobs[4] = new job(1,3,5);
        jobs[3] = new job(2,5,6);
        jobs[2] = new job(4,6,5);
        jobs[1] = new job(6,7,4);
        jobs[0] = new job(5,8,11);
        jobs[5] = new job(7,9,2);
        Arrays.sort(jobs,new Comparator<job>(){

			@Override
			public int compare(job arg0, job arg1) {
				
				return arg0.end-arg1.end;
			}
        	
        });
        
        int temp[] = new int[6];
        temp[0] = jobs[0].weight;
        for(int i=1;i<jobs.length;i++){
        	temp[i] = jobs[i].weight;
        	for(int j=i-1;j>=0;j--){
        		if(jobs[j].end<=jobs[i].start){
        			temp[i]= Math.max(temp[i], temp[j]+jobs[i].weight);
        		}
        	}
        }
        int max = Integer.MIN_VALUE;
        for(int i:temp){
        	if(i>max)
        		max=i;
        }
        System.out.println(max);
	}

}
