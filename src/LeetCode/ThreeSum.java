package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); // eg: [[-1,-1,2],[-1,1,0]......]
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || i > 0 && nums[i] != nums[i-1]){
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (nums[lo] == nums[lo+1] && lo < nums.length - 3) lo++; // lo < num.length -3 is for avoiding out of bound
                        while (lo < hi && nums[hi] == nums[hi-1] && hi > 1) hi--;
                        lo++; hi--;

                    }else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

}