package LeetCode.Tree.BinaryTree;
//Invert a binary tree.
//
//        Example:
//
//        Input:
//
//        4
//        /   \
//        2     7
//        / \   / \
//        1   3 6   9
//        Output:
//
//        4
//        /   \
//        7     2
//        / \   / \
//        9   6 3   1

import LeetCode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {


////  Method1:  Recursion
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode right = invertTree(root.right);
//        TreeNode left = invertTree(root.left);
//        root.left = right;
//        root.right = left;
//
//        return root;
//    }

//  Method2:  Iterative BFS
    public TreeNode inverTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);

        }
        return root;
    }


}
