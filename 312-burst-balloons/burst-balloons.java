import java.util.Arrays;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        temp[0] = 1;
        temp[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            temp[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2]; // safer size
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(temp, 1, n, dp); // solve between 1 and n
    }

    private int solve(int[] arr, int i, int j, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int max = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            int coins = arr[i - 1] * arr[k] * arr[j + 1]
                      + solve(arr, i, k - 1, dp)
                      + solve(arr, k + 1, j, dp);
            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }
}
