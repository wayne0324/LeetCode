package LeetCode.Tree.BinaryTree;

import LeetCode.Tree.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        return traverse(s,t);

    }

    private boolean isSameTree(TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null) return true;
        if(t1==null||t2==null) return false;
        return (t1.val==t2.val) && isSameTree(t1.left, t2.left) && isSameTree(t1.right,t2.right);
    }

    private boolean traverse(TreeNode s, TreeNode t){

        return  (s!=null) && (isSameTree(s,t) || traverse(s.left,t) || traverse(s.right,t));

        /**假如s.root = null,isSameTree(s,t)会返回false,然后执行到traverse(s.left,t)就会抛出exception*/
    }
}
