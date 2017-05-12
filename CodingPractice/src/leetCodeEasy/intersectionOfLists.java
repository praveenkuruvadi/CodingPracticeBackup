package leetCodeEasy;


import leetCodeEasy.ListNode;
public class intersectionOfLists {
	public static void main(String[] args){
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(1);
		System.out.println(getIntersectionNode( headA,  headB).val);
	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
       
        int lenA =0,lenB=0;
        ListNode currA =headA;
        ListNode currB = headB;
        while(currA !=null){
            lenA++;
            currA=currA.next;
        }
        while(currB !=null){
            lenB++;
            currB = currB.next;
        }
        int diff = lenA-lenB;
        System.out.println(diff);
        if(diff>0){
            int count=0;
            while(count<diff){
                headA=headA.next;
                count++;
            }
            while(headA != null && headB !=null){
                if(headA.val == headB.val)
                    return headA;
                headA=headA.next;
                headB=headB.next;
            }
            return null;
        }else if(diff<0){
            diff = Math.abs(diff);
            int count=0;
            while(count<diff){
                headB=headB.next;
                count++;
            }
            while(headA != null && headB !=null){
                if(headA.val == headB.val)
                    return headA;
                headA=headA.next;
                headB=headB.next;
            }
            return null;
        }else{
        	System.out.println("here");
            while(headA != null && headB !=null){
                if(headA.val == headB.val)
                    return headA;
                headA=headA.next;
                headB=headB.next;
            }
            return null;
        }
    }
}
