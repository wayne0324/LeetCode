package LeetCode.LinkedList;
//142.Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//        Note: Do not modify the linked list.
//
//        Follow up:
//        Can you solve it without using extra space?

import java.util.HashSet;
import java.util.Set;

public class ListCycleII {
    public ListNode detectCycle_hashTable(ListNode head) {
        Set<ListNode> firstCycleNode = new HashSet<>();
        if (head == null) return null;
        while(head!=null){
            if(firstCycleNode.contains(head)){
                return head;
            }
            firstCycleNode.add(head);
            head = head.next;
        }
        return null;


    }

    private ListNode findIntersect(ListNode head){
        if(head == null || head.next == null) return null;
//        ListNode slow = head, fast = head;
//        while(fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if(slow == fast){
//                return fast;
//            }
//        }
//        return null;

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
    public ListNode detectCycle_twoPointers(ListNode head) {
        ListNode intersect = findIntersect(head);
        if(intersect == null){
            return null;
        }else{
            ListNode ptr1 = head;
            ListNode ptr2 = intersect;
            while(ptr1 != ptr2){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;

        }
    }



    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }
}
