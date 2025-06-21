class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int temp[] : dp) {
            Arrays.fill(temp, -1);
        }
        return solve(text1, text2, text1.length(), text2.length(), dp);

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