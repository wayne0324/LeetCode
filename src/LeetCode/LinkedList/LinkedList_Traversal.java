package LeetCode.LinkedList;
import LeetCode.LinkedList.ListNode;
//import LeetCode.LinkedList.ListCycleII.ListNode;
import LeetCode.LinkedList.ReverseLinkedList;

public class LinkedList_Traversal {

    LeetCode.LinkedList.ListNode head;



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
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
//        Node curr = list.head;

        list.head.next = second;
        second.next= third;
        third.next = fourth;
        fourth.next = fifth;

//        ListCycleII listCycleII = new ListCycleII();
//        listCycleII.detectCycle_twoPointers(list.head);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
//        reverseLinkedList.reverseList_iteratively(list.head);
        ListNode p = reverseLinkedList.reverseList_recursively(list.head);
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }


    }


}
