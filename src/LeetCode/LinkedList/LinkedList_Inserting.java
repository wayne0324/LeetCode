package LeetCode.LinkedList;

public class LinkedList_Inserting {

    Node head;

    class Node{
        int val;
        Node next;
        Node(int x){val = x; next = null;}
    }

    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAfter(Node prev_node, int new_data){
        if(prev_node == null){
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void append(int new_data){
        Node new_node = new Node(new_data);
        if(head == null){
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while(last.next != null) last = last.next;
        last.next = new_node;
        return;
    }

    public void printList(){
        Node tnode = head;
        while(tnode != null){
            System.out.println(tnode.val+" ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList_Inserting list = new LinkedList_Inserting();
        list.append(6);
        list.push(7);
        list.push(1);
        list.append(4);
        list.insertAfter(list.head.next, 8);
        System.out.println("\nCreated Linked list is: ");
        list.printList();
    }

}
