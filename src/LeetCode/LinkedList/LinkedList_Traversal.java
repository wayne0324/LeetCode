package LeetCode.LinkedList;


public class LinkedList_Traversal {

    Node head;

    static class Node{
        int val;
        Node next;
        Node(int x){ val = x; next = null;}
    }

    public void printList(){
        Node n = head;
        while(n!=null){
            System.out.println(n.val+" ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedList_Traversal list = new LinkedList_Traversal();
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node curr = list.head;

        list.head.next = second;
        second.next = third;
        curr.next = third;
//        System.out.println(list.head.next.next.val+"  "+second.next.val);


        System.out.println(list.head.next.next+"  "+second.next);
    }


}
