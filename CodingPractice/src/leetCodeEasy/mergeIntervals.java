package leetCodeEasy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import leetCodeEasy.Interval;
public class mergeIntervals {
/// Doesnt work
	public static void main(String[] args) {
		

	}
	
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1)
            return intervals;
        
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                return Integer.compare(i1.start,i2.start);
            }
        });
        
        
        
        List<Interval> outList= new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(int i=1;i<=intervals.size()-1;i++){
            //System.out.println(intervals.get(i).start);
             if(end >= intervals.get(i).start){
                end = Math.max(intervals.get(i).end,end);
                //System.out.println(end);
            }else{
                outList.add(new Interval(start,end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        outList.add(new Interval(start,end));
        return outList;
    }
}
