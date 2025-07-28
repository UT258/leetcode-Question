class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean dp[][] = new boolean[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i + l <= n; i++) {
                int j = i + l - 1;// j index
                if (i == j) {
                    //1 length
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    //length 2 substring
                    dp[i][j] = s.charAt(i) == s.charAt(j);

                } else {
                    //more than 2
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    count++;
                }
            }           
        }
        return count;

    }

}