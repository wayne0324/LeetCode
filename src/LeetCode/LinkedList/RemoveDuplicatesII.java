package LeetCode.LinkedList;

//82. Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//        Example 1:
//
//        Input: 1->2->3->3->4->4->5
//        Output: 1->2->5
//        Example 2:
//
//        Input: 1->1->1->2->3
//        Output: 2->3

public class RemoveDuplicatesII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = head, pre = dummyNode; // pre = dummyNode rather than head!!
        dummyNode.next = head;

        while (curr != null && curr.next != null) {

            if (curr.val != curr.next.val) {
                pre = curr;
                curr = curr.next;
            } else {

                while (curr.next != null && curr.val == curr.next.val) {   //if switch items on both sides of &&, there will be null pointer error

                    curr = curr.next;
                }
                if (curr != null) {
                    pre.next = curr.next;
                    curr = curr.next;
                }
            }

        }
        return dummyNode.next;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
