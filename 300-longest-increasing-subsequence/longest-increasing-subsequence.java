class Solution {
    public int solve(int[] arr, int i, int p, int[][] dp) {
        if (i >= arr.length) return 0;

        if (dp[i][p + 1] != -1) return dp[i][p + 1];

        int take = 0;
        if (p == -1 || arr[i] > arr[p]) {
            take = 1 + solve(arr, i + 1, i, dp);
        }

        int skip = solve(arr, i + 1, p, dp);

        dp[i][p + 1] = Math.max(take, skip);
        return dp[i][p + 1];
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1]; // shift p by +1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, -1, dp);
    }
}
