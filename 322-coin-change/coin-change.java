class Solution {
    public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int INF = Integer.MAX_VALUE - 1;

    int[] prev = new int[amount + 1];
    int[] curr = new int[amount + 1];

    // Base case: with 0 coins, all amounts > 0 are impossible
    Arrays.fill(prev, INF);
    prev[0] = 0;

    for (int i = 1; i <= n; i++) {
        curr[0] = 0; // 0 amount needs 0 coins
        for (int j = 1; j <= amount; j++) {
            if (coins[i - 1] <= j) {
                int take = 1 + curr[j - coins[i - 1]];  // Use curr here for unlimited coins
                int notake = prev[j];
                curr[j] = Math.min(take, notake);
            } else {
                curr[j] = prev[j];
            }
        }
        // Move current row to prev for next iteration
        prev = curr.clone();
    }

    return prev[amount] == INF ? -1 : prev[amount];
}

}