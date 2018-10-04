package LeetCode.LinkedList;

import LeetCode.LinkedList.ListCycleII.ListNode;


public class LinkedList_Traversal {

    ListNode head;



    public void printList(){
        ListNode n = head;
        while(n!=null){
            System.out.println(n.val+" ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedList_Traversal list = new LinkedList_Traversal();

        list.head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = list.head;
//        Node second = new Node(2);
//        Node third = new Node(3);
//        Node curr = list.head;

        list.head.next = second;
        second.next= third;

        ListCycleII listCycleII = new ListCycleII();
        listCycleII.detectCycle_twoPointers(list.head);
    }


}
