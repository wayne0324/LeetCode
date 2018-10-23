package LeetCode.DynamicProgramming;

//746.On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
//
//        Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
//
//        Example 1:
//        Input: cost = [10, 15, 20]
//        Output: 15
//        Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
//        Example 2:
//        Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//        Output: 6
//        Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
//        Note:
//        cost will have a length in the range [2, 1000].
//        Every cost[i] will be an integer in the range [0, 999].

public class MinCostClimbingStairs {

//    Solution #1: Bottom-Up dynamic programming
//
//    Let dp[i] be the minimum cost to reach the i-th stair.
//
//    Base cases:
//
//    dp[0]=cost[0]
//    dp[1]=cost[1]
//
//    DP formula:
//
//    dp[i]=cost[i]+min(dp[i-1],dp[i-2])
//
//    Note: the top floor n can be reached from either 1 or 2 stairs away, return the minimum.

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i<cost.length;i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[cost.length-2],dp[cost.length-1]);

    }
}
