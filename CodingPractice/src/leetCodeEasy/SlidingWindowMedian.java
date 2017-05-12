package leetCodeEasy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> minHeap,maxHeap;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] output = new double[nums.length-k];
        for(int i=0;i<nums.length-k+1;i++){
        	 minHeap = new PriorityQueue<Integer>(1,new Comparator<Integer>(){
                 
                 public int compare(Integer i1, Integer i2){
                     return i1-i2;
                 }
             });
             maxHeap = new PriorityQueue<Integer>(1,new Comparator<Integer>(){
                 
                 public int compare(Integer i1,Integer i2){
                     return i2-i1;
                 }
             }); 
            for(int j=i;j<i+k;j++)
                addElement(nums[j]);
                
            output[i]= getMedian();
        }
        return output;
    }
    private void addElement(int num){
        if(minHeap.size()== maxHeap.size()){
            if(minHeap.peek()!=null && num>minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }else
                maxHeap.add(num);
        }else{
            if(num<maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }else
                minHeap.add(num);
        }
    }
    private double getMedian(){
        if(minHeap.size()==maxHeap.size())
            return (double)((double)minHeap.peek()+(double)maxHeap.peek())/2;
        else
            return (double)maxHeap.peek();
    }

}
