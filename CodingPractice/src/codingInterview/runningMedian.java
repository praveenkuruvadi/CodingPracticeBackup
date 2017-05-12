package codingInterview;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.*;

public class runningMedian {
private static PriorityQueue<Integer> minHeap,maxHeap;
    
    public static void main(String[] args) {
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
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            addElement(a[a_i]);
            System.out.println(getMedian());
        }
    }
    
    private static Double getMedian(){
        if(minHeap.size()==maxHeap.size())
            return ((double)minHeap.peek()+(double)maxHeap.peek())/2;
        else
            return (double)maxHeap.peek();
    }
    
    private static void addElement(Integer elem){
        if(minHeap.size()==maxHeap.size()){
            if(minHeap.peek()!=null && elem>minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(elem);
            }else
                maxHeap.add(elem);
        }else{
            if(elem<maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(elem);
            }else
                minHeap.add(elem);
        }
    }

}
