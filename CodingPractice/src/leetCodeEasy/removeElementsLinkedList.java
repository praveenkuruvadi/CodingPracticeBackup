package leetCodeEasy;

public class removeElementsLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        if(head.next == null && head.val == val)
            return null;
        if(head.val ==val){
            while(head.val ==val){
                if(head.next == null)
                    return null;
                head =head.next;
            }
                
        }
        ListNode curr =head;
        while(curr.next!=null){
            if(curr.next.val == val && curr.next.next == null){
                curr.next = null;
                break;
            }
            else if(curr.next.val == val){
                ListNode temp = curr.next;
                while(temp.val == val){
                    if(temp.next == null){
                        temp = null;
                        break;
                    }
                        
                    temp=temp.next;
                }
                    
                curr.next = temp;
                if(temp == null)
                    break;
            }
                
            curr = curr.next;
        }
        return head;
        
    }

}
