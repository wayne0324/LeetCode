package LeetCode.ArrayorString;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    //     O(NlongN) 解法
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 1) return nums.length;
        int len = 0;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        for(int num : nums){
            if(num < tails[0]){
                tails[0] = num;
            }else if(num > tails[len]){
                tails[++len] = num;
            }else{
                tails[binarySearch(tails,0,len,num)] = num;
            }
        }
        System.out.println(Arrays.toString(tails));
        return len + 1;

    }

    public int binarySearch(int[] tails, int min, int max, int target){
        if(min >= max) return min;
        int mid = (min + max)/2;
        if(tails[mid]==target || (tails[mid]>target&&tails[mid-1]<target)) {
            return mid;
        }else if(tails[mid] > target){
            return binarySearch(tails,min,mid-1,target);
        }else{
            return binarySearch(tails,mid+1,max,target);
        }
    }

    //     O(N2) 解法
//    public int lengthOfLIS(int[] nums) {
//        if(nums.length < 1) return nums.length;
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp,1);
//        for(int i = 1; i < nums.length; i++){
//            for(int j = 0; j<i; j++){
//                if(nums[j]<nums[i]){
//                    if(dp[i]<dp[j]+1){
//                        dp[i] = dp[j]+1;
//                    }
//                }
//            }
//        }
//
//        int longest = 0;
//        for(int i=0; i<dp.length;i++){
//            longest = Math.max(longest,dp[i]);
//        }
//        return longest;
//    }
}
