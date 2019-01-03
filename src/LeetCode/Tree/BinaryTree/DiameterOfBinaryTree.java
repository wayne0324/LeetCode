package LeetCode.Tree.BinaryTree;
import LeetCode.Tree.TreeNode;

public class DiameterOfBinaryTree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestLink(root);
        return ans;
    }

    private int longestLink(TreeNode root){
        if(root == null) return 0;
        int L = longestLink(root.left);
        int R = longestLink(root.right);
        ans = Math.max(ans, L+R);
        return Math.max(L,R)+1;

    }
}
