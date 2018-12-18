package LeetCode.Tree.Main;
import LeetCode.Tree.BST.*;
public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree(5);
        bt.insert(2);
        bt.insert(13);
        bt.insert(1);
        bt.insert(3);
        bt.insert(7);
        bt.insert(20);
//        bt.insert(248);
//        bt.insert(32);
//        bt.insert(666);
//        bt.insert(455);
//        bt.insert(777);
//        bt.insert(999);
        bt.inOrderTraverse();
//        bt.preOrderTraverse();
//        bt.postOrderTraverse();
//        System.out.println(bt.findKey(32));
//        System.out.println(bt.findKey(81));
//        System.out.println("最小值:" + bt.getMinval());
//		bt.delete(32);      //删除叶子节点
//		bt.delete(50);      //删除只有一个左子节点的节点
//		bt.delete(248);      //删除只有一个右子节点的节点
//		bt.delete(248);      //删除只有一个右子节点的节点
//		bt.delete(580);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点的左后代
//		bt.delete(888);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点
//        bt.delete(52);       //删除有两个子节点的节点，且删除节点为根节点

//        bt.inOrderTraverse();

        ConvertBSTtoBiggerTree convertBSTtoBiggerTree = new ConvertBSTtoBiggerTree();
        convertBSTtoBiggerTree.convertBST(bt.root);
        bt.inOrderTraverse();

    }
}