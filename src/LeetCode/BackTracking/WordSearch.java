package LeetCode.BackTracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        boolean[][] used = new boolean[board.length][board[0].length];

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(existHelper(board, used,word.toCharArray(),0,col,row)){
                    // System.out.println("wtf");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, boolean[][] used, char[] word, int idx, int col, int row){

        if(idx == word.length) return true;
        if(row<0||row>=board.length||col<0||col>=board[0].length) return false;
        // System.out.println(board[row][col]);
        if(used[row][col]==true||board[row][col]!=word[idx]) return false; //这个字母用过了吗？
        used[row][col]=true; //先标记成为这个字母已经用过了，执行下面的语句

        boolean exist = existHelper(board,used,word,idx+1,col+1,row);
        if(exist) return true;
        exist = existHelper(board,used,word,idx+1,col-1,row);
        if(exist) return true;
        exist = existHelper(board,used,word,idx+1,col,row+1);
        if(exist) return true;
        exist = existHelper(board,used,word,idx+1,col,row-1);
        // System.out.println(exist);
        used[row][col]=false; //如果这个字母的上下左右都没有找到下一个字母，就当当前这个字母标记成没过过

        if(exist) return true;

        return false;

    }
}
