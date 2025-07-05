class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        return solve(s, p, m, n, dp);
    }

    public boolean solve(String s, String p, int i, int j, Boolean[][] dp) {
        if (i == 0 && j == 0) return true;

        if (i == 0 && j > 0) {
            for (int k = 0; k < j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (i > 0 && j == 0) return false;

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            return dp[i][j] = solve(s, p, i - 1, j - 1, dp);
        }

        if (p.charAt(j - 1) == '*') {
            return dp[i][j] = solve(s, p, i - 1, j, dp) || solve(s, p, i, j - 1, dp);
        }

        return dp[i][j] = false;
    }
}
