package LeetCode.ArrayorString;

import java.net.NoRouteToHostException;
import java.util.Arrays;
import java.util.Random;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length/2; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = temp;
        }
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix.length;j++){
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
