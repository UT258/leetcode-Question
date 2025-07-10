class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, zeroCount = 0;
        for (int num : nums) {
            sum += num;
            if (num == 0) zeroCount++;
        }

        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) return 0;

        int s1 = (sum + target) / 2;
        int ways = countSubsetsIgnoringZeros(nums, s1);

        // Each zero can be +0 or -0, contributing to 2^zeroCount combinations
        return (int)(ways * Math.pow(2, zeroCount));
    }

    public int countSubsetsIgnoringZeros(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            if (num == 0) continue;
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
