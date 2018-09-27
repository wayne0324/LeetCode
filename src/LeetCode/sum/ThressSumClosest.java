package LeetCode.sum;
//Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
//Return the sum of the three integers. You may assume that each input would have exactly one solution.
//Example:
//Given array nums = [-1, 2, 1, -4], and target = 1.
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

import java.util.Arrays;

public class ThressSumClosest {
    public int threeSumClosest(int[] num, int target){
        Arrays.sort(num);
        int result = num[0] + num[1] +num[num.length-1];
        for(int i=0;i<num.length-2;i++){
            int lo = i+1, hi = num.length-1;
            while(lo<hi){
                int sum = num[i]+num[lo]+num[hi];
                if(sum>target){
                    hi--;
                }else{
                    lo++;
                }
                if(Math.abs(sum-target)<Math.abs(result-target)){
                    result = sum;
                }
            }
        }

        return result;
    }

}
