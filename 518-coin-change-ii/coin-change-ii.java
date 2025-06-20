class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        return helperchange(coins, amount, coins.length, dp);

    }

    int helperchange(int[] coins, int amount, int i, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (i == 0) {
            return 0; //we cannot form any
        }
        if (dp[i][amount] != -1)
            return dp[i][amount];
        if (coins[i - 1] <= amount) {
            return dp[i][amount] = helperchange(coins, amount - coins[i - 1], i, dp)
                    + helperchange(coins, amount, i - 1, dp);
        }
        return dp[i][amount] = helperchange(
                coins, amount, i - 1, dp);
    }
}