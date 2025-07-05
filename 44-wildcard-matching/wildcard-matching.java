class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[] prev = new boolean[n + 1];

        // base case: empty string and empty pattern
        prev[0] = true;

        // fill for empty string and pattern up to j
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                prev[j] = prev[j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            boolean[] curr = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '?') {
                    curr[j] = prev[j - 1];
                } else if (pc == '*') {
                    curr[j] = curr[j - 1] || prev[j];
                }
            }
            prev = curr;
        }

        return prev[n];
    }
}
