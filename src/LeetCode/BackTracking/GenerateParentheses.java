package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> list = generateParentheses.generateParenthesis(2);
        System.out.println(Arrays.toString(list.toArray()));/**简单的打印ArrayList的方法！*/
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();  //这里不能写 new List<String>(),一定要是LinkedList或者是ArrayList
        doadd(n,n,list,"");
        return list;
    }

    public static void doadd(int left, int right, List<String> list, String path){

        if (left == 0 && right == 0){
            list.add(path);
            return;
        }
        if (left != 0)
            doadd(left-1,right,list,path+"(");
        if (right != 0 && right > left)
            doadd(left,right-1,list,path+")");
    }

}
