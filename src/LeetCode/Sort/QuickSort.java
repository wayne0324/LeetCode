package LeetCode.Sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int array[] = {13, 33, 34, 78, 11, 12, 10, 99};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int array[], int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = array[i];
        while (i < j) {
            while (i < j && array[j] > key) {
                j--;
            }
            array[i] = array[j];
            //从后往前找到第一个比key小的数与array[i]交换；
            while (i < j && array[i] < key) {
                i++;
            }
            array[j] = array[i];
            //从前往后找到第一个比key大的数与array[j]交换；
        }
        array[i] = key;
        //一趟快排之后已经将key的位置找到。
        quickSort(array, left, i - 1);
        //对key左边的进行排序
        quickSort(array, i + 1, right);
        //对key右边的进行排序
    }
}

