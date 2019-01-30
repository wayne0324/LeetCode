package LeetCode.Tree.BinaryTree;

import LeetCode.Tree.TreeNode;
//114. Flatten Binary Tree to Linked List
public class FlattenBinaryTreeToLinkedList {

    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }



}

