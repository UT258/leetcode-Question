class Solution {
    public int numDistinct(String s, String t) {
        //unbounded knapsack variant
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        prev[0] = 1; // Base case

        for (int i = 1; i <= m; i++) {
            curr[0] = 1;
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr.clone(); // or use swapping
        }
        return prev[n];

    }

    int solve(String s, String t, int i, int j, int dp[][]) {
        if (j == 0)
            return 1;//always possible to  form the empty
        if (i == 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            return dp[i][j] = solve(s, t, i - 1, j - 1, dp) + solve(s, t, i - 1, j, dp);
        }
        return dp[i][j] = solve(s, t, i - 1, j, dp);

    }
}