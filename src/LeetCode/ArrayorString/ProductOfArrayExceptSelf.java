package LeetCode.ArrayorString;

//238. Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//Example:
//
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
//Note: Please solve it without division and in O(n).
//
//Follow up:
//Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 0; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;

        for (int i = n - 1; i >= 0; i--) {   //注意这里是要 i>=0 不是 i<=0~不要瞎写！
            res[i] = res[i] * right;
            right = right * nums[i];
        }

        return res;
    }
}

/** 现在明白了， 给定任意一个点， res[i]  的值应该等于它的左边： res[0..i-1] 与 右边 ：res[i+1 ... len] 乘
 所以第一次从左向右，把每一个点的 res[0..i-1] 乘完算出来暂存在 res[i] 上。

 然后再从右边向左边乘，把右边res[i+1 ... len] 累乘完再乘以res[i], 注意这里res[i]上一次循环己经暂存成了res[0..i-1]的值， 所以现在结果正好等于: res[0..i-1] * res[i+1 ... len]
 太聪明！*/