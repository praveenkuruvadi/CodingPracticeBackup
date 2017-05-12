package leetCodeEasy;

import java.util.Iterator;
import java.util.Stack;

public class minStack {
    private Stack<Integer> stack;
    private int minElem;

    /** initialize your data structure here. */
    public minStack() {
        stack = new Stack<Integer>();
        minElem =Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        stack.push(x);
        if(x<minElem)
            minElem =x;
    }
    
    public void pop() {
        if(!stack.empty()){
            int out = stack.pop();
            if(out == minElem){
                minElem = Integer.MAX_VALUE;;
                Iterator<Integer> i = stack.iterator();
                while(i.hasNext()){
                    int val = i.next();
                    if(val<minElem)
                        minElem =val;
                }
            }
        }
        
    }
    
    public int top() {
        if(!stack.empty()){
            int out = stack.peek();
            return out;
        }
        return 0;
    }
    
    public int getMin() {
        return minElem;
    }
}
