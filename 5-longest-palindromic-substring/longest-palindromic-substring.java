class Solution {
    public String longestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];
        int maxLen = 0;
        int endIndex = 0; // ending index in original string

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // Confirm the substring is a palindrome
                    int startInOriginal = i - dp[i][j];
                    int startInReverse = n - j;
                    if (startInOriginal == startInReverse) {
                        if (dp[i][j] > maxLen) {
                            maxLen = dp[i][j];
                            endIndex = i; // end index (exclusive)
                        }
                    }
                }
            }
        }

        return s.substring(endIndex - maxLen, endIndex);
    }
}
