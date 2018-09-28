package LeetCode.sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length - 3; i++){
            if(i==0 || i>0 && nums[i] != nums[i-1]){
                for(int j = i + 1; j < nums.length - 2; j++){
                    int lo = j + 1, hi = nums.length - 1;
                    if(j==i+1 || j>i+1 &&nums[j]!=nums[j-1]){
                        while(lo<hi){
                            int sum = target - nums[i] - nums[j];
                            if(sum == nums[lo] + nums[hi]){
                                res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                                while(nums[lo]==nums[lo+1]&&lo<nums.length-3) lo++;
                                while(nums[hi]==nums[hi-1]&&hi>1) hi--;
                                lo++;hi--;
                            }else if(sum > nums[lo] + nums[hi]) lo++;
                            else hi--;


                        }

                    }
                }
            }

        }
        return res;

    }

}