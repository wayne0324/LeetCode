package LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;


//141.Given a linked list, determine if it has a cycle in it.
//
//        Follow up:
//        Can you solve it without using extra space?
public class ListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){   //In case list is empty. (ex: given [])
            return false;
        }
        ListNode slow = head, fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null){
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;


    }

    public boolean hasCycle_hashTable(ListNode head){

        Set<ListNode> repeatedNode = new HashSet<>();
        while(head != null){
            repeatedNode.add(head);
            head = head.next;
            if(repeatedNode.contains(head)){
                return true;
            }
        }
        return false;

    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

}
