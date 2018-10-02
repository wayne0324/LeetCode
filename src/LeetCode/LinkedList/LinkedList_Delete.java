package LeetCode.LinkedList;

public class LinkedList_Delete {
    Node head;

    class Node {
        int val;

        Node(int x) {
            val = x;
            next = null;
        }

        Node next;
    }

    void deleteNode(int key) {
        Node temp = head, prev = head;

        if (temp != null && temp.val == key) {
            head = temp.next;

        }

        while (temp != null) {
            if(temp.val == key){

                prev.next = temp.next;
                temp=temp.next;

            }else{
                prev = temp;
                temp = temp.next;

            }

        }

    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printlist() {
        Node tnode = head;
        while (tnode != null) {
            System.out.println(tnode.val + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList_Delete list = new LinkedList_Delete();
        list.push(7);
        list.push(1);
        list.push(3);
        list.push(2);
        list.push(1);
        list.push(4);
        System.out.println("\nCreated Linded list is:");
        list.printlist();
        list.deleteNode(1);
        System.out.println("after deletion: ");
        list.printlist();
    }


}
