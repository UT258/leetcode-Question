class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        return solve(s, p, m, n, dp);
    }

    public boolean solve(String s, String p, int i, int j, Boolean[][] dp) {
        if (i == 0 && j == 0)
            return true;

        if (i == 0) {
            for (int k = 0; k < j; k += 2) {
                if (k + 1 >= j || p.charAt(k + 1) != '*')
                    return dp[i][j] = false;
            }
            return dp[i][j] = true;
        }

        if (j == 0)
            return false;

        if (dp[i][j] != null)
            return dp[i][j];

        if (p.charAt(j - 1) == '*') {
            boolean zero = solve(s, p, i, j - 2, dp);
            boolean more = false;

            if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                more = solve(s, p, i - 1, j, dp);
            }

            return dp[i][j] = zero || more;
        }

        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
            return dp[i][j] = solve(s, p, i - 1, j - 1, dp);
        }

        return dp[i][j] = false;
    }
}
