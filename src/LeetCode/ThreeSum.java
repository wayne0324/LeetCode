package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public List<Integer> threeSum(int[] num) {
        Arrays.sort(num);
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                }
            }
        }

    }

}