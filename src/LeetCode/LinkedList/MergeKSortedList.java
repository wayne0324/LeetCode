package LeetCode.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

//23.Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
//        Example:
//
//        Input:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        Output: 1->1->2->3->4->4->5->6

/** Looking illustration in OneNote */

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
            System.out.println("node.val =  " + node.val);
        }


        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            System.out.println("tail.val = " + tail.val);

            if (tail.next != null) {
                System.out.println("tail.next.val = " + tail.next.val);
                queue.add(tail.next);
            }
        }
        return dummy.next;


    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}


