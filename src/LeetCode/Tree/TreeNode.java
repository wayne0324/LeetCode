package LeetCode.Tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){val = x;}

    public void display(){
        System.out.println(this.val + "\t");
    }

    public String toString() {
        return String.valueOf(val);
    }

}
