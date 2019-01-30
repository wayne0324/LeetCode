package LeetCode.Tree.BinaryTree;

import LeetCode.Tree.TreeNode;

public class ConstructBinaryTreeFromPreAndIn {

    public static void main(String[] args) {
        int[] preorder = {1,2,4,6,7,5,9,3,10,11};
        int[] inorder = {6,4,7,2,8,5,1,10,3,11};

        ConstructBinaryTreeFromPreAndIn constructBinaryTreeFromPreAndIn = new ConstructBinaryTreeFromPreAndIn();
        constructBinaryTreeFromPreAndIn.buildTree(preorder,inorder);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
