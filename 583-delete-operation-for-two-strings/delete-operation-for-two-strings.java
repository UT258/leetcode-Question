class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        //tabulation
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

    public int minDistance(String word1, String word2) {
        int s1=word1.length();
        int s2=word2.length();
        int lcs= longestCommonSubsequence(word1,word2);
        //we need to find the minimum steps
        //sea eat  logest common=ea   compare this both and remove the common
        return s1+s2-2*lcs;

    }
}