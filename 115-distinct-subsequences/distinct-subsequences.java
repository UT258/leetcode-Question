class Solution {
    public int numDistinct(String s, String t) {
        //unbounded knapsack variant
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;//if s is empty then we can never form 
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;//if t is empty it is always possible 
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];

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