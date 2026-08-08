class Solution {
    public long maxAlternatingSum(int[] nums) {
        Long[][] dp = new Long[nums.length][2];
        return solve(nums, 0, 1, dp);
    }

    private long solve(int[] nums, int i, int flag, Long[][] dp) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][flag] != null) {
            return dp[i][flag];
        }

        long val = nums[i];

        if (flag == 0) {
            val = -val;
        }

        long take = val + solve(nums, i + 1, 1 - flag, dp);
        long skip = solve(nums, i + 1, flag, dp);

        return dp[i][flag] = Math.max(take, skip);
    }
}