import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);

        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num; // collect total points for each value
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);
        return solve(points, max, dp);
    }

    private int solve(int[] points, int i, int[] dp) {
        // base cases
        if (i == 0) return 0;
        if (i == 1) return points[1];
        if (dp[i] != -1) return dp[i];

        // recurrence: choose max of taking or skipping current value
        int take = points[i] + solve(points, i - 2, dp);
        int skip = solve(points, i - 1, dp);

        return dp[i] = Math.max(take, skip);
    }
}
