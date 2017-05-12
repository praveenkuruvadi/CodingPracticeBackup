package leetCodeEasy;

public class deleteNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode start = new ListNode(0);
        ListNode fast=start,current =start;
        current.next = head;
        if(n == 0)
            return head;
   
            
        while(count<=n+1){
            fast = fast.next;
            count++;
        }
        while(fast != null){
            current = current.next;
            fast = fast.next;
        }
        ListNode skipNode = current.next;
        current.next = skipNode.next;
        return start.next;
    }

}
