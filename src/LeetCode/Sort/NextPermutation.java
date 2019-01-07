package LeetCode.Sort;

// https://blog.csdn.net/qq_34672688/article/details/79557380 字典排序
// https://blog.csdn.net/napoay/article/details/79879529


public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i>=0&&nums[i+1]<=nums[i]) i--;
        if(i>=0){
            int j = nums.length - 1;
            while(j>=0&&nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[]nums, int start){
        int i = start, j = nums.length -1;
        while(i<j){
            swap(nums, i , j);
            i++;
            j--;
        }
    }

//    如果当前排列是124653,找它的下一个排列的方法是，从这个序列中从右至左找第一个左邻小于右邻的数，
//
//    如果找不到，则所有排列求解完成，如果找得到则说明排列未完成。
//
//    本例中将找到46,计4所在的位置为i,找到后不能直接将46位置互换，而又要从右到左到第一个比4大的数，
//
//    本例找到的数是5，其位置计为j，将i与j所在元素交换125643,
//
//    然后将i+1至最后一个元素从小到大排序得到125346，这就是124653的下一个排列。


}
