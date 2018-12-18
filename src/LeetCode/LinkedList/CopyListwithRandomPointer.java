package LeetCode.LinkedList;

//138. A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//Return a deep copy of the list.


import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class CopyListwithRandomPointer {

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(4);
        head.next = new RandomListNode(7);
        head.next.next = new RandomListNode(-2);

        CopyListwithRandomPointer copyListwithRandomPointer = new CopyListwithRandomPointer();
        copyListwithRandomPointer.copyRandomList(head);

    }

    static class RandomListNode{
        int label;
        RandomListNode next, random;
        RandomListNode(int x){this.label = x;}
    }


    //Solution 1: HashMap
    HashMap<RandomListNode,RandomListNode> visited = new HashMap<RandomListNode,RandomListNode>();
    public RandomListNode getClonedNode(RandomListNode node){
        if (node != null){
            if(this.visited.containsKey(node)){
                return this.visited.get(node);
            }else{
                this.visited.put(node, new RandomListNode(node.label));
                return this.visited.get(node);
            }
        }
        return null;
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        RandomListNode oldNode = head;
        RandomListNode newNode = new RandomListNode(oldNode.label);
        this.visited.put(oldNode, newNode);

        while(oldNode != null){
            newNode.next = this.getClonedNode(oldNode.next);
            newNode.random = this.getClonedNode(oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next;

        }

        System.out.println(visited);
        return this.visited.get(head);


    }

//    Solution 2: Modify directly on linkedList with space complexity O(1)
//    public RandomListNode copyRandomList(RandomListNode head) {
//
//        if (head == null) {
//            return null;
//        }
//
//        // Creating a new weaved list of original and copied nodes.
//        RandomListNode ptr = head;
//        while (ptr != null) {
//
//            // Cloned node
//            RandomListNode newNode = new RandomListNode(ptr.label);
//
//            // Inserting the cloned node just next to the original node.
//            // If A->B->C is the original linked list,
//            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
//            newNode.next = ptr.next;
//            ptr.next = newNode;
//            ptr = newNode.next;
//        }
//        ptr = head;
//
//        // Now link the random pointers of the new nodes created.
//        // Iterate the newly created list and use the original nodes' random pointers,
//        // to assign references to random pointers for cloned nodes.
//        while (ptr != null) {
//            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
//            ptr = ptr.next.next;
//        }
//
//        // Unweave the linked list to get back the original linked list and the cloned list.
//        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
//        RandomListNode ptr_old_list = head; // A->B->C
//        RandomListNode ptr_new_list = head.next; // A'->B'->C'
//        RandomListNode head_old = head.next;
//        while (ptr_old_list != null) {
//            ptr_old_list.next = ptr_old_list.next.next;
//            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
//            ptr_old_list = ptr_old_list.next;
//            ptr_new_list = ptr_new_list.next;
//        }
//        return head_old;
//    }

}

