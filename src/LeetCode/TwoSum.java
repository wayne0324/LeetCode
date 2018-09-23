package LeetCode;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(nums, 22);

    }

    public int[] twoSum(int[] nums, int target) {

        int[] solution = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                    break;
                }
            }
        }


        return solution;
    }
}