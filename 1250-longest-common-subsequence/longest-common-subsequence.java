class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        //initialization
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0; //if text2 is empty then lcs is 0
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0; //if text1 is empty then lcs is 0

        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }
        return dp[m][n];

    }

    private int solve(String text1, String text2, int length, int length1, int dp[][]) {
        if (length == 0 || length1 == 0) {
            return 0;
        }
        if (dp[length][length1] != -1) {
            return dp[length][length1];
        }
        if (text1.charAt(length - 1) == text2.charAt(length1 - 1)) {
            return dp[length][length1] = 1 + solve(text1, text2, length - 1, length1 - 1, dp);
        } else {
            return dp[length][length1] = Math.max(solve(text1, text2, length - 1, length1, dp),
                    solve(text1, text2, length, length1 - 1, dp));
        }
    }
}