package leetCodeEasy;

public class mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newRoot = null,currNode = null;
        
        while(l1!=null || l2 !=null){
            if(l1==null){
                if(newRoot == null){
                    newRoot = new ListNode(l2.val);
                    currNode=newRoot;
                    l2=l2.next;
                }else{
                    currNode.next = new ListNode(l2.val);
                    currNode =currNode.next;
                    l2= l2.next;
                }
            }else if(l2== null){
                if(newRoot == null){
                    newRoot = new ListNode(l1.val);
                    currNode=newRoot;
                    l1=l1.next;
                }else{
                    currNode.next = new ListNode(l1.val);
                    currNode =currNode.next;
                    l1= l1.next;
                }
                
            }else{
                if(newRoot == null){
                    if(l1.val<l2.val){
                        newRoot = new ListNode(l1.val);
                        currNode = newRoot;
                        l1=l1.next;
                    }else{
                        newRoot = new ListNode(l2.val);
                        currNode = newRoot;
                        l2=l2.next;
                    }
                }else{
                    if(l1.val <l2.val){
                        currNode.next = new ListNode(l1.val);
                        currNode = currNode.next;
                        l1 = l1.next;
                    }else{
                        currNode.next = new ListNode(l2.val);
                        currNode = currNode.next;
                        l2 = l2.next;
                    }
                }
                
            }
        }
        return newRoot;
        
    }

}
