package LeetCode.LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList_iteratively(ListNode head) {

        if(head == null||head.next==null){
            return head;
        }else{
            ListNode pre = head;
            ListNode curr = head.next;
            ListNode temp = curr;
            while(temp!=null){
                temp=temp.next;
                curr.next = pre;
                pre = curr;
                curr = temp;

            }
            head.next = null;
            head = pre;
        }
        return head;


    }



    public ListNode reverseList_recursively(ListNode head) {

        if(head == null||head.next==null){
            return head;
        }

        ListNode p=reverseList_recursively(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }

}
