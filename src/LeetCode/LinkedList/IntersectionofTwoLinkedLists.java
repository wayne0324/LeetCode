
package LeetCode.LinkedList;

//160. Write a program to find the node at which the intersection of two singly linked lists begins.
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len_A = length(headA), len_B = length(headB);
        while(len_A > len_B){
            headA = headA.next;
            len_A--;
        }
        while(len_A < len_B){
            headB = headB.next;
            len_B--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;



    }

    private int length(ListNode node){
        int length = 0;
        while(node!=null){
            node = node.next;
            length++;
        }
        return length;
    }

}
