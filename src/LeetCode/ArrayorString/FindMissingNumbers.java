package LeetCode.ArrayorString;

import java.util.*;

//解题要求：数组里面的数都小于数组的长度！
public class FindMissingNumbers {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindMissingNumbers findMissingNumbers = new FindMissingNumbers();
        findMissingNumbers.findDisappearedNumbers(nums);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        System.out.println(ret);
        return ret;
    }
}
