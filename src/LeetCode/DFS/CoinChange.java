package LeetCode.DFS;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[][] f = new int[coins.length + 1][amount + 1];
        Arrays.fill(f[coins.length], Integer.MAX_VALUE);
        f[coins.length][0] = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i+1][j];
                if (j >= coins[i]) {
                    if (f[i][j - coins[i]] < Integer.MAX_VALUE) {
                        f[i][j] = Integer.min(f[i][j], f[i][j - coins[i]] + 1);
                    }
                }
            }
        }
        return (f[0][amount] == Integer.MAX_VALUE ? -1 : f[0][amount]);
    }

//    public int coinChange(int[] coins, int amount) {
//        int [][]f = new int[coins.length+1][amount+1];
//        Arrays.fill(f[coins.length], Integer.MAX_VALUE);
//        f[coins.length][0] = 0;
//        for (int i = coins.length - 1; i >= 0; i--) {
//            for(int j=0;j<=amount;j++){
//                f[i][j] = f[i+1][j];
//                int maxK = j / coins[i];
//                for (int k = 1; k <= maxK; k++) {
//                    int prev = f[i + 1][j - k * coins[i]];
//                    if (prev < Integer.MAX_VALUE) {
//                        f[i][j] = Integer.min(f[i][j], prev + k);
//                    }
//                }
//            }
//        }
//        return (f[0][amount] == Integer.MAX_VALUE? -1: f[0][amount]);
//    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] a = {1, 2, 5};
        System.out.println("number of coins: " + coinChange.coinChange(a, 11));
    }
}
