package LeetCode.sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//        Note:
//        The solution set must not contain duplicate quadruplets.
//
//        Example:
//
//        Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//        A solution set is:
//        [
//        [-1,  0, 0, 1],
//        [-2, -1, 1, 2],
//        [-2,  0, 0, 2]
//              ]
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length-3; i++){
            if(i==0||i>0&&nums[i]!=nums[i-1]){
                for(int j = i + 1; j< nums. length - 2; j++){
                    int lo = j + 1, hi = nums.length - 1;
                    if(j>0 && nums[j]!=nums[j-1]){
                        int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                        if(sum == target){
                            res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                            while(nums[lo]==nums[lo+1]&&lo<nums.length-3) lo++;
                            while(nums[hi]==nums[hi-1]) hi--;
                            lo++;hi--;
                        }else if(sum>target) hi--;
                        else lo++;

                    }
                }
            }

        }
        return res;
    }

}
