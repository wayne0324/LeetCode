package LeetCode.Tree.Main;
import LeetCode.Tree.TreeNode;

import java.util.Stack;


/**
 二叉树之Java实现二叉树基本操作 https://blog.csdn.net/fengrunche/article/details/52305748
 */

public class BinaryTree {

    TreeNode root = null;

    BinaryTree(int val) {
        root = new TreeNode(val);
        root.left  = null;
        root.right = null;
    }
    

    public TreeNode findKey(int val) {
        TreeNode current = root;
        while (true) {
            if (val == current.val) {
                return current;
            } else if (val < current.val) {
                current = current.left;
            } else if (val > current.val) {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }
    }

    public String insert(int val) {
        String error = null;

        TreeNode TreeNode = new TreeNode(val);
        if (root == null) {
            root = TreeNode;
            root.left  = null;
            root.right = null;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                if (val < current.val) {
                    parent = current;
                    current = current.left;
                    if (current == null) {
                        parent.left = TreeNode;
                        break;
                    }
                } else if (val > current.val) {
                    parent = current;
                    current = current.right;
                    if (current == null) {
                        parent.right = TreeNode;
                        break;
                    }
                } else {
                    error = "having same val in binary tree";
                }
            } // end of while
        }
        return error;
    }

    /**
     * //中序遍历(递归)：
     *    1、调用自身来遍历节点的左子树
     *    2、访问这个节点
     *    3、调用自身来遍历节点的右子树
     */
    public void inOrderTraverse() {
        System.out.print("中序遍历:");
        inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(TreeNode TreeNode) {
        if (TreeNode == null)
            return ;

        inOrderTraverse(TreeNode.left);
        TreeNode.display();
        inOrderTraverse(TreeNode.right);
    }

    /**
     * 中序非递归遍历：
     *     1）对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     *     2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     *     3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void inOrderByStack() {
        System.out.print("中序非递归遍历:");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current.display();
                current = current.right;
            }
        }
        System.out.println();
    }

    /**
     * //前序遍历(递归)：
     *    1、访问这个节点
     *    2、调用自身来遍历节点的左子树
     *    3、调用自身来遍历节点的右子树
     */
    public void preOrderTraverse() {
        System.out.print("前序遍历:");
        preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(TreeNode TreeNode) {
        if (TreeNode == null)
            return ;

        TreeNode.display();
        preOrderTraverse(TreeNode.left);
        preOrderTraverse(TreeNode.right);
    }

    /**
     * 前序非递归遍历：
     *     1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     *     2）若左子树为空，栈顶节点出栈，将该节点的右子树置为current
     *     3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void preOrderByStack() {
        System.out.print("前序非递归遍历:");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current.display();
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }
        System.out.println();
    }

    /**
     * //后序遍历(递归)：
     *    1、调用自身来遍历节点的左子树
     *    2、调用自身来遍历节点的右子树
     *    3、访问这个节点
     */
    public void postOrderTraverse() {
        System.out.print("后序遍历:");
        postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(TreeNode TreeNode) {
        if (TreeNode == null)
            return ;

        postOrderTraverse(TreeNode.left);
        postOrderTraverse(TreeNode.right);
        TreeNode.display();
    }

    /**
     * 后序非递归遍历：
     *     1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     *     2）若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preTreeNode置为该节点
     *     3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void postOrderByStack() {
        System.out.print("后序非递归遍历:");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        TreeNode preTreeNode = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.peek().right;
                if (current == null || current == preTreeNode) {
                    current = stack.pop();
                    current.display();
                    preTreeNode = current;
                    current = null;
                }
            }
        }
        System.out.println();
    }

    public int getMinval() {
        TreeNode current = root;
        while (true) {
            if (current.left == null)
                return current.val;

            current = current.left;
        }
    }


    /**
     *
     * 得到后继节点，即删除节点的左后代
     */
    private TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successor = delNode;
        TreeNode successorParent = null;
        TreeNode current = delNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        //如果后继节点不是删除节点的右子节点时，
        if (successor != delNode.right) {
            //要将后继节点的右子节点指向后继结点父节点的左子节点，
            successorParent.left = successor.right;
            //并将删除节点的右子节点指向后继结点的右子节点
            successor.right = delNode.right;
        }
        //任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点
        successor.left = delNode.left;

        return successor;
    }


    public boolean delete(int val) {
        TreeNode current = root;    //需要删除的节点
        TreeNode parent = null;     //需要删除的节点的父节点
        boolean isleft = true;   //需要删除的节点是否父节点的左子树

        while (true) {
            if (val == current.val) {
                break;
            } else if (val < current.val) {
                isleft = true;
                parent = current;
                current = current.left;
            } else {
                isleft = false;
                parent = current;
                current = current.right;
            }

            //找不到需要删除的节点，直接返回
            if (current == null)
                return false;
        }

        //分情况考虑
        //1、需要删除的节点为叶子节点
        if (current.left == null && current.right == null) {
            //如果该叶节点为根节点，将根节点置为null
            if (current == root) {
                root = null;
            } else {
                //如果该叶节点是父节点的左子节点，将父节点的左子节点置为null
                if (isleft) {
                    parent.left  = null;
                } else { //如果该叶节点是父节点的右子节点，将父节点的右子节点置为null
                    parent.right = null;
                }
            }
        }
        //2、需要删除的节点有一个子节点，且该子节点为左子节点
        else if (current.right == null) {
            //如果该节点为根节点，将根节点的左子节点变为根节点
            if (current == root) {
                root = current.left;
            } else {
                //如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点
                if (isleft) {
                    parent.left = current.left;
                } else {  //如果该节点是父节点的右子节点，将该节点的左子节点变为父节点的右子节点
                    parent.right = current.left;
                }
            }
        }
        //2、需要删除的节点有一个子节点，且该子节点为右子节点
        else if (current.left == null) {
            //如果该节点为根节点，将根节点的右子节点变为根节点
            if (current == root) {
                root = current.right;
            } else {
                //如果该节点是父节点的左子节点，将该节点的右子节点变为父节点的左子节点
                if (isleft) {
                    parent.left = current.right;
                } else {  //如果该节点是父节点的右子节点，将该节点的右子节点变为父节点的右子节点
                    parent.right = current.right;
                }
            }
        }
        //3、需要删除的节点有两个子节点，需要寻找该节点的后续节点替代删除节点
        else {
            TreeNode successor = getSuccessor(current);
            //如果该节点为根节点，将后继节点变为根节点，并将根节点的左子节点变为后继节点的左子节点
            if (current == root) {
                root = successor;
            } else {
                //如果该节点是父节点的左子节点，将该节点的后继节点变为父节点的左子节点
                if (isleft) {
                    parent.left = successor;
                } else {  //如果该节点是父节点的右子节点，将该节点的后继节点变为父节点的右子节点
                    parent.right = successor;
                }
            }
        }
        current = null;
        return true;
    }




}
