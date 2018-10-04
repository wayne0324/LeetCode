package LeetCode.LinkedList;

public class ListCycle {
    public boolean hasCycle_twoPointers(ListNode head) {
        ListNode slow = head, fast = head.next;

        if(slow == null || fast == null){
            return false;
        }

        while(slow != fast) {
            if(fast == null){
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;


    }

//    public boolean hasCycle_hashTable(ListNode head){
//
//    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

}
