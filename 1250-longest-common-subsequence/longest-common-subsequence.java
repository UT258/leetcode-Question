class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Always make sure we use less space by iterating over the shorter string
        if (n > m) {
            return longestCommonSubsequence(text2, text1);
        }

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Swap the rows for the next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];  // Final result is in 'prev' after the last swap
    }
}
