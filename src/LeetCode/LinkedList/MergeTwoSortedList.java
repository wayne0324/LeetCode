package LeetCode.LinkedList;

//21.Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
//        Example:
//
//        Input: 1->2->4, 1->3->4
//        Output: 1->1->2->3->4->4
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val < l2.val){        //get smaller value, then smaller value.next = next smaller value
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);    //get smaller value, then smaller value.next = next smaller value
            return l2;
        }


    }




    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

}
