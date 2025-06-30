class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // Replace
                            Math.min(
                                    dp[i][j - 1], // Insert
                                    dp[i - 1][j] // Delete
                            ));
                }
            }
        }
        return dp[m][n];

    }

    int solve(String word1, String word2, int i, int j, int[][] dp) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            dp[i][j] = solve(word1, word2, i - 1, j - 1, dp);
        } else {
            dp[i][j] = 1 + Math.min(
                    solve(word1, word2, i - 1, j - 1, dp), // Replace
                    Math.min(
                            solve(word1, word2, i, j - 1, dp), // Insert
                            solve(word1, word2, i - 1, j, dp) // Delete
                    ));
        }
        return dp[i][j];
    }
}
