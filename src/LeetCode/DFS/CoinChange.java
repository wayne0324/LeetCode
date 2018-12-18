package LeetCode.DFS;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount+1]);
    }

    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if(rem<0) return -1; // not valid
        if(rem==0) return 0; // completed
        if(count[rem] != 0) return count[rem]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            System.out.println("coin: " + coin);
            int result = helper(coins, rem-coin, count);
            System.out.println("rem: " + (rem));
            System.out.println("result: " + result);
            if(result>=0 && result < min)
                min = 1+result;
            System.out.println("min: " + min);
        }
        count[rem] = (min==Integer.MAX_VALUE) ? -1 : min;
        System.out.println("return count[" + (rem) + "]= "  +count[rem] + '\n');

        return count[rem];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] a = {1, 2, 5};
        System.out.println("number of coins: "+coinChange.coinChange(a, 11));
    }
}
