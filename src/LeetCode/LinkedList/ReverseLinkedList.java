package LeetCode.LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

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
        

    }

}
