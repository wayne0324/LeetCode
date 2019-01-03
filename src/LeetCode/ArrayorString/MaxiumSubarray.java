package LeetCode.ArrayorString;

public class MaxiumSubarray {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1};
        MaxiumSubarray maxiumSubarray = new MaxiumSubarray();
        maxiumSubarray.maxSubArray(arr);
    }

//    //Solution 1:
//    public int maxSubArray(int[] nums) {
//        int sum = 0;
//        int max = Integer.MIN_VALUE;
//        for(int num:nums){
//            sum = Math.max(sum + num, num);
//            max = Math.max(max, sum);
//        }
//        System.out.println(max);
//        return max;
//    }

    //Solution 2 divide and conquer:

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return Max_Subarray_Sum(nums, 0, nums.length - 1);

    }

    public int Max_Subarray_Sum(int[] nums, int left, int right){

        if (left == right) {
            return nums[left];
        }

        int middle = (left + right)/2;

        int left_mss = Max_Subarray_Sum(nums,left,middle);
        int right_mss = Max_Subarray_Sum(nums, middle + 1, right);

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = middle + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Integer.max(rightSum, sum);
        }

        sum = 0;

        for (int i = middle; i >= left; i--) {
            sum += nums[i];
            leftSum = Integer.max(leftSum, sum);
        }

        int res = Integer.max(left_mss, right_mss);

        System.out.println("res: "+res+"\n"+"leftsum:"+leftSum+" rightsum:"+rightSum+" left_mss:"+left_mss+" right_mss:"+right_mss);

        return Integer.max(res, leftSum + rightSum);
    }

}
