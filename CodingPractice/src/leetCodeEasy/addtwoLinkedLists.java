package leetCodeEasy;

import java.util.Stack;

public class addtwoLinkedLists {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start=null,current=null;
        Stack<Integer> carry= new Stack<Integer>();
        while(l1 != null || l2 != null){
            
            if(start==null ){
                int sum = l1.val+l2.val;
                if(sum/10==0){
                    start = new ListNode(sum);
                    l1= l1.next;
                    l2 = l2.next;
                    current =start;
                }
                else{
                    start = new ListNode(sum%10);
                    l1= l1.next;
                    l2 = l2.next;
                    carry.push(sum/10);
                    current = start;
                }
            }else{
                int sum=0;
                
                if(l1 !=null && l2 != null){
                    if(!carry.empty())
                        sum = l1.val+l2.val+carry.pop();
                    else
                        sum= l1.val+l2.val;
                    if(sum/10==0){
                        current.next = new ListNode(sum);
                        l1= l1.next;
                        l2 = l2.next;
                        current = current.next;
                    }
                    else{
                        current.next = new ListNode(sum%10);
                        l1= l1.next;
                        l2 = l2.next;
                        carry.push(sum/10);
                        current=current.next;
                    }
                }
                else if(l1 !=null){
                    if(!carry.empty())
                        sum = l1.val+carry.pop();
                    else
                        sum= l1.val;
                    if(sum/10==0){
                        current.next = new ListNode(sum);
                        l1= l1.next;
                        current = current.next;
                    }
                    else{
                        current.next = new ListNode(sum%10);
                        l1= l1.next;
                        carry.push(sum/10);
                        current=current.next;
                    }
                }
                else if(l2 !=null){
                    if(!carry.empty())
                        sum = l2.val+carry.pop();
                    else
                        sum= l2.val;
                    if(sum/10==0){
                        current.next = new ListNode(sum);
                        l2= l2.next;
                        current = current.next;
                    }
                    else{
                        current.next = new ListNode(sum%10);
                        l2= l2.next;
                        carry.push(sum/10);
                        current=current.next;
                    }
                }
            }
            
        }
        if(!carry.empty())
                current.next = new ListNode(carry.pop());
        
        return start;
        
    }
}


