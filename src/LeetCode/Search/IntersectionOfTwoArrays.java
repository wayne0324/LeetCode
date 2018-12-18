package LeetCode.Search;

//Given two arrays, write a function to compute their intersection.
//
//        Example 1:
//
//        Input: nums1 = [1,2,2,1], nums2 = [2,2]
//        Output: [2]
//        Example 2:
//
//        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        Output: [9,4]
//        Note:
//
//        Each element in the result must be unique.
//        The result can be in any order.

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

    //Solution 1: O(n) HashSet
    public int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> intersection = new HashSet<Integer>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int j : nums2) {
            if (set.contains(j)) {
                intersection.add(j);
            }
        }

        int[] result = new int[intersection.size()];
        int val = 0;
        for (Integer num : intersection) {
            result[val++] = num;
        }
        return result;

    }

    //solution2: O(nlogn) binary search
//    public int[] intersection(int[] nums1, int[] nums2){
//        HashSet<Integer> intersection = new HashSet<Integer>();
//        Arrays.sort(nums1);
//        for (Integer num : nums2) {
//            if(binarySearch(nums1, num){
//                intersection.add(num);
//            }
//
//        }
//
//        int[] result = new int[intersection.size()];
//        int val = 0;
//        for (Integer integer : intersection) {
//            result[val++] = integer;
//
//        }
//    }
//
//    private boolean binarySearch(int[] nums, int target) {
//        int lo = 0, hi = nums.length-1;
//        while (lo <= hi) {
//            int mid = lo + (hi-lo)/2;
//            if(nums[mid]==target){
//                return true;
//            }else if(nums[mid]>target){
//                hi = mid - 1;
//            }else{
//                lo = mid + 1;
//            }
//        }
//        return false;
//    }


}
